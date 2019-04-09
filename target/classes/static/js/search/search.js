

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
                loadSearResult(1);
            }else if(data.policyCount>0){
                loadSearResult(2);
            }else if(data.downloadCount>0){
                loadSearResult(3);
            }
        }
    })



})

function loadSearResult(type){
    $.ajax({
        async: false,
        type: "POST",
        data:  {"keyword":keyword,"type":type},
        url: 'search/searchByType',
        dataType: 'json',
        success: function (data) {
            var list = data.list;
            var elem = document.getElementById("resultList");
            while(elem.hasChildNodes()) //当elem下还存在子节点时 循环继续
            {
                elem.removeChild(elem.firstChild);
            }

            var html="";

            $.each(list, function(i) {
                html += "<li>" +
                    "<h2 class='one-txt-cut'>" + list[i].title + "</h2>" +
                    "<p class='txt-cut'>" + list[i].summary + "</p>" +
                    "<h6>" + list[i].createTime + "</h6>" +
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