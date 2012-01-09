package eu.byjean.model;

import javax.persistence.*;

/**
 * Date: 24/11/11
 */
@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ADDRESS")
    @SequenceGenerator(name = "SEQ_ADDRESS", sequenceName = "ADDRESS_SEQ")
    private Long id;

    @Column(name = "name")
    private String address;

    @Column(name = "subaddress")
    private String subaddress;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSubaddress() {
        return subaddress;
    }

    public void setSubaddress(String subaddress) {
        this.subaddress = subaddress;
    }


}
