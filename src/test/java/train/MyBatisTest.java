package train;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.train.service.IStationService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring.xml","classpath:spring-mybatis.xml" })
public class MyBatisTest {

	@Autowired
	private IStationService stationService;
	@Test
	public void testCalcuSartToEndPrice(){
		//返回值快捷键ctrl+shift+L
//		ClassPathXmlApplicationContext beans=new ClassPathXmlApplicationContext(new String[]{"spring.xml","spring-mybatis.xml"});
//	    IStationService stationService=(IStationService)beans.getBean("stationService");
	   Double calcuSartToEndPrice = stationService.calcuSartToEndPrice("k188","云梦", "上海");
	   System.out.println("calcuSartToEndPrice:" + calcuSartToEndPrice);
	}
}
