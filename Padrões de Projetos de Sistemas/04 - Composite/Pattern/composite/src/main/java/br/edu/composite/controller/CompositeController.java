package br.edu.composite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.composite.compositeInterface.compositeInterface;
import br.edu.composite.dto.MusicDTO;
import br.edu.composite.dto.PlaylistDTO;
import br.edu.composite.entity.Music;
import br.edu.composite.entity.Playlist;
import br.edu.composite.service.PlaylistService;
import br.edu.composite.service.MusicService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/composite")
public class CompositeController {

    @Autowired
    private compositeInterface musicPlaylist;

    @Autowired
    private MusicService musicService;

    @Autowired
    private PlaylistService playlistService;
    
    @GetMapping("/music")
    public List<Music> getAllMusics() {
        return musicService.getAllMusics().orElseThrow(() -> new RuntimeException("Erro ao buscar músicas"));
    }

    @GetMapping("/music/{id}")
    public Music getMusicById(@RequestParam Long id) {
        return musicService.getMusicById(id).orElseThrow(() -> new RuntimeException("Erro ao buscar música"));
    }
    
    @GetMapping("/playlist")
    public List<Playlist> getAllPlaylists() {
        return playlistService.getAllPlaylists().orElseThrow(() -> new RuntimeException("Erro ao buscar playlists"));
    }

    @GetMapping("/playlist/{id}")
    public Playlist getPlaylistById(@RequestParam Long id) {
        return playlistService.getPlaylistById(id)
                .orElseThrow(() -> new RuntimeException("Error while fetching playlist"));
    }

    @PostMapping("music/add")
    public Music postMethodName(@RequestBody MusicDTO musicDTO) {
        return musicService.addMusic(musicDTO);
    }

    @PostMapping("playlist/add")
    public Playlist postMethodName(@RequestBody PlaylistDTO playlistDTO) {
        return playlistService.addPlaylist(playlistDTO);
    }
}
