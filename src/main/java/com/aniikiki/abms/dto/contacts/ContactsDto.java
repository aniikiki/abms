package com.aniikiki.abms.dto.contacts;

import com.aniikiki.abms.entity.contacts.ContactsEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "联系人数据传输类")
public class ContactsDto extends ContactsEntity {

    @ApiModelProperty("联系人群组ID集合")
    private String[] groupIdArr;

}
