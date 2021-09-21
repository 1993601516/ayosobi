let tag_id=null;
function dangerBtn(obj){
    $('#exampleModal').show();
    tag_id=$(obj).siblings('input').val();
}
$('#delete').click(function (){
    $.ajax({
        url:'/admin/tag/delete',
        method:'get',
        data:{tag_id:tag_id},
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