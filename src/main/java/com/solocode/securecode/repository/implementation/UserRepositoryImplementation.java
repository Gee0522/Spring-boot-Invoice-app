package com.solocode.securecode.repository.implementation;

import com.solocode.securecode.domain.User;
import com.solocode.securecode.exception.ApiException;
import com.solocode.securecode.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Map;
import java.util.Objects;

import static com.solocode.securecode.query.UserQuery.COUNT_USER_EMAIL_QUERY;
import static com.solocode.securecode.query.UserQuery.INSERT_USER_QUERY;
import static java.util.Objects.requireNonNull;


@RequiredArgsConstructor
@Repository
@Slf4j

public class UserRepositoryImplementation implements UserRepository<User> {

    public final NamedParameterJdbcTemplate jdbc;

    @Override
    public User create(User user) {
//        check if email is unique
        if (getEmailCount(user.getEmail().trim().toLowerCase()) > 0) throw  new ApiException("Email already in use. Please use a different email and try again.")
//        Save new user
        try {
            KeyHolder holder = new GeneratedKeyHolder();
            SqlParameterSource parameters = getSqlParameterSource(user);
            jdbc.update(INSERT_USER_QUERY, parameters, holder);
            user.setId(requireNonNull(holder.getKey()).longValue());
            roleRepository.addRoleToUser(user.getId(), ROLE_USER.name());
        } catch (EmptyResultDataAccessException exception) {

        } catch (Exception exception) {}
//        Add role to the user
//        send verification URL
//        save URL in verification table
//        Send email to user with verification URL
//        Return the newly created user
//        if any errors, throw exception with proper message
        return null;
    }

    private SqlParameterSource getSqlParameterSource(User user) {
    }

    private Integer getEmailCount(String email) {
        return jdbc.queryForObject(COUNT_USER_EMAIL_QUERY, Map.of("email", email), Integer.class);
    }

    @Override
    public Collection<User> list(int page, int pageSize) {
        return null;
    }

    @Override
    public User get(Long id) {
        return null;
    }

    @Override
    public User update(User data) {
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        return null;
    }
}
