package mk.ukim.finki.wp.lab.repository;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.wp.lab.model.Album;
import mk.ukim.finki.wp.lab.model.Song;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Component
public class DataInit {
    private final AlbumRepository albumRepository;
    private final SongRepository songRepository;

    public DataInit(AlbumRepository albumRepository, SongRepository songRepository) {
        this.albumRepository = albumRepository;
        this.songRepository = songRepository;
    }
    @PostConstruct
    public void init() {
        List<Song> songs = new ArrayList<>();
        songs.add(new Song("1", "Bohemian Rhapsody", "Rock", 1975, new ArrayList<>()));
        songs.add(new Song("2", "I Will Always Love You", "Pop", 1992, new ArrayList<>()));
        songs.add(new Song("3", "Jailhouse Rock", "Rock and Roll", 1957, new ArrayList<>()));
        songs.add(new Song("4", "Respect", "Soul", 1967, new ArrayList<>()));
        songs.add(new Song("5", "Thriller", "Pop", 1982, new ArrayList<>()));

        List<Album> albums = albumRepository.findAll();

        IntStream.range(0, songs.size()).forEach(i->{
            songs.get(i).setAlbum(albums.get(i));
            songRepository.save(songs.get(i));
        });
    }
}
