package com.mobi.domain;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "sessao")
public class Sessao {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "foi_aberta")
    private Boolean foi_aberta;

    @Column(name = "pautaid")
    private Long pautaid;

    @Column(name = "data_abertura")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private LocalDateTime data_abertura;

    @Column(name = "tempo_determinado")
    private Long tempo_determinado;

}
