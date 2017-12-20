package com.yimai.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yimai.web.base.AbctractBaseController;

/**
 * 用户 Controller
 * 
 * @author sunfx
 */
@Controller
@RequestMapping("/role")
public class RolesController extends AbctractBaseController {

	private final static String roleListJSP = "role/roleList";

	/**
	 * 角色列表
	 * 
	 * @return
	 */
	@RequestMapping("/list.shtml")
	public String list() {
		log4j.info(System.currentTimeMillis());
		return roleListJSP;
	}

}
