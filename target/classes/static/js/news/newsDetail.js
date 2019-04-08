
var place;
var type;
$(function(){

    // 编辑
    var urlinfo = window.location.href; //获取当前页面的url
    var len = urlinfo.length;//获取url的长度
    var offset = urlinfo.indexOf("?");//设置参数字符串开始的位置
    var param = urlinfo.substr(offset, len)//取出参数字符串 这里会获得类似“id=1”这样的字符串
    var paramList = param.split("=");//对获得的参数字符串按照“=”进行分割
    var id = paramList[1].split("&")[0];//得到ID
    place = paramList[2].split("&")[0];//得到place
    type = paramList[3];//得到type

    console.log(paramList)
    console.log(id)
    console.log(place)
    console.log(type)

    $.ajax({
        async: false,
        type: "POST",
        data:  {"id":id,"type":type,"place":place},
        url: 'news/getOneById',
        dataType: 'json',
        success: function (data) {
            $("#title").html(data.news.title);
            $("#time").html(data.news.createTime.substring(0,10));
            $("#readCount").html(data.news.readCount);
            $("#contentText").html(data.news.content);

            if(data.preNews!=null){
                $("#preId").val(data.preNews.id);
                $("#preNewsTitle").html(data.preNews.title);
            }else{
                $("#preId").val(null);
                $("#preNewsTitle").html("没有了");
            }

            if(data.nextNews!=null){
                $("#nextId").val(data.nextNews.id);
                $("#nextNewsTitle").html(data.nextNews.title);
            }else{
                $("#nextId").val(null);
                $("#nextNewsTitle").html("没有了");
            }

        }
    })
})

//上一条新闻详情
function preNewsDetail() {
    var id = $("#preId").val();
    if(id!=null){
        window.location.href="toNewsDetail?id="+id+"&place="+place+"&type="+type;
    }

}

//下一条新闻详情
function nextNewsDetail() {
    var id = $("#nextId").val();
    if(id!=null){
        window.location.href="toNewsDetail?id="+id+"&place="+place+"&type="+type;
    }

}