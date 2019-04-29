package com.pavilion.cricket.service.repo;

import com.pavilion.cricket.model.UserAuth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserAuthRepo extends JpaRepository<UserAuth, Long> {

    @Query("SELECT u FROM UserAuth u WHERE u.email = :#{#email}")
    UserAuth findByEmail(@Param("email") String email);

}
