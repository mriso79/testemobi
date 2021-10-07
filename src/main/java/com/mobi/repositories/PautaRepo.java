package com.mobi.repositories;

import com.mobi.domain.Pauta;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PautaRepo extends CrudRepository<Pauta, Long> {
    List<Pauta> findAll();
}
