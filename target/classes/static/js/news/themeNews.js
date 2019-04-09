var count;
$(function(){
    getAll(1);

})

function getAll(start){
    $.ajax({
        async: false,
        type: "POST",
        data:  {"type":3,"place":1,"start":(start-1)*9+1,"length":9},
        url: 'news',
        dataType: 'json',
        success: function (data) {
            $("#pagination").show()
            count = data.pages;
            page(start,count);

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