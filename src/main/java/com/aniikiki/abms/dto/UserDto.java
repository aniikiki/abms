package com.aniikiki.abms.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class UserDto implements Serializable {

    @ApiModelProperty("用户id")
    private String userId;

    @ApiModelProperty("用户名")
    private String username;

    @JsonIgnore
    @ApiModelProperty("用户密码")
    private String password;

    @ApiModelProperty("用户昵称")
    private String nickname;

    @ApiModelProperty("邮箱")
    private String email;

    @ApiModelProperty("备注")
    private String remark;

    @ApiModelProperty("状态 -1 删除 0 停用 1 正常")
    private String status;

    @ApiModelProperty("验证码")
    private String verifyCode;

    @ApiModelProperty("最后登录ip")
    private String lastLoginIp;

    @ApiModelProperty("最后登录时间")
    private String lastLoginTime;

    @JsonIgnore
    @ApiModelProperty("创建人")
    private String createUser;

    @JsonIgnore
    @ApiModelProperty("创建时间")
    private String createTime;

    @JsonIgnore
    @ApiModelProperty("修改人")
    private String updateUser;

    @JsonIgnore
    @ApiModelProperty("修改时间")
    private String updateTime;

    @JsonIgnore
    @ApiModelProperty("登录Token")
    private String token;

    @ApiModelProperty("日期条件类型 1 创建日期 2 修改日期 3 最后登录日期")
    private String dateType;

    @ApiModelProperty("开始日期")
    private String startDate;

    @ApiModelProperty("结束日期")
    private String endDate;

}
