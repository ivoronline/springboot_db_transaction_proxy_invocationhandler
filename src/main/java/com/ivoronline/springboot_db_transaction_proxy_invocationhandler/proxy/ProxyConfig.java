package com.ivoronline.springboot_db_transaction_proxy_invocationhandler.proxy;

import com.ivoronline.springboot_db_transaction_proxy_invocationhandler.service.IMyService;
import com.ivoronline.springboot_db_transaction_proxy_invocationhandler.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.lang.reflect.Proxy;

@Configuration
public class ProxyConfig {

  //PROPERTIES
  @Autowired private MyServiceInvocationHandler myServiceInvocationHandler;
  
  //=========================================================================================================
  // GET MY SERVICE PROXY
  //=========================================================================================================
  @Bean("myServiceProxy")
  public IMyService myServiceProxy() {
    
    IMyService myServiceProxy = (IMyService) Proxy.newProxyInstance(
        MyService.class.getClassLoader()
      , new Class[] { IMyService.class }
      , myServiceInvocationHandler
    );
    
    return myServiceProxy;
    
  }

}
