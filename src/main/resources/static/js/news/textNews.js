var count;
$(function(){

    getAll(1);
})

function getAll(start){
    $.ajax({
        async: false,
        type: "POST",
        data:  {"type":1,"place":1,"start":(start-1)*3+1,"length":3},
        url: 'news',
        dataType: 'json',
        success: function (data) {

            $("#pagination").show()
            count = data.pages;
            page(start,count);

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
}

function page(start,count){
    $("#pagination").paginate({
        count 		: count,
        start 		: start,
        display     : 5,
        border					: true,
        border_color			: '#ABABAB',
        text_color  			: '#4D4D4D',
        background_color    	: '#FFFFFF',
        border_hover_color		: '#2397DA',
        text_hover_color  		: '#FFFFFF',
        background_hover_color	: '#2397DA',
        rotate      : false,
        images		: false,
        mouse		: 'press',
        onChange: function(start) {
            nextPage(start);
        }
    });
}

function nextPage(start){
    getAll(start);
}

//新闻详情
function newsDetail(id,place,type) {
    window.location.href="toNewsDetail?id="+id+"&place="+place+"&type="+type;
}