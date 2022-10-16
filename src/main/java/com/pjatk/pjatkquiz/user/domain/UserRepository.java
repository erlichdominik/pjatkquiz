package com.pjatk.pjatkquiz.user.domain;

import org.springframework.data.repository.Repository;

import java.util.Optional;

interface UserRepository extends Repository<ApplicationUser, Long> {
    Optional<ApplicationUser> findByEmail(String email);

    long count();

    <S extends ApplicationUser> S save(S entity);
}
