package cn.jiawei.blog.controller.admin;

import cn.jiawei.blog.dao.adminDao.ImagesMapper;
import cn.jiawei.blog.pojo.Images;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ImgRandomController {
    @Autowired
    ImagesMapper imagesMapper;
    @RequestMapping("/random")
    public String random(){
        int count = imagesMapper.SelectCount();
        int ran = (int) Math.floor(Math.random()*count+1);
        Images images = imagesMapper.selectByPrimaryKey(ran);
        return images.getImg_url();
    }
}
