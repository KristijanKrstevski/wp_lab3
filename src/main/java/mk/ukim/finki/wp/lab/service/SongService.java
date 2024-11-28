package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.model.Song;
import mk.ukim.finki.wp.lab.model.Artist;

import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

public interface SongService {
    List<Song> listSongs();
    Artist addArtistToSong(Artist artist, Song song);
    public Song findByTrackId(String trackId);
    void save(Long id,String title, String trackId,String genre,int releaseYear, Long albumId);
    void removeArtistFromSong(Long songId, Long performerId);
    void deleteById(long id);
    Optional<Song> findById(long id);
    void findAndAddArtistToSong(Long artistId, Long songId);

}
