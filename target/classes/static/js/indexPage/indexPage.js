$(function(){
    //加载首页所有广告
    laodAdvertisement();

    //加载外链列表
    loadOuterLink();
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




    //加载医保动态
    loadNews();

    //加载政务公开页签
    loadOrgPolicyTips();

    //加载下载列表
    loadDownload();

    //加载底部信息
    loadBottomInfo()


})


//加载广告
function laodAdvertisement(){
    $.ajax({
        async: false,
        type: "POST",
        data:  {"state":1,"block":1},
        url: 'advertisement/indexAdvertisement',
        dataType: 'json',
        success: function (data) {

            var list = data.list;
            
            var html1="";
            var html2="";
            var html3="";
            $.each(list, function(i) {

                if(list[i].place==3){
                    html1 += "<div class='swiper-slide'>"+
                             "<a href='"+list[i].url+"'><img  src='"+list[i].img+"'>"+
                             "<h3 class='one-txt-cut'>"+list[i].title+"</h3></a>"+
                             "</div>";

                }else if(list[i].place==5){
                    html2 += "<a href='"+list[i].url+"'><img src='"+list[i].img+"' alt='广告'></a>";

                }else if(list[i].place==4){
                     html3 +="<div class='swiper-slide'>"+
                                "<a href='"+list[i].url+"'><img src='"+list[i].img+"'>"+
                                    "<h3 class='one-txt-cut'>"+list[i].title+"</h3></a>"+
                                "</div>";

                }
            });

            $("#topBanner").append(html1);

            $("#midAd").append(html2);

            $("#policyBanner").append(html3);
        }
    })
}

//加载新闻动态和一周热点新闻
function loadNews() {
    $.ajax({
        async: false,
        type: "POST",
        data: {"place": 1,"type":1},
        url: 'news/getIndexNews',
        dataType: 'json',
        success: function (data) {
            var list1 = data.list1;

            //医保动态
            var html1 = "";
            $.each(list1, function (i) {
                html1 += "<li  class='d-flex'>"+
                            "<div class='col-3 p-0'>"+
                                "<img src='"+list1[i].imgUrl+"' alt='新闻图片'>"+
                            "</div>"+
                            "<div class='col-9 pr-0'>"+
                                "<h2 style='cursor: pointer' onclick='newsDetail("+list1[i].id+",1,1)' class='one-txt-cut'>"+list1[i].title+"</h2>"+
                            "<p class='txt-cut'>"+list1[i].summary+"</p>"+
                            "</div>"+
                          "</li>";
            })
            $("#newsList1").append(html1);


            //一周热点新闻
            var list2 = data.list2;
            var html2 = "";
            $.each(list2, function (i) {
                html2 += "<li class='one-txt-cut'>"+
                             "<a style='cursor: pointer'  onclick='newsDetail("+list2[i].id+",1,1)' >"+list2[i].title+"</a >"+
                         "</li>";
            })
            $("#newsList2").append(html2);
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
                html+="<li><a style='cursor: pointer'  onclick='loadOrgPolicy("+list[i].id+")'>"+list[i].typeName+"</a></li>";
            })

            $("#policyTips").append(html);

            //加载政务公开
            loadOrgPolicy(list[0].id);

        }
    })
}

//加载政务公开5条记录
function loadOrgPolicy(type){

    $.ajax({
        async: false,
        type: "POST",
        data:  {"place":2,"type":type},
        url: 'news/getOrgPolicy',
        dataType: 'json',
        success: function (data) {

            var elem = document.getElementById("policyList");
            while(elem.hasChildNodes()) //当elem下还存在子节点时 循环继续
            {
                elem.removeChild(elem.firstChild);
            }
            var list = data.list;
            var html="";
            $.each(list, function(i) {
                html+="<li>"+
                        "<a style='cursor: pointer' onclick='newsDetail("+list[i].id+",2,"+type+")'  class='one-txt-cut'>"+list[i].title+"</a>"+
                        "<h6>"+list[i].createTime.substring(0,10)+"</h6>"+
                      "</li>";
            })
            $("#policyList").append(html);
        }
    })
}

//新闻详情
function newsDetail(id,place,type) {
    window.location.href="toNewsDetail?id="+id+"&place="+place+"&type="+type;
}

//加载下载列表
function loadDownload(){
    $.ajax({
        async: false,
        type: "POST",
        data:  null,
        url: 'download/listOrderByloadCount',
        dataType: 'json',
        success: function (data) {

            var elem = document.getElementById("downloadList");
            while(elem.hasChildNodes()) //当elem下还存在子节点时 循环继续
            {
                elem.removeChild(elem.firstChild);
            }
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
                                    "<span>下载：</span><em>"+list[i].loadCount+"</em>"+
                                "</div>"+
                            "</div>"+
                          "</div>"+
                        "</li>";
            })
            $("#downloadList").append(html);
        }
    })
}

//下载详情
function downloadDetail(id) {
    window.location.href="toDownloadDetail?id="+id;

}



//加载外链列表
function loadOuterLink(){
    $.ajax({
        async: false,
        type: "POST",
        data:  null,
        url: 'outerLink/getList',
        dataType: 'json',
        success: function (data) {

            var elem = document.getElementById("outerLinkList");
            while(elem.hasChildNodes()) //当elem下还存在子节点时 循环继续
            {
                elem.removeChild(elem.firstChild);
            }
            var list = data.list;
            var html="";
            $.each(list, function(i) {
                html+="<div style='max-height: 30px' class='swiper-slide'>"+
                        "<a href='"+list[i].url+"'><img style='width: 100%;height: 100%'  src='"+list[i].img+"'></a>"+
                      "</div>";
            })
            $("#outerLinkList").append(html);
        }
    })
}


//加载底部信息
function loadBottomInfo(){
    $.ajax({
        async: false,
        type: "POST",
        data:  null,
        url: 'information/getInfomation',
        dataType: 'json',
        success: function (data) {
            $("#sponser").html(data.sponser);
            $("#copyRight").html(data.copyRight);
            $("#identification").html(data.identification);
            $("#icpCode").html(data.icpCode);
            $("#bottomImg1").attr("src",data.bottomImg1);
            $("#bottomImg2").attr("src",data.bottomImg2);

        }
    })
}



