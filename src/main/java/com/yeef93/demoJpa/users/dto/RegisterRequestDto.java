package com.yeef93.demoJpa.users.dto;

import com.yeef93.demoJpa.users.entity.Users;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RegisterRequestDto {
    @NotBlank(message = "Name is required")
    private String name;

    @Email
    @NotBlank(message = "Email is required")
    private String email;

    @NotBlank(message = "Password is required")
    private String password;

    @NotNull
    @Min(1)
    private int activeCurrency;

    public Users toEntity() {
        Users user = new Users();
        user.setUsername(name);
        user.setEmail(email);
        user.setPassword(password);
        user.setActiveCurrency(activeCurrency);
        return user;
    }
}
