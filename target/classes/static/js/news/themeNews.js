
$(function(){

    $.ajax({
        async: false,
        type: "POST",
        data:  {"type":3,"place":1},
        url: 'news',
        dataType: 'json',
        success: function (data) {

            var elem = document.getElementById("themeNews");
            while(elem.hasChildNodes()) //当elem下还存在子节点时 循环继续
            {
                elem.removeChild(elem.firstChild);
            }

            var list = data.list;

            var html="";
            $.each(list, function(i) {
                html+="<li style='cursor: pointer' onclick='newsDetail("+list[i].id+",1,3)' class='col-6 col-sm-4'>"+
                         "<div>"+
                            "<a>"+
                                "<img src='"+list[i].imgUrl+"'>"+
                            "</a>"+
                         "</div>"+
                         "<h2 class='one-txt-cut'>"+
                            "<a >"+list[i].title+"</a>"+
                         "</h2>"+
                         "</li>";
            })
            $("#themeNews").append(html)

        }
    })
})


//新闻详情
function newsDetail(id,place,type) {
    window.location.href="toNewsDetail?id="+id+"&place="+place+"&type="+type;
}