package com.guilhermesilva.workshopmongo.config;

import com.guilhermesilva.workshopmongo.domain.Post;
import com.guilhermesilva.workshopmongo.domain.User;
import com.guilhermesilva.workshopmongo.dto.AuthorDTO;
import com.guilhermesilva.workshopmongo.repository.PostRepository;
import com.guilhermesilva.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {
        userRepository.deleteAll();
        postRepository.deleteAll();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyy");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User guilherme = new User(null, "Guilherme Silva", "guisilva@gmail.com");

        userRepository.saveAll(Arrays.asList(maria, alex, guilherme));

        Post post1 = new Post(null, simpleDateFormat.parse("24/03/2026"), "Estudos estoy loco", "Não aguento mais estudar e resultar em nada", new AuthorDTO(guilherme));
        Post post2 = new Post(null, simpleDateFormat.parse("23/03/2026"), "Alguem me dá um tiro", "Ansia de não ter nada", new AuthorDTO(guilherme));
        Post post3 = new Post(null, simpleDateFormat.parse("21/03/2026"), "Dicas de estudos", "Alguém sabe dicas pra estudar 10 minutos e aprender tudo enquanto scrollo o TikTok?", new AuthorDTO(maria));
        Post post4 = new Post(null, simpleDateFormat.parse("19/03/2026"), "Assisti Jujutsu e...", "Achei uma porcaria viu spike", new AuthorDTO(alex));

        postRepository.saveAll(Arrays.asList(post1, post2, post3, post4));

        guilherme.getPostsDoUsuario().addAll(Arrays.asList(post1, post2));
        maria.getPostsDoUsuario().addAll(Arrays.asList(post3));
        alex.getPostsDoUsuario().addAll(Arrays.asList(post4));
        userRepository.save(maria);
        userRepository.save(guilherme);
        userRepository.save(alex);
    }
}
