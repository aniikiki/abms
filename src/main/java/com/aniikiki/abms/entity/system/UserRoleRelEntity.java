package com.aniikiki.abms.entity.system;

import com.aniikiki.abms.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "用户角色关联实体类")
public class UserRoleRelEntity extends BaseEntity {

    @ApiModelProperty("用户ID")
    private String userId;

    @ApiModelProperty("角色")
    private RoleEntity role;

}
