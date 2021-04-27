package com.example.MovieRentalLab.entities;

import com.example.MovieRentalLab.enums.CinemaCommunityAwardType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@NamedQueries({
})
@Table(name = "AWARD")
@Getter
@Setter
public class Award implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(max = 50)
    @Column(name = "OFFICIAL_NAME")
    private String officialName;

    @Column(name = "AWARD_TYPE")
    private CinemaCommunityAwardType awardType;

    @Column(name = "DISCOUNT")
    private double discount;

    @ManyToOne
    private Client client;
}
