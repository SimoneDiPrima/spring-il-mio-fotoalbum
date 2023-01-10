package org.foto.italy.demo.repo;


import org.foto.italy.demo.pojo.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepo extends JpaRepository<Comment, Integer>{

}
