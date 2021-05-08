package com.aniikiki.abms.dto.contacts;

import com.aniikiki.abms.entity.contacts.ContactsGroupEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "联系人群组数据传输类")
public class ContactsGroupDto extends ContactsGroupEntity {

    @ApiModelProperty("联系人ID集合")
    private String[] contactIdArr;

}
