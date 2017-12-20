/**
 * Created by zxm on 2017/3/10.
 */
$.fn.extend({
    "initUpload":function(opt) {
        if (typeof opt != "object") {
            alert('鍙傛暟閿欒!');
            return;
        }
        var uploadId = $(this).attr("id");
        if(uploadId==null||uploadId==""){
            alert("瑕佽瀹氫竴涓猧d!");
        }
        $.each(uploadTools.getInitOption(uploadId), function (key, value) {
            if (opt[key] == null) {
                opt[key] = value;
            }
        });
        uploadTools.initWithLayout(opt);//鍒濆鍖栧竷灞€
        uploadTools.initWithDrag(opt);//鍒濆鍖栨嫋鎷�
        uploadTools.initWithSelectFile(opt);//鍒濆鍖栭€夋嫨鏂囦欢鎸夐挳
        uploadTools.initWithUpload(opt);//鍒濆鍖栦笂浼�
        uploadTools.initWithCleanFile(opt);
        uploadFileList.initFileList();
    }
});
/**
 * 涓婁紶鍩烘湰宸ュ叿鍜屾搷浣�
 */
var uploadTools = {
    /**
     * 鍩烘湰閰嶇疆鍙傛暟
     * @param uploadId
     * @returns {{uploadId: *, url: string, autoCommit: string, canDrag: boolean, fileType: string, size: string, ismultiple: boolean, showSummerProgress: boolean}}
     */
    "getInitOption":function(uploadId){
        //url test娴嬭瘯闇€瑕佹洿鏀�
        var initOption={
            "uploadId":uploadId,
            "uploadUrl":"#",//蹇呴』锛屼笂浼犲湴鍧€
            "progressUrl":"#",//鍙€夛紝鑾峰彇杩涘幓淇℃伅鐨剈rl
            "autoCommit":false,//鏄惁鑷姩涓婁紶
            "canDrag":true,//鏄惁鍙互鎷栧姩
            "fileType":"*",//鏂囦欢绫诲瀷
            "size":"-1",//鏂囦欢澶у皬闄愬埗,鍗曚綅kB
            "ismultiple":true,//鏄惁閫夋嫨澶氭枃浠�
            "showSummerProgress":true,//鏄剧ず鎬昏繘搴︽潯
            "filelSavePath":"",//鏂囦欢涓婁紶鍦板潃锛屽悗鍙拌缃殑鏍圭洰褰�
            "beforeUpload":function(){//鍦ㄤ笂浼犲墠闈㈡墽琛岀殑鍥炶皟鍑芥暟
            },
            "onUpload":function(){//鍦ㄤ笂浼犱箣鍚�
                alert("hellos");
            }

        };
        return initOption;
    },
    /**
     * 鍒濆鍖栨枃浠朵笂浼�
     * @param opt
     */
    "initWithUpload":function(opt){
        var uploadId = opt.uploadId;
        $("#"+uploadId+" .uploadBts .uploadFileBt").on("click",function(){
            uploadEvent.uploadFileEvent(opt);
        });
        $("#"+uploadId+" .uploadBts .uploadFileBt i").css("color","#0099FF");


    },
    /**
     * 鍒濆鍖栨竻闄ゆ枃浠�
     * @param opt
     */
    "initWithCleanFile":function(opt){

        var uploadId = opt.uploadId;
        $("#"+uploadId+" .uploadBts .cleanFileBt").on("click",function(){
            uploadEvent.cleanFileEvent(opt);
        });
        $("#"+uploadId+" .uploadBts .cleanFileBt i").css("color","#0099FF");

    },
    /**
     * 鍒濆鍖栭€夋嫨鏂囦欢鎸夐挳
     * @param opt
     */
    "initWithSelectFile":function(opt){
        var uploadId = opt.uploadId;
        $("#"+uploadId+" .uploadBts .selectFileBt").on("click",function(){
            uploadEvent.selectFileEvent(opt);
        });
        $("#"+uploadId+" .uploadBts .selectFileBt").css("background-color","#0099FF");
    },
    /**
     * 杩斿洖鏄剧ず鏂囦欢绫诲瀷鐨勬ā鏉�
     * @param isImg 鏄惁寮忓浘鐗囷細true/false
     * @param fileType 鏂囦欢绫诲瀷
     * @param fileName 鏂囦欢鍚嶅瓧
     * @param isImgUrl 濡傛灉浜嬫枃浠舵椂鐨勬枃浠跺湴鍧€榛樿涓簄ull
     */
    "getShowFileType":function(isImg,fileType,fileName,isImgUrl,fileCodeId){
        var showTypeStr="<div class='fileType'>"+fileType+"</div> <i class='iconfont icon-wenjian'></i>";//榛樿鏄剧ず绫诲瀷
        if(isImg){
            if(isImgUrl!=null&&isImgUrl!="null"&&isImgUrl!=""){//鍥剧墖鏄剧ず绫诲瀷
                showTypeStr = "<img src='"+isImgUrl+"'/>";
            }
        }
        var modelStr="";
        modelStr+="<div class='fileItem'  fileCodeId='"+fileCodeId+"'>";
        modelStr+="<div class='imgShow'>";
        modelStr+=showTypeStr;
        modelStr+=" </div>";
        modelStr+=" <div class='progress'>";
        modelStr+="<div class='progress_inner'></div>";
        modelStr+="</div>";
        modelStr+="<div class='status'>";
        modelStr+="<i class='iconfont icon-shanchu'></i>";
        modelStr+="</div>";
        modelStr+=" <div class='fileName'>";
        modelStr+=fileName;
        modelStr+="</div>";
        modelStr+=" </div>";
        return modelStr;
    },
    /**
     * 鍒濆鍖栧竷灞€
     * @param opt 鍙傛暟瀵硅薄
     */
    "initWithLayout":function(opt){
        var uploadId = opt.uploadId;
        //閫夋嫨鏂囦欢鍜屼笂浼犳寜閽ā鏉�
        var btsStr = "";
        btsStr += "<div class='uploadBts'>";
        btsStr += "<div>";
        btsStr += "<div class='selectFileBt'>请选择文件</div>";
        btsStr += "</div>";
        btsStr += "<div class='uploadFileBt'>";
        btsStr += "<i class='iconfont icon-shangchuan'></i>";
        btsStr += " </div>";
        btsStr += "<div class='cleanFileBt'>";
        btsStr += "<i class='iconfont icon-qingchu'></i>";
        btsStr += " </div>";
        btsStr += "</div>";
        $("#"+uploadId).append(btsStr);
        //娣诲姞鎬昏繘搴︽潯
        if(opt.showSummerProgress){
            var summerProgressStr = "<div class='subberProgress'>";
            summerProgressStr += "<div class='progress'>";
            summerProgressStr += "<div>0%</div>";
            summerProgressStr += "</div>";
            summerProgressStr += " </div>";
            $("#"+uploadId).append(summerProgressStr);
        }
        //娣诲姞鏂囦欢鏄剧ず妗�
        var boxStr = "<div class='box'></div>";
        $("#"+uploadId).append(boxStr);
    },
    /**
     * 鍒濆鍖栨嫋鎷戒簨浠�
     * @param opt 鍙傛暟瀵硅薄
     */
    "initWithDrag":function(opt){
        var canDrag = opt.canDrag;
        var uploadId = opt.uploadId;
        if(canDrag){
            $(document).on({
                dragleave:function(e){//鎷栫聽
                    e.preventDefault();
                },
                drop:function(e){//鎷栧悗鏀韭�
                    e.preventDefault();
                },
                dragenter:function(e){//鎷栬繘聽
                    e.preventDefault();
                },
                dragover:function(e){//鎷栨潵鎷栧幓聽
                    e.preventDefault();
                }
            });
            var box = $("#"+uploadId+" .box").get(0);
            if(box!=null){
                //楠岃瘉鍥剧墖鏍煎紡锛屽ぇ灏忥紝鏄惁瀛樺湪
                box.addEventListener("drop",function(e) {
                    uploadEvent.dragListingEvent(e,opt);
                });
            }
        }
    },
    /**
     * 鍒犻櫎鏂囦欢
     * @param opt
     */
    "initWithDeleteFile":function(opt){
        var uploadId = opt.uploadId;
        $("#"+uploadId+" .fileItem .status i").on("click",function(){
            uploadEvent.deleteFileEvent(opt,this);
        })
    },
    /**
     * 鑾峰彇鏂囦欢鍚嶅悗缂€
     * @param fileName 鏂囦欢鍚嶅叏鍚�
     * */
    "getSuffixNameByFileName":function(fileName){
        var str = fileName;
        var pos = str.lastIndexOf(".")+1;
        var lastname = str.substring(pos,str.length);
        return lastname;
    },
    /**
     * 鍒ゆ柇鏌愪釜鍊兼槸鍚﹀湪杩欎釜鏁扮粍鍐�
     * */
    "isInArray":function(strFound,arrays){
        var ishave = false;
        for(var i=0;i<arrays.length;i++){
            if(strFound==arrays[i]){
                ishave = true;
                break;
            }
        }
        return ishave;
    },
    /**
     * 鏂囦欢鏄惁宸茬粡瀛樺湪
     * */
    "fileIsExit":function(file){
        var fileList = uploadFileList.fileList;
        var ishave = false;
        for(var i=0;i<fileList.length;i++){
            //鏂囦欢鍚嶇浉鍚岋紝鏂囦欢澶у皬鐩稿悓
            if(fileList[i]!=null&&fileList[i].name ==file.name&&fileList[i].size==file.size){
                ishave = true;
            }
        }
        return ishave;
    },
    /**
     * 娣诲姞鏂囦欢鍒板垪琛�
     * */
    "addFileList":function(fileList,opt){
        var uploadId = opt.uploadId;
        var boxJsObj =  $("#"+uploadId+" .box").get(0);
        var fileListArray=uploadFileList.getFileList();
        var fileNumber = uploadTools.getFileNumber(opt);
        if(fileNumber+fileList.length>opt.maxFileNumber){
            alert("文件个数超过"+opt.maxFileNumber+"个");
            return;
        }
        var imgtest=/image\/(\w)*/;//鍥剧墖鏂囦欢娴嬭瘯
        var fileTypeArray = opt.fileType;//鏂囦欢绫诲瀷闆嗗悎
        var fileSizeLimit = opt.size;//鏂囦欢澶у皬闄愬埗
        for(var i=0;i<fileList.length;i++){
            //鍒ゆ柇鏂囦欢鏄惁瀛樺湪
            if(uploadTools.fileIsExit(fileList[i])){
                alert("文件"+fileList[i].name+"已经存在");
                continue;
            }
            var fileTypeStr =  uploadTools.getSuffixNameByFileName(fileList[i].name);
            //鏂囦欢澶у皬鏄剧ず鍒ゆ柇
            if(fileSizeLimit!=-1&&fileList[i].size>(fileSizeLimit*1000)){
                alert("文件"+fileList[i].name+"超过最大"+fileSizeLimit+"KB数");
                continue;
            }
            //鏂囦欢绫诲瀷鍒ゆ柇
            if(fileTypeArray=="*"||uploadTools.isInArray(fileTypeStr,fileTypeArray)){
                var fileTypeUpcaseStr = fileTypeStr.toUpperCase();
                if(imgtest.test(fileList[i].type)){
                    //var imgUrlStr = window.webkitURL.createObjectURL(fileList[i]);//鑾峰彇鏂囦欢璺緞
                    var imgUrlStr ="";//鑾峰彇鏂囦欢璺緞
                    if (window.createObjectURL != undefined) { // basic
                        imgUrlStr = window.createObjectURL(fileList[i]);
                    } else if (window.URL != undefined) { // mozilla(firefox)
                        imgUrlStr = window.URL.createObjectURL(fileList[i]);
                    } else if (window.webkitURL != undefined) { // webkit or chrome
                        imgUrlStr = window.webkitURL.createObjectURL(fileList[i]);
                    }
                    var fileModel = uploadTools.getShowFileType(true,fileTypeUpcaseStr,fileList[i].name,imgUrlStr,fileListArray.length);
                    $(boxJsObj).append(fileModel);
                }else{
                    var fileModel = uploadTools.getShowFileType(true,fileTypeUpcaseStr,fileList[i].name,null,fileListArray.length);
                    $(boxJsObj).append(fileModel);
                }
                uploadTools.initWithDeleteFile(opt);
                fileListArray[fileListArray.length] = fileList[i];
            }else{
                alert("涓嶆敮鎸佽鏍煎紡鏂囦欢涓婁紶:"+fileList[i].name);
            }
        }
        uploadFileList.setFileList(fileListArray);

    },
    /**
     * 娓呴櫎閫夋嫨鏂囦欢鐨刬nput
     * */
    "cleanFilInputWithSelectFile":function(opt){
        var uploadId = opt.uploadId;
        $("#"+uploadId+"_file").remove();
    },
    /**
     * 鏍规嵁鍒跺畾淇℃伅鏄剧ず
     */
    "showUploadProgress":function(opt,bytesRead,percent){

        var uploadId = opt.uploadId;
        var fileListArray = uploadFileList.getFileList();
        if(opt.showSummerProgress){
            var progressBar = $("#"+uploadId+" .subberProgress .progress>div");
            progressBar.css("width",percent+"%");
            progressBar.html(percent+"%");
        }
        for(var i=0;i<fileListArray.length;i++){
            if(fileListArray[i]==null){
                continue;
            }
            var testbytesRead =bytesRead -fileListArray[i].size;
            if(testbytesRead<0){
                if(percent==100){
                    $("#"+uploadId+" .box .fileItem[fileCodeId='"+i+"'] .progress>div").addClass("error");
                    $("#"+uploadId+" .box .fileItem[fileCodeId='"+i+"'] .progress>div").css("width","100%");
                    $("#"+uploadId+" .box .fileItem[fileCodeId='"+i+"'] .status>i").addClass("iconfont icon-cha");
                    bytesRead = bytesRead-fileListArray[i].size;
                }else{
                    $("#"+uploadId+" .box .fileItem[fileCodeId='"+i+"'] .progress>div").css("width",(bytesRead/fileListArray[i].size*100)+"%");
                    break;
                }
            }else if(testbytesRead>=0){

                $("#"+uploadId+" .box .fileItem[fileCodeId='"+i+"'] .status>i").addClass("iconfont icon-gou");
                $("#"+uploadId+" .box .fileItem[fileCodeId='"+i+"'] .progress>div").css("width","100%");
                bytesRead = bytesRead-fileListArray[i].size;
            }
        }
    },
	/**
     * 涓婁紶鏂囦欢澶辫触闆嗕綋鏄剧ず
     * @param opt
     */
    "uploadError":function(opt){
        var uploadId = opt.uploadId;
        $("#"+uploadId+" .box .fileItem .progress>div").addClass("error");
        $("#"+uploadId+" .box .fileItem .progress>div").css("width","100%");
        $("#"+uploadId+" .box .fileItem .status>i").addClass("iconfont icon-cha");
        var progressBar = $("#"+uploadId+" .subberProgress .progress>div");
        progressBar.css("width","0%");
        progressBar.html("0%");
    },
    /**
     * 涓婁紶鏂囦欢
     */
    "uploadFile":function(opt){
        var uploadUrl = opt.uploadUrl;
        var fileList = uploadFileList.getFileList();

        var formData = new FormData();
        var fileNumber = uploadTools.getFileNumber(opt);
        if(fileNumber<=0){
            alert("还没有选中文件");
            return;
        }

        for(var i=0;i<fileList.length;i++){
            if(fileList[i]!=null){
                formData.append("file",fileList[i]);
            }
        }

        formData.append("filelSavePath",opt.filelSavePath);
        if(uploadUrl!="#"&&uploadUrl!=""){
            uploadTools.disableFileUpload(opt);//绂佺敤鏂囦欢涓婁紶
            uploadTools.disableCleanFile(opt);//绂佺敤娓呴櫎鏂囦欢
            uploadTools.disableSelectFile(opt);//绂佹閫夋嫨鏂囦欢

            $.ajax({
                type:"post",
                url:uploadUrl,
                data:formData,
                processData : false,
                contentType : false,
                /*  beforeSend: function(request) {
                 request.setRequestHeader("filePath", file_path);
                 }, */
                success:function(data){
                    setTimeout(function(){opt.onUpload(opt,data)},500);
                },
                error:function(e){
                		
                }
            });

        }else{
            uploadTools.disableFileUpload(opt);//绂佺敤鏂囦欢涓婁紶
            uploadTools.disableCleanFile(opt);//绂佺敤娓呴櫎鏂囦欢
            uploadTools.disableSelectFile(opt);//绂佹閫夋嫨鏂囦欢
        }

        uploadTools.getFileUploadPregressMsg(opt);

    },
    /**
     *  鑾峰彇鏂囦欢涓婁紶杩涘害淇℃伅
     */
    "getFileUploadPregressMsg":function(opt){
        var uploadId = opt.uploadId;
        var progressUrl = opt.progressUrl;
        if(opt.showSummerProgress){
            $("#"+uploadId+" .subberProgress").css("display","block");
        }
        $("#"+uploadId+" .box .fileItem .status>i").removeClass();
        if(progressUrl!="#"&&progressUrl!="") {
            var intervalId = setInterval(function(){
                $.get(progressUrl,{},function(data,status){
                    console.log(data);
                    var percent = data.percent;
                    var bytesRead = data.bytesRead;
                    if(percent >= 100){
                        clearInterval(intervalId);
                        percent = 100;//涓嶈兘澶т簬100
                        uploadTools.initWithCleanFile(opt);
                    }
                    uploadTools.showUploadProgress(opt, bytesRead, percent);
                },"json");
            },500);
        }else{
            var percent = 0;
            var bytesRead = 0;
            var intervalId = setInterval(function(){
                percent+=5;
                bytesRead+=50000;
                if(percent >= 100){
                    clearInterval(intervalId);
                    percent = 100;//涓嶈兘澶т簬100
                    uploadTools.initWithCleanFile(opt);
                }
                uploadTools.showUploadProgress(opt, bytesRead, percent);
            },500);
        }
    },
    /**
     * 绂佺敤鏂囦欢涓婁紶
     */
    "disableFileUpload":function(opt){
        var uploadId = opt.uploadId;
        $("#"+uploadId+" .uploadBts .uploadFileBt").off();
        $("#"+uploadId+" .uploadBts .uploadFileBt i").css("color","#DDDDDD");

    },
    /**
     * 绂佺敤鏂囦欢娓呴櫎
     */
    "disableCleanFile":function(opt){
        var uploadId = opt.uploadId;
        $("#"+uploadId+" .uploadBts .cleanFileBt").off();
        $("#"+uploadId+" .uploadBts .cleanFileBt i").css("color","#DDDDDD");
    },
    /**
     * 绂佹閫夋嫨鏂囦欢
     * @param opt
     */
    "disableSelectFile":function(opt){
        var uploadId = opt.uploadId;
        $("#"+uploadId+" .uploadBts .selectFileBt").off();
        $("#"+uploadId+" .uploadBts .selectFileBt").css("background-color","#DDDDDD");
    },
    /**
     * 鑾峰彇鏂囦欢涓暟
     * @param opt
     */
    "getFileNumber":function(opt){
        var number = 0;
        var fileList = uploadFileList.getFileList();
        for(var i=0;i<fileList.length;i++){
            if(fileList[i]!=null){
                number++;
            }
        }
        return number;
    }
}
/**
 * 涓婁紶浜嬩欢鎿嶄綔
 * */
