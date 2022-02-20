package com.kryakushin.SchoolSite.repo;

import com.kryakushin.SchoolSite.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT * FROM User u WHERE u.email = ?1", nativeQuery = true)
    User findUserByName(String name);
}
