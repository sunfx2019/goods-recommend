package com.yimai.web.security.filter;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.web.filter.AccessControlFilter;

import com.yimai.core.util.HttpRequestUtil;

/**
 * 
 * 登陆拦截
 * 
 */
public class LoginFilter extends AccessControlFilter {

	public Log log4j = LogFactory.getLog(getClass());
	
	@Override
	protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue)
			throws Exception {
		log4j.info("调用LoginFilter。。。");
		HttpServletRequest httpRequest = ((HttpServletRequest) request);
		HttpServletResponse httpResponse = ((HttpServletResponse) response);
		if (null != SecurityUtils.getSubject().getPrincipal() || isLoginRequest(request, response)) {
			return Boolean.TRUE;
		}
		if (HttpRequestUtil.isAjax(httpRequest)) {// ajax请求
			Map<String, String> resultMap = new HashMap<String, String>();
			//System.out.println("当前用户没有登录，并且是Ajax请求！");
			resultMap.put("login_status", "300");
			resultMap.put("message", "当前用户没有登录！"); // 当前用户没有登录！
			HttpRequestUtil.renderJson(httpResponse, resultMap);
		}
		return Boolean.FALSE;
	}

	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
		// 保存Request和Response 到登录后的链接
		saveRequestAndRedirectToLogin(request, response);
		return Boolean.FALSE;
	}

}
