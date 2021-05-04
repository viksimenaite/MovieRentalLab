package com.example.MovieRentalLab.entities;

import com.example.MovieRentalLab.enums.MovieGenre;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(name = "Movie.findAll", query = "select m from Movie as m")
})
@Table(name = "MOVIE")
@Getter
@Setter
public class Movie implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(max = 50)
    @Column(name = "NAME")
    private String name;

    @Column(name = "GENRE")
    private MovieGenre genre;

    @Column(name = "RELEASE_DATE")
    private Date releaseDate;

    @Column(name = "AVAILABILITY_END_DATE")
    private Date availabilityEndDate;

    @ManyToMany(mappedBy = "movies")
    private List<Client> clients = new ArrayList<>();
}
