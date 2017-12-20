package com.yimai.web.listener;

import java.io.File;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import com.yimai.entity.Actiontype;
import com.yimai.entity.Tenant;
import com.yimai.entity.TenantWithBLOBs;
import com.yimai.service.IActionService;
import com.yimai.service.IActionTypeService;
import com.yimai.service.IMahoutService;
import com.yimai.service.ITenantService;

@Service("initMahoutDataListener")
public class InitMahoutDataListener implements ApplicationListener<ContextRefreshedEvent> {

	//生成的Data数据
	public final static String MAHOUT_DATA_PATH = "/resources/data/recommend";
	
	//数据文件后缀名
	public final static String MAHOUT_DATA_FILE_SUFFIX = ".data";

	//数据文件目录
	public String DIRECTORY = "";
	
	@Autowired
	private ITenantService tenantService;

	@Autowired
	public IActionService actionServiceImpl;
	
	@Autowired
	public IMahoutService mahoutService;

	@Autowired
	private IActionTypeService actionTypeService;
	
	public Log log4j = LogFactory.getLog(getClass());

	/**
	 * 需要执行的逻辑代码，当spring容器初始化完成后就会执行该方法。
	 */
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		ApplicationContext applicationContext = event.getApplicationContext();  
		WebApplicationContext webApplicationContext = (WebApplicationContext)applicationContext;  
		ServletContext servletContext = webApplicationContext.getServletContext();
		
		DIRECTORY = servletContext.getRealPath(MAHOUT_DATA_PATH); 
		
		// 但是这个时候，会存在一个问题，在web 项目中（spring mvc），系统会存在两个容器，一个是root application context ,
		// 另一个就是我们自己的 projectName-servlet context（作为root application context的子容器）。
		// 这种情况下，就会造成onApplicationEvent方法被执行两次。为了避免上面提到的问题，我们可以只在root
		// application context初始化完成后调用逻辑代码，其他的容器的初始化完成，则不做任何处理，修改后代码
		// root application context 没有parent，他就是老大.
		// log4j.info("InitMahoutDataListener.onApplicationEvent...");
		if (event.getApplicationContext().getParent() == null) {
			// 需要执行的逻辑代码，当spring容器初始化完成后就会执行该方法。
			log4j.info("DIRECTORY:" + DIRECTORY);
			initData();
		}
		
	}
	
	public void initData(){

		log4j.info("---------------------------------------------------------------------------------------------------------------------");
		log4j.info("InitMahoutDataListener.initData()");
		log4j.info("---------------------------------------------------------------------------------------------------------------------");
		
		try {
			
			//查询所有的应用
			List<Tenant> tenantList = tenantService.getAll();
			for(Tenant t : tenantList){
				//查询应用下全部的Actiontype
				List<Actiontype> actiontypeList = actionTypeService.queryByTenantid(t.getId());
				for(Actiontype actiontype : actiontypeList){
					//应用
					TenantWithBLOBs tenant = tenantService.getById(actiontype.getTenantid());
					String tenantName = tenant.getStringid();
					//数据文件
					String fileName = actiontype.getName();
					String directory = DIRECTORY + File.separator + tenantName;
					//分Actiontype类别写入到不同的Actiontype数据文件
					String dataFile = directory + File.separator + fileName + MAHOUT_DATA_FILE_SUFFIX;
					//创建数据文件
					//this.iMahoutService.createDataFile(directory, fileName);
					//写入数据到文件
					log4j.info("dataFile:" + dataFile);
					mahoutService.writeDataToFile(actiontype.getId(), dataFile);
				}
			}
			
		} catch (Exception e) {
			log4j.error(e.getMessage(), e);
		}
	
	}

}
