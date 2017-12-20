package com.yimai.web.security;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;

import com.alibaba.fastjson.JSONArray;
import com.yimai.entity.TUser;
import com.yimai.service.IUserService;
import com.yimai.web.security.encryption.ThreeDesUtil;

/**
 * Realm 验证
 * 
 * @author Administrator
 *
 */
public class MyRealm extends AuthorizingRealm {

	// 用户Service
	private IUserService userService;

	// 3Des加密
	private ThreeDesUtil threeDes = ThreeDesUtil.getInstance();

	private Log log4j = LogFactory.getLog(getClass());

	private final static String key = "073188992648forenetf8ssc";

	private final static String iv = "88888888";

	/**
	 *  授权 
	 * 	shiro什么时候会进入doGetAuthorizationInfo(PrincipalCollection principals)
	 *  会进入授权方法一共有三种情况！
	 *	1、subject.hasRole(“admin”) 或 subject.isPermitted(“admin”)：自己去调用这个是否有什么角色或者是否有什么权限的时候；
	 *	2、@RequiresRoles("admin") ：在方法上加注解的时候；
	 *	3、[@shiro.hasPermission name = "admin"][/@shiro.hasPermission]：在页面上加shiro标签的时候，即进这个页面的时候扫描到有这个标签的时候。
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		log4j.info("----------doGetAuthorizationInfo 查询and授权角色资源----------");
		String userName = (String) getAvailablePrincipal(principals);
		List<String> rolsList = userService.findUserRoles(userName);
		List<String> permissionList = userService.findUserPermissions(userName);
		//权限信息对象info,用来存放查出的用户的所有的角色（role）及权限（permission）
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		// 角色集合
		Set<String> r = new HashSet<String>();
		// 权限集合
		Set<String> p = new HashSet<String>();
		for (String roleName : rolsList) {
			r.add(roleName);
		}
		for (String url : permissionList) {
			p.add(url);
		}
		info.setRoles(r);
		info.setStringPermissions(p);
		log4j.info(JSONArray.toJSON(principals));
		log4j.info(JSONArray.toJSON(info));
		return info;
	}

	/**
	 * 登陆校验
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		log4j.info("----------doGetAuthenticationInfo 登陆校验----------");
		String userName = (String) token.getPrincipal(); // 用户名
		String password = new String((char[]) token.getCredentials()); // 密码
		log4j.info("userName:" + userName);
		log4j.info("password:" + password);
		TUser user = userService.findUserByUserName(userName);
		String encryptPassword = encryptPassword(password);
		//如果用户的status为禁用。那么就抛出<code>DisabledAccountException</code> 
		if (user == null) {
			throw new UnknownAccountException("用户不存在！");
		}
		if (!(user.getPswd()).equals(encryptPassword)) {
			throw new IncorrectCredentialsException("密码错误！");
		}
		// 身份验证通过,返回一个身份信息
		AuthenticationInfo aInfo = new SimpleAuthenticationInfo(userName, password, getName());
		return aInfo;
	}

	/**
     * 清空当前用户权限信息
     */
	public void clearCachedAuthorizationInfo() {
		PrincipalCollection principalCollection = SecurityUtils.getSubject().getPrincipals();
		SimplePrincipalCollection principals = new SimplePrincipalCollection(principalCollection, getName());
		super.clearCachedAuthorizationInfo(principals);
	}
	/**
	 * 指定principalCollection 清除
	 */
	public void clearCachedAuthorizationInfo(PrincipalCollection principalCollection) {
		SimplePrincipalCollection principals = new SimplePrincipalCollection(principalCollection, getName());
		super.clearCachedAuthorizationInfo(principals);
	}
	
	/**
	 * 密码加密
	 * 
	 * @param password
	 *            原始密码
	 * @return
	 */
	public String encryptPassword(String password) {
		try {
			return threeDes.encrypt(key, iv, password);
		} catch (Exception e) {
			log4j.error(e.getMessage(), e);
			return null;
		}
	}

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

}
