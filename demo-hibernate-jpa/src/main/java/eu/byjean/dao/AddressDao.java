package eu.byjean.dao;

import eu.byjean.model.Address;

public interface AddressDao {
    public Address findByAddress(String address);
}
