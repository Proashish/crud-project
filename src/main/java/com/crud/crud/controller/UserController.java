package com.crud.crud.controller;


import com.crud.crud.entity.User;
import com.crud.crud.service.UserService;
import lombok.Getter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/test")
    public String test() {
        return "Working";
    }

    //Create
     @PostMapping
    public User create(@RequestBody User user){
        return service.save(user);
     }

     //Read All
    @GetMapping
    public List<User> getAll(){
        return service.getAll();
    }

    //Read by id
    @GetMapping("/{id}")
    public User getById(@PathVariable Long id){
        return service.getById(id).orElse(null);
    }

    //Update
    @PutMapping("/{id}")
    public User update(@PathVariable Long id, @RequestBody User user){
        user.setId(id);
        return service.save(user);
    }

    //Delete
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){
        service.delete(id);
        return "Delete Successfully";
    }

    //Bulk data store
    @PostMapping("/bulk")
    public ResponseEntity<String> saveBulkUsers(@RequestBody List<User>users)
    {
        service.saveAllUsers(users);
        return ResponseEntity.ok("Bulk Insert Successful");
    }

    @GetMapping("/paginated")
    public Page<User> getUsers(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String direction
    ){
        Sort sort =direction.equalsIgnoreCase("desc")
                ? Sort.by(sortBy).descending()
                :Sort.by(sortBy).ascending();

        Pageable pageable = PageRequest.of(page,size,sort);
        return service.getUsersWithPagination(pageable);
    }

    @GetMapping("/bulkdata")
    public Page<User> getBulk(@RequestParam(defaultValue = "0") int page){
        Pageable pageable = PageRequest.of(page,5);
        return service.getUsersWithPagination(pageable);
    }

    @GetMapping("/hello")
    public String hello(){
        return "Hello bro";
    }


}
