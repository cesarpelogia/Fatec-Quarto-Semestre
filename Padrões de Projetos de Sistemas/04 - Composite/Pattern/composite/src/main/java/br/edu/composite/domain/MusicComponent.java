package br.edu.composite.domain;

import br.edu.composite.compositeInterface.CompositeInterface;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MusicComponent implements CompositeInterface {

    private final Long id;
    private final String title;
    private final String artist;
    private final int duration;

    @Override
    public String play(Long id) {
        return this.id.equals(id) ? "Tocando música: " + title + " do artista: " + artist : "Música não encontrada!";
    }

    @Override
    public String deleteMusic(Long id) {
        return this.id.equals(id) ? "Música deletada: " + title + " do artista: " + artist : "Música não encontrada!";
    }

}
