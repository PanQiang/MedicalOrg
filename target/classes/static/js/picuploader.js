/**
 * Created by xyb on 2018/1/30.
 */

var picuploader = {


    init:function (targetid,viewid,uploadpicname) {
        //图片上传

    	
        var uploader = new Q.Uploader({
            url: "upload",
            target: document.getElementById(targetid),
            view: document.getElementById(viewid),
            auto: false,
            upName: "test",
            allows: ".jpg,.png,.gif,.bmp",
            multiple: false,
            dataType:"string",
            	
            on: {
                //添加之前触发
                add: function (task) {
                    if (task.disabled) return alert("允许上传的文件格式为：" + this.ops.allows);
                    $("#"+viewid).children('img').remove();
                },
                //图片预览后触发
                preview: function (data) {
                    console.log(data.task.name + " : " + data.src);
                    
                },
                complete:function (data) {
                    console.log(data.response);
                    $("#"+uploadpicname).val(data.response);
                }
            }
        });
        return uploader;
    },
    btnclick:function (selectid,myuploader) {
        $("#"+selectid).on('click',function () {
            myuploader.start();
        });
    },
    initByUrl:function (targetid,viewid,uploadpicname,uploadUrl) {
        //图片上传

    	
        var uploader = new Q.Uploader({
            url: uploadUrl,
            target: document.getElementById(targetid),
            view: document.getElementById(viewid),
            auto: false,
            upName: "test",
            allows: ".jpg,.png,.gif,.bmp",
            multiple: false,
            dataType:"string",
            	
            on: {
                //添加之前触发
                add: function (task) {
                    if (task.disabled) return alert("允许上传的文件格式为：" + this.ops.allows);
                    $("#"+viewid).children('img').remove();
                },
                //图片预览后触发
                preview: function (data) {
                    console.log(data.task.name + " : " + data.src);
                    
                },
                complete:function (data) {
                    console.log(data.response);
                    $("#"+uploadpicname).val(data.response);
                }
            }
        });
        return uploader;
    },
    
    init2:function (targetid,viewid,uploadpicname,divId) {
        //图片上传

    	
        var uploader = new Q.Uploader({
            url: "upload",
            target: document.getElementById(targetid),
            view: document.getElementById(viewid),
            auto: false,
            upName: "test",
            allows: ".jpg,.png,.gif,.bmp",
            multiple: false,
            dataType:"string",
            	
            on: {
                //添加之前触发
                add: function (task) {
                    if (task.disabled) return alert("允许上传的文件格式为：" + this.ops.allows);
                    $("#"+divId).removeAttr("style");
                },
                //图片预览后触发
                preview: function (data) {
                    console.log(data.task.name + " : " + data.src);
                    
                },
                complete:function (data) {
                    console.log(data.response);
                    $("#"+uploadpicname).val(data.response);
                }
            }
        });
        return uploader;
    }






}