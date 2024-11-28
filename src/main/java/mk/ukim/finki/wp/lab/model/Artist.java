package mk.ukim.finki.wp.lab.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class Artist {
    private static Long artistId = 0L;

    private Long id;
    private String firstName;
    private String lastName;
    private String bio;

    public Artist(String firstName, String lastName, String bio){
        this.id = ++artistId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.bio = bio;
    }
}

