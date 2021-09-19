package cn.jiawei.blog.service.blogServiceImpl;

import cn.jiawei.blog.dao.adminDao.ImagesMapper;
import cn.jiawei.blog.service.blogService.ImagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImagesServiceImpl implements ImagesService {
    @Autowired
    ImagesMapper imagesMapper;
    @Override
    public int InsertOneImage(String filename) {
        String imgurl="http://localhost:25500/css/img/random/"+filename;
        return  imagesMapper.InsertOneImg(imgurl);
    }
}
