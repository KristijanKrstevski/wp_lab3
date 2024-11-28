package mk.ukim.finki.wp.lab.service.impl;

import mk.ukim.finki.wp.lab.model.Album;
import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;
import mk.ukim.finki.wp.lab.repository.AlbumRepository;
import mk.ukim.finki.wp.lab.repository.ArtistRepository;
import mk.ukim.finki.wp.lab.repository.SongRepository;
import mk.ukim.finki.wp.lab.service.SongService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SongServiceImpl implements SongService {

    private final SongRepository songRepository;
    private final ArtistRepository artistRepository;
    private final AlbumRepository albumRepository;


    public SongServiceImpl(SongRepository songRepository, ArtistRepository artistRepository, AlbumRepository albumRepository) {
        this.songRepository = songRepository;
        this.artistRepository = artistRepository;
        this.albumRepository = albumRepository;
    }

    @Override
    public List<Song> listSongs() {
        return songRepository.findAll();
    }

    @Override
    public Artist addArtistToSong(Artist artist, Song song) {
        return songRepository.addArtistToSong(artist, song);
    }

    @Override
    public Song findByTrackId(String trackId) {
        return songRepository.findByTrackId(trackId);
    }

    @Override
    public Optional<Song> findById(long id) {
        return songRepository.findById(id);
    }

    @Override
    public void findAndAddArtistToSong(Long artistId, Long songId) {
        Artist artist = artistRepository.findById(artistId).orElseThrow(RuntimeException::new);
        Song song = songRepository.findById(songId).orElseThrow(RuntimeException::new);
        this.addArtistToSong(artist,song);
    }

    @Override
    public void save(Long id, String title, String trackId, String genre, int releaseYear, Long albumId) {
        Song newSong = new Song(trackId,title,genre,releaseYear,new ArrayList<>());
        if(id!=null){
            newSong.setId(id);
            newSong.setPerformers(songRepository.findById(id).orElseThrow().getPerformers());
        }
        Album albumToAdd = albumRepository.findById(albumId).orElseThrow();
        newSong.setAlbum(albumToAdd);
        songRepository.save(newSong);
    }

    @Override
    public void removeArtistFromSong(Long songId, Long performerId) {
        songRepository.removePerformerFromSong(songId,performerId);
    }

    @Override
    public void deleteById(long id) {
        songRepository.deleteById(id);
    }


}
