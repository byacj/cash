package com.korea.credit.user.repositories;

import com.korea.credit.user.entities.UserTermsOfUse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author sungjun
 * @since 9/8/24
 */
@Repository
public interface UserTermsOfUseRepository extends JpaRepository<UserTermsOfUse, Long> {
    Optional<UserTermsOfUse> findByUserId(String userId);
}
