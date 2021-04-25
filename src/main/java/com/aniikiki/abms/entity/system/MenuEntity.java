package com.aniikiki.abms.entity.system;

import com.aniikiki.abms.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "菜单实体类")
public class MenuEntity extends BaseEntity {

    @ApiModelProperty("主键")
    private String menuId;

    @ApiModelProperty("菜单名称")
    private String menuName;

    @ApiModelProperty("菜单类型 从字典表中取")
    private String menuType;

    @ApiModelProperty("菜单地址")
    private String menuUrl;

    @ApiModelProperty("菜单图标")
    private String menuIcon;

    @ApiModelProperty("排序")
    private Integer sort;

    @ApiModelProperty("父级菜单id")
    private String pid;

}
