package eu.byjean.model;

import javax.persistence.*;

/**
 * Date: 24/11/11
 */
@Entity
@Table(name="address")
public class Address {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="SEQ_ADDRESS")
    @SequenceGenerator(name = "SEQ_ADDRESS", sequenceName = "ADDRESS_SEQ")
    private Long id;

    @Column(name = "address")
    private String adress;

    @Column(name = "subaddress")
    private String subaddress;


}
