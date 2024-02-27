package com.solocode.securecode.service.implementation;

import com.solocode.securecode.dataTransferObject.UserDTO;
import com.solocode.securecode.domain.User;
import com.solocode.securecode.dtomapper.UserDTOMapper;
import com.solocode.securecode.repository.UserRepository;
import com.solocode.securecode.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImplementation implements UserService {
    private final UserRepository<User> userRepository;


    @Override
    public UserDTO createUser(User user) {
        return UserDTOMapper.fromUser(userRepository.create(user));
    }
}
