package com.solocode.securecode.repository;

import com.solocode.securecode.domain.Role;

import java.util.Collection;

public interface RoleRepository <T extends Role> {
//    basic CRUD ops


    T create(T data);
    Collection<T> list(int page, int pageSize);
    T get(Long id);
    T update(T data);
    Boolean delete(Long id);

//    More complex operations
    void addRoleToUser(Long userId, String roleName);
    Role getRoleByUserId(Long userId);
    Role getRoleByUserEmail(Long userId);
    void updateUserRole(Long userId, String roleName);
}
