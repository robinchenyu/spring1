# Study Spring with demos

### v1.00

Spring demo, basic
1. install jar with maven
2. POJO classes
   CompactDisc.java for base interface
   SgtPeppers.java for impl, add @Component to be a bean
3. config part
   CDPlayerConfig.java, using @ComponentScan to auto create bean objs
4. calling or test
   CDPlayerTest.java, using @ContextConfiguration(classes = CDPlayerConfig.class) to invoke the config.
   @Autowired and auto inject object

   invoke the config with ContextConfiguration
```java
   @ContextConfiguration(locations = {"applicationContext.xml"})
   @ContextConfiguration(classes = CDPlayerConfig.class)
```

### v1.01

add xml configuration instead of javaconfig
add CDPlayer.java to invoke xml config and calling beans

### v1.02

using component-scan in xml config

### v1.03

add property for SgtPeppers, and set the value in xml config files

### v1.04

using singleton to initialize ApplicationContext object. Add @Bean to initial POJO instead of component scan.
1. add ApplicatonContextUtil.java to com.singleton.utils package
2. using @Bean to initialize bean in CDPlayerConfig.java

### v1.05

using constructor-arg(c schema) tag in xml to inject data to bean
using property (p schema) tag in xml to inject data to bean
1. constructor-arg depending on Constructor method, it would call Constructor Method to set value
2. property depending on setter method, it would call setter method to set value



