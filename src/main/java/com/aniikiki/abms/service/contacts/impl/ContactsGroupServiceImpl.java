package com.aniikiki.abms.service.contacts.impl;

import com.aniikiki.abms.constant.DataStatus;
import com.aniikiki.abms.constant.ModelOpType;
import com.aniikiki.abms.dao.contacts.ContactsGroupDao;
import com.aniikiki.abms.dao.contacts.ContactsGroupRelDao;
import com.aniikiki.abms.dto.contacts.ContactsGroupDto;
import com.aniikiki.abms.entity.contacts.ContactsGroupEntity;
import com.aniikiki.abms.service.contacts.ContactsGroupService;
import com.aniikiki.abms.utils.ModelUtil;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class ContactsGroupServiceImpl implements ContactsGroupService {

    @Autowired
    private ContactsGroupDao contactsGroupDao;

    @Autowired
    private ContactsGroupRelDao contactsGroupRelDao;

    @Override
    public List<ContactsGroupEntity> getGroupList(ContactsGroupDto dto, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return contactsGroupDao.selectByCriteria(dto);
    }

    @Override
    public List<ContactsGroupEntity> getGroupList(ContactsGroupDto dto) {
        return contactsGroupDao.selectByCriteria(dto);
    }

    @Override
    public ContactsGroupEntity getGroupInfo(String groupId) {
        return contactsGroupDao.selectByPrimaryKey(groupId);
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public int createGroup(ContactsGroupEntity group) {
        ModelUtil.setBasicModelData(group, group.getCreateUser(), DataStatus.ENABLE.getCode(), ModelOpType.CREATE);
        return contactsGroupDao.insert(group);
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public int updateGroup(ContactsGroupEntity group) {
        ModelUtil.setBasicModelData(group, group.getUpdateUser(), ModelOpType.UPDATE);
        return contactsGroupDao.updateByPrimaryKeySelective(group);
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public int deleteGroup(String groupId, String currentUserId) {
        //与之前分配的联系人解除关联
        contactsGroupRelDao.updateStatusByCriteria(groupId, null, DataStatus.DELETION.getCode(), currentUserId, ModelUtil.now());

        ContactsGroupEntity group = new ContactsGroupEntity();
        group.setGroupId(groupId);
        group.setStatus(DataStatus.DELETION.getCode());
        group.setUpdateUser(currentUserId);

        return this.updateGroup(group);
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public boolean assignContacts(String groupId, String[] contactIdArr, String currentUserId) {
        //与之前分配的联系人解除关联
        contactsGroupRelDao.updateStatusByCriteria(groupId, null, DataStatus.DELETION.getCode(), currentUserId, ModelUtil.now());

        //关联新分配的联系人
        if (contactIdArr.length > 0) {
            ContactsGroupDto dto = new ContactsGroupDto();
            dto.setGroupId(groupId);
            dto.setContactIdArr(contactIdArr);
            ModelUtil.setBasicModelData(dto, currentUserId, DataStatus.ENABLE.getCode(), ModelOpType.CREATE);

            int count = contactsGroupRelDao.insertBatch(dto);
            System.out.println("***************" + count);
        }

        return true;
    }

}
