package com.mobi.repositories;

import com.mobi.domain.Users;
import com.mobi.domain.Voto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface VotoRepo extends CrudRepository<Voto, Long> {
    List<Voto> findAll();
    Optional<Voto> findByUsuarioid(Long userid);

    @Query("select count(*) from Voto where voto = 0")
    public Long verificaSim();

    @Query("select count(*) from Voto where voto = 1")
    public Long verificaNao();
}
