package com.yeef93.demoJpa.user;

import com.yeef93.demoJpa.responses.Response;
import com.yeef93.demoJpa.user.entity.User;
import com.yeef93.demoJpa.user.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<Response<List<User>>> getUser(){
        return Response.successfulResponse("All user fetched", userService.getUser());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response<Optional<User>>> getUser(@PathVariable Long id){
        return Response.successfulResponse("User detail found", userService.getUser(id));
    }


}
