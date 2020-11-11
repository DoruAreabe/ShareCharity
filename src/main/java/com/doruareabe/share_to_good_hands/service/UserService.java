package com.doruareabe.share_to_good_hands.service;

import com.doruareabe.share_to_good_hands.entity.User;
import com.doruareabe.share_to_good_hands.web.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User save(User user);
    User save(UserDto userDto);
    User findUserByEmail(String email);
}
