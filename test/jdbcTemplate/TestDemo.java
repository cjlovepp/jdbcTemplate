package jdbcTemplate;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.coddy.common.Page;
import com.coddy.dao.HomeWorkDao;
import com.coddy.entity.HomeWork;

/**
 * @author CJ
 *
 * @date 2014年10月23日 下午1:46:59
 */
/**
 * @author CJ
 *
 * @date 2014年10月24日 上午11:32:25
 */
public class TestDemo {
	
	ApplicationContext context;
	//获取配置文件上下文
	@Before
	public void initContext(){
		context = new ClassPathXmlApplicationContext("spring-context.xml");
	}
	
	
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
	
	@Test
	public void TestGetHomeworkWithPage(){
		
		//获取Bean
		HomeWorkDao homeWork = context.getBean(HomeWorkDao.class);
		Page<HomeWork> homeWorkList = homeWork.getHomeWorks(2, 2);
		for (HomeWork homework : homeWorkList.getPageItems()) {
			System.out.println(homework.getTitle());
		}
		
//		Iterator iterator = homeWorkList.iterator();
//		System.out.println(iterator.toString());
	}
	
}
