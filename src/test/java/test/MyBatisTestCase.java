package test;


import java.util.Map;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.synchro.dao.YmyyDao;
import com.synchro.service.PersonService;

public class MyBatisTestCase {

    ClassPathXmlApplicationContext ctx;
    @Before
    public void init(){
        ctx = new ClassPathXmlApplicationContext(
            "spring-web.xml",
            "spring-service.xml",
            "spring-mybatis.xml");
    }
    @Test
    public void testDataSource(){
        DataSource ds = ctx.getBean(
            "dataSource", DataSource.class);
        System.out.println(ds); 
    }
    @Test
    public void testSqlSessionFactory(){
        SqlSessionFactory factory=
            ctx.getBean("sqlSessionFactory",
            SqlSessionFactory.class);
        System.out.println(factory);
    }
    @Test
    public void testMapperScanner(){
        MapperScannerConfigurer scanner=
            ctx.getBean("mapperScanner",
            MapperScannerConfigurer.class);
        System.out.println(scanner); 
    }
    @Test
    public void testfindAll(){
        YmyyDao dao = ctx.getBean(
            "ymyyDao", YmyyDao.class);
//        dao.findAll();
//        Map map=dao.findAll();
//        System.out.println(map);
    }
    @Test
    public void testfindAll2(){
        PersonService service = ctx.getBean(
            "personService", PersonService.class);
//        Map map=service.finddata();
//        System.out.println(map);
    }
/*    @Test
    public void testfindmap(){
    YmyyDao dao = ctx.getBean(
    	 "ymyyDao", YmyyDao.class);
	Map<String,Person> personMap = dao.findMap();
	System.out.println(personMap);
    }*/
}