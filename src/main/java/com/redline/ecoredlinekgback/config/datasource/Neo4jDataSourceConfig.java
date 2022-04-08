package com.redline.ecoredlinekgback.config.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
// 扫描 Mapper 接口并容器管理
@MapperScan(basePackages = Neo4jDataSourceConfig.PACKAGE, sqlSessionFactoryRef = "neo4jSqlSessionFactory")
public class Neo4jDataSourceConfig {

    // 精确到 neo4j 目录，以便跟其他数据源隔离
    static final String PACKAGE = "com.redline.ecoredlinekgback.mapper.neo4j";
    static final String MAPPER_LOCATION = "classpath:mybatis/mapper/neo4j/*.xml";

    @Bean(name = "neo4jDataSource")
    @ConfigurationProperties("spring.datasource.druid.neo4j")
    public DataSource neo4jDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        return dataSource;
    }

    @Bean(name = "neo4jTransactionManager")
    public DataSourceTransactionManager neo4jTransactionManager() {
        return new DataSourceTransactionManager(neo4jDataSource());
    }

    @Bean(name = "neo4jSqlSessionFactory")
    public SqlSessionFactory neo4jSqlSessionFactory(@Qualifier("neo4jDataSource") DataSource neo4jDataSource)
            throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(neo4jDataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(Neo4jDataSourceConfig.MAPPER_LOCATION));
        return sessionFactory.getObject();
    }
}
