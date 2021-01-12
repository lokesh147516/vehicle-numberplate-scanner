/*package com.rto.vehilcles.rtovehicleregistrationdetails.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;
@Configuration
@Component
@EnableTransactionManagement
public class HibernateConfiguration {

	@Value("${hibernate.connection.driver_class}")	
	private String driver;
	@Value("${hibernate.connection.password}")
	private String password;
	@Value("${hibernate.connection.url}")
	private String url;
	@Value("${hibernate.connection.username}")
	private String username;
	@Value("${hibernate.dialect}")
	private String dialect;
	@Value("${hibernate.show_sql}")
	private String show_sql;
	@Value("${hibernate.hbm2ddl}")
	private String hbm2ddl_auto;
	@Value("${entitymanager.packagesToScan}")
	private String package_to_scan;

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(driver);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		return dataSource;
	}

	@Bean(name="entityManagerFactory")
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		String[] packages = new String[1];
		packages[0] = package_to_scan;
		sessionFactory.setPackagesToScan(packages);

		Properties hibernateProperties = new Properties();
		hibernateProperties.put("hibernate.dialect", dialect);
		hibernateProperties.put("hibernate.show_sql", show_sql);
		hibernateProperties.put("hibernate.hbm2ddl.update", hbm2ddl_auto);
		sessionFactory.setHibernateProperties(hibernateProperties);
		return sessionFactory;
	}
	
	@Bean
	public HibernateTransactionManager transactionManager() {
		HibernateTransactionManager transactionManager=new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory().getObject());
		
		return transactionManager;
	}

}
*/