package com.aniikiki.abms.dao.contacts;

import com.aniikiki.abms.dto.contacts.ContactsDto;
import com.aniikiki.abms.entity.contacts.ContactsEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ContactsDao {

    List<ContactsEntity> selectByCriteria(ContactsDto dto);

    ContactsEntity selectByPrimaryKey(@Param("contactId") String contactId);

    int insert(ContactsEntity contact);

    int updateByPrimaryKeySelective(ContactsEntity contact);

}
