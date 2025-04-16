package com.teachmeskills.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Setter
@Getter
@NoArgsConstructor
@Component
public class RegistrationRequestDto {

    @Size(min = 2, max = 100)
    @NotNull
    private String firstName;

    @Size(min = 2, max = 100)
    @NotNull
    private String lastName;

    @NotNull
    @Pattern(regexp = "[0-9]{12}")
    private String telephoneNumber;

    @Size(max = 255)
    @NotNull
    @Email
    private String email;

    @NotNull
    @NotBlank
    private String login;

    @NotNull
    @NotBlank
    private String password;

}
