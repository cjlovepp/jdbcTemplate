package jdbcTemplate;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.coddy.dao.HomeWorkDao;

/**
 * @author CJ
 *
 * @date 2014年10月23日 下午1:46:59
 */
public class TestDemo {
	
	@Test
	public void testDataSource() throws SQLException {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
		DataSource dataSource = context.getBean("springDSN",DataSource.class) ;
		System.out.println(dataSource.getConnection());
	}
	
	@Test
	public void TestGetHomework(){
		//获取配置文件上下文
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
		//获取Bean
		HomeWorkDao homeWork = context.getBean(HomeWorkDao.class);
		List<Map<String, Object>> homeWorkList = homeWork.findALL();
		Iterator iterator = homeWorkList.iterator();
		System.out.println(iterator.toString());
	}
	
}
