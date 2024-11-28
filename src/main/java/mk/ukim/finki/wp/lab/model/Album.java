package mk.ukim.finki.wp.lab.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class Album {

    public static Long albumId = 0L;

    private Long id;
    private String name;
    private String genre;
    private String releaseYear;

    public Album (String name, String genre, String releaseYear){
        this.id = ++albumId;
        this.name = name;
        this.genre = genre;
        this.releaseYear = releaseYear;
    }

}
