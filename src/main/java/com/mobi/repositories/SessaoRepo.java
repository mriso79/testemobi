package com.mobi.repositories;

import com.mobi.domain.Sessao;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface SessaoRepo extends CrudRepository<Sessao, Long> {
        List<Sessao> findAll();
        Optional<Sessao> findByPautaid(Long pautaid);
}
