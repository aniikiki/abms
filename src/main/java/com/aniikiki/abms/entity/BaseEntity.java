package com.aniikiki.abms.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class BaseEntity implements Serializable {

    @ApiModelProperty("数据状态 从数据字典表中取")
    private String status;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @ApiModelProperty("创建人")
    private String createUser;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @ApiModelProperty("创建时间")
    private String createTime;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @ApiModelProperty("修改人")
    private String updateUser;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @ApiModelProperty("修改时间")
    private String updateTime;

}
