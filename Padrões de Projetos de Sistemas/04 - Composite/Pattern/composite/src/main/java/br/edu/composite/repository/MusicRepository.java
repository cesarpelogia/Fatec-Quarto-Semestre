package br.edu.composite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.composite.entity.MusicEntity;

@Repository
public interface MusicRepository extends JpaRepository<MusicEntity, Long> {
    
}
