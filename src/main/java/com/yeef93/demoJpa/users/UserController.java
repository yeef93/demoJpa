package com.yeef93.demoJpa.users;

import com.yeef93.demoJpa.responses.Response;
import com.yeef93.demoJpa.users.dto.RegisterRequestDto;
import com.yeef93.demoJpa.users.entity.Users;
import com.yeef93.demoJpa.users.service.UserService;
import jakarta.validation.Valid;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/users")
@Validated
@Log
public class UserController {
    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<Response<List<Users>>> findAll(){
        return Response.successfulResponse("All user fetched", userService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response<Optional<Users>>> getUser(@PathVariable Long id){
        return Response.successfulResponse("User detail found", userService.getUser(id));
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody RegisterRequestDto registerRequestDto) {
        return Response.successfulResponse("User registered successfully", userService.register(registerRequestDto));
    }

    @GetMapping("/profile")
    public ResponseEntity<?> profile() {
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        String username = authentication.getName();
        log.info("User profile requested for user: " + username);
        return Response.successfulResponse("User profile", userService.findByEmail(username));
    }


}
