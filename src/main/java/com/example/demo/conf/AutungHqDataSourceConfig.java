package com.example.demo.conf;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import lombok.extern.slf4j.Slf4j;

@Configuration
@EnableTransactionManagement

@EnableJpaRepositories(
        entityManagerFactoryRef = "entityManagerFactory",//配置連線工廠 entityManagerFactory
        transactionManagerRef = "transactionManager", //配置 事物管理器  transactionManager
        basePackages = {"antung.db.hq.dao"}//設定持久層所在位置
)

@Slf4j
public class AutungHqDataSourceConfig {

	@Value("${antung.hq.spring.datasource.username}")
	private String hqUserName;
	
	@Value("${antung.hq.spring.datasource.password}")
	private String hqPd;

	@Value("${antung.hq.spring.datasource.url}")
	private String hqJdbcUrl;

	
	
	@ConfigurationProperties(prefix = "antung.hq")
    @Bean(name = "hqDatasource")
	public DataSource hqDatasource() {

		log.info("db id: {} , connect url: {}", hqUserName, hqJdbcUrl);
		
		return DataSourceBuilder.create().url(hqJdbcUrl).username(hqUserName).password(hqPd).build();
	}

	@Bean(name ="secondaryJdbcTemplate")
	public JdbcTemplate secondaryJdbcTemplate(
	@Qualifier("hqDatasource") DataSource hqDatasource) {
		return new JdbcTemplate(hqDatasource);
	}
	
	@DependsOn({"hqDatasource"})
	@Bean(name="entityManagerFactory")
	//掃描entity 所在的package名稱
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(EntityManagerFactoryBuilder builder,@Qualifier("hqDatasource") DataSource hqDatasource) {
		return builder.dataSource(hqDatasource()).packages("antung.db.hq").build();
	}

	
	@Bean(name="transactionManager")
	public PlatformTransactionManager transactionManager(EntityManagerFactoryBuilder builder,@Qualifier("hqDatasource") DataSource hqDatasource) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactoryBean(builder, hqDatasource).getObject());
		return transactionManager;
	}

}