$(function (){
    function blog(){
        $.ajax({
            url:'/blog/',
            method:'get',
            data:{"blog_id":$("#blog_id").val()}
        })
    }
})