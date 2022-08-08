package com.dellead.aula.repository;

import com.dellead.aula.models.Receita;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceitaRepositoty extends CrudRepository<Receita, Long> {
}
