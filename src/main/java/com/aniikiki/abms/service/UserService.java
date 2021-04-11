package com.aniikiki.abms.service;

import com.aniikiki.abms.dto.UserDto;
import com.aniikiki.abms.entity.UserEntity;

public interface UserService {

    UserEntity login(UserDto dto, String ip);

}
