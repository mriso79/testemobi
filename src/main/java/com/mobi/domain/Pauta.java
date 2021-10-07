package com.mobi.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pauta")
public class Pauta {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name = "descricao")
    private String descricao;


}
