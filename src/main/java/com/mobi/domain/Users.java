package com.mobi.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class Users {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "cpf")
    private String cpf;

    public Users(String username, String cpf) {
        this.username = username;
        this.cpf = cpf;
    }
}
