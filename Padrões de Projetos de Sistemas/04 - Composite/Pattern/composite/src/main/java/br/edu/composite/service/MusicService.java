package br.edu.composite.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.composite.dto.MusicDTO;
import br.edu.composite.entity.MusicEntity;
import br.edu.composite.repository.MusicRepository;

@Service
public class MusicService {

    @Autowired
    private MusicRepository musicRepository;

    public Optional<List<MusicDTO>> getAllMusics(){
        List<MusicDTO> musicDTOs = musicRepository.findAll().stream()
                .map(music -> new MusicDTO(music.getTitle(), music.getArtist(), music.getDuration()))
                .toList();
        return Optional.of(musicDTOs);
    }

    public Optional<MusicDTO> getMusicById(Long id){
        return musicRepository.findById(id)
                .map(music -> new MusicDTO(music.getTitle(), music.getArtist(), music.getDuration()));
    }

    public MusicEntity createMusic(MusicDTO music){
        if (music.getTitle() == null || music.getArtist() == null || music.getDuration() <= 0) {
            throw new IllegalArgumentException("Dados inválidos para criação da música");
        }

        MusicEntity newMusic = new MusicEntity();
        newMusic.setTitle(music.getTitle());
        newMusic.setArtist(music.getArtist());
        newMusic.setDuration(music.getDuration());
        return musicRepository.save(newMusic);
    }
}
