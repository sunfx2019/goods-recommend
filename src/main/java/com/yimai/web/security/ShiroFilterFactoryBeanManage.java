package com.yimai.web.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.springframework.core.io.ClassPathResource;

import com.yimai.core.util.ApplicationContextFactoryUtil;
import com.yimai.core.util.INI4j;
import com.yimai.service.IPermissService;
import com.yimai.service.IUserService;

public class ShiroFilterFactoryBeanManage {

	private IUserService userService;

	private IPermissService permissService;

	// 登录页面
	public final static String LOGIN_URL = "/login.shtml";
	// 踢出登录提示
	public final static String KICKED_OUT_URL = "/error/kickedOut.jsp";
	// 没有权限提醒
	public final static String UNAUTHORIZED_URL = "/error/403.jsp";

	// 固定配置权限
	public final static String SHIRO_INI_FILENAME = "shiro_auth.ini";
	// ShiroFilterFactoryBeanName
	public final static String SHIROFILTERFACTORY_BEANNAME = "shiroFilter";
	// 换行符
	private static final String CRLF = "\r\n";
	// 默认的配置（所有的资源URL都必须经过 authc和login拦截器）
	private static final String lastDefinitions = "/**=authc,login";

	public Log log4j = LogFactory.getLog(getClass());

	public String loadFilterChainDefinitions() {
		StringBuffer sb = new StringBuffer();
		sb.append(this.getFixedAuthRule()); // 添加配置文件
		sb.append(this.getDBAuthRule()); // 添加DB中的配置
		sb.append(lastDefinitions);	//最后必须加这个才能生效
		System.out.println(CRLF);
		System.out.println("*****************************************************************************************************");
		System.out.println(sb.toString());
		System.out.println("*****************************************************************************************************");
		System.out.println(CRLF);
		return sb.toString();
	}

	/**
	 * 从配额文件获取固定权限验证规则串
	 */
	private String getFixedAuthRule() {
		ClassPathResource cp = new ClassPathResource(SHIRO_INI_FILENAME);
		INI4j ini = null;
		try {
			ini = new INI4j(cp.getFile());
		} catch (IOException e) {
			log4j.error(e.getMessage(), e);
		}
		String section = "base_auth";
		Set<String> keys = ini.get(section).keySet();
		StringBuffer sb = new StringBuffer();
		for (String key : keys) {
			String value = ini.get(section, key);
			sb.append(key).append("=").append(value).append(CRLF);
		}
		return sb.toString();
	}

	/**
	 * 添加DB中的动态权限
	 */
	public String getDBAuthRule() {
		// 返回 Map<RoleName, URL>
		List<Map<Object, Object>> list = permissService.findPermissionRole(); // 查询DB中的角色权限URL关系
		// 存放<URL,List<Role>>
		Map<String, List<String>> permissionsRoleMap = new HashMap<String, List<String>>();
		// 组装DB中的definitions
		StringBuffer definitions = new StringBuffer();
		for (Map<Object, Object> map : list) {
			String roleName = String.valueOf(map.get("name"));
			String url = String.valueOf(map.get("url"));
			if (permissionsRoleMap.containsKey(url)) {
				List<String> roles = permissionsRoleMap.get(url); // 该URL所拥有的角色
				roles.add(roleName); // 追加Role
			} else {
				List<String> roles = new ArrayList<String>();
				roles.add(roleName);
				permissionsRoleMap.put(url, roles);
			}
		}
		Iterator<String> it = permissionsRoleMap.keySet().iterator();
		while (it.hasNext()) {
			String url = it.next();
			List<String> roles = permissionsRoleMap.get(url);
			definitions.append(url);
			definitions.append("=");
			definitions.append("authc,login,permission,anyRoles");	//分别调用相对应的过滤器
			definitions.append("[").append(StringUtils.join(roles.toArray(), ",")).append("]");
			definitions.append(CRLF);
		}
		return definitions.toString();
	}

	/**
	 * 重新刷新权限配置
	 */
	public void reloadFilterChains() {

		synchronized (this) { // 强制同步，控制线程安全
			ShiroFilterFactoryBean shiroFilter = ApplicationContextFactoryUtil.getBean(SHIROFILTERFACTORY_BEANNAME, ShiroFilterFactoryBean.class);
			log4j.info(shiroFilter);
			//...待完善
		}

	}

	public static void main(String[] args) {
		System.out.println(new ShiroFilterFactoryBeanManage().getFixedAuthRule());
	}
	
	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public IPermissService getPermissService() {
		return permissService;
	}

	public void setPermissService(IPermissService permissService) {
		this.permissService = permissService;
	}

}
