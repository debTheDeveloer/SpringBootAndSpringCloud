package com.IN28minutes.rest.webservice.restfulwebservice.user;

import jdk.nashorn.internal.runtime.regexp.joni.encoding.ObjPtr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class UserJpaResource {
    @Autowired
    private UserDaoService service;

    @Autowired
    private UserRepository repository;

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/jpa/users")
    public List<User> retrieveAllUsers() {
        return repository.findAll();
    }

    @GetMapping("/jpa/users/{id}")
    public User retrieveUser(@PathVariable int id) {
        Optional<User> userOptional = repository.findById(id);
        if(!userOptional.isPresent())
            throw new UserNotFoundException("id-"+id);
        return userOptional.get();
    }
    @PostMapping("/jpa/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user){
        User savedUser = repository.save(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
                buildAndExpand(savedUser.getId()).toUri(); //This piece of code helps us to return created status code(201)
                                                           //and it also creates the uri of newly created resource which
                                                            // is visible in the header section of Postman.

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/jpa/users/{id}")
    public void deleteUser(@PathVariable int id){
        repository.deleteById(id);
    }

    @GetMapping("/jpa/users/{id}/posts")
    public List<Post> retrieveUserPosts(@PathVariable int id) {
        Optional<User> userOptional = repository.findById(id);
        if(!userOptional.isPresent())
            throw new UserNotFoundException("id-"+id);
        return userOptional.get().getPosts();
    }

    @PostMapping("/jpa/users/{id}/posts")
    public ResponseEntity<User> createPost(@Valid @RequestBody Post post,@PathVariable int id){
        Optional<User> optionalUser = repository.findById(id);
        if(!optionalUser.isPresent())
            throw new UserNotFoundException("id-"+id);
        User user = optionalUser.get();
        post.setUser(user);
        Post savedPost = postRepository.save(post);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
                buildAndExpand(savedPost.getId()).toUri(); //This piece of code helps us to return created status code(201)
        //and it also creates the uri of newly created resource which
        // is visible in the header section of Postman.

        return ResponseEntity.created(location).build();
    }

}