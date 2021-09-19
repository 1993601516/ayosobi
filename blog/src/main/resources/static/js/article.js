// 初始化MarkDown编辑器
var contentEditor;
$(function() {
    contentEditor = editormd("md-content", {
        width   : "100%",
        height  : 500,
        placeholder:"请输入文章内容",
        syncScrolling : "single",
        path : "/md/lib/"
    });
});

$(function (){
    $("#publish").click(function() {
        var blogId = $("#blogId").val();
        var title = $("#title").val();
        var tag = $("#tag").val();
        var imgUrl = $("#imgUrl").val();
        var category = $("#category").val();
        var content = contentEditor.getMarkdown();
        if (title.length > 50) {
            swal("文章标题最多不超过五十个字", {
                icon: "error",
            })

        }
        if (title == null || title.trim() == "") {
            swal("文章标题不能为空", {
                icon: "error",
            })
            return;
        }
        if (tag.split(',').length>10) {
            swal("标签不能大于10个", {
                icon: "error",
            })
            return;
        }
        if (tag == null || tag.trim() == "") {
            swal("标签不能为空", {
                icon: "error",
            })
            return;
        }
        if (imgUrl == null || imgUrl.trim() == "") {
            swal("图片地址不能为空", {
                icon: "error",
            })
            return;
        }
        if (category == null || category.trim() == "") {
            swal("没有选中分类", {
                icon: "error",
            })
            return;
        }
        if (content == null || content.trim() == "") {
            swal("内容不能为空", {
                icon: "error",
            })
            return;
        }
        $("#ArticleModal").modal('show');
    });
        let blogStatus=-1;
        $("#saveButton").click(function (){
            /*发布方法*/
            blogStatus=1;
            saveBlog();
        })
        $('#drafts').click(function (){
            blogStatus=0;
            saveBlog();
        })
        /*fun*/
        function saveBlog(){
            /*获取页面值*/
            var blogId = $("#blogId").val();
            var title = $("#title").val();
            var tag = $("#tag").val();
            var imgUrl = $("#imgUrl").val();
            var category = $("#category").val();
            var content = contentEditor.getMarkdown();
            var blog_coverImg = $("#PictureCover")[0].src;
            /*对象*/
            var savedata = {
                blog_title:title,
                blog_tag:tag,
                blog_category:category,
                blog_content:content,
                blog_url:imgUrl,
                blog_coverImg:blog_coverImg,
                blog_status:blogStatus,
            }
            let updatedata={
                blog_id:blogId,
                blog_title:title,
                blog_tag:tag,
                blog_category:category,
                blog_content:content,
                blog_url:imgUrl,
                blog_coverImg:blog_coverImg,
                blog_status:blogStatus,
            }
            /*保存*/
            if(blogId==null || blogId==""){
                $.ajax({
                    url:"/admin/saveBlog",
                    method: "post",
                    data: savedata,
                    success:function(result){
                        /*添加博客成功*/
                        if (result.code==200){
                            swal("添加成功",{
                                icon:"success",
                            }).then(function (){
                                window.location.href="/admin/article"
                            })
                        }else {
                            swal("添加失败",{
                                icon:"error",
                            })
                        }
                    }
                })
            }
            /*更新*/
            if(blogId!=null || blogId!=""){
                $.ajax({
                    url:"/admin/updateBlog",
                    method: "post",
                    data: updatedata,
                    success:function(result){
                        /*添加博客成功*/
                        if (result.code==200){
                            swal("更新成功",{
                                icon:"success",
                            }).then(function (){
                                window.location.href="/admin/article"
                            })
                        }else {
                            swal("更新失败",{
                                icon:"error",
                            })
                        }
                    }
                })
            }
        }
});
$(function (){
    $("#randomImg").click(function (){
        $.get("/random",function (image){
           if (image!=null){
               $("#PictureCover").attr("src",image);
           }else{
               $("#PictureCover").attr("src","/css/img/random/random1.jpg");
           }
        })
        $("#PictureCover").attr("style","width:120px;height:100px");
    })
})
$("#fileBtn").click(function (){
    let formData = new FormData($("#uploadForm")[0]);
    formData.append("file",$("#file")[0].files[0])
    if (formData.get("file")==null){
        swal("不能上传空图片",{
            icon:"error"
        })
    }
    $.ajax({
        url:"/FileUpdate",
        method: 'post',
        data:formData,
        processData:false,
        contentType:false,
        dataType:'text',
        success:function (result){
            /*json转对象*/
            let data = JSON.parse(result);
            if (data.code==200){
                swal("上传成功",{
                    icon:'success',
                })
            }else if (data.code==404){
                swal("上传失败",{
                    icon:'error',
                })
            }
        }
    })
})