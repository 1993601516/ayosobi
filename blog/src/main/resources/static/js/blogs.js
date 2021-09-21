let comment_id;
let replyname;
$(window).on("load",function (){
    $("#replyBtn").click(function (){
        let replybody = $("#replyBody").val();
        let replynickname=$("#replyNickname").val();
        if (replybody==null || replybody.trim()==""){
            swal("回复内容不能为空",{
                icon:"error",
            })
        }
        if (replynickname==null || replynickname.trim()==""){
            swal("昵称不能为空",{
                icon:"error",
            })
        }
        /*判断评论类别*/
        if (replybody!=null && replybody.trim()!="" && replynickname!=null && replynickname.trim()!=""){
            if (replybody.indexOf("@")==0){
                insertReply();
            }
            if(replybody.indexOf("@")==-1){
                insertComment();
            }
        }
    })
})

/*获取回复昵称*/
function replyComment(obj){
        replyname = $(obj).parent().siblings("h5").html();
        comment_id = $(obj).siblings("input").val();
        $("#replyBody").prop("value","@"+replyname);
}

/*主评论*/
function insertComment(){
    let data ={
        "blog_id":$("#blogId").val(),
        "comment_body":$("#replyBody").val(),
        "comment_nickname":$("#replyNickname").val(),
        "comment_email":$("#replyEmail").val()
    }
    $.ajax({
        url:"/InsertComment",
        method:'post',
        data:data,
        success:function (result){
            if (result.code ==200){
                swal("发布成功",{
                    icon:"success",
                })
                setTimeout("window.location.reload ()",3000);
            }else if (result.code ==500){
                swal("发布失败",{
                    icon:"error",
                })
                setTimeout("window.location.reload ()",3000);
            }
        }
    })
}
/*子评论*/
function insertReply(){
    let data = {
        "comment_id":comment_id,
        "reply_body":$("#replyBody").val(),
        "reply_nickname":$("#replyNickname").val(),
        "reply_email":$("#replyEmail").val(),
        "replyname":replyname
    }
    $.ajax({
        url:"/InsertReply",
        method:"post",
        data:data,
        success:function (result){
            if (result.code==200){
                swal("回复成功",{
                    icon:"success",
                })
                setTimeout("window.location.reload()",1000);
            }else{
                swal("回复失败",{
                    icon:"error",
                })
                setTimeout("window.location.reload()",1000);
            }
        }
    })
}


