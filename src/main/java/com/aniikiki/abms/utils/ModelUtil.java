package com.aniikiki.abms.utils;

import com.aniikiki.abms.constant.ModelOpType;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Method;
import java.util.Date;

@Slf4j
public class ModelUtil {

    public ModelUtil() {

    }

    public static String now() {
        return DateUtil.currentDateTimeStr();
    }

    public static void setBasicModelData(Object model, String user, String status, String now, ModelOpType op) {
        if (StringUtils.isBlank(user)) {
            user = "[SYS]";
        }

        Class clazz = model.getClass();

        try {
            Method setStatus = clazz.getMethod("setStatus", String.class);
            Method setCreateTime = clazz.getMethod("setCreateTime", String.class);
            Method setUpdateTime = clazz.getMethod("setUpdateTime", String.class);
            Method setCreateUser = clazz.getMethod("setCreateUser", String.class);
            Method setUpdateUser = clazz.getMethod("setUpdateUser", String.class);

            if (StringUtils.isNotEmpty(status)) {
                setStatus.invoke(model, status);
            }

            if (op == ModelOpType.CREATE) {
                setCreateTime.invoke(model, now);
                setCreateUser.invoke(model, user);
            } else {
                setUpdateTime.invoke(model, now);
                setUpdateUser.invoke(model, user);
            }

        } catch (Exception e) {
            log.warn("Model基础信息设置失败，请检查五个共通字段 {}", model.getClass().getName(), e);
        }

    }

    public static void setBasicModelData(Object model, String user, String status, ModelOpType op) {
        setBasicModelData(model, user, status, now(), op);
    }

    public static void setBasicModelData(Object model, String user,ModelOpType op) {
        setBasicModelData(model, user, null, now(), op);
    }

}
