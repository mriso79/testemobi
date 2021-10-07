package com.mobi.services;

import com.mobi.domain.Sessao;
import com.mobi.domain.Users;
import com.mobi.repositories.SessaoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SessaoService {
    @Autowired
    private SessaoRepo sessaoRepo;

    public Boolean verificaSessaoAberta(Long pauta_id){
        Optional<Sessao> sessao = sessaoRepo.findByPautaid(pauta_id);
        if(sessao.isPresent() && sessao.get().getFoi_aberta()){
            return true;
        }
        return false;
    }


    public void criarSessao(Sessao sessao){
        sessaoRepo.save(sessao);
    }


    public List<Sessao> listarSessoes(){
        return sessaoRepo.findAll();
    }
}
