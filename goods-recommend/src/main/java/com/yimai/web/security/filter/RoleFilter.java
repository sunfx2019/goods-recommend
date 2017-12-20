package com.yimai.web.security.filter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.StringUtils;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.util.WebUtils;

import com.yimai.web.security.ShiroFilterFactoryBeanManage;

/**
 * 角色校验
 * 
 * 由于Shiro filterChainDefinitions中 roles默认是and， /** = user,roles[system,general]
 * 比如：roles[system,general] ，表示同时需要“system”和“general” 2个角色才通过认证 所以需要自定义 继承
 * AuthorizationFilter
 * 
 * @author Administrator
 *
 */
public class RoleFilter extends AccessControlFilter {

	public Log log4j = LogFactory.getLog(getClass());
	
	@Override
	protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue)
			throws Exception {
		log4j.info("调用RoleFilter。。。");
		Subject subject = getSubject(request, response);
		String[] rolesArray = (String[]) mappedValue;
		if (rolesArray == null || rolesArray.length == 0) {
			return true;
		}
		for (int i = 0; i < rolesArray.length; i++) {
			if (subject.hasRole(rolesArray[i])) {
				return true;
			}
		}
		return false;
	}

	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
		Subject subject = getSubject(request, response);
		if (subject.getPrincipal() == null) {// 表示没有登录，重定向到登录页面
			saveRequest(request);
			WebUtils.issueRedirect(request, response, ShiroFilterFactoryBeanManage.LOGIN_URL);
		} else {
			if (StringUtils.hasText(ShiroFilterFactoryBeanManage.UNAUTHORIZED_URL)) {// 如果有未授权页面跳转过去
				WebUtils.issueRedirect(request, response, ShiroFilterFactoryBeanManage.UNAUTHORIZED_URL);
			} else {// 否则返回401未授权状态码
				WebUtils.toHttp(response).sendError(HttpServletResponse.SC_UNAUTHORIZED);
			}
		}
		return false;
	}

}
