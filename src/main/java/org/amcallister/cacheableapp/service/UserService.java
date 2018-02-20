package org.amcallister.cacheableapp.service;

import org.amcallister.cacheableapp.entities.User;
import org.amcallister.cacheableapp.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@CacheConfig(cacheNames = "userCache")
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Cacheable
    public User findByName(String name) {
        return this.userRepository.findByName(name);
    }

    public void save(User user) {
        this.userRepository.save(user);
    }

    public void save(List<User> users) {
        this.userRepository.save(users);
    }
}
