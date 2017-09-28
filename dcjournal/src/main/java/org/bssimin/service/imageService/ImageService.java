package org.bssimin.service.imageService;

import org.bssimin.domain.ImageVO.Image_info;
import org.bssimin.domain.mceContens.MceContentDTO;

import java.util.List;

/**
 * Created by joo on 2017. 7. 16..
 */
public interface ImageService {
    public void addImage(Image_info iInfo) throws Exception;
    public void deleImage(String fPath) throws Exception;
    public List<Image_info> allSelectImage() throws Exception;
    public String selectPathImage(int ino) throws Exception;
    public int getImageNo(String fPath) throws Exception;
    public void addContent(MceContentDTO contentDTO) throws Exception;
}
