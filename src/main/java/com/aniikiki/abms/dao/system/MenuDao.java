package com.aniikiki.abms.dao.system;

import com.aniikiki.abms.dto.system.MenuDto;
import com.aniikiki.abms.entity.system.MenuEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MenuDao {

    List<MenuEntity> selectByCriteria(MenuDto dto);

    MenuEntity selectByPrimaryKey(@Param("menuId") String menuId);

    int insert(MenuEntity menu);

    int updateByPrimaryKeySelective(MenuEntity menu);

    int updateStatusBatch(MenuDto dto);

}
