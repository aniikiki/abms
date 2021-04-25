package com.aniikiki.abms.service.system;

import com.aniikiki.abms.dto.system.UserDto;
import com.aniikiki.abms.entity.system.UserEntity;

import java.util.List;

public interface UserService {

    UserEntity login(UserDto dto, String ip);

    String updatePassword(UserDto dto);

    List<UserEntity> getUserList(UserDto dto, Integer pageNum, Integer pageSize);

    List<UserEntity> getUserListByUsername(String excludeUserId, String username);

    UserEntity getUserInfo(String userId);

    int createUser(UserEntity user);

    int updateUser(UserEntity user);

}