var uploadEvent = {
    /**
     * 鎷栧姩鏃舵搷浣滀簨浠�
     */
    "dragListingEvent":function(e,opt){

        e.preventDefault();//鍙栨秷榛樿娴忚鍣ㄦ嫋鎷芥晥鏋溌�
        var fileList = e.dataTransfer.files;//鑾峰彇鏂囦欢瀵硅薄
        uploadTools.addFileList(fileList,opt);
        if(opt.autoCommit){
            uploadEvent.uploadFileEvent(opt);
        }

    },
    /**
     * 鍒犻櫎鏂囦欢瀵瑰簲鐨勪簨浠�
     * */
    "deleteFileEvent":function(opt,obj){
        var fileItem = $(obj).parent().parent();
        var fileCodeId = fileItem.attr("fileCodeId");
        var fileListArray = uploadFileList.getFileList();
        delete fileListArray[fileCodeId];
        uploadFileList.setFileList(fileListArray);
        fileItem.remove();

    },
    /**
     * 閫夋嫨鏂囦欢鎸夐挳浜嬩欢
     * @param opt
     */
    "selectFileEvent":function(opt){
        var uploadId = opt.uploadId;
        var ismultiple = opt.ismultiple;
        var inputObj=document.createElement('input');
        inputObj.setAttribute('id',uploadId+'_file');
        inputObj.setAttribute('type','file');
        inputObj.setAttribute("style",'visibility:hidden');
        if(ismultiple){//鏄惁閫夋嫨澶氭枃浠�
            inputObj.setAttribute("multiple","multiple");
        }
        //inputObj.setAttribute("onchange","uploadEvent.selectFileChangeEvent(this.files,"+opt+")");
        $(inputObj).on("change",function(){
            uploadEvent.selectFileChangeEvent(this.files,opt);
        });
        document.body.appendChild(inputObj);
        inputObj.click();
    },
    /**
     * 閫夋嫨鏂囦欢鍚庡鏂囦欢鐨勫洖璋冧簨浠�
     * @param opt
     */
    "selectFileChangeEvent":function(files,opt){
        uploadTools.addFileList(files,opt);
        uploadTools.cleanFilInputWithSelectFile(opt);

        if(opt.autoCommit){
            uploadEvent.uploadFileEvent(opt);
        }
    },
    /**
     * 涓婁紶鏂囦欢鐨勪簨浠�
     * */
    "uploadFileEvent":function(opt){
        opt.beforeUpload(opt);

        uploadTools.uploadFile(opt);
    },
    /**
     * 娓呴櫎鏂囦欢浜嬩欢
     */
    "cleanFileEvent":function(opt){
        var uploadId = opt.uploadId;
        if(opt.showSummerProgress){
            $("#"+uploadId+" .subberProgress").css("display","none");
            $("#"+uploadId+" .subberProgress .progress>div").css("width","0%");
            $("#"+uploadId+" .subberProgress .progress>div").html("0%");
        }
        uploadTools.cleanFilInputWithSelectFile(opt);
        uploadFileList.setFileList([]);
        $("#"+uploadId+" .box").html("");
        uploadTools.initWithUpload(opt);//鍒濆鍖栦笂浼�
        uploadTools.initWithSelectFile(opt);//鍒濆鍖栭€夋嫨鏂囦欢
    }
}

var uploadFileList={
    "fileList":[],
    "initFileList":function(){
        uploadFileList.fileList = new Array();
    },
    "getFileList":function(){
        return uploadFileList.fileList;
    },
    "setFileList":function(fileList){
        uploadFileList.fileList = fileList;
    }
}