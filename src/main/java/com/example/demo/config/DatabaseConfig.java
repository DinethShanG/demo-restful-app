package com.example.demo.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
public class DatabaseConfig {

	@Value("${spring.datasource.url}")
	private String jdbcUrl;

	@Value("${spring.datasource.username}")
	private String username;

	@Value("${spring.datasource.password}")
	private String password;

	@Value("${spring.datasource.driver-class-name}")
	private String driverClassName;

	@Value("${spring.datasource.hikari.pool-name}")
	private String poolName;

	@Value("${spring.datasource.hikari.maximum-pool-size}")
	private int maximumPoolSize;

	@Value("${spring.datasource.hikari.minimum-idle}")
	private int minimumIdle;

	@Value("${spring.datasource.hikari.idle-timeout}")
	private long idleTimeout;

	@Value("${spring.datasource.hikari.connection-timeout}")
	private long connectionTimeout;

	@Value("${spring.datasource.hikari.max-lifetime}")
	private long maxLifetime;

	@Value("${spring.datasource.hikari.data-source-properties.cachePrepStmts}")
	private boolean cachePrepStmts;

	@Value("${spring.datasource.hikari.data-source-properties.prepStmtCacheSize}")
	private int prepStmtCacheSize;

	@Value("${spring.datasource.hikari.data-source-properties.prepStmtCacheSqlLimit}")
	private int prepStmtCacheSqlLimit;

	@Bean
	@Primary
	public DataSource dataSource() {
		HikariConfig config = new HikariConfig();
		config.setJdbcUrl(jdbcUrl);
		config.setUsername(username);
		config.setPassword(password);
		config.setDriverClassName(driverClassName);
		config.setPoolName(poolName);
		config.setMaximumPoolSize(maximumPoolSize);
		config.setMinimumIdle(minimumIdle);
		config.setIdleTimeout(idleTimeout);
		config.setConnectionTimeout(connectionTimeout);
		config.setMaxLifetime(maxLifetime);

		config.addDataSourceProperty("cachePrepStmts", cachePrepStmts);
		config.addDataSourceProperty("prepStmtCacheSize", prepStmtCacheSize);
		config.addDataSourceProperty("prepStmtCacheSqlLimit", prepStmtCacheSqlLimit);

		return new HikariDataSource(config);
	}

	@Bean
	public PlatformTransactionManager transactionManager(DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}
}