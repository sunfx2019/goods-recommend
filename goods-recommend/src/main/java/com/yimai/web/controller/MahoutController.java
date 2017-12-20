package com.yimai.web.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.yimai.bean.JsonResult;
import com.yimai.core.util.HttpRequestUtil;
import com.yimai.core.util.StringUtil;
import com.yimai.entity.Action;
import com.yimai.entity.Actiontype;
import com.yimai.entity.Item;
import com.yimai.entity.ItemType;
import com.yimai.entity.Tenant;
import com.yimai.entity.TenantWithBLOBs;
import com.yimai.idgenerator.SnowflakeIdWorker;
import com.yimai.service.IActionService;
import com.yimai.service.IActionTypeService;
import com.yimai.service.IItemService;
import com.yimai.service.IItemTypeService;
import com.yimai.service.IMahoutService;
import com.yimai.service.ITenantService;
import com.yimai.web.base.AbctractBaseController;

/**
 * 推荐系统 Mahout Controller
 * 
 * @author sunfx
 *
 */
@Controller
@RequestMapping("/mahout")
public class MahoutController extends AbctractBaseController {

	@Autowired
	private IActionService actionServiceImpl;

	@Autowired
	private IItemService itemService;

	@Autowired
	private IActionTypeService actionTypeService;

	@Autowired
	private IItemTypeService itemTypeService;

	@Autowired
	private ITenantService tenantService;

	@Autowired
	private IMahoutService mahoutService;

	private Log log4j = LogFactory.getLog(getClass());

	// ID生成器
	private SnowflakeIdWorker idWorker = new SnowflakeIdWorker(0, 0);

	// 应用 tenantId
	public final static int tenantId = 1;

	/**
	 * 获取ActionType
	 * 
	 * @param response
	 */
	@RequestMapping(value = "/getActionType.shtml", method = RequestMethod.GET)
	public void getActionType(HttpServletRequest request, HttpServletResponse response) {
		try {
			List<Actiontype> list = actionTypeService.getAll();
			this.renderJson(response, JsonResult.returnSuccess(list));
		} catch (Exception e) {
			log4j.error(e.getMessage(), e);
			this.renderJson(response, JsonResult.returnFailure());
		}
	}

	/**
	 * 获取ItemType
	 * 
	 * @param response
	 */
	@RequestMapping(value = "/getItemType.shtml", method = RequestMethod.GET)
	public void getItemType(HttpServletRequest request, HttpServletResponse response) {
		try {
			List<ItemType> list = itemTypeService.getAll();
			this.renderJson(response, JsonResult.returnSuccess(list));
		} catch (Exception e) {
			log4j.error(e.getMessage(), e);
			this.renderJson(response, JsonResult.returnFailure());
		}
	}

	/**
	 * 获取Tenant
	 * 
	 * @param response
	 */
	@RequestMapping(value = "/getTenant.shtml", method = RequestMethod.GET)
	public void getTenant(HttpServletRequest request, HttpServletResponse response) {
		try {
			List<Tenant> list = tenantService.getAll();
			this.renderJson(response, JsonResult.returnSuccess(list));
		} catch (Exception e) {
			log4j.error(e.getMessage(), e);
			this.renderJson(response, JsonResult.returnFailure());
		}
	}

	/**
	 * 其他用户也买过... 基于用户相似度的协同过滤推荐实现
	 * @see
	 * <p>
	 * 	http://localhost:8080/goods-recommend/mahout/getBaseUserCF.shtml?itemid=1&actionTypeId=1&userId=1&num=1
	 * </p>
	 * 
	 * @param request
	 * @param response
	 */
//	@SuppressWarnings("rawtypes")
//	@RequestMapping(value = "/getBaseUserCF.shtml", method = RequestMethod.GET)
//	public void getBaseUserCF(@RequestParam("itemid") Integer itemid,
//			@RequestParam("actionTypeId") Integer actionTypeId, @RequestParam("userId") Integer userId,
//			@RequestParam("num") Integer num, HttpServletRequest request, HttpServletResponse response) {
//		try {
//			Item item = itemService.getById(itemid);
//			if (item == null) {
//				this.renderJson(response, JsonResult.returnFailure("itemid不存在!"));
//				return;
//			}
//			Actiontype actiontype = actionTypeService.getById(actionTypeId);
//			if (actiontype == null) {
//				this.renderJson(response, JsonResult.returnFailure("actionTypeId不存在!"));
//				return;
//			}
//			List list = mahoutService.baseUserCF(actiontype.getName(), userId, num);
//			this.renderJson(response, JsonResult.returnSuccess(list));
//		} catch (Exception e) {
//			log4j.error(e.getMessage(), e);
//			this.renderJson(response, JsonResult.returnFailure());
//		}
//	}

	/**
	 * 给用户推荐actionType行为的商品 基于内容相似度的协同过滤推荐实现
	 * 
	 * @param request
	 * @param response
	 */
//	@SuppressWarnings("rawtypes")
//	@RequestMapping(value = "/getBaseItemCF.shtml", method = RequestMethod.GET)
//	public void getBaseItemCF(@RequestParam("itemid") Integer itemid, @RequestParam("actionType") Integer actionTypeId,
//			@RequestParam("userId") Integer userId, @RequestParam("num") Integer num, HttpServletRequest request,
//			HttpServletResponse response) {
//		try {
//			Item item = itemService.getById(itemid);
//			if (item == null) {
//				this.renderJson(response, JsonResult.returnFailure("itemid不存在!"));
//				return;
//			}
//			Actiontype actiontype = actionTypeService.getById(actionTypeId);
//			if (actiontype == null) {
//				this.renderJson(response, JsonResult.returnFailure("actionTypeId不存在!"));
//				return;
//			}
//			List list = mahoutService.baseItemCF(actiontype.getName(), userId, num);
//			this.renderJson(response, JsonResult.returnSuccess(list));
//		} catch (Exception e) {
//			log4j.error(e.getMessage(), e);
//			this.renderJson(response, JsonResult.returnFailure(e.getMessage()));
//		}
//	}
	
