/**
 * Created by SunCoder on 2017/7/28.
 */

function initInput() {
    $(".sccheck input").click(function () {
        $(this).parent().toggleClass("check");
    });
    $(".scradio input").click(function () {
        $('.scradio input[name=' + $(this).attr('name') + ']').parent().removeClass("check");
        $(this).parent().addClass("check");
    });
}
$(function () {
    initInput();
    $(".scnav li a").click(function () {
        var tis = $(this);
        tis.next(".scnav-second-level").slideToggle(200, function () {
            tis.find(".up").toggle();
            tis.find(".dw").toggle();
        });
    });
});
/**
 * Created by SunCoder on 2017/8/3.
 */

uploadApk = function (opts) {
    opts.timeout = opts.timeout ? opts.timeout : 10 * 60 * 1000;
    opts.auto = opts.auto ? opts.auto : true;
    opts.chunkRetry = opts.chunkRetry ? opts.chunkRetry : 1;
    opts.compress = opts.compress ? opts.compress : false;
    var uploader = WebUploader.create(opts)
        .on('beforeFileQueued',function(file){
            // if(file.type != "application/octet-stream" && file.ext != "apk"){return false;}
        })
        .on('fileQueued', function (file) {
            var queu = $('<div class="sc-progress" id="' + file.id + '">' +
                '<span class="filename">' + file.name.substring(0, 25) + '... (' + parseInt(file.size / 1024 / 1024) + 'MB)</span><span class="data"> - 0%</span>' +
                '<div class="sc-progress-bar"><div class="sc-progress-bar-in" style="width: 0%;"><!--Progress Bar--></div></div>' +
                '</div>');
            $(opts.pick).append(queu);
        })
        .on('uploadStart',function(file){
            if (opts.uploadStart && (typeof opts.uploadStart) == 'function') {opts.uploadStart(file);}
        })
        .on('uploadProgress', function (file, percentage) {
            if (percentage == 1) {
                $('#' + file.id).find('.fileName').html('文件上传完毕,正在处理中,');
                $('#' + file.id).find('.data').html('文件越大时间越长...');
            }
            else {
                var $li = $('#' + file.id);
                $li.find('.data').html(' - ' + parseInt(percentage * 100) + '%');
                $li.find('.sc-progress-bar-in').css('width', percentage * 100 + '%');
            }
        })
        .on('uploadSuccess', function (file, response) {
            if (opts.uploadSuccess && (typeof opts.uploadSuccess) == 'function') {opts.uploadSuccess(file, response);}
        })
        .on('uploadError', function (file, response) {
            if (opts.uploadError && (typeof opts.uploadError) == 'function') {opts.uploadError(response);}
        })
        .on('uploadComplete', function (file) {
            uploader.removeFile(file);
            $(opts.pick).find('.sc-progress').fadeOut(1200,function(){$(opts.pick).find('.progress').fadeOut()});
            uploader.reset();
            if (opts.uploadComplete && (typeof opts.uploadComplete) == 'function') {opts.uploadComplete(file);}
        });
    return uploader;
};
uploadImg = function (opts) {
    // opts.timeout = opts.timeout ? opts.timeout : 10 * 60 * 1000;
    opts.auto = opts.auto ? opts.auto : true;
    opts.chunkRetry = opts.chunkRetry ? opts.chunkRetry : 1;
    opts.compress = opts.compress ? opts.compress : false;
    var uploader = WebUploader.create(opts)
        .on('uploadStart',function(file){
            // LoadingShow(opts.pick);
        })
        .on('uploadSuccess', function (file, response) {
            if (opts.uploadSuccess && (typeof opts.uploadSuccess) == 'function') {opts.uploadSuccess(file, response);}
        })
        .on('uploadError', function (file,response) {
            if (opts.uploadError && (typeof opts.uploadError) == 'function') {opts.uploadError(response);}
        })
        .on('uploadComplete', function (file) {
            uploader.removeFile(file);
            // LoadingHide(opts.pick);
            $(opts.pick).find('.progress').fadeOut();
        });
    return uploader;
};