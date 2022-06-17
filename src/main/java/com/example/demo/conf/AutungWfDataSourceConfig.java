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
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;


import lombok.extern.slf4j.Slf4j;

@Configuration
@EnableJpaRepositories(
        entityManagerFactoryRef = "entityManagerFactory1",//配置連線工廠 entityManagerFactory1
        transactionManagerRef = "transactionManager1", //配置 事物管理器  transactionManager1
        basePackages = {"antung.db.wf.dao"}//設定持久層所在位置
)

@Slf4j
public class AutungWfDataSourceConfig {

	@Value("${antung.wf.spring.datasource.username}")
	private String wfUserName;
	
	@Value("${antung.wf.spring.datasource.password}")
	private String wfPd;

	@Value("${antung.wf.spring.datasource.url}")
	private String wfJdbcUrl;

	
	@Primary
	@ConfigurationProperties(prefix = "antung.wf")
    @Bean(name = "wfDatasource")
	public DataSource wfDatasource() {

		log.info("db id: {} , connect url: {}", wfUserName, wfJdbcUrl);
		return DataSourceBuilder.create().url(wfJdbcUrl).username(wfUserName).password(wfPd).build();
	}

	@Primary
	@Bean(name ="primaryJdbcTemplate")
	public JdbcTemplate primaryJdbcTemplate(
	@Qualifier("wfDatasource") DataSource wfDatasource) {
		return new JdbcTemplate(wfDatasource);
	}
	
	@Primary
	@Bean(name="entityManagerFactory1")
	//掃描entity 所在的package名稱
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(EntityManagerFactoryBuilder builder,@Qualifier("wfDatasource") DataSource wfDatasource) {
		return builder.dataSource(wfDatasource()).packages("antung.db.wf").build();
	}

	@Primary
	@Bean(name="transactionManager1")
	public PlatformTransactionManager transactionManager(EntityManagerFactoryBuilder builder,@Qualifier("wfDatasource") DataSource wfDatasource) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactoryBean(builder, wfDatasource).getObject());
		return transactionManager;
	}

}