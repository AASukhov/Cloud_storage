package com.example.diploma.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;


@Data
@Entity
@Builder
@Table (name = "Files")
@AllArgsConstructor
@NoArgsConstructor
public class File {

    @Id
    @Column (nullable = false, unique = true)
    private String fileName;

    @Column (nullable = false)
    private LocalDateTime localDateTime;

    @Column (nullable = false)
    private Long size;

    @Column (nullable = false)
    private String type;

    @Lob
    private byte [] content;

    @ManyToOne
    private User user;
}
