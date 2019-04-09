
$(function(){

    $.ajax({
        async: false,
        type: "POST",
        data:  null,
        url: 'news/getMoreNews',
        dataType: 'json',
        success: function (data) {

            var elem1 = document.getElementById("medicalNews");
            while(elem1.hasChildNodes()) //当elem下还存在子节点时 循环继续
            {
                elem1.removeChild(elem1.firstChild);
            }

            var elem2 = document.getElementById("themeNews");
            while(elem2.hasChildNodes()) //当elem下还存在子节点时 循环继续
            {
                elem2.removeChild(elem2.firstChild);
            }

            var elem3 = document.getElementById("picNews");
            while(elem3.hasChildNodes()) //当elem下还存在子节点时 循环继续
            {
                elem3.removeChild(elem3.firstChild);
            }

            var list1 = data.list1;
            var list2 = data.list2;
            var list3 = data.list3;

            var html1=""
            var html2=""
            var html3=""

            $.each(list1, function(i) {
                html1+="<li class='row'>"+
                       "<h2 class='col-9 one-txt-cut'>"+
                       "<a style='cursor: pointer' onclick='newsDetail("+list1[i].id+",1,1)'>"+list1[i].title+"</a>"+
                       "</h2>"+
                       "<h6 class='col-3'>"+list1[i].createTime.substring(0,10)+"</h6>"+
                       "</li>";
            })
            $("#medicalNews").append(html1)


            $.each(list2, function(i) {
                html2+="<li>" +
                       "<a style='cursor: pointer' onclick='newsDetail("+list2[i].id+",1,3)'>" +
                       "<img src='"+list2[i].imgUrl+"'>"+
                       "</a>"+
                       "</li>";
            })
            $("#themeNews").append(html2);


            if(list3.length>0){

                var href="newsDetail("+list3[0].id+",1,2)";
                $("#picNewsBigDiv").show();
                $(".firstPicNewsLink").attr("onclick",href);
                $("#firstPicNewsImg").attr("src",list3[0].imgUrl);
                $("#firstPicNewsTitle").html(list3[0].title);

                console.log(list3);
                for(var i=1; i<list3.length;i++){
                    html3+="<li class='col-6'>"+
                               "<div>"+
                                 "<a style='cursor: pointer' onclick='newsDetail("+list3[i].id+",1,2)'>"+
                                    "<img src='"+list3[i].imgUrl+"'>"+
                                 "</a>"+
                               "</div>"+
                               "<h2>"+
                                  "<a style='cursor: pointer' href='newsDetail("+list3[i].id+",1,2)' class='one-txt-cut'>"+list3[i].title+"</a>"+
                               "</h2>"+
                            "</li>";
                }

                $("#picNews").append(html3);
            }else{
                $("#picNewsBigDiv").hide();
            }

        }
    })
})


//新闻详情
function newsDetail(id,place,type) {
    window.location.href="toNewsDetail?id="+id+"&place="+place+"&type="+type;
}