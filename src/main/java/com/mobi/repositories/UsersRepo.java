package com.mobi.repositories;

import com.mobi.domain.Users;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UsersRepo extends CrudRepository<Users, Long> {
    List<Users> findAll();
    Optional<Users> findById(Long id);
}
