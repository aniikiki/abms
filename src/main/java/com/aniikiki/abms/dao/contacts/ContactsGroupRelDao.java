package com.aniikiki.abms.dao.contacts;

import com.aniikiki.abms.dto.contacts.ContactsGroupDto;
import com.aniikiki.abms.entity.contacts.ContactsGroupRelEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ContactsGroupRelDao {

    List<ContactsGroupRelEntity> selectByCriteria(@Param("groupId") String groupId, @Param("contactId") String contactId);

    int updateStatusByCriteria(@Param("groupId") String groupId, @Param("contactId") String contactId, @Param("status") String status, @Param("updateUser") String updateUser, @Param("updateTime") String updateTime);

    int insertBatch(ContactsGroupDto dto);

}
