package com.soxam.yliad.configuration;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class DataSourceConfig {

	@Bean
	public HikariDataSource mysqlDataSource() {
		return DataSourceBuilder.create()
			.url("jdbc:mysql://localhost/yliad_db")
			.username("root")
			.password("isamovingon")
			.type(HikariDataSource.class)
			.build();
	}

}
