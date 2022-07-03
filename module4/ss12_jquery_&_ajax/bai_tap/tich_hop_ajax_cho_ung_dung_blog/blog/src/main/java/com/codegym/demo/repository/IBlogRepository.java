package com.codegym.demo.repository;

import com.codegym.demo.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

import javax.websocket.server.PathParam;
import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    Page<Blog> findAllByNameContaining(String name, Pageable pageable);

//    @Query(value =  "select * " +
//                "from blog " +
//                "where name like :keyword", nativeQuery = true)
    @Query(value = "select * from blog where name like :keyword", nativeQuery = true)
    List<Blog> findAllByName(String keyword);
}
