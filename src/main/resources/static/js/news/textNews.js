
$(function(){

    $.ajax({
        async: false,
        type: "POST",
        data:  {"type":1,"place":1},
        url: 'news',
        dataType: 'json',
        success: function (data) {

            var elem = document.getElementById("textNews");
            while(elem.hasChildNodes()) //当elem下还存在子节点时 循环继续
            {
                elem.removeChild(elem.firstChild);
            }

            var list = data.list;

            var html="";
            $.each(list, function(i) {
                html+="<li class='row'>" +
                       "<h2 class='col-9 one-txt-cut'>" +
                       "<a style='cursor: pointer' onclick='newsDetail("+list[i].id+",1,1)'>"+list[i].title+"</a>\n" +
                       "</h2>" +
                       "<h6 class='col-3'>"+list[i].createTime+"</h6>" +
                       "</li>";
            })
            $("#textNews").append(html)

        }
    })
})


//新闻详情
function newsDetail(id,place,type) {
    window.location.href="toNewsDetail?id="+id+"&place="+place+"&type="+type;
}