package cn.jiawei.blog.controller.admin;

import cn.jiawei.blog.dao.adminDao.ImagesMapper;
import cn.jiawei.blog.service.blogService.ImagesService;
import cn.jiawei.blog.unitl.Result;
import cn.jiawei.blog.unitl.ResultGentor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class FileUpdateController {
    @Autowired
    ImagesMapper imagesMapper;
    @Autowired
    ImagesService imagesService;
    @ResponseBody
    @RequestMapping("/FileUpdate")
    public Result updateFile(@RequestParam("file") MultipartFile file) {
        /*获取源文件*/
        String originName = file.getOriginalFilename();
        String[] strings = originName.split("\\.");
        /*自定义文件名*/
        String filename = "random" + (imagesMapper.SelectCount()+1)+"."+strings[1];
        /*项目真实地址*/
        String destFileName = "D:\\respository\\blog\\src\\main\\resources\\static\\css\\img\\random" + File.separator + filename;
        File destFile = new File(destFileName);
        try {
            file.transferTo(destFile);
        } catch (IOException e) {
            e.printStackTrace();
            return ResultGentor.setERROR_RESULT(404, "error");
        }
        int i = imagesService.InsertOneImage(filename);
        if(i>0){
            return ResultGentor.setSUCCESS_RESULT();
        }else {
            return ResultGentor.setERROR_RESULT(404, "error");
        }
    }

}