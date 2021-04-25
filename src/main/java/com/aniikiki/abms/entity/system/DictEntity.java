package com.aniikiki.abms.entity.system;

import com.aniikiki.abms.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "数据字典实体类")
public class DictEntity extends BaseEntity {

    @ApiModelProperty("主键")
    private String dictId;

    @ApiModelProperty("字典类型中文名")
    private String dictTypeCn;

    @ApiModelProperty("字典类型英文名")
    private String dictTypeEn;

    @ApiModelProperty("字典名称")
    private String dictName;

    @ApiModelProperty("字典值")
    private String dictValue;

    @ApiModelProperty("排序")
    private Integer sort;

}
