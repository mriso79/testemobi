package com.mobi.services;

import com.mobi.domain.Pauta;
import com.mobi.repositories.PautaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PautaService {
    @Autowired
    private PautaRepo pautaRepo;

    public Pauta savePauta(Pauta pauta) {
        return pautaRepo.save(pauta);
    }

    public List<Pauta> listarPautas(){
        return pautaRepo.findAll();
    }
}
