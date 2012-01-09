package eu.byjean.dao.impl;

import eu.byjean.dao.AddressDao;
import eu.byjean.model.Address;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class AddressDaoImpl extends AbstractDao<Address, Long> implements AddressDao {

    public Address findByAddress(String address) {
        Query query = getSession().createQuery("from Address where address=:address");
        query.setParameter("address", address);
        return (Address) query.uniqueResult();
    }
}
