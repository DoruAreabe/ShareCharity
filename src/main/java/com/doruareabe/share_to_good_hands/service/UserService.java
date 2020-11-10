package com.doruareabe.share_to_good_hands.service;

import com.doruareabe.share_to_good_hands.entity.User;
import com.doruareabe.share_to_good_hands.web.dto.UserDto;

public interface UserService {
    User save(User user);
    User save(UserDto userDto);
}
