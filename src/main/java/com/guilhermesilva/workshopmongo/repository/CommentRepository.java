package com.guilhermesilva.workshopmongo.repository;

import com.guilhermesilva.workshopmongo.domain.Comment;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CommentRepository extends MongoRepository<@NotNull Comment, @NotNull String> {

}
