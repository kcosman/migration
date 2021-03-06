package com.nfl.mysqltoneo.config;

import org.neo4j.ogm.session.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.config.Neo4jConfiguration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.server.Neo4jServer;
import org.springframework.data.neo4j.server.RemoteServer;
import org.springframework.data.transaction.ChainedTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableNeo4jRepositories(basePackages = "com.nfl.mysqltoneo.repository")
public class Neo4jConfig extends Neo4jConfiguration {
    @Value("${db.neo4j.username}")
    private String username;
    @Value("${db.neo4j.password}")
    private String password;
    @Value("${db.neo4j.url}")
    private String url;

    @Autowired
    @Qualifier("sqlTransactionManager")
    private PlatformTransactionManager sqlTransactionManager;

    @Override
    public Neo4jServer neo4jServer() {
        return new RemoteServer(url, username, password);
    }

    @Bean(name = "transactionManager")
    public PlatformTransactionManager neo4jTransactionManager() throws Exception {
        return new ChainedTransactionManager(sqlTransactionManager, super.transactionManager());
    }

    @Override
    public SessionFactory getSessionFactory() {
        return new SessionFactory("com.nfl.dm.shield.domain.graph");
    }
}
