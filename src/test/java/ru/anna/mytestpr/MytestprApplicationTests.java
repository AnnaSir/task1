package ru.anna.mytestpr;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import ru.anna.mytestpr.dao.OrderDao;
import ru.anna.mytestpr.jdo.Order;
import ru.anna.mytestpr.utils.MyFileUtils;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class MytestprApplicationTests {

	private final static String INIT_DB=MyFileUtils.scriptLoader("/sql/createAllTables.sql");
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Before
	public void init() {
		jdbcTemplate.execute(INIT_DB);
	}

	@Autowired
	private OrderDao orderDao;

	@Test
	public void getOrderListTest() {
		List<Order> result = orderDao.getOrderList();

		assert result.size() == 0;

		orderDao.addOrder(1L, true);

		assert orderDao.getOrderList().size() == 1;
	}

}
