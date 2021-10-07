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
@Table(name = "voto")
public class Voto {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name = "usuarioid")
    private Long usuarioid;

    @Column(name = "pauta_id")
    private Long pauta_id;

    @Column(name = "data_voto")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private LocalDateTime data_voto;

    // 1 para Sim e 2 para Não
    @Column(name = "voto")
    private Resposta voto;
}
