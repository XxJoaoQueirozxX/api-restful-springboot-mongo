package com.restful.api.resources;

import com.restful.api.domain.Post;
import com.restful.api.resources.util.URL;
import com.restful.api.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {
    @Autowired
    private PostService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id){
        Post p = service.findById(id);

        return ResponseEntity.ok(p);
    }

    @GetMapping(value = "/titlesearch")
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value="text", defaultValue = "") String title){
        title = URL.decodeParam(title);
        List<Post> posts = service.findByTitle(title);
        return ResponseEntity.ok(posts);
    }

}
