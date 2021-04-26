package com.aniikiki.abms.entity.contacts;

import com.aniikiki.abms.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "联系人群组实体类")
public class ContactsGroupEntity extends BaseEntity {

    @ApiModelProperty("主键")
    private String groupId;

    @ApiModelProperty("联系人群组名称")
    private String groupName;

    @ApiModelProperty("联系人群组备注")
    private String groupRemark;

}
