package org.bssimin.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.bssimin.domain.GeUser_info;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by joo on 2017. 5. 20..
 */


@Mapper
public interface Db1Mapper {
    public GeUser_info readGeUser(String geUserId);
    public List<String> readAuthority(String geUserPw);




}
