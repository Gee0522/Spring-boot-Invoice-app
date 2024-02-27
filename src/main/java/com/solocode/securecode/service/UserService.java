package com.solocode.securecode.service;

import com.solocode.securecode.dataTransferObject.UserDTO;
import com.solocode.securecode.domain.User;

public interface UserService {
    UserDTO createUser(User user);
}
