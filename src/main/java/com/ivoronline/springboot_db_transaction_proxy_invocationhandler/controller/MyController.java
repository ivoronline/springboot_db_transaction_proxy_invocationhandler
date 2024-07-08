package com.ivoronline.springboot_db_transaction_proxy_invocationhandler.controller;

import com.ivoronline.springboot_db_transaction_proxy_invocationhandler.service.IMyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

  //PROPERTIES
  @Autowired private IMyService myService;

  //=========================================================================================================
  // INSERT
  //=========================================================================================================
  @ResponseBody
  @GetMapping("/insert")
  public String insert() throws Exception {
    myService.insert(); //Call Proxy Method
    return "Records Inserted";
  }
  

}
