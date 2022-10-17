package com.example.diploma.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Builder
@Table(name = "Users")
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @Column (nullable = false, unique = true)
    private String login;

    @Column (nullable = false)
    private String password;

    @OneToMany (cascade = CascadeType.ALL)
    private List<File> files;

}
