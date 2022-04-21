package com.producter.app.domain;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import javax.persistence.*;
import java.io.Serializable;
import java.time.OffsetDateTime;

@Getter
@Setter
@Entity
@Table(name = "PLAYER")
public class Player implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "PLAYER_NAME", nullable = false)
    private String name;

    @Column(name = "PLAYER_SURNAME", nullable = false)
    private String surname;

    @Column(name = "POSITION_NAME", nullable = false)
    private String position;

}
