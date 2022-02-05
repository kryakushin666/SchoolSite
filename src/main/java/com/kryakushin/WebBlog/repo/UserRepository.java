package com.kryakushin.WebBlog.repo;

import com.kryakushin.WebBlog.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
