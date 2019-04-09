var type;
var oneId;
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
        url: 'download/getOneById',
        dataType: 'json',
        success: function (data) {
            type=data.type;
            oneId=data.id;
            $("#fileName").html(data.fileName);
            $("#loadCount").html(data.loadCount);
            $("#createTime").html(data.createTime.substring(0,10));
            $("#summary").html(data.summary);
            document.getElementById("url").download=data.fileName;
            document.getElementById("url").href=data.url;
            $("#img").attr("src",data.img);
        }
    })

    loadList();
    laodAdvertisement();
})

//加载相关下载
function loadList(){

    $.ajax({
        async: false,
        type: "POST",
        data: {"type":type},
        url: 'download/listMoreDownloadByType',
        dataType: 'json',
        success: function (data) {
            var list = data.list;
            var html="";
            var index=1;
            $.each(list, function(i) {
                if(index>5){
                    return;
                }
                if(list[i].id!=oneId){
                    html+=  "<li class='row'>"+
                                "<div class='col-3'>"+
                                    "<img src='"+list[i].img+"'>"+
                                "</div>"+
                                "<div class='col-9'>"+
                                    "<h2>"+
                                        "<a style='cursor: pointer' onclick='downloadDetail("+list[i].id+")' class='txt-cut'>"+list[i].fileName+"</a>"+
                                    "</h2>"+
                                    "<div class='d-flex justify-content-between align-items-center'>"+
                                        "<h6>"+list[i].createTime.substring(0,10)+"</h6>"+
                                        "<p>"+list[i].loadCount+"</p>"+
                                    "</div>"+
                                "</div>"+
                            "</li>";
                    index+=1;
                }

            })


            $("#list").append(html);

        }
    })
}

//加载广告
function laodAdvertisement(){
    $.ajax({
        async: false,
        type: "POST",
        data:  {"state":1,"block":4},
        url: 'advertisement/indexAdvertisement',
        dataType: 'json',
        success: function (data) {
            var list = data.list;
            var html="";
            if(list!=null){

                html+="<a href='"+list[0].url+"'>"+
                         "<div class='d-flex justify-content-center img'>"+
                            "<img src='"+list[0].img+"'>"+
                         "</div>"+
                       "</a>";

                $("#ad").append(html);
            }
        }
    })
}

function addLoadCount() {
    $.ajax({
        async: false,
        type: "POST",
        data:  {"id":oneId},
        url: 'download/addLoadCount',
        dataType: 'json',
        success: function (data) {
            window.location.reload();
        }
    })
}

//详情
function downloadDetail(id) {
    window.location.href="toDownloadDetail?id="+id;
}