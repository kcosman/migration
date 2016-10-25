package com.nfl.mysqltoneo.config;

import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EntityScan(basePackages = { "com.nfl.dm.shield.ingestion.domain.job" })
public class DatabaseConfiguration {
}
