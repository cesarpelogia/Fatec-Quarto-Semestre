package br.edu.composite.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.composite.entity.Music;

@Repository
public interface MusicRepository extends JpaRepository<Music, Long> {

    Optional<Music> findByMusicTitle(String title);
    Optional<Music> findByArtists(String artists);
    
}
