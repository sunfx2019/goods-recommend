package com.yimai.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yimai.web.base.AbctractBaseController;

/**
 * 首页 Controller
 * 
 * @author sunfx
 */
@Controller
public class IndexController extends AbctractBaseController {

	public static final String TILES_INDEX = "tiles_index";

	/**
	 * 首页
	 * 
	 * @return
	 */
	@RequestMapping("/index.shtml")
	public String index() {
		log4j.info(System.currentTimeMillis());
		return "index";
	}

	@RequestMapping("/top.shtml")
	public String top() {
		log4j.info(System.currentTimeMillis());
		return "top";
	}

	@RequestMapping("/left.shtml")
	public String left() {
		log4j.info(System.currentTimeMillis());
		return "left";
	}

	@RequestMapping("/right.shtml")
	public String right() {
		log4j.info(System.currentTimeMillis());
		return "right";
	}

}
