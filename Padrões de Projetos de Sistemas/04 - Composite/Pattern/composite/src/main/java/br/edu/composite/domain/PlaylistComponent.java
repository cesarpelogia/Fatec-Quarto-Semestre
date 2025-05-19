package br.edu.composite.domain;

import java.util.Iterator;
import java.util.List;

import br.edu.composite.compositeInterface.CompositeInterface;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PlaylistComponent implements CompositeInterface {

    private final Long id;
    private final String name;
    private final List<CompositeInterface> items;
    private int duration;
    private int numberOfMusics;

    @Override
    public String play(Long id){
        if (this.id.equals(id)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Tocando playlist: ").append(name).append("\n");
            for (CompositeInterface item : items) {
                sb.append(item.play(id)).append("\n");
            }
            return sb.toString();
        }
        return "Playlist não encontrada!";
        
    }

    @Override
    public String deleteMusic(Long id){
        Iterator<CompositeInterface> iterator = items.iterator();
        while(iterator.hasNext()){
            CompositeInterface item = iterator.next();

            if (item instanceof MusicComponent music && music.getId().equals(id)){
                iterator.remove();
                return "Música deletada: " + music.getTitle() + " do artista: " + music.getArtist();
            } else if(item instanceof PlaylistComponent playlist) {
                if (playlist.getId().equals(id)) {
                    iterator.remove();
                    return "Playlist deletada: " + playlist.getName();
                } else {
                    String result = playlist.deleteMusic(id);
                    if (!result.equals("Música ou playlist não encontrada!")) {
                        return result;
                    }
                }
            }
        }
        return "Música ou playlist não encontrada!";
    }
}
