package com.guilhermesilva.workshopmongo.Resources;

import com.guilhermesilva.workshopmongo.domain.Comment;
import com.guilhermesilva.workshopmongo.domain.Post;
import com.guilhermesilva.workshopmongo.service.CommentService;
import com.guilhermesilva.workshopmongo.service.PostService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/comments")
public class CommentResource {

    @Autowired
    private CommentService commentService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<@NotNull Comment> findById(@PathVariable String id){
        Comment comment = commentService.findById(id);
        return ResponseEntity.ok().body(comment);
    }
}
