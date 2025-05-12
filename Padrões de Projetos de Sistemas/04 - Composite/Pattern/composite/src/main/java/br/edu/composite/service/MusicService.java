package br.edu.composite.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.composite.dto.MusicDTO;
import br.edu.composite.entity.Music;
import br.edu.composite.repository.MusicRepository;

@Service
public class MusicService {

    @Autowired
    private MusicRepository musicRepository;

    public Optional<List<Music>> getAllMusics() {
        List<Music> musics = musicRepository.findAll()
                .stream()
                .map(music -> {
                    music.setTitle(music.getTitle());
                    music.setArtist(music.getArtist());
                    music.setDuration(music.getDuration());
                    return music;
                })
                .toList();
        return Optional.of(musics);
    }

    public Optional<Music> getMusicById(Long id) {
        return musicRepository.findById(id)
                .map(music -> {
                    music.setTitle(music.getTitle());
                    music.setArtist(music.getArtist());
                    music.setDuration(music.getDuration());
                    return music;
                });
    }

    public Music addMusic(MusicDTO musicDTO) {
        if(musicDTO == null) {
            throw new IllegalArgumentException("A música não pode ser nula");
        }
        if(musicRepository.findByMusicTitle(musicDTO.getTitle()).isPresent() &&
           musicRepository.findByArtists(musicDTO.getArtist()).isPresent()) {
            throw new IllegalArgumentException("A música já existe");
        }
        Music musicToSave = new Music();
        musicToSave.setTitle(musicDTO.getTitle());
        musicToSave.setArtist(musicDTO.getArtist());
        musicToSave.setDuration(musicDTO.getDuration());
        return Optional.ofNullable(musicRepository.save(musicToSave))
                .orElseThrow(() -> new RuntimeException("Erro ao salvar a música"));
    }

    public String deleteMusic(Long id) {
        if(musicRepository.findById(id).isPresent()) {
            musicRepository.deleteById(id);
            return "Música deletada com sucesso";
        } else {
            throw new IllegalArgumentException("A música não existe");
        }
    }
}
