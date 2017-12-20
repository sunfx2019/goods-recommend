<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>微信-居安整装-用户关注推送</title>
</head>
<body>
	<%
		
		/** 
	     * 请求消息类型：事件 
	     */  
	    public static final String REQ_MESSAGE_TYPE_EVENT = "event";  
	  
	    /** 
	     * 事件类型：subscribe(关注) 
	     */  
	    public static final String EVENT_TYPE_SUBSCRIBE = "subscribe";  
	  
	    /** 
	     * 事件类型：unsubscribe(取消关注) 
	     */  
	    public static final String EVENT_TYPE_UNSUBSCRIBE = "unsubscribe";  
	  
	    /** 
	     * 事件类型：CLICK(自定义菜单点击事件) 
	     */  
	    public static final String EVENT_TYPE_CLICK = "CLICK";  
	
		try{
			
			Article article1 = new Article();
		    article1.setTitle("第7篇\n文本消息中换行符的使用");  
		    article1.setDescription("");  
		    article1.setPicUrl("http://0.xiaoqrobot.duapp.com/images/avatar_liufeng.jpg");  
		    article1.setUrl("http://blog.csdn.net/lyq8479/article/details/9141467");  
		
		    Article article2 = new Article();  
		    article2.setTitle("第8篇\n文本消息中使用网页超链接");  
		    article2.setDescription("");  
		    article2.setPicUrl("http://avatar.csdn.net/1/4/A/1_lyq8479.jpg");  
		    article2.setUrl("http://blog.csdn.net/lyq8479/article/details/9157455");  
		
		    Article article3 = new Article();  
		    article3.setTitle("如果觉得文章对你有所帮助，请通过博客留言或关注微信公众帐号xiaoqrobot来支持柳峰！");  
		    article3.setDescription("");  
		    // 将图片置为空  
		    article3.setPicUrl("");  
		    article3.setUrl("http://blog.csdn.net/lyq8479");  
		
		    articleList.add(article1);  
		    articleList.add(article2);  
		    articleList.add(article3);  
		    newsMessage.setArticleCount(articleList.size());  
		    newsMessage.setArticles(articleList);  
		    respMessage = MessageUtil.newsMessageToXml(newsMessage);
		    
		}catch(Exception e){
			
		}
	%>
</body>
</html>