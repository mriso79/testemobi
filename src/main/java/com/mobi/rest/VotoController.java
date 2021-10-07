package com.mobi.rest;

import com.mobi.domain.*;
import com.mobi.services.VotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VotoController {
    @Autowired
    private VotoService votoService;

    /**
     * Voto do Usuário: http://localhost:8080/v1/voto
     *
     * Payload exemplo:
     * {
     *     "usuarioid":1,
     *     "pauta_id": 2,
     *     "data_voto": "2021-10-06 19:50:01",
     *     "voto":Sim (Nao)
     * }
     * @param voto
     * @return
     */
    @PostMapping(value = "/voto", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Retorno adicionarVoto(final @RequestBody Voto voto){
        return votoService.adicionarVotoService(voto);
    }

    @GetMapping(value = "/votos")
    public List<Voto> listaVotos() {
        return votoService.listarVotos();
    }

    /**
     * Apuração: http://localhost:8080/v1/votos/2
     * Exemplo de resposta:
     * {
     *     "pauta": "Votação de Teste",
     *     "sim": 1,
     *     "nao": 1
     * }
     * @param pautaid
     * @return
     */
    @GetMapping(value = "/votos/{pautaid}")
    public Apuracao contabilizaVoto(final @PathVariable Long pautaid) {
        return votoService.contabilizaVotos(pautaid);
    }
}
