package com.doruareabe.share_to_good_hands.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Donation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Integer quantity;
    String sity;
    String street;
    String zipCode;
    LocalDate pickUpDate;
    LocalTime pickUpTime;
    String pickUpComment;
    @ManyToOne
    Category category;
    @ManyToOne
    Institution institution;
}
