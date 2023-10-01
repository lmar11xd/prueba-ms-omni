package com.lmar.dominioservice.repository;

import com.lmar.dominioservice.entity.Dominio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DominioRepository extends JpaRepository<Dominio, Integer> {
}
