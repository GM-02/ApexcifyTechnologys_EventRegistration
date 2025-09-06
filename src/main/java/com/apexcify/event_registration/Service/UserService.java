package com.apexcify.event_registration.Service;

import com.apexcify.event_registration.Pojo.User;
import com.apexcify.event_registration.Repo.UserRepo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;
// Create user
    public void createUser(User user) {
        userRepo.save(user);
    }
// all users
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }
    // user by ID
    public Optional<User> getUserById(String id) {
        return userRepo.findById(new ObjectId(id));
    }
    // user by email
    public Optional<User> getUserByEmail(String email) {
        return userRepo.findByEmail(email);
    }
    // Delete user by ID
    public void deleteUser(String id) {
        userRepo.deleteById(new ObjectId(id));
    }
}