package br.edu.composite.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import br.edu.composite.compositeInterface.compositeInterface;

@Data
@Entity
@Table(name = "music")
public class Music implements compositeInterface {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "artist")
    private String artist;

    @Column(name = "duration")
    private int duration;

    @Override
    public String play(Long id) {
        return "Tocando a música: " + title;
    }

    @Override
    public String deleteMusic(Long id) {
        return "Música deletada com sucesso! Título: " + title;
    }
}
