package eu.byjean.dao;

import com.excilys.ebi.spring.dbunit.test.DataSet;
import com.excilys.ebi.spring.dbunit.test.DataSetTestExecutionListener;
import eu.byjean.model.Address;
import eu.byjean.test.utils.parallel.jpa.hibernate.JpaHibernateDbSetupTestListener;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import static junit.framework.Assert.assertNull;
import static org.junit.Assert.assertNotNull;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"applicationContext-test.xml"})
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class, JpaHibernateDbSetupTestListener.class, DataSetTestExecutionListener.class})
@DataSet(value = "AddressDaoTest.xml")
public class AddressDaoTest {

    @Autowired
    private AddressDao addressDao;

    @Test
    public void testFindByAddressname() {
        Address user = addressDao.findByAddress("a");
        assertNotNull(user);
    }

    @Test
    public void testFindByAbsentAddressname() {
        Address user = addressDao.findByAddress("c");
        assertNull(user);

    }

}