package com.codegym.casestudy.repository.comment;

import com.codegym.casestudy.model.comment.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ICommentRepository extends CrudRepository<Comment,Long> {

}
