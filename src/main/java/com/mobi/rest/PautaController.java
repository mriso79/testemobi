package com.mobi.rest;

import com.mobi.domain.Pauta;
import com.mobi.domain.Retorno;
import com.mobi.services.PautaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PautaController {
    @Autowired
    private PautaService pautaService;

    /**
     * Criando uma pauta: http://localhost:8080/v1/pauta
     *
     * Payload:
     * {
     *     "descricao":"Votação de Teste"
     * }
     *
     * @param pauta
     * @return
     */
    @PostMapping(value = "/pauta", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Retorno cadastrarPauta(final @RequestBody Pauta pauta) {
        Pauta p = pautaService.savePauta(pauta);
        return new Retorno("Inserido com sucesso, Pauta #ID: " + pauta.getId());
    }

    @GetMapping(value = "/pautas")
    public List<Pauta> listarPautas() {
        return pautaService.listarPautas();
    }

}
