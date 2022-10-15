package com.pjatk.pjatkquiz.user.domain;

import com.pjatk.model.Email;
import org.springframework.data.repository.Repository;

import java.util.Optional;
import java.util.UUID;

interface UserRepository extends Repository<User, UUID> {
    Optional<User> findByEmail(Email email);

    long count();

    <S extends User> S save(S entity);
}
