let reply_id=null;
function dangerBtn(obj){
    $('#exampleModal').show();
    reply_id=$(obj).siblings('input').val();
}
$('#delete').click(function (){
    $.ajax({
        url:'/admin/reply/delete',
        method:'get',
        data:{reply_id:reply_id},
        success:function (result){
            if (result.code ==200){
                swal('删除成功',{
                    icon:'success',
                })
            }else  if (result.code ==404){
                swal('删除失败',{
                    icon: "error",
                })
            }
            $('#exampleModal').hide();
            setTimeout("window.location.reload()",1000);
        }
    })
})