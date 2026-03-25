package com.guilhermesilva.workshopmongo.service;

import com.guilhermesilva.workshopmongo.Resources.exception.ObjectNotFoundException;
import com.guilhermesilva.workshopmongo.domain.Comment;
import com.guilhermesilva.workshopmongo.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public Comment findById(String id){
        Optional<Comment> comment = commentRepository.findById(id);
        return comment.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado"));
    }
}
