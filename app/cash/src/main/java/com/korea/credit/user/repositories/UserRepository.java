package com.korea.credit.user.repositories;

import com.korea.credit.user.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author sungjun
 * @since 9/8/24
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserId(String userId);
    Optional<User> findByBusinessNo(String businessNo);
}
