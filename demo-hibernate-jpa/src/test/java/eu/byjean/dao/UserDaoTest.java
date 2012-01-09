package eu.byjean.dao;

import com.excilys.ebi.spring.dbunit.test.DataSet;
import com.excilys.ebi.spring.dbunit.test.DataSetTestExecutionListener;
import eu.byjean.model.User;
import eu.byjean.test.utils.parallel.jpa.hibernate.JpaHibernateDbSetupTestListener;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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

@DataSet(value = "UserDaoTest.xml")
public class UserDaoTest {
    private static final Log logger = LogFactory.getLog(UserDaoTest.class);

    @Autowired
    private UserDao userDao;

    @Test
    public void testFindByUsername() {
        User user = userDao.findByUsername("jean");
        assertNotNull(user);
    }

    @Test
    public void testFindByAbsentUsername() {
        User user = userDao.findByUsername("tean");
        assertNull(user);

    }

}