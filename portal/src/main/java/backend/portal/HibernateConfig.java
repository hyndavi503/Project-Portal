package backend.portal;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Properties;

import javax.sql.DataSource;


@Configuration
@EnableTransactionManagement
@ComponentScan("backend.portal")
public class HibernateConfig 
{
	
	@Bean
	public DataSource getDataSource()
	{
		BasicDataSource dataSource=new BasicDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/portal");
		dataSource.setUsername("sa");
		dataSource.setPassword("sa");
		return dataSource;
	}
	
	@Bean
	public SessionFactory getSessionFactory(DataSource dataSource)
	{
		LocalSessionFactoryBuilder factoryBuilder=new LocalSessionFactoryBuilder(dataSource);
		factoryBuilder.addProperties(getProperties());
		factoryBuilder.scanPackages("backend.portal.model");
		return factoryBuilder.buildSessionFactory();
		
	}
	

	public Properties getProperties()
	{
		Properties properties=new Properties();
		properties.setProperty("hibernate.dialect","org.hibernate.dialect.H2Dialect");
		properties.setProperty("hibernate.hbm2ddl.auto","update");
		properties.setProperty("hibernate.show_sql","true");
		return properties;
		
	}
	
	
	@Bean
	public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionFactory)
	{
		return new HibernateTransactionManager(sessionFactory);
	}
	
	
}

