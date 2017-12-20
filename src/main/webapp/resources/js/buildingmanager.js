function changeBuilding(buildingId) {

	//alert(buildingId);
	
	var aj = $.ajax({
		url : basePath_ + '/spacelease/building/queryBuildingAreaInfo.html',
		type : 'post',
		cache : false,
		dataType : 'json',
		data : { id : buildingId },
		success : function(data) {
			//console.log(data);
			if(data && data.length > 0){
				$("#area_tbody_noresult").hide();
				$("#area_tbody tr:not(:first)").remove();
				$.each(data, function(index, val) {
					//console.log(index);
					//console.log(val);
					var url = (basePath_ + '/spacelease/building/info.html?id=' + val.buildingId);
					$("#area_tbody").append("<tr id='area_tbody_tr_" + index + "'></tr>");
					$("#area_tbody_tr_" + index).append("<td><a href='" + url + "'>" + val.buildingName + "</a></td>");
					$("#area_tbody_tr_" + index).append("<td>" + val.totalArea + " ㎡</td>");
					$("#area_tbody_tr_" + index).append("<td>" + val.alreadyArea + " ㎡</td>");
					$("#area_tbody_tr_" + index).append("<td>" + val.mayArea + " ㎡</td>");
					$("#area_tbody_tr_" + index).append("<td>" + val.alreadyPrice + " 元/月</td>");
					$("#area_tbody_tr_" + index).append("<td>" + val.chckinNumber + "</td>");
				});
			}else{
				$("#area_tbody_noresult").show();
				$("#area_tbody tr:not(:first)").remove();
			}
		},
		error : function() {
			//alert("异常！");
		}
	});

}