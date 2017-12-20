package com.yimai.service;

import javax.servlet.http.HttpServletRequest;

/**
 * 微信服务
 * 
 * @author sunfx
 *
 */
public interface IWeiXinService {

	/**
	 * emoji表情转换(hex -> utf-16)
	 * @param hexEmoji
	 * @return
	 */
	public String emoji(int hexEmoji);
	
	/**
	 * 处理微信发来的请求
	 * @param request
	 * @return
	 */
	public String processRequest(HttpServletRequest request);
	
}
