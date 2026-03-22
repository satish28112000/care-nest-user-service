package com.carenest.user_service.repository;

import com.carenest.user_service.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);

    boolean existsByPhone1(String phone1);
}
