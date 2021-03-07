package com.restful.api.services;

import com.restful.api.domain.Post;
import com.restful.api.repositories.PostRepository;
import com.restful.api.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    @Autowired
    private PostRepository repository;



    public Post findById(String id){
        Optional<Post> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public List<Post> findByTitle(String text){
        return repository.searchTitle(text);
    }

}
