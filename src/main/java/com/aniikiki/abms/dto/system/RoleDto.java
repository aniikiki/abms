package com.aniikiki.abms.dto.system;

import com.aniikiki.abms.entity.system.RoleEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "角色数据传输类")
public class RoleDto extends RoleEntity {

    @ApiModelProperty("不包括的角色Id")
    private String excludeRoleId;

}
