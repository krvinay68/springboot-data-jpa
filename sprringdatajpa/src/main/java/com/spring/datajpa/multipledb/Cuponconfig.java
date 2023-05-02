//package com.spring.datajpa.multipledb;
//
//import javax.sql.DataSource;
//
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//import com.zaxxer.hikari.HikariDataSource;
//
//import jakarta.persistence.EntityManagerFactory;
//
//@Configuration
//@EnableTransactionManagement
//@EnableJpaRepositories(entityManagerFactoryRef ="cuponEntityManagerFactory",transactionManagerRef ="cuponTransactionMagnager",
//basePackages = {"com.spring.datajpa.multipledb"})
//public class Cuponconfig {
//
//	//this will read the configuration from the properties file
//	@Primary
//	@Bean(name="cuponDataSourceProperties")
//	@ConfigurationProperties("spring.datasource-cupon")
//	public DataSourceProperties cuponDataSourceProperties() {		
//			return new DataSourceProperties();
//	}
//	@Primary
//	@Bean(name="cuponDataSource")
//	public DataSource cuponDataSource() {
//		return cuponDataSourceProperties().initializeDataSourceBuilder().type(HikariDataSource.class).build();
//	}
//	
//	@Primary
//	@Bean(name="cuponEntityManagerFactory")
//	public LocalContainerEntityManagerFactoryBean cuponEntityManagerFactory(EntityManagerFactoryBuilder builder) {
//		
//		return builder.dataSource(cuponDataSource()).packages(Cupon.class).build();
//		
//	}
//	@Primary
//	@Bean(name="cuponTransactionMagnager")
//	public PlatformTransactionManager cuponTransactionMagnager(@Qualifier("cuponEntityManagerFactory") 
//	                                 EntityManagerFactory cuponEntityManagerFactory) {
//		return new JpaTransactionManager(cuponEntityManagerFactory);
//	}
//	
//}
