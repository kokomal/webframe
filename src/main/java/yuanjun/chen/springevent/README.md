@SpecialThanksTo: 木易森林senlinyang  
Spring加载事件监听，总共有如下类型的事件：  
ApplicationStartingEvent  
ApplicationFailedEvent  
ApplicationPreparedEvent  
ApplicationReadyEvent  
ApplicationEnvironmentPreparedEvent  
ApplicationStartedEvent  
实现监听步骤  
１．监听类实现ApplicationListener接口  
２．将监听类添加到SpringApplication实例中  
也可以放到META-INF的spring.factories文件里面，类似：  
org.springframework.context.ApplicationListener=xx.xx.ApplicationEnvironmentPreparedEventListener,\
  xx.xx.ApplicationFailedEventListener,\
  xx.xx.ApplicationPreparedEventListener,\
  xx.xx.ApplicationReadyEventListener,\
  xx.xx.ApplicationStartedEventListener,\
  xx.xx.ApplicationStartingEventListener 