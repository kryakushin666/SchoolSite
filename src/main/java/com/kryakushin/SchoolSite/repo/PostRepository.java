package com.kryakushin.SchoolSite.repo;

import com.kryakushin.SchoolSite.models.Post;
import com.kryakushin.SchoolSite.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PostRepository extends JpaRepository<Post, Long> {

    @Query(value = "SELECT * FROM Post u WHERE u.id = ?1", nativeQuery = true)
    Post findPostById(Long id);

}
