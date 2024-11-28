package mk.ukim.finki.wp.lab.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
public class Song {

    private static Long idCounter = 0L;

    private String trackId;
    private String title;
    private String genre;
    private int releaseYear;
    private List<Artist> performers;
    private Long id;
    private Album album;
    public Song (String trackId, String title, String genre, int releaseYear, List<Artist> performers){
        this.id = ++idCounter;
        this.trackId = trackId;
        this.title = title;
        this. genre = genre;
        this.releaseYear = releaseYear;
        this.performers = performers;
        album = null;
    }
}
