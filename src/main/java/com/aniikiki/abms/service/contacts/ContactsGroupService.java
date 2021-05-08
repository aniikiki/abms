package com.aniikiki.abms.service.contacts;

import com.aniikiki.abms.dto.contacts.ContactsGroupDto;
import com.aniikiki.abms.entity.contacts.ContactsGroupEntity;

import java.util.List;

public interface ContactsGroupService {

    List<ContactsGroupEntity> getGroupList(ContactsGroupDto dto, Integer pageNum, Integer pageSize);

    List<ContactsGroupEntity> getGroupList(ContactsGroupDto dto);

    ContactsGroupEntity getGroupInfo(String groupId);

    int createGroup(ContactsGroupEntity group);

    int updateGroup(ContactsGroupEntity group);

    int deleteGroup(String groupId, String currentUserId);

    boolean assignContacts(String groupId, String[] contactIdArr, String createUserId);
}
