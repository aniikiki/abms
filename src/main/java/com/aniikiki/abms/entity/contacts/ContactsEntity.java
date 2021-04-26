package com.aniikiki.abms.entity.contacts;

import com.aniikiki.abms.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "联系人实体类")
public class ContactsEntity extends BaseEntity {

    @ApiModelProperty("主键")
    private String contactId;

    @ApiModelProperty("联系人姓名")
    private String contactName;

    @ApiModelProperty("联系人手机")
    private String contactMobile;

    @ApiModelProperty("联系人电话")
    private String contactTel;

    @ApiModelProperty("联系人邮箱")
    private String contactEmail;

    @ApiModelProperty("联系人地址")
    private String contactAddress;

    @ApiModelProperty("联系人称呼")
    private String contactNickname;

    @ApiModelProperty("联系人生日")
    private String contactBirthday;

    @ApiModelProperty("联系人备注")
    private String contactRemark;

    @ApiModelProperty("联系人头像")
    private String contactIcon;

}
