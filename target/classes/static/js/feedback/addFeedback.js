



$(function(){

    $.ajax({
        async: false,
        type: "POST",
        data:  null,
        url: 'feedback/selectByPage',
        dataType: 'json',
        success: function (data) {
            var list = data.list;
            var html="";
            $.each(list,function(i){
                html+="<li class='row'>"+
                        "<h2 class='col-9 one-txt-cut'>"+
                            "<a style='cursor: pointer' onclick='feedbackDetail("+list[i].id+")'>"+list[i].title+"</a>"+
                        "</h2>"+
                        "<h6 class='col-3'>"+list[i].createTime.substring(0,10)+"</h6>"+
                      "</li>";
            })

            $("#list").append(html);
        }
    })

})


function save() {
    var form = $('#feedbackForm').serialize();
    $.ajax({
        cache: true,
        type: "POST",
        url: 'feedback/save',
        data: form,
        async: false,
        success: function (data) {
            if (data == "success") {
                layer.msg('保存成功');
                window.location.reload();
                document.getElementById("feedbackForm").reset();
            } else {
                layer.msg('保存失败');
            }
        }
    });
}

function refresh(){
    document.getElementById("feedbackForm").reset();
}

function  feedbackDetail(id){
    window.location.href="toFeedbackDetail?id="+id;

}