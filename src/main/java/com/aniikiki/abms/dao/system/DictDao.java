package com.aniikiki.abms.dao.system;

import com.aniikiki.abms.entity.system.DictEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DictDao {

    List<DictEntity> selectByCriteria(DictEntity dict);

    DictEntity selectByPrimaryKey(@Param("dictId") String dictId);

    int insert(DictEntity dict);

    int updateByPrimaryKeySelective(DictEntity dict);

}
