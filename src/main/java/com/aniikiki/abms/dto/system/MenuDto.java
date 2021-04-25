package com.aniikiki.abms.dto.system;

import com.aniikiki.abms.entity.system.MenuEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel(description = "菜单数据传输类")
public class MenuDto extends MenuEntity {

    @ApiModelProperty("不包括的数据状态")
    private String excludeStatus;

    @ApiModelProperty("后代菜单Id")
    private List<String> descendantList;

}
