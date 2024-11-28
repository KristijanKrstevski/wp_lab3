package mk.ukim.finki.wp.lab.repository;

import org.springframework.stereotype.Repository;
import mk.ukim.finki.wp.lab.model.Album;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public class AlbumRepository {
    private final List<Album> albums;

    public AlbumRepository() {
        Album album1 = new Album("Album1", "Rock", "2003");
        Album album2 = new Album("Album2", "House", "2020");
        Album album3 = new Album("Album3", "Techno", "2023");
        Album album4 = new Album("Album4", "R&B", "2012");
        Album album5 = new Album("Album4", "Afro", "2024");
        albums = Arrays.asList(album1, album2, album3, album4, album5);
    }
    public List<Album> findAll(){
        return albums;
    }
    public Optional<Album> findById(Long id){
        return albums.stream().filter(i->i.getId().equals(id)).findFirst();
    }

}
