
$(function(){
    laodAdvertisement();
    //nav
    $('.navBtn').on('click',
        function () {
            $('#nav').toggleClass('active')
        }
    );

    //banner
    let banner = new Swiper('.banner .swiper-container',
        {
            autoplay: true,
            loop: true,
            pagination: {
                el: '.swiper-pagination',
            },
        }
    );

    //imgNews
    let imgNews = new Swiper('.imgNews .swiper-container',
        {
            autoplay: true,
            loop: true,
            pagination: {
                el: '.swiper-pagination',
            },
        }
    );

    //link
    let link = new Swiper('.link .swiper-container',
        {
            autoplay: true,
            loop: true,
            slidesPerView: 6,
            navigation: {
                nextEl: '.swiper-button-next',
                prevEl: '.swiper-button-prev',
            },
        }
    )

    loadOrgPolicyTips();
})



function laodAdvertisement(){
    $.ajax({
        async: false,
        type: "POST",
        data:  {"state":1,"block":1,"place":4},
        url: 'advertisement/indexAdvertisement',
        dataType: 'json',
        success: function (data) {

            var list = data.list;
            var html="";
            $.each(list, function(i) {


                html +="<div class='swiper-slide'>"+
                           "<a href=''>"+
                             "<img src='"+list[i].img+"'>"+
                           "</a>"+
                           "<h2 class='one-txt-cut'>"+
                             "<a href='' class='one-txt-cut'>"+list[i].title+"</a>"+
                           "</h2>"+
                        "</div>";

            });

            $("#policyBanner").append(html);
        }
    })
}
//加载政务公开页签
function loadOrgPolicyTips(){

    $.ajax({
        async: false,
        type: "POST",
        data:  {"place":2},
        url: 'news/getOrgPolicyTips',
        dataType: 'json',
        success: function (data) {
            var list = data.list;
            var html="";
            $.each(list, function(i) {
                if(list[i].id==4){
                    loadNewsList1(list[i].id);
                }else{
                    html+="<div id='type"+list[i].id+"' class='row governmentItem'>"+
                              "<div class='col-md-1'>"+
                                "<a href='' class='d-none d-md-block pc'>"+list[i].typeName+
                                 "<span>更多</span>"+
                                "</a>"+
                              "</div>"+
                           "</div>";
                }
            })

            $("#policyTips").append(html);
            $.each(list, function(i) {
                if(list[i].id!=4){
                    loadNewsList2(list[i].id);
                }


            })



        }
    })
}

//加载政策公开
function loadNewsList1(type){

    $.ajax({
        async: false,
        type: "POST",
        data: {"place":2,"type":type},
        url: 'news/getOrgPolicy',
        dataType: 'json',
        success: function (data) {

            var elem1 = document.getElementById("policy1");
            while(elem1.hasChildNodes()) //当elem下还存在子节点时 循环继续
            {
                elem1.removeChild(elem1.firstChild);
            }
            var list = data.list;
            var html1="";
            $.each(list, function(i) {
                if(i<3){
                    html1+="<li class='d-flex'>"+
                        "<div class='col-2'>0"+(i+1)+"</div>"+
                        "<div class='col-10 pr-0'>"+
                        "<h2 class='one-txt-cut'>"+
                        "<a style='cursor: pointer' onclick='newsDetail("+list[i].id+",2"+","+type+")'>"+list[i].title+"</a>"+
                        "</h2>"+
                        "<p class='txt-cut'>"+list[i].summary+"</p>"+
                        "</div></li>";
                }
            })
            $("#policy1").append(html1);

        }
    })
}

//加载其他政务信息
function loadNewsList2(type){

    $.ajax({
        async: false,
        type: "POST",
        data: {"place":2,"type":type},
        url: 'news/getOrgPolicy',
        dataType: 'json',
        success: function (data) {

            var typeId='type'+type;
           /* var elem1 = document.getElementById("typeId");
            while(elem1.hasChildNodes()) //当elem下还存在子节点时 循环继续
            {
                elem1.removeChild(elem1.firstChild);
            }*/

            var list = data.list;
            var html1="";
            if(list!=null){
                    var id=typeId+"_"+list[0].id;
                     html1+="<div class='col-md-3 img'>"+
                            "<a style='cursor: pointer' onclick='newsDetail("+list[0].id+",2"+","+type+")'>" +
                            "<img src='"+list[0].imgUrl+"'>" +
                            "</a>" +
                            "<h2>" +
                            "<a>"+list[0].title+"</a>" +
                            "</h2>" +
                            "</div>" +
                            "<ul class='col-md-8 text'>";

                            $.each(list, function(i){
                                if(i>0&&i<6){
                                    html1+= "<li class='d-flex'>"+
                                            "<h2 class='col-9 p-0 one-txt-cut'>"+
                                            "<a style='cursor: pointer' onclick='newsDetail("+list[i].id+",2"+","+type+")'>"+list[i].title+"</a>"+
                                            "</h2>"+
                                            "<h6 class='col-3 p-0'>"+list[i].createTime+"</h6>"+
                                            "</li>";
                                }
                            })

                            html1+="</ul>";

                     var idstr = "#"+typeId
                     $(idstr).append(html1);

            }


        }
    })
}


//新闻详情
function newsDetail(id,place,type) {
    window.location.href="toNewsDetail?id="+id+"&place="+place+"&type="+type;
}