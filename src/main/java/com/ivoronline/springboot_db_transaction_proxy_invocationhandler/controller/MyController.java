package com.ivoronline.springboot_db_transaction_proxy_invocationhandler.controller;

import com.ivoronline.springboot_db_transaction_proxy_invocationhandler.service.IMyService;
import com.ivoronline.springboot_db_transaction_proxy_invocationhandler.service.MyService;
import com.ivoronline.springboot_db_transaction_proxy_invocationhandler.serviceproxy.MyServiceInvocationHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Proxy;

@RestController
public class MyController {

  //PROPERTIES
  @Autowired private MyServiceInvocationHandler myServiceInvocationHandler;

  //=========================================================================================================
  // INSERT
  //=========================================================================================================
  @ResponseBody
  @GetMapping("/insert")
  public String insert() throws Exception {
  
    IMyService myServiceProxy = (IMyService) Proxy.newProxyInstance(
      MyService.class.getClassLoader()
      , new Class[] { IMyService.class } //person.getClass().getInterfaces()
      , myServiceInvocationHandler
    );
    
    myServiceProxy.insert(); //Call Proxy Method
    return "Records Inserted";
  }
  

}
