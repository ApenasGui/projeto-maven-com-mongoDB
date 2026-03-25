package com.guilhermesilva.workshopmongo.service;

import com.guilhermesilva.workshopmongo.Resources.exception.ObjectNotFoundException;
import com.guilhermesilva.workshopmongo.domain.Post;
import com.guilhermesilva.workshopmongo.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Post findById(String id){
        Optional<Post> post = postRepository.findById(id);
        return post.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado"));
    }
}
