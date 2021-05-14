package com.aniikiki.abms.service.system.impl;

import com.aniikiki.abms.constant.DataStatus;
import com.aniikiki.abms.constant.ModelOpType;
import com.aniikiki.abms.constant.ResultMessage;
import com.aniikiki.abms.dao.system.MenuDao;
import com.aniikiki.abms.dao.system.UserDao;
import com.aniikiki.abms.dao.system.UserRoleRelDao;
import com.aniikiki.abms.dto.system.UserDto;
import com.aniikiki.abms.entity.system.MenuEntity;
import com.aniikiki.abms.entity.system.UserEntity;
import com.aniikiki.abms.entity.system.UserRoleRelEntity;
import com.aniikiki.abms.service.system.UserService;
import com.aniikiki.abms.utils.DateUtil;
import com.aniikiki.abms.utils.ModelUtil;
import com.aniikiki.abms.utils.UUIDUtil;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserRoleRelDao userRoleRelDao;

    @Autowired
    private MenuDao menuDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional(rollbackFor = Throwable.class)
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

        //获取菜单
        user.setMenuList(getMenuListByUser(user.getUserId()));

        return user;
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public String updatePassword(UserDto dto) {
        UserEntity user = userDao.selectByPrimaryKey(dto.getUserId());
        if (user == null) {
            return ResultMessage.SYS_USER_NOT_FOUND;
        }

        if (!passwordEncoder.matches(dto.getPassword(), user.getPassword())) {
            return ResultMessage.SYS_UPDATE_PASSWORD_OLDPWD_ERR;
        }

        dto.setPassword(passwordEncoder.encode(dto.getNewPassword()));
        ModelUtil.setBasicModelData(dto, dto.getUserId(), ModelOpType.UPDATE);
        userDao.updateByPrimaryKeySelective(dto);

        return null;
    }

    @Override
    public List<UserEntity> getUserList(UserDto dto, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return userDao.selectByCriteria(dto);
    }

    @Override
    public List<UserEntity> getUserListByUsername(String excludeUserId, String username) {
        UserDto dto = new UserDto();
        dto.setUsername(username);
        dto.setExcludeUserId(excludeUserId);
        return userDao.selectByCriteria(dto);
    }

    @Override
    public UserEntity getUserInfo(String userId) {
        return userDao.selectByPrimaryKey(userId);
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public int createUser(UserEntity user) {
        if (StringUtils.isNotEmpty(user.getPassword())) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        }

        ModelUtil.setBasicModelData(user, user.getCreateUser(), DataStatus.ENABLE.getCode(), ModelOpType.CREATE);
        return userDao.insert(user);
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public int updateUser(UserEntity user) {
        if (StringUtils.isNotEmpty(user.getPassword())) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        }

        ModelUtil.setBasicModelData(user, user.getUpdateUser(), ModelOpType.UPDATE);
        return userDao.updateByPrimaryKeySelective(user);
    }

    @Override
    public List<UserRoleRelEntity> getUserRoleList(String userId) {
        return userRoleRelDao.selectByCriteria(userId, null);
    }

    @Override
    public boolean assignRole(String userId, String[] roleIdArr, String currentUserId) {
        //与之前分配的角色解除关联
        userRoleRelDao.updateStatusByCriteria(userId, null, DataStatus.DELETION.getCode(), currentUserId, ModelUtil.now());

        //关联新分配的角色
        if (roleIdArr.length > 0) {
            UserDto dto = new UserDto();
            dto.setUserId(userId);
            dto.setRoleIdArr(roleIdArr);
            ModelUtil.setBasicModelData(dto, currentUserId, DataStatus.ENABLE.getCode(), ModelOpType.CREATE);

            int count = userRoleRelDao.insertBatch(dto);
        }

        return true;
    }

    @Override
    public List<MenuEntity> getMenuListByUser(String userId) {
        return menuDao.getMenuListByUser(userId);
    }
}
