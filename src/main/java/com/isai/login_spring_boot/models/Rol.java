package com.isai.login_spring_boot.models;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@Entity
@Table(name = "roles")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rolId;

    @NotEmpty
    @Length(max = 30)
    private String name;

    public Rol() {
    }

    public Rol(Long rolId, @NotEmpty @Length(max = 30) String name) {
        this.rolId = rolId;
        this.name = name;
    }

}