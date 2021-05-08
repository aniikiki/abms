package com.aniikiki.abms.controller.contacts;

import com.aniikiki.abms.common.CommonPage;
import com.aniikiki.abms.common.CommonResult;
import com.aniikiki.abms.constant.DataStatus;
import com.aniikiki.abms.constant.ResultMessage;
import com.aniikiki.abms.controller.BaseController;
import com.aniikiki.abms.dto.contacts.ContactsGroupDto;
import com.aniikiki.abms.entity.contacts.ContactsGroupEntity;
import com.aniikiki.abms.service.contacts.ContactsGroupService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 联系人群组
 * @author aniikiki
 * @date 2021-04-28 16:24:11
 */
@RestController
@RequestMapping("/contactsGroup")
@Api(tags = "联系人群组")
@Slf4j
public class ContactsGroupController extends BaseController {

    @Autowired
    private ContactsGroupService contactsGroupService;

    @ApiOperation("群组列表")
    @PostMapping("/list")
    public CommonResult<CommonPage<ContactsGroupEntity>> getGroupList(@RequestBody ContactsGroupDto dto,
                                                                     @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                                     @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        dto.setCreateUser(this.getCurrentUserId());
        List<ContactsGroupEntity> groupList = contactsGroupService.getGroupList(dto, pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(groupList));
    }

    @ApiOperation("群组列表")
    @PostMapping("/all")
    public CommonResult<List<ContactsGroupEntity>> getGroupList(@RequestBody ContactsGroupDto dto) {
        dto.setCreateUser(this.getCurrentUserId());
        dto.setStatus(DataStatus.ENABLE.getCode());
        List<ContactsGroupEntity> groupList = contactsGroupService.getGroupList(dto);
        return CommonResult.success(groupList);
    }

    @ApiOperation("群组信息")
    @GetMapping("/info/{groupId}")
    public CommonResult<ContactsGroupEntity> getGroupInfo(@PathVariable(value = "groupId") String groupId) {
        ContactsGroupEntity group = contactsGroupService.getGroupInfo(groupId);
        if (group != null && !DataStatus.DELETION.getCode().equals(group.getStatus())) {
            return CommonResult.success(group);
        } else {
            return CommonResult.failed(ResultMessage.SYS_CONTACT_GROUP_NOT_FOUND);
        }
    }

    @ApiOperation("新增群组")
    @PostMapping("/create")
    public CommonResult createGroup(@RequestBody ContactsGroupEntity group) {
        if (StringUtils.isEmpty(group.getGroupName())) {
            return CommonResult.validateFailed();
        }

        group.setCreateUser(this.getCurrentUserId());
        int count = contactsGroupService.createGroup(group);
        if (count == 1) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("修改群组")
    @PostMapping("/update/{groupId}")
    public CommonResult updateGroup(@PathVariable( value = "groupId") String groupId, @RequestBody ContactsGroupEntity group) {
        if (StringUtils.isEmpty(group.getGroupId())) {
            return CommonResult.validateFailed();
        }

        group.setUpdateUser(this.getCurrentUserId());
        int count = contactsGroupService.updateGroup(group);
        if (count == 1) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("删除群组")
    @PostMapping("/delete/{groupId}")
    public CommonResult deleteGroup(@PathVariable( value = "groupId") String groupId) {
        int count = contactsGroupService.deleteGroup(groupId, this.getCurrentUserId());

        if (count == 1) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("分配联系人")
    @PostMapping("/assign/{groupId}")
    public CommonResult assignContacts(@PathVariable( value = "groupId") String groupId, @RequestBody String[] contactIdArr) {
        ContactsGroupEntity group = contactsGroupService.getGroupInfo(groupId);
        if (group == null || DataStatus.DELETION.getCode().equals(group.getStatus())) {
            return CommonResult.failed(ResultMessage.SYS_CONTACT_GROUP_NOT_FOUND);
        }

        boolean flag = contactsGroupService.assignContacts(groupId, contactIdArr, this.getCurrentUserId());
        if (flag) {
            return CommonResult.success(null);
        } else {
            return CommonResult.failed();
        }
    }

}
