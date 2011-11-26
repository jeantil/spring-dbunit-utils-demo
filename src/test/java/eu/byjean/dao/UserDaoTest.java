package eu.byjean.dao;

import com.excilys.ebi.spring.dbunit.test.DataSet;
import com.excilys.ebi.spring.dbunit.test.DataSetTestExecutionListener;
import eu.byjean.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:applicationContext-test.xml")
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class, DataSetTestExecutionListener.class})
@DataSet(value = "UserDaoTest.xml")
public class UserDaoTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void testFindByUsername() {
        User user = userDao.findByUsername("jean");
        assertNotNull(user);

    }

}