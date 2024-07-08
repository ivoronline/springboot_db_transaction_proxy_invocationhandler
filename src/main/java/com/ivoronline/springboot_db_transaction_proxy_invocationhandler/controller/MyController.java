package com.ivoronline.springboot_db_transaction_proxy_invocationhandler.controller;

import com.ivoronline.springboot_db_transaction_proxy_invocationhandler.service.IMyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

  //PROPERTIES
  @Autowired @Qualifier("myServiceProxy") private IMyService myServiceProxy;

  //=========================================================================================================
  // INSERT
  //=========================================================================================================
  @ResponseBody
  @GetMapping("/insert")
  public String insert() throws Exception {
    myServiceProxy.insert();
    return "Records Inserted";
  }
  
}
