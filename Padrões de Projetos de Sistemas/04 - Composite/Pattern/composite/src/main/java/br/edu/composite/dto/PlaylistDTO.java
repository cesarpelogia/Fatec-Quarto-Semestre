package br.edu.composite.dto;

import java.util.ArrayList;
import java.util.List;

import br.edu.composite.compositeInterface.CompositeInterface;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PlaylistDTO {

    private String title;
    private List<CompositeInterface> items = new ArrayList<>();
    private int duration;
    private int numberOfMusics;

}
