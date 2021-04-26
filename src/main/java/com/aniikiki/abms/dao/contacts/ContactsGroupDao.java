package com.aniikiki.abms.dao.contacts;

import com.aniikiki.abms.dto.contacts.ContactsGroupDto;
import com.aniikiki.abms.entity.contacts.ContactsGroupEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ContactsGroupDao {

    List<ContactsGroupEntity> selectByCriteria(ContactsGroupDto dto);

    ContactsGroupEntity selectByPrimaryKey(@Param("groupId") String groupId);

    int insert(ContactsGroupEntity group);

    int updateByPrimaryKeySelective(ContactsGroupEntity group);

}
