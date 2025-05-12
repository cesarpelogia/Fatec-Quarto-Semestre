package br.edu.composite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.composite.entity.Playlist;

@Repository
public interface PlaylistRepository extends JpaRepository<Playlist, Long> {
    // Define any custom query methods if needed
    // For example:
    // List<Playlist> findByUserId(Long userId);

}
