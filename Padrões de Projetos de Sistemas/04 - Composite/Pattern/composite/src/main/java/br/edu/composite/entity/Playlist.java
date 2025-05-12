package br.edu.composite.entity;

import java.util.ArrayList;
import java.util.List;

import br.edu.composite.compositeInterface.compositeInterface;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "playlist")
public class Playlist implements compositeInterface{

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "playlist_id")
    @Column(name = "musics")
    private List<Music> musics = new ArrayList<>();

    @Column(name = "duration")
    private int duration;

    @Column(name = "number_of_musics")
    private int numberOfMusics;

    public String addMusic(Music music) {
        this.musics.add(music);
        this.duration += music.getDuration();
        this.numberOfMusics++;
        return "Nova música adicionada com sucesso! Título: " + music.getTitle();
    }

    public String removeMusic(Music music) {
        this.musics.remove(music);
        this.duration -= music.getDuration();
        this.numberOfMusics--;
        return "Música removida com sucesso! Título: " + music.getTitle();
    }

    public void clear() {
        this.musics.clear();
        this.duration = 0;
        this.numberOfMusics = 0;
    }

    @Override
    public String play(Long id) {
        for (Music music : musics) {
            if (music.getId().equals(id)) {
                return "Tocando a música: " + music.getTitle();
            }
        }
        return "Música não encontrada na playlist.";
    }

    @Override
    public String deleteMusic(Long id) {
        for (Music music : musics) {
            if (music.getId().equals(id)) {
                this.removeMusic(music);
                return "Música removida com sucesso! Título: " + music.getTitle();
            }
        }
        return "Música não encontrada na playlist.";
    }
}
