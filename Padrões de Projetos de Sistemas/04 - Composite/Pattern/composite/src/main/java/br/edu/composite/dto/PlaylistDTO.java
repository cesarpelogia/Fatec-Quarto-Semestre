package br.edu.composite.dto;

import java.util.ArrayList;
import java.util.List;

import br.edu.composite.entity.Music;
import lombok.Data;

@Data
public class PlaylistDTO {

    private String name;
    private List<Music> musics = new ArrayList<>();
    private int duration;
    private int numberOfMusics;

}
