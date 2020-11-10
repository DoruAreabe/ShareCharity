package com.doruareabe.share_to_good_hands.service;

import com.doruareabe.share_to_good_hands.entity.User;
import com.doruareabe.share_to_good_hands.repository.UserRepository;
import com.doruareabe.share_to_good_hands.web.dto.UserDto;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    UserRepository userRepository;
    RoleService roleService;

    public UserServiceImpl(UserRepository userRepository, RoleService roleService) {
        this.userRepository = userRepository;
        this.roleService = roleService;
    }

    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public User save(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getName());
        user.setSurname(userDto.getSurname());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword1());
        user.setRole(roleService.findById(2L));
        return userRepository.save(user);
    }
}
