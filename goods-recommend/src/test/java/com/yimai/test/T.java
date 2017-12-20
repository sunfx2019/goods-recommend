package com.yimai.test;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.DatatypeConverter;

import org.apache.commons.lang.StringUtils;

import sun.management.VMManagement;

public class T {

	
	public static void main(String[] args) {

		Map<String, List<String>> permissionsRoleMap = new HashMap<String, List<String>>();		//存放URL，List<Role>
		permissionsRoleMap.put("123", new ArrayList<>());
		System.out.println(permissionsRoleMap);
		permissionsRoleMap.get("123").add("1");
		System.out.println(permissionsRoleMap);
		permissionsRoleMap.put("123", null);
		System.out.println(permissionsRoleMap);
		
		List<String> roles = new ArrayList<>();
		roles.add("1");
		roles.add("2");
		roles.add("3");
		String str = StringUtils.join(roles.toArray(), ",");
		System.out.println(str);
		
		try {
			
			//java获取进程ID  
			RuntimeMXBean runtime = ManagementFactory.getRuntimeMXBean();  
			Field jvm = runtime.getClass().getDeclaredField("jvm");  
			jvm.setAccessible(true);  
			VMManagement mgmt = (VMManagement) jvm.get(runtime);  
			Method pidMethod = mgmt.getClass().getDeclaredMethod("getProcessId");  
			pidMethod.setAccessible(true);  
			int pid = (Integer) pidMethod.invoke(mgmt);
			System.out.println("pid->" + pid);

			InetAddress ia = InetAddress.getLocalHost();  
			byte[] mac = NetworkInterface.getByInetAddress(ia).getHardwareAddress();  
			String macStr = DatatypeConverter.printHexBinary(mac);
			System.out.println(macStr);
			
			System.out.println("390092862206771201".length());
			System.out.println("20171212390092862206771201".length());
			System.out.println("20171212310500201010240019960400".length());
			
			System.out.println(T.class.getClassLoader().getResource("jdbc.properties"));  
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}

}
