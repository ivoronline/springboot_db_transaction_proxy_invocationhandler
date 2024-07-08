package com.ivoronline.springboot_db_transaction_proxy_invocationhandler.proxy;

import com.ivoronline.springboot_db_transaction_proxy_invocationhandler.service.IMyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;

@Component
public class MyServiceInvocationHandler implements InvocationHandler {

  //PROPERTIES
             private IMyService myService;
  @Autowired private Connection connection;
  
  //=========================================================================================================
  // CONSTRUCTOR
  //=========================================================================================================
  public MyServiceInvocationHandler(IMyService myService) {
    this.myService = myService;
  }

  //=========================================================================================================
  // INVOKE
  //=========================================================================================================
  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
  
    if(!method.getName().equals("insert")) { return method.invoke(myService, args); }

    try {
    
      //START TRANSACTION
      System.out.println("Before Method " + method.getName());
      connection.setAutoCommit(false);
      
      //CALL SERVICE
      method.invoke(myService, args);
      
      //COMMIT TRANSACTION
      System.out.println("After Method " + method.getName());
      connection.commit();
      
    }
    catch (Exception e) {
      //ROLLBACK TRANSACTION
      connection.rollback();
    }
    finally {
      connection.close();
    }

    return 1;

  }

}
