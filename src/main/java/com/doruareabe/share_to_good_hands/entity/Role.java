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
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String role;
    @ManyToMany(mappedBy = "role",fetch = FetchType.EAGER)
    List<User> users;
}
