package br.edu.composite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.composite.domain.MusicComponent;
import br.edu.composite.domain.PlaylistComponent;
import br.edu.composite.dto.MusicDTO;
import br.edu.composite.dto.PlaylistDTO;
import br.edu.composite.entity.MusicEntity;
import br.edu.composite.entity.PlaylistEntity;
import br.edu.composite.service.PlaylistService;
import br.edu.composite.service.MusicService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/composite")
public class CompositeController {

    @Autowired
    private MusicService musicService;

    @Autowired
    private PlaylistService playlistService;

    @GetMapping("/musics")
    public ResponseEntity<List<MusicDTO>> getAllMusics() {
        return musicService.getAllMusics()
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/music/{id}")
    public ResponseEntity<MusicDTO> getMusicById(@RequestParam Long id) {
        return musicService.getMusicById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    @GetMapping("/playlists")
    public ResponseEntity<List<PlaylistDTO>> getAllPlaylists() {
        return playlistService.getAllPlaylists()
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/playlist/{id}")
    public ResponseEntity<PlaylistDTO> getPlaylistById(@PathVariable Long id) {
        return playlistService.getPlaylistById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("music/add")
    public ResponseEntity<MusicEntity> createMusic(@RequestBody MusicDTO music) {
        try {
            MusicEntity saved = musicService.createMusic(music);
            return ResponseEntity.ok(saved);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    @PostMapping("playlist/add")
    public ResponseEntity<PlaylistEntity> createPlaylist(@RequestBody PlaylistDTO playlist) {
        try {
            PlaylistEntity saved = playlistService.createPlaylist(playlist);
            return ResponseEntity.ok(saved);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    @GetMapping("music/play/{id}")
    public ResponseEntity<String> playMusic(@PathVariable Long id) {
        try {
            var musicOptional = musicService.getMusicById(id);
            if (musicOptional.isEmpty()) return ResponseEntity.badRequest().body("Música não encontrada");
            var music = musicOptional.get();
            MusicComponent musicComponent = new MusicComponent(id, music.getTitle(), music.getArtist(), music.getDuration());
            String result = musicComponent.play(id);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao tocar playlist");
        }
    }

    @GetMapping("playlist/play/{id}")
    public ResponseEntity<String> playPlaylist(@PathVariable Long id) {
        try {
            var playlistOptional = playlistService.getPlaylistById(id);
            if (playlistOptional.isEmpty()) return ResponseEntity.badRequest().body("Playlist não encontrada");
            var playlist = playlistOptional.get();
            PlaylistComponent playlistComponent = new PlaylistComponent(id, playlist.getTitle(), playlist.getItems(), playlist.getDuration(), playlist.getNumberOfMusics());
            String result = playlistComponent.play(id);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao tocar playlist");
        }
    }
    
    
    @GetMapping("music/delete")
    public ResponseEntity<String> deleteMusic(@RequestParam Long id) {
        try {
            var musicOpt = musicService.getMusicById(id);
            if (musicOpt.isEmpty()) return ResponseEntity.badRequest().body("Música não encontrada!");
            var musicDTO = musicOpt.get();
            MusicComponent musicComponent = new MusicComponent(id, musicDTO.getTitle(), musicDTO.getArtist(), musicDTO.getDuration());
            String result = musicComponent.deleteMusic(id);
            // Aqui você pode também remover do banco se quiser
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao deletar música");
        }
    }

    @GetMapping("playlist/delete")
    public ResponseEntity<String> deletePlaylist(@RequestParam Long id) {
        try {
            var playlistOpt = playlistService.getPlaylistById(id);
            if (playlistOpt.isEmpty()) return ResponseEntity.badRequest().body("Playlist não encontrada!");
            var playlistDTO = playlistOpt.get();
            PlaylistComponent playlistComponent = new PlaylistComponent(id, playlistDTO.getTitle(), playlistDTO.getItems(), playlistDTO.getDuration(), playlistDTO.getNumberOfMusics());
            String result = playlistComponent.deleteMusic(id);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao deletar playlist");
        }
    }
}
