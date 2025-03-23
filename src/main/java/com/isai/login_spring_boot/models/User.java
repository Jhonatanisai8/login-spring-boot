package com.isai.login_spring_boot.models;

import java.util.Collection;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@Entity
@Table(name = "users", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "userId"), inverseJoinColumns = @JoinColumn(name = "rol_id", referencedColumnName = "rolId"))
    private Collection<Rol> roles;

    public User() {
    }

    public User(Long userId, @NotEmpty @Length(max = 30) String firstName, @NotEmpty @Length(max = 30) String lastName,
            @NotEmpty @Length(max = 30) String email, @NotEmpty @Length(max = 30) String password,
            Collection<Rol> roles) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    public User(@NotEmpty @Length(max = 30) String firstName, @NotEmpty @Length(max = 30) String lastName,
            @NotEmpty @Length(max = 30) String email, @NotEmpty @Length(max = 30) String password,
            Collection<Rol> roles) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

}
