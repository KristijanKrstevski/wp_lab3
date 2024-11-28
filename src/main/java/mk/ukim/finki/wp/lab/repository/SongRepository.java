package mk.ukim.finki.wp.lab.repository;

import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

@Repository
public class SongRepository {
    private final List<Song> songs;

    public SongRepository(){
        songs = new ArrayList<>();
    }
    public List<Song> findAll(){
        return songs;
    }
    public Song findByTrackId(String trackId){
        return songs.stream().filter(song -> song.getTrackId().equals(trackId)).findFirst().orElse(null);
    }
    public Optional<Song> findById(long id){
        return songs.stream()
                .filter(track->track.getId().equals(id))
                .findFirst();
    }
    public Artist addArtistToSong(Artist artist, Song song){

        Artist returnArtist = null;
        Song foundSong = songs.stream().filter(findSong -> findSong.equals(song)).findFirst().orElse(null);
        if (foundSong != null){
            foundSong.getPerformers().add(artist);
            returnArtist = artist;
        }
        return returnArtist;
    }
    public void save(Song song){
        songs.removeIf(s->s.getId().equals(song.getId()));
        songs.add(song);
    }
    public void deleteById(long id){
        songs.removeIf(s->s.getId().equals(id));
    }
    public void removePerformerFromSong(long songId,long artistId){
        songs.stream()
                .filter(s->s.getId().equals(songId))
                .findFirst()
                .orElseThrow()
                .getPerformers().removeIf(p->p.getId().equals(artistId));
    }

}
