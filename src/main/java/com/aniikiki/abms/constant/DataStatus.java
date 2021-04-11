package com.aniikiki.abms.constant;

/**
 * 数据状态
 */
public enum DataStatus {

    DELETION("-1", "已删除"),
    UNABLE("0", "停用"),
    ENABLE("1", "正常");

    private String code;
    private String message;

    private DataStatus(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
