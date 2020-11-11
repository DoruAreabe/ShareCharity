package com.doruareabe.share_to_good_hands.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String surname;
    @Column(unique = true)
    String email;
    String password;
    @ManyToMany(fetch = FetchType.EAGER)
    List<Role> role;
}
