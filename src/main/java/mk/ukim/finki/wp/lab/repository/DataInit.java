package mk.ukim.finki.wp.lab.repository;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.wp.lab.model.Album;
import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Component
public class DataInit {
    private final AlbumRepositoryJPA albumRepository;
    private final ArtistRepositoryJPA artistRepository;
    private final SongRepositoryJPA songRepository;

    public DataInit(AlbumRepositoryJPA albumRepository, ArtistRepositoryJPA artistRepository, SongRepositoryJPA songRepository) {
        this.albumRepository = albumRepository;
        this.artistRepository = artistRepository;
        this.songRepository = songRepository;
    }
    @PostConstruct
    public void init() {
        List<Album> albums = new ArrayList<>();
        albums.add( new Album("Album1", "Rock", "2003"));
        albums.add( new Album("Album2", "House", "2020"));
        albums.add( new Album("Album3", "Techno", "2023"));
        albums.add( new Album("Album4", "R&B", "2012"));
        albums.add( new Album("Album4", "Afro", "2024"));
        albumRepository.saveAll(albums);

        List<Song> songs = new ArrayList<>();
        songs.add(new Song("1", "Song1", "Rock", 2003));
        songs.add(new Song("2", "Song2", "Pop", 2013));
        songs.add(new Song("3", "Song3", "Rock", 2015));
        songs.add(new Song("4", "Song4", "Soul", 2024));
        songs.add(new Song("5", "Song5", "Pop", 2023));

        List<Album> temp_albums = albumRepository.findAll();

        IntStream.range(0, songs.size()).forEach(i->{
            songs.get(i).setAlbum(temp_albums.get(i));
            songRepository.save(songs.get(i));
        });

        List<Artist> artists = new ArrayList<>();
        artists.add(new Artist("Nikola", "Hristovski", "Top 1 Afro artist"));
        artists.add(new Artist("Kristijan", "Krstevski", "Making beats"));
        artists.add(new Artist("Gorazd", "Filipovski", "Top 1 R&B artist"));
        artists.add(new Artist("Teodor", "Bogoeski", "Poetry"));
        artists.add(new Artist("Viktor", "Spasovski", "Jazz performer"));
        artistRepository.saveAll(artists);
    }
}
