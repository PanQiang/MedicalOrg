
var count;
var keyword=$("#searchKeyword").val();
$(function(){
    $.ajax({
        async: false,
        type: "POST",
        data:  {"keyword":keyword},
        url: 'search/searchCount',
        dataType: 'json',
        success: function (data) {
            $("#medicalCount").html(data.medicalCount);
            $("#policyCount").html(data.policyCount);
            $("#downloadCount").html(data.downloadCount);

            if(data.medicalCount>0){
                loadSearResult(1,1);
            }else if(data.policyCount>0){
                loadSearResult(2,1);
            }else if(data.downloadCount>0){
                loadSearResult(3,1);
            }
        }
    })
})

function loadSearResult(type,start){
    $.ajax({
        async: false,
        type: "POST",
        data:  {"keyword":keyword,"type":type,"start":(start-1)*5+1,"length":5},
        url: 'search/searchByType',
        dataType: 'json',
        success: function (data) {

            $("#pagination").show()
            count = data.pages;
            page(start,count,type);

            var list = data.list;
            var elem = document.getElementById("resultList");
            while(elem.hasChildNodes()) //当elem下还存在子节点时 循环继续
            {
                elem.removeChild(elem.firstChild);
            }

            var html="";

            $.each(list, function(i) {
                html += "<li>";
                        if(type==1||type==2){
                            html += "<h2 style='cursor: pointer' onclick='newsDetail("+list[i].id+","+list[i].place+","+list[i].type+")'  class='one-txt-cut'>" + list[i].title + "</h2>";
                        }else{
                            html += "<h2 style='cursor: pointer' onclick='downloadDetail("+list[i].id+")'  class='one-txt-cut'>" + list[i].title + "</h2>";
                        }

                    html += "<p class='txt-cut'>" + list[i].summary + "</p>" +
                    "<h6>" + list[i].createTime.substring(0,10) + "</h6>" +
                    "</li>";
            })

            $("#resultList").append(html);

            if(type==1){
                $("#tip").html("医保动态");
            }else if(type==2){
                $("#tip").html("政务公开");
            }else if(type==3){
                $("#tip").html("下载专区");
            }
        }
    })
}


function page(start,count,type){
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
            nextPage(start,type);
        }
    });
}

function nextPage(start,type){
    loadSearResult(type,start);
}


//新闻详情
function newsDetail(id,place,type) {
    window.location.href="toNewsDetail?id="+id+"&place="+place+"&type="+type;
}


//下载详情
function downloadDetail(id) {
    window.location.href="toDownloadDetail?id="+id;

}