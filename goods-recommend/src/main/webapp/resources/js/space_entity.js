/**
 * 实体空间管理
 */

/**
 * 楼层版本更新
 */
function fupdate(){
	var errMsg = [];
	errMsg[0] = "公摊面积不能为空!";
	errMsg[1] = "房间号不能为空!";
	errMsg[2] = "存在重复的房间号!";
	errMsg[3] = "建筑面积不能为空!";
	errMsg[4] = "使用面积不能为空!";
	errMsg[5] = "房间号长度不能超过10个字符!";
	errMsg[6] = "建筑面积需等于使用面积和公摊面积之和!";
	errMsg[7] = "面积需要大于0!";
	var dataArr = [];
	var getDataFlag = getData(dataArr, 'tr2');
	if (getDataFlag != -1){
		alert(errMsg[parseInt(getDataFlag)]);
		return false;
	}
	var attachmentId = $('.fileName').attr('data-uuid');
	$.ajax({
		type: "POST",
		url: "/cmsk-erp-web/realSpace/updateFloor.html",
		data:{
			'floorId': $("#floorId_").val(),
			'data': JSON.stringify(dataArr),
			'attachmentId' : attachmentId
		},
		dataType:'json',
		async: false,
		error: function(data){
			alert("楼层版本更新失败!");
			return false;
		},
		success: function(data){
//			window.location="/cmsk-erp-web/spacelease/entityspace.html?regionid=1&buildingid=1";
			location.reload();
		}
	}); 
}

function info(){
	alert("Detail!");
	return false;
}

function fsplit(){
	var errMsg = [];
	errMsg[0] = "公摊面积不能为空!";
	errMsg[1] = "房间号不能为空!";
	errMsg[2] = "存在重复的房间号!";
	errMsg[3] = "建筑面积不能为空!";
	errMsg[4] = "使用面积不能为空!";
	errMsg[5] = "房间号长度不能超过10个字符!";
	errMsg[6] = "建筑面积需等于使用面积和公摊面积之和!";
	errMsg[7] = "面积需要大于0!";
	errMsg[10] = "逻辑空间中建筑面积之和不能大于当前实体空间面积!";
	var dataArr = [];
	var getDataFlag = getData(dataArr, 'tr3');
	if (getDataFlag != -1){
		alert(errMsg[parseInt(getDataFlag)]);
		return false;
	}
	if (dataArr.length == 0){
		return false;
	}
	$.ajax({
		type: "POST",
		url: '/cmsk-erp-web/logicspace/breakupLogicSpace.html',
		data:{
			'realSpaceId': $("#realSpaceId").val(),
			'data': JSON.stringify(dataArr)
		},
		dataType:'json',
		async: false,
		error: function(data){
			alert("拆分空间失败!");
			return false;
		},
		success: function(data){
//			window.location="/cmsk-erp-web/spacelease/virtualspace.html?regionid=1&buildingid=1";
			location.reload();
		}
	}); 
}

function getData(dataArr, flag){
	var obj = $('.' + flag);
	var dataNameArr = [];
	var constructionAreaTotal = 0.00; 
	for(var index = 0; index < obj.length; index++){
		var value = obj[index];
		var roomName = value.children[0].children[0].value;
		if (roomName == "" || roomName == null || roomName == undefined){
			return '1';
		}
		if ($.inArray(roomName, dataNameArr) != -1){
			return '2';
		}
		if (roomName.length > 10){
			return '5';
		}
		dataNameArr[index] = roomName;
		var constructionArea = parseFloat(value.children[1].children[0].value).toFixed(2);
		if (constructionArea == "" || constructionArea == null || constructionArea == undefined || constructionArea == 'NaN'){
			return '3';
		}
		if (parseFloat(constructionArea) <= 0.00){
			return "7";
		}
		
		constructionAreaTotal = parseFloat(parseFloat(constructionAreaTotal) + parseFloat(constructionArea)).toFixed(2);
		if (index == (obj.length - 1)){
			if (flag == 'tr3'){
				var total = $('#area_1_input').val();
				if (parseFloat(constructionAreaTotal) > parseFloat(total)){
					return '10';
				}
			}
		}
		var usageArea = parseFloat(value.children[2].children[0].value).toFixed(2);
		if (usageArea == "" || usageArea == null || usageArea == undefined || usageArea == 'NaN'){
			return '4';
		}
		if (parseFloat(usageArea) <= 0.0){
			return "7";
		}
		var poolArea = parseFloat(value.children[3].children[0].value).toFixed(2);
		if (poolArea == "" || poolArea == null || poolArea == undefined || poolArea == 'NaN'){
			return '0';
		}
		if (parseFloat(poolArea) <= 0.0){
			return "7";
		}
		var poolAddUsage = parseFloat(parseFloat(usageArea) + parseFloat(poolArea)).toFixed(2)
		if (poolAddUsage != constructionArea){
			return '6';
		}
		
		var data = {
				'roomName':roomName,
				'constructionArea':constructionArea,
				'usageArea':usageArea,
				'poolArea':poolArea
		};
		dataArr.push(data);
	}
	return '-1';
}

function fdel2(){
	if ($('.del2').length > 1){
		$(this).parent().parent().remove();
	}    		
}

function fdel3(){
	if ($('.del3').length > 1){
		$(this).parent().parent().remove();
	}    		
}

function addTr(){
	var len = $('.tr3').length;
	var parent = $('.tr3').eq(len - 1);
	$('.tr3').eq(len-1).parent().append(parent.clone());
	$('.del3').click(fdel3);
}
function addTr2(){
	var len = $('.tr2').length;
	var parent = $('.tr2').eq(len - 1);
	$('.tr2').eq(len-1).parent().append(parent.clone());
	$('.del2').click(fdel2);
}

$(function(){
	$('.del2').click(fdel2);
	$('.del3').click(fdel3);
});