package com.yimai.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yimai.web.base.AbctractBaseController;

/**
 * 首页 Controller
 * 
 * @author sunfx
 */
@Controller
public class LoginController extends AbctractBaseController {

	public static final String TILES_INDEX = "tiles_index";

	/**
	 * 登陆页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/login.shtml")
	public String login() {
		return "login";
	}

	/**
	 * 退出URL
	 * 
	 * @return
	 */
	@RequestMapping(value = "/loginOut.shtml", method = RequestMethod.POST)
	public String loginOut(HttpServletRequest request, HttpServletResponse response) {
		request.getSession().invalidate();
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		return "login";
	}

	/**
	 * 登陆验证
	 * 
	 * @param user
	 * @param bindingResult
	 * @param redirectAttributes
	 * @return
	 */
	@RequestMapping(value = "/loginCheck.shtml", method = RequestMethod.POST)
	public String loginCheck(HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
				redirectAttributes.addFlashAttribute("message", "用户名或密码不能为空");
				return "redirect:/login.shtml";
			}
			// 使用权限工具进行用户登录，登录成功后跳到shiro配置的successUrl中，与下面的return没什么关系！
			SecurityUtils.getSubject().login(new UsernamePasswordToken(username, password));
			return "redirect:/index.shtml";
		} catch (UnknownAccountException e) {
			log4j.error(e.getMessage(), e);
			redirectAttributes.addFlashAttribute("message", "用户不存在！");
			return "redirect:/login.shtml";
		} catch (AuthenticationException e) {
			log4j.error(e.getMessage(), e);
			redirectAttributes.addFlashAttribute("message", "用户名或密码错误！");
			return "redirect:/login.shtml";
		} catch (Exception e) {
			log4j.error(e.getMessage(), e);
			redirectAttributes.addFlashAttribute("message", "登陆异常！");
			return "redirect:/login.shtml";
		}
	}

}
