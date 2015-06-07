package sk.stopangin.spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import sk.stopangin.repository.ExpenseDao;
import sk.stopangin.spring.security.config.SecurityConfig;
import sk.stopangin.spring.security.repository.UserDao;
import sk.stopangin.spring.security.service.MyUserDetailService;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by myPC on 22. 3. 2015.
 */
@Configuration
@EnableTransactionManagement
@Import(SecurityConfig.class)
@ComponentScan(basePackageClasses = {UserDao.class, ExpenseDao.class, MyUserDetailService.class})
@PropertySource(value = "classpath:application.properties")
public class AppConfig {

    @Value("${default.schema}")
    private String defaultSchema;

    @Bean
    @Autowired
    LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        localContainerEntityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        localContainerEntityManagerFactoryBean.setDataSource(dataSource);
        localContainerEntityManagerFactoryBean.setPackagesToScan(new String[]{"sk.stopangin.spring.security.model", "sk.stopangin.model"});
        final Properties props = new Properties();
        props.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQL9Dialect");
        props.setProperty("hibernate.show_sql", "true");
        props.setProperty("hibernate.default_schema", "data");
        localContainerEntityManagerFactoryBean.setJpaProperties(props);

        return localContainerEntityManagerFactoryBean;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

    @Bean
    DataSource getDataSource() {
        final JndiDataSourceLookup dsLookup = new JndiDataSourceLookup();
        dsLookup.setResourceRef(true);
        DataSource dataSource = dsLookup.getDataSource("jdbc/postgres");

        return dataSource;
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