	/**
	 * 推荐商品
	 * @see
	 * <p>
	 * 	http://localhost:8080/goods-recommend/mahout/goodsRecommend.shtml?actionTypeId=1&userId=1&num=3&tenantId=1
	 * </p>
	 * 
	 * @param tenantId 应用ID
	 * @param actionTypeId actionType
	 * @param userId	用户
	 * @param num	推荐的商品个数
	 * @param request
	 * @param response
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/goodsRecommend.shtml", method = RequestMethod.GET)
	public void goodsRecommend(@RequestParam("tenantId") Integer tenantId, @RequestParam("actionTypeId") Integer actionTypeId,
			@RequestParam("userId") Integer userId, @RequestParam("num") Integer num, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			TenantWithBLOBs tanant = tenantService.getById(tenantId);
			Actiontype actiontype = actionTypeService.getById(actionTypeId);
			if(tanant == null){
				this.renderJson(response, JsonResult.returnFailure("tenantId不存在!"));
			}
			if(actiontype == null){
				this.renderJson(response, JsonResult.returnFailure("actionTypeId不存在!"));
			}
			//参数：应用ID，actiontype，用户ID，推荐个数
			List list = mahoutService.goodsRecommend(tanant.getStringid(), actiontype.getName(), userId, num);
			if(list!=null && list.size()>0){
				List<Long> ids = new ArrayList<Long>();
				for(int i=0; i<list.size();i++){
					RecommendedItem recommend = (RecommendedItem)list.get(i);
					ids.add(recommend.getItemID());
					List<Item> items = itemService.getByIds(ids);
					this.renderJson(response, JsonResult.returnSuccess(items));
				}
			}else{
				this.renderJson(response, JsonResult.returnSuccess(new ArrayList()));
			}
		} catch (Exception e) {
			log4j.error(e.getMessage(), e);
			this.renderJson(response, JsonResult.returnFailure(e.getMessage()));
		}
	}

	/**
	 * 用户行为数据接收
	 * 
	 * @sess
	 *       <p>
	 *       http://localhost:8080/goods-recommend/mahout/saveAction.shtml?tenantid=1&userid=1&sessionid=2&ip=3&itemid=4&itemtypeid=1&actiontypeid=1&ratingvalue=5&actioninfo=6
	 *       </p>
	 * @param response
	 */
	@RequestMapping(value = "/saveAction.shtml")
	public void saveAction(HttpServletRequest req, HttpServletResponse res, Action action) {
		try {
			log4j.info(action);
			log4j.info(req);
			if (action == null || StringUtil.isEmpty(action.getUserid()) || StringUtil.isEmpty(action.getSessionid())
					|| StringUtil.isEmpty(action.getItemid()) || StringUtil.isEmpty(action.getRatingvalue())
					|| StringUtil.isEmpty(action.getActioninfo()) || StringUtil.isEmpty(action.getTenantid())) {
				this.renderJson(res, JsonResult.returnFailure("参数不完整！"));
				return;
			}
			action.setId(idWorker.nextId());
			action.setIp(HttpRequestUtil.getIpAddr(req));
			if (actionServiceImpl.saveOne(action)) {
				this.renderJson(res, JsonResult.returnSuccess());
			} else {
				this.renderJson(res, JsonResult.returnFailure());
			}
		} catch (Exception e) {
			log4j.error(e.getMessage(), e);
			this.renderJson(res, JsonResult.returnFailure(e.getMessage()));
		}
	}

	/**
	 * 商品数据接收
	 * 
	 * @sess
	 *       <p>
	 *       http://localhost:8080/goods-recommend/mahout/saveAction.shtml?tenantid=1&userid=1&sessionid=2&ip=3&itemid=4&itemtypeid=1&actiontypeid=1&ratingvalue=5&actioninfo=6
	 *       </p>
	 * @param response
	 */
	@RequestMapping(value = "/saveItem")
	public void saveItem(HttpServletRequest req, HttpServletResponse res, Item item) {
		try {
			if (item == null || StringUtil.isEmpty(item.getTenantid()) || StringUtil.isEmpty(item.getItemid())
					|| StringUtil.isEmpty(item.getItemtype())) {
				this.renderJson(res, JsonResult.returnFailure("参数不完整！"));
				return;
			}
			item.setId(idWorker.nextId());
			item.setCreationdate(new Date()); // 创建时间
			item.setChangedate(new Date()); // 修改时间
			if (itemService.saveOne(item)) {
				this.renderJson(res, JsonResult.returnSuccess());
			} else {
				this.renderJson(res, JsonResult.returnFailure());
			}
		} catch (Exception e) {
			log4j.error(e.getMessage(), e);
			this.renderJson(res, JsonResult.returnFailure(e.getMessage()));
		}
	}

}
