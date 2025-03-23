package com.isai.login_spring_boot.dto;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserRequest {
    private Long userId;

    @NotEmpty
    @Length(max = 30)
    private String firstName;

    @NotEmpty
    @Length(max = 30)
    private String lastName;

    @NotEmpty
    @Length(max = 30)
    private String email;

    @NotEmpty
    @Length(max = 30)
    private String password;

    public UserRequest() {
    }

    public UserRequest(Long userId, @NotEmpty @Length(max = 30) String firstName,
            @NotEmpty @Length(max = 30) String lastName, @NotEmpty @Length(max = 30) String email,
            @NotEmpty @Length(max = 30) String password) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public UserRequest(@NotEmpty @Length(max = 30) String firstName, @NotEmpty @Length(max = 30) String lastName,
            @NotEmpty @Length(max = 30) String email, @NotEmpty @Length(max = 30) String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public UserRequest(@NotEmpty @Length(max = 30) String email) {
        this.email = email;
    }

}
