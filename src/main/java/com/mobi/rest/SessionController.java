package com.mobi.rest;

import com.mobi.domain.Resposta;
import com.mobi.domain.Retorno;
import com.mobi.domain.Sessao;
import com.mobi.domain.Users;
import com.mobi.services.SessaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class SessionController {
    @Autowired
    private SessaoService sessaoService;

    /**
     * Criando uma Sessao: http://localhost:8080/v1/sessao
     *
     * Payload de exemplo:
     * {
     *     "foi_aberta": true,
     *     "pautaid": 2,
     *     "data_abertura": "2021-10-06 18:42:00",
     *     "tempo_determinado": 60
     * }
     *
     * @param sessao
     */
    @PostMapping(value = "/sessao", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Retorno abrirSessao(final @RequestBody Sessao sessao) {
        if(sessaoService.verificaSessaoAberta(sessao.getPautaid())){
            return new Retorno("Sessão já foi aberta!");
        }

        sessaoService.criarSessao(sessao);
        return new Retorno("Sessão aberta com sucesso");

    }

    @GetMapping(value = "/sessoes")
    public List<Sessao> listaSessoes() {
        return sessaoService.listarSessoes();
    }


}
