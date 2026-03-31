package com.crud.crud.service;

import com.crud.crud.entity.User;
import com.crud.crud.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class UserService{

    private final UserRepository repo;

    public UserService(UserRepository repo){
        this.repo = repo;
    }
    public User save(User user){
        return repo.save(user);
    }

    public List<User> getAll(){
        return repo.findAll();
    }

    public Optional<User>getById(Long id){
        return repo.findById(id);
    }

    public void delete(Long id){
        repo.deleteById(id);
    }

    public List<User> saveAllUsers(List<User>users){
        return repo.saveAll(users);
    }

    public Page<User> getUsersWithPagination(Pageable pageable){
        return repo.findAll(pageable);
    }


}
