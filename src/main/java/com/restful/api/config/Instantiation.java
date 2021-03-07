package com.restful.api.config;

import com.restful.api.domain.Post;
import com.restful.api.domain.User;
import com.restful.api.dto.AuthorDTO;
import com.restful.api.repositories.PostRepository;
import com.restful.api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;



@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        postRepository.deleteAll();
        userRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");
        userRepository.saveAll(Arrays.asList(maria, alex, bob));

        Post p1 = new Post(null, LocalDate.parse("21/03/2018", df), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(maria));
        Post p2 = new Post(null, LocalDate.parse("21/03/2018", df), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(maria));
        postRepository.saveAll(Arrays.asList(p1, p2));

        maria.getPosts().addAll(Arrays.asList(p1, p2));
        userRepository.save(maria);
    }
}
