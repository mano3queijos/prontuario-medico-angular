package com.api.prontuario.repositories;

import com.api.prontuario.entites.Medico;
import com.api.prontuario.entites.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long> {
    Optional<Medico> findByLogin(String login);
}
