package com.ivoronline.springboot_db_transaction_proxy_invocationhandler.serviceproxy;

import com.ivoronline.springboot_db_transaction_proxy_invocationhandler.service.IMyService;
import com.ivoronline.springboot_db_transaction_proxy_invocationhandler.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import java.lang.reflect.Proxy;

@Configuration
public class MyServiceProxy {

  //PROPERTIES
  @Autowired private MyService myService;
  
  //=========================================================================================================
  // GET MY SERVICE PROXY
  //=========================================================================================================
  @Bean
  @DependsOn({"connection"})
  public IMyService getMServiceProxy() {
    System.out.println("MyServiceProxy");
    MyServiceInvocationHandler myServiceInvocationHandler = new MyServiceInvocationHandler(myService);
    IMyService                 myServiceProxy             = (IMyService) Proxy.newProxyInstance(
      MyService.class.getClassLoader()
      , new Class[] { IMyService.class } //person.getClass().getInterfaces()
      , myServiceInvocationHandler
    );
    return myServiceProxy;
  }
  
}
