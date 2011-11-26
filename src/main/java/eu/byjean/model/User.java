package eu.byjean.model;

import javax.persistence.*;

@Entity
@Table(name="user")
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="SEQ_USER")
    @SequenceGenerator(name = "SEQ_USER", sequenceName = "USER_SEQ")
    private Long id;

    @Column(name = "username")
    private String username;
}
