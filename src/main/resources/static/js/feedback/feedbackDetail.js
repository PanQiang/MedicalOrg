$(function(){
    // 编辑
    var urlinfo = window.location.href; //获取当前页面的url
    var len = urlinfo.length;//获取url的长度
    var offset = urlinfo.indexOf("?");//设置参数字符串开始的位置
    var param = urlinfo.substr(offset, len)//取出参数字符串 这里会获得类似“id=1”这样的字符串
    var paramList = param.split("=");//对获得的参数字符串按照“=”进行分割
    var id = paramList[1];//得到ID


    $.ajax({
        async: false,
        type: "POST",
        data:  {"id":id},
        url: 'feedback/getOneById',
        dataType: 'json',
        success: function (data) {
            $("#createTime").val(data.createTime.substring(0,10));
            $("#title").val(data.title);
            $("#content").val(data.content);
            if(data.replyTime!=null){
                $("#replyTime").val(data.replyTime.substring(0,10));
            }

            $("#reply").val(data.reply);
        }
    })

})