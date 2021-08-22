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
        if (tag.length > 5) {
            swal("标签不能大于五个字", {
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
        //ajax提交
        $("#saveButton").click(function (){
            var blogId = $("#blogId").val();
            var title = $("#title").val();
            var tag = $("#tag").val();
            var imgUrl = $("#imgUrl").val();
            var category = $("#category").val();
            var content = contentEditor.getMarkdown();
            var blog_coverImg = $("#PictureCover")[0].src;
            /*保存*/
            var savedata = {
                blog_title:title,
                blog_tag:tag,
                blog_category:category,
                blog_content:content,
                blog_url:imgUrl,
                blog_coverImg:blog_coverImg
            }
            var updatedata={
                blog_id:blogId,
                blog_title:title,
                blog_tag:tag,
                blog_category:category,
                blog_content:content,
                blog_url:imgUrl,
                blog_coverImg:blog_coverImg
            }
            if(blogId>0){
                $.ajax({
                    url:"/admin/updateBlog",
                    method:"post",
                    data:updatedata,
                    success:function (result){

                    }
                })
            }
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
        })
});
$(function (){
    $("#randomImg").click(function (){
        var ran =Math.floor(Math.random()*4+1);
        $("#PictureCover").attr("src","/css/img/random/"+"random"+ran+".jpg");
        $("#PictureCover").attr("style","width:120px;height:100px");
    })
})