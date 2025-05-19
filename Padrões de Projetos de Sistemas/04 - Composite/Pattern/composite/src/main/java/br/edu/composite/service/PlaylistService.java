package br.edu.composite.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.composite.compositeInterface.CompositeInterface;
import br.edu.composite.dto.PlaylistDTO;
import br.edu.composite.entity.PlaylistEntity;
import br.edu.composite.repository.PlaylistRepository;

@Service
public class PlaylistService {

    @Autowired
    private PlaylistRepository playlistRepository;

    public Optional<List<PlaylistDTO>> getAllPlaylists() {
        List<PlaylistDTO> playlistDTOs = playlistRepository.findAll().stream()
                .map(playlist -> new PlaylistDTO(
                        playlist.getTitle(),
                        playlist.getItems() != null ?
                            playlist.getItems().stream()
                                .map(item -> (CompositeInterface) item)
                                .toList()
                            : new ArrayList<>(),
                        playlist.getDuration(),
                        playlist.getNumberOfMusics()))
                .toList();
        return Optional.of(playlistDTOs);
    }

    public Optional<PlaylistDTO> getPlaylistById(Long id) {
        return playlistRepository.findById(id)
                .map(playlist -> new PlaylistDTO(
                    playlist.getTitle(),
                    playlist.getItems() != null ?
                        playlist.getItems().stream()
                        .map(item -> (CompositeInterface) item)
                        .toList()
                    : new ArrayList<>(),
                    playlist.getDuration(),
                    playlist.getNumberOfMusics()));
    }

    public PlaylistEntity createPlaylist(PlaylistDTO playlist) {
        if (playlist.getTitle() == null || playlist.getItems() == null) {
            throw new IllegalArgumentException("Dados inválidos para criação da playlist");
        }

        PlaylistEntity newPlaylist = new PlaylistEntity();
        newPlaylist.setTitle(playlist.getTitle());
        newPlaylist.setItems(null);
        newPlaylist.setDuration(playlist.getDuration());
        newPlaylist.setNumberOfMusics(playlist.getNumberOfMusics());
        return playlistRepository.save(newPlaylist);
    }
}