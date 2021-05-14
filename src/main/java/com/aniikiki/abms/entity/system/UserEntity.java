package com.aniikiki.abms.entity.system;

import com.aniikiki.abms.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@ApiModel(description = "用户实体类")
public class UserEntity extends BaseEntity {

    @ApiModelProperty("用户id")
    private String userId;

    @ApiModelProperty("用户名")
    private String username;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ApiModelProperty("用户密码")
    private String password;

    @ApiModelProperty("用户昵称")
    private String nickname;

    @ApiModelProperty("邮箱")
    private String email;

    @ApiModelProperty("备注")
    private String remark;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @ApiModelProperty("最后登录ip")
    private String lastLoginIp;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @ApiModelProperty("最后登录时间")
    private String lastLoginTime;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @ApiModelProperty("登录Token")
    private String token;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @ApiModelProperty("菜单List")
    private List<MenuEntity> menuList;

}
