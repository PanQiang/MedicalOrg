
$(function(){
    $.ajax({
        async: false,
        type: "POST",
        data: null,
        url: 'download/listDownloadType',
        dataType: 'json',
        success: function (data) {
            var list = data.list;
            var html="";
            var elem1 = document.getElementById("downloadType");
            while(elem1.hasChildNodes()) //当elem下还存在子节点时 循环继续
            {
                elem1.removeChild(elem1.firstChild);
            }

            $.each(list, function(i) {
                html+="<div class='row'>"+
                          "<div class='col-12'>"+
                              "<div class='commonTitle'>"+
                                  "<h3>"+list[i].typeName+"</h3>"+
                                  "<a style='cursor: pointer' onclick='toMore("+list[i].id+")'>更多</a>"+
                              "</div>"+
                          "</div>"+
                       "</div>"+
                       "<div class='row'>"+
                            "<ul style='margin-bottom: 30px' id='type_"+list[i].id+"' class='d-flex flex-wrap item'></ul>"+
                       "</div>";

            })

            $("#downloadType").append(html);
            $.each(list, function(i) {
                    loadDownloadList(list[i].id);

            })
        }
    })
})


//根据类型加载列表
function loadDownloadList(type){
    $.ajax({
        async: false,
        type: "POST",
        data: {"type":type},
        url: 'download/listMoreDownloadByType',
        dataType: 'json',
        success: function (data) {
            var id = "type_"+type;
            var list = data.list;
            var html="";
            $.each(list, function(i) {
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


            var idstr = "#"+id;
            $(idstr).append(html);

        }
    })
}

//更多
function toMore(type){
    window.location.href="toMoreDownload?type="+type;
}


//新闻详情
function downloadDetail(id) {
    window.location.href="toDownloadDetail?id="+id;

}