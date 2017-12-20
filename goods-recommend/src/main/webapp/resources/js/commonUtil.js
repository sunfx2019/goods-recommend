function queryUserById(userId){
	var userName = "";
	$.ajax({
		type: "GET",
		url: "/cmsk-erp-web/system/usermanager/queryUserById.html",
		data:{
			'userId': userId
		},
		dataType:'json',
		async: false,
		error: function(data){
			
		},
		success: function(data){
			if (data){
				userName = data.username == undefined ? "" : data.username;
			}
		}
	}); 
	return userName;
}