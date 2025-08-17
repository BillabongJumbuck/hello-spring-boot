package com.example.hello_spring_boot;

import org.springframework.web.bind.annotation.*;
import com.example.hello_spring_boot.UserRepository;

import java.util.List;
import java.util.Optional;

@RestController
public class HelloController {

    private final UserRepository userRepository;

    public HelloController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/hello")
    public String  sayHello() {
        return "Hello World";
    }

    @GetMapping("hello/{name}")
    public String  sayHello(@PathVariable String name) {
        return "Hello " + name;
    }

    @GetMapping("/greeting")
    public String  sayGreeting(@RequestParam String name) {
        return "Hello " + name + " for Spring Boot";
    }

    // 新增用户：POST请求
    @PostMapping("/users")
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    // 获取所有用户：GET请求
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // 根据ID获取单个用户
    @GetMapping("/users/{id}")
    public Optional<User> getUserById(@PathVariable Long id) {
        return userRepository.findById(id);
    }

    // 根据ID删除用户
    @DeleteMapping("/users/{id}")
    public void deleteUserById(@PathVariable Long id) {
        userRepository.deleteById(id);
    }
}
