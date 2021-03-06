package com.aniikiki.abms.service.contacts;

import com.aniikiki.abms.dto.contacts.ContactsDto;
import com.aniikiki.abms.entity.contacts.ContactsEntity;

import java.util.List;

public interface ContactsService {

    List<ContactsEntity> getContactsList(ContactsDto dto, Integer pageNum, Integer pageSize);

    List<ContactsEntity> getContactsList(ContactsDto dto);

    ContactsEntity getContactsInfo(String contactsId);

    int createContact(ContactsEntity contact);

    int updateContact(ContactsEntity contact);

    int deleteContact(String contactId, String currentUserId);
}
