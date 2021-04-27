package com.example.MovieRentalLab.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
@NamedQueries({
})
@Table(name = "CLIENT")
@Getter
@Setter
public class Client implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(max = 50)
    @Column(name = "USERNAME")
    private String username;

    @Size(max = 12)
    @Column(name = "PHONE")
    private String phone;

    @Size(max = 50)
    @Column(name = "EMAIL")
    private String email;

    @OneToMany(mappedBy = "client")
    private List<CinemaCommunityAward> awards;

    @ManyToMany
    private List<Movie> movies;
}
