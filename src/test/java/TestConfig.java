import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import sk.stopangin.log.LogAspect;
import sk.stopangin.repository.ExpenseDao;
import sk.stopangin.spring.security.repository.UserDao;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by myPC on 23. 5. 2015.
 */
@Configuration
@EnableTransactionManagement
@ComponentScan(basePackageClasses = {UserDao.class, ExpenseDao.class, LogAspect.class})
@PropertySource( "classpath:application.properties")
@EnableAspectJAutoProxy(proxyTargetClass = true)

public class TestConfig {
    @Value("${default.schema}")
    private String defaultSchema;
    @Value("${showsql}")
    private String showSql;

    @Bean
    @Autowired
    LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        localContainerEntityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        localContainerEntityManagerFactoryBean.setDataSource(dataSource);
        localContainerEntityManagerFactoryBean.setPackagesToScan(new String[]{"sk.stopangin.spring.security.model", "sk.stopangin.model"});
        final Properties props = new Properties();
        props.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQL9Dialect");
        props.setProperty("hibernate.show_sql", showSql);
        props.setProperty("hibernate.default_schema", defaultSchema);
        localContainerEntityManagerFactoryBean.setJpaProperties(props);

        return localContainerEntityManagerFactoryBean;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

    //todo do configu
    @Bean
    DataSource getDataSource() {
        final BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setDriverClassName("org.postgresql.Driver");
        basicDataSource.setUrl("jdbc:postgresql://127.0.0.1:5432/expensev3");
        basicDataSource.setUsername("postgres");
        basicDataSource.setPassword("boot");
        basicDataSource.setMaxTotal(20);
        basicDataSource.setMaxIdle(100);
        return  basicDataSource;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);

        return transactionManager;
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
        return new PropertySourcesPlaceholderConfigurer();
    }

}
