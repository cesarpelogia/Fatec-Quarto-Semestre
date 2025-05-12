package br.edu.composite.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.composite.dto.PlaylistDTO;
import br.edu.composite.entity.Music;
import br.edu.composite.entity.Playlist;
import br.edu.composite.repository.PlaylistRepository;

@Service
public class PlaylistService {

    @Autowired
    private PlaylistRepository  playlistRepository;

    public Optional<List<Playlist>> getAllPlaylists() {
        return Optional.of(playlistRepository.findAll());
    }

    public Optional<Playlist> getPlaylistById(Long id) {
        return playlistRepository.findById(id);
    }

    public Playlist addPlaylist(PlaylistDTO playlistDTO) {
        Playlist playlist = new Playlist();
        playlist.setName(playlistDTO.getName());
        playlist.setMusics(new ArrayList<Music>());
        playlist.setDuration(0);
        playlist.setNumberOfMusics(0);
        return playlistRepository.save(playlist);
    }
}
