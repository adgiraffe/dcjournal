package org.bssimin.dao.image;

import org.apache.ibatis.session.SqlSession;
import org.bssimin.domain.ImageVO.Image_info;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * Created by joo on 2017. 7. 13..
 */

@Repository
public class ImageDAOImpl implements ImageDAO {

    @Named("db1SqlSessionTemplate")
    @Inject
    SqlSession session;

    private static String imageNamespace="org.bssimin.mybatis.mapper.imageVOMapper.xml";

   @Override
    public void upLoadImage(Image_info iInfo) throws Exception {
        session.insert(imageNamespace+".regiImage",iInfo);
   }

    @Override
    public void deleteImage(String fPath) throws Exception {
        session.delete(imageNamespace+".deleImage",fPath);
    }

    @Override
    public List<Image_info> allImageSelect() throws Exception {
        return session.selectList(imageNamespace+".imageAllSelect");
    }

    @Override
    public String selectImagePath(int ino) throws Exception {
        return session.selectOne(imageNamespace+".selectImagePath",ino);
    }

    @Override
    public int selectIno(String fPath) throws Exception {
        return session.selectOne(imageNamespace+".getIno",fPath);
    }
}
