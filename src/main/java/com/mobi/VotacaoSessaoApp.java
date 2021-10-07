package com.mobi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author @mriso79
 * @date 2021-10-05
 *
 * Normalmente eu uso nomenclaturas de variáveis e métodos em inglês, por costume
 * de trabalhar com equipes internacionais, mas neste exemplo eu fiz a maioria em PT-BR mesmo.
 */

@SpringBootApplication
public class VotacaoSessaoApp {
    public static void main(String[] args) {
        SpringApplication.run(VotacaoSessaoApp.class, args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }
}
