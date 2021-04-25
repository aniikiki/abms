package com.aniikiki.abms.dto.system;

import com.aniikiki.abms.entity.system.UserEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "用户数据传输类")
public class UserDto extends UserEntity {

    @ApiModelProperty("不包括的用户Id")
    private String excludeUserId;

    @ApiModelProperty("新密码")
    private String newPassword;

    @ApiModelProperty("验证码")
    private String verifyCode;

    @ApiModelProperty("日期条件类型 1 创建日期 2 修改日期 3 最后登录日期")
    private String dateType;

    @ApiModelProperty("开始日期")
    private String startDate;

    @ApiModelProperty("结束日期")
    private String endDate;

}
