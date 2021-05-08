package com.aniikiki.abms.controller.contacts;

import com.aniikiki.abms.common.CommonPage;
import com.aniikiki.abms.common.CommonResult;
import com.aniikiki.abms.constant.DataStatus;
import com.aniikiki.abms.constant.ResultMessage;
import com.aniikiki.abms.controller.BaseController;
import com.aniikiki.abms.dto.contacts.ContactsDto;
import com.aniikiki.abms.entity.contacts.ContactsEntity;
import com.aniikiki.abms.service.contacts.ContactsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 联系人管理
 * @author aniikiki
 * @date 2021-04-26 01:13:05
 */
@RestController
@RequestMapping("/contacts")
@Api(tags = "联系人管理")
@Slf4j
public class ContactsController extends BaseController {

    @Autowired
    private ContactsService contactsService;

    @ApiOperation("联系人列表")
    @PostMapping("/list")
    public CommonResult<CommonPage<ContactsEntity>> getContactsList(@RequestBody ContactsDto dto,
                                                                @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                                @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        dto.setCreateUser(this.getCurrentUserId());
        List<ContactsEntity> contactsList = contactsService.getContactsList(dto, pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(contactsList));
    }

    @ApiOperation("所有联系人")
    @PostMapping("/all")
    public CommonResult<List<ContactsEntity>> getContactsList(@RequestBody ContactsDto dto) {
        dto.setCreateUser(this.getCurrentUserId());
        dto.setStatus(DataStatus.ENABLE.getCode());
        List<ContactsEntity> contactsList = contactsService.getContactsList(dto);
        return CommonResult.success(contactsList);
    }

    @ApiOperation("联系人信息")
    @GetMapping("/info/{contactId}")
    public CommonResult<ContactsEntity> getContactsInfo(@PathVariable(value = "contactId") String contactId) {
        ContactsEntity contact = contactsService.getContactsInfo(contactId);
        if (contact != null && !DataStatus.DELETION.getCode().equals(contact.getStatus())) {
            return CommonResult.success(contact);
        } else {
            return CommonResult.failed(ResultMessage.SYS_CONTACT_NOT_FOUND);
        }
    }

    @ApiOperation("新增联系人")
    @PostMapping("/create")
    public CommonResult createContact(@RequestBody ContactsEntity contact) {
        if (!validCreateParam(contact)) {
            return CommonResult.validateFailed();
        }

        contact.setCreateUser(this.getCurrentUserId());
        int count = contactsService.createContact(contact);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("修改联系人")
    @PostMapping("/update/{contactId}")
    public CommonResult updateContact(@PathVariable( value = "contactId") String contactId, @RequestBody ContactsEntity contact) {
        if (!validUpdateParam(contact)) {
            return CommonResult.validateFailed();
        }

        contact.setUpdateUser(this.getCurrentUserId());
        int count = contactsService.updateContact(contact);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("删除联系人")
    @PostMapping("/delete/{contactId}")
    public CommonResult deleteContact(@PathVariable( value = "contactId") String contactId) {
        int count = contactsService.deleteContact(contactId, this.getCurrentUserId());

        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    private boolean validCreateParam(ContactsEntity contact) {
        String contactName = contact.getContactName();
        String contactMobile = contact.getContactMobile();

        if (StringUtils.isBlank(contactName) || StringUtils.isBlank(contactMobile)) {
            return false;
        }

        return true;
    }

    private boolean validUpdateParam(ContactsEntity contact) {
        String contactId = contact.getContactId();

        if (StringUtils.isBlank(contactId)) {
            return false;
        }

        return true;
    }

}
