package com.aniikiki.abms.entity.contacts;

import com.aniikiki.abms.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "联系人群组关联实体类")
public class ContactsGroupRelEntity extends BaseEntity {

    @ApiModelProperty("群组ID")
    private String groupId;

    @ApiModelProperty("联系人")
    private ContactsEntity Contact;

}
