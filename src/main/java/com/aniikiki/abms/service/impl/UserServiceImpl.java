package com.aniikiki.abms.service.impl;

import com.aniikiki.abms.constant.DataStatus;
import com.aniikiki.abms.dao.UserDao;
import com.aniikiki.abms.dto.UserDto;
import com.aniikiki.abms.entity.UserEntity;
import com.aniikiki.abms.service.UserService;
import com.aniikiki.abms.utils.DateUtil;
import com.aniikiki.abms.utils.UUIDUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public UserEntity login(UserDto dto, String ip) {
        String password = dto.getPassword();

        dto.setPassword(null);
        dto.setStatus(DataStatus.ENABLE.getCode());
        List<UserEntity> userList = userDao.selectByCriteria(dto);
        if (userList == null || userList.size() == 0) {
            //用户名错误
            return null;
        }

        UserEntity user = userList.get(0);
        if (!passwordEncoder.matches(password, user.getPassword())) {
            //密码错误
            return null;
        }

        String token = UUIDUtil.getUUID();
        user.setToken(token);

        //更新登录信息
        dto.setUserId(user.getUserId());
        dto.setUsername(null);
        dto.setStatus(null);
        dto.setLastLoginTime(DateUtil.currentDateTimeStr());
        dto.setLastLoginIp(ip);
        dto.setToken(token);
        userDao.updateByPrimaryKeySelective(dto);

        return user;
    }
}
