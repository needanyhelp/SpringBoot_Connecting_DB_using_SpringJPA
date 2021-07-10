# SpringBoot Connecting Multiple Schemas with Configurations


___
___


# Important
## You should specify com.example.demo.employee.repository name(package where repository belongs to) and make package(folder) 
## and move only repository(jpa) class file to the package, not any other file ,or you will get errors
```{.java}
@Configuration
@PropertySource({"application.properties"})
@EnableJpaRepositories(
        basePackages = "com.example.demo.employee.repository",
        entityManagerFactoryRef = "employeeEntityManager",
        transactionManagerRef = "employeeTransactionManager"
```    

# Important
## You should specify com.example.demo.employee.entity name(package where entity class belongs to) and make package(folder)
## and move only entity class file to the package, not any other file, or you will get errors

```{.java}
public class PersistenceEmployeeConfiguration {
    @Autowired
    private Environment env;

    @Bean(name="employeeEntityManager")
    @Primary
    public LocalContainerEntityManagerFactoryBean employeeEntityManager() {
        LocalContainerEntityManagerFactoryBean em
                = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(employeeDataSource());
        em.setPackagesToScan(
                new String[] {"com.example.demo.employee.entity"});
```
