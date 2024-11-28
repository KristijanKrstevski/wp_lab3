package mk.ukim.finki.wp.lab.repository;

import mk.ukim.finki.wp.lab.model.Artist;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ArtistRepository {
    private List<Artist> artists;

    public ArtistRepository(){
        artists = new ArrayList<>();
        artists.add(new Artist(1L, "Nikola", "Hristovski", "Top 1 Afro artist"));
        artists.add(new Artist(2L, "Kristijan", "Krstevski", "Making beats"));
        artists.add(new Artist(3L, "Gorazd", "Filipovski", "Top 1 R&B artist"));
        artists.add(new Artist(4L, "Teodor", "Bogoeski", "Poetry"));
        artists.add(new Artist(5L, "Viktor", "Spasovski", "Jazz performer"));
    }

    public List<Artist> findAll(){
        return artists;
    }
    public Optional<Artist> findById(Long id){
        return artists.stream().filter(artist -> artist.getId().equals(id)).findFirst();
    }
}
