package org.bssimin.service.imageService;

import org.bssimin.dao.image.ImageDAO;
import org.bssimin.domain.ImageVO.Image_info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Created by joo on 2017. 7. 16..
 */

@Service
public class ImageServiceImpl implements ImageService{
    @Autowired
    ImageDAO imagedao;

    @Override
    public void addImage(Image_info iInfo) throws Exception {
        imagedao.upLoadImage(iInfo);
    }

    @Override
    public void deleImage(String fPath) throws Exception {
        imagedao.deleteImage(fPath);
    }

    @Override
    public List<Image_info> allSelectImage() throws Exception {
        return imagedao.allImageSelect();
    }

    @Override
    public String selectPathImage(int ino) throws Exception {
        return imagedao.selectImagePath(ino);
    }

    @Override
    public int getImageNo(String fPath) throws Exception {
        return imagedao.selectIno(fPath);
    }
}
