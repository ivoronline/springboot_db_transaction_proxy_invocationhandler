package com.ivoronline.springboot_db_transaction_proxy_invocationhandler.config;

import com.ivoronline.springboot_db_transaction_proxy_invocationhandler.service.IMyService;
import com.ivoronline.springboot_db_transaction_proxy_invocationhandler.service.MyService;
import com.ivoronline.springboot_db_transaction_proxy_invocationhandler.serviceproxy.MyServiceInvocationHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.sql.DataSource;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.SQLException;

@Configuration
public class DatabaseConfig {

  //PROPERTIES
  @Autowired private DataSource dataSource;

  //=========================================================================================================
  // CONNECTION
  //=========================================================================================================
  @Bean
  public Connection connection() throws SQLException {
    System.out.println("connection");
    return dataSource.getConnection();
  }
  
}
