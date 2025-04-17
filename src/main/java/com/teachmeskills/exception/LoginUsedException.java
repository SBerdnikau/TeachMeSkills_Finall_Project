package com.teachmeskills.exception;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class LoginUsedException extends Exception {
    public LoginUsedException(@NotNull(message = "Login cannot be null") @NotBlank(message = "Login cannot be blank") @Pattern(
            regexp = "^[a-zA-Z0-9]+$",
            message = "Login must contain only letters and digits"
    ) @NotNull(message = "Login cannot be null") @NotBlank(message = "Login cannot be blank") @Pattern(
            regexp = "^[a-zA-Z0-9]+$",
            message = "Login must contain only letters and digits"
    ) String login) {
    }
}
