
$(function(){
    // 编辑
    var urlinfo = window.location.href; //获取当前页面的url
    var len = urlinfo.length;//获取url的长度
    var offset = urlinfo.indexOf("?");//设置参数字符串开始的位置
    var param = urlinfo.substr(offset, len)//取出参数字符串 这里会获得类似“id=1”这样的字符串
    var paramList = param.split("=");//对获得的参数字符串按照“=”进行分割
    var id = paramList[1].split("&")[0];//得到ID




    $.ajax({
        async: false,
        type: "POST",
        data:  {"id":id},
        url: 'download/getTypeNameByTypeId',
        dataType: 'json',
        success: function (data) {
            $("#typeName").html(data.typeName);
        }
    })

    $.ajax({
        async: false,
        type: "POST",
        data:  {"type":id},
        url: 'download/getAll',
        dataType: 'json',
        success: function (data) {
            var list = data.list;
            var html="";
            $.each(list,function (i) {
                html+="<li class='col-sm-6 col-md-4'>"+
                      "<div class='d-flex justify-content-between'>"+
                        "<div class='col-1 p-0'>"+
                            "<img src='./images/icon_2.png' alt='封面图'>"+
                        "</div>"+
                        "<div class='col-11'>"+
                            "<h2 class='one-txt-cut'>"+
                                "<a style='cursor: pointer' onclick='downloadDetail("+list[i].id+")'>"+list[i].fileName+"</a>"+
                            "</h2>"+
                            "<p class='txt-cut'>"+list[i].summary+"</p>"+
                            "<div>"+
                                "<span>发布时间：</span>"+
                                "<em>"+list[i].createTime.substring(0,10)+"</em>"+
                                "<span>下载：</span>"+
                                "<em>"+list[i].loadCount+"</em>"+
                            "</div>"+
                        "</div>"+
                      "</div>"+
                      "</li>";
            })
            $("#list").append(html);
        }
    })
})

function downloadDetail(id) {
    window.location.href="toDownloadDetail?id="+id;

}