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
@RequestMapping("/resources")
public class ResourcesController extends AbctractBaseController {

	private final static String resourcesListJSP = "resources/resourcesList";

	/**
	 * 资源列表
	 * 
	 * @return
	 */
	@RequestMapping("/list.shtml")
	public String list() {
		log4j.info(System.currentTimeMillis());
		return resourcesListJSP;
	}

}
