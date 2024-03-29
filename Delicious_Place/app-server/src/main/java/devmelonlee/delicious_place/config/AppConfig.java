package devmelonlee.delicious_place.config;


import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;


@ComponentScan(basePackages = {
        "devmelonlee.delicious_place.dao",
        "devmelonlee.delicious_place.controller",
        "devmelonlee.delicious_place.service"})
@PropertySource({"classpath:devmelonlee/delicious_place/config/jdbc.properties"})
@MapperScan("devmelonlee.delicious_place.dao")

public class AppConfig {

  public AppConfig() {
    System.out.println("AppConfig() 호출됨");
  }

  @Bean
  public SqlSessionFactory sqlSessionFactory(DataSource dataSource, ApplicationContext appCtx) throws Exception {
    System.out.println("AppConfig.sqlSessionFactory() 호출됨!");

    // Mybatis에서 Log4j 2.x 버전을 사용하도록 활성화시킨다.
    org.apache.ibatis.logging.LogFactory.useLog4J2Logging();

    SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
    factoryBean.setDataSource(dataSource);
    factoryBean.setTypeAliasesPackage("devmelonlee.delicious_place.vo");
    factoryBean.setMapperLocations(appCtx.getResources("classpath:devmelonlee/delicious_place/dao" +
            "/mysql" +
            "/*Dao.xml"));

    return factoryBean.getObject();
  }

  @Bean
  public DataSource dataSource(
          @Value("${jdbc.driver}") String driver,
          @Value("${jdbc.url}") String url,
          @Value("${jdbc.username}") String username,
          @Value("${jdbc.password}") String password) {
    System.out.println("AppConfig.dataSource() 호출됨!");

    DriverManagerDataSource ds = new DriverManagerDataSource();
    ds.setDriverClassName(driver);
    ds.setUrl(url);
    ds.setUsername(username);
    ds.setPassword(password);

    return ds;
  }

  @Bean
  public PlatformTransactionManager transactionManager(DataSource dataSource) {
    System.out.println("AppConfig.transactionManager() 호출됨!");

    return new DataSourceTransactionManager(dataSource);
  }

}
