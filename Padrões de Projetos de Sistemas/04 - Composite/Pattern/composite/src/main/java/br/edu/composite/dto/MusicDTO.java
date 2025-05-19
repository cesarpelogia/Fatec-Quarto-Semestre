package br.edu.composite.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MusicDTO {

    private String title;
    private String artist;
    private int duration;

}
