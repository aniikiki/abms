package com.aniikiki.abms.service.contacts.impl;

import com.aniikiki.abms.constant.DataStatus;
import com.aniikiki.abms.constant.ModelOpType;
import com.aniikiki.abms.dao.contacts.ContactsDao;
import com.aniikiki.abms.dto.contacts.ContactsDto;
import com.aniikiki.abms.entity.contacts.ContactsEntity;
import com.aniikiki.abms.service.contacts.ContactsService;
import com.aniikiki.abms.utils.ModelUtil;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class ContactsServiceImpl implements ContactsService {

    @Autowired
    private ContactsDao contactsDao;

    @Override
    public List<ContactsEntity> getContactsList(ContactsDto dto, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return contactsDao.selectByCriteria(dto);
    }

    @Override
    public ContactsEntity getContactsInfo(String contactsId) {
        return contactsDao.selectByPrimaryKey(contactsId);
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public int createContact(ContactsEntity contact) {
        ModelUtil.setBasicModelData(contact, contact.getCreateUser(), DataStatus.ENABLE.getCode(), ModelOpType.CREATE);
        return contactsDao.insert(contact);
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public int updateContact(ContactsEntity contact) {
        ModelUtil.setBasicModelData(contact, contact.getUpdateUser(), ModelOpType.UPDATE);
        return contactsDao.updateByPrimaryKeySelective(contact);
    }

}
