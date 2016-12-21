package com.saurabh;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.saurabh.fileProcessor.MenuFileReader;

@SpringBootApplication
public class MenuApplication {

  @Autowired
  private MenuFileReader fileReader;

  public static void main(String[] args) {
    ConfigurableApplicationContext ctx =
        SpringApplication.run(MenuApplication.class, args);
    MenuApplication mainObj = ctx.getBean(MenuApplication.class);
    mainObj.init();
  }

  public void init() {
    boolean fileavailable = fileReader.checkFileAvailablility();
    if (fileavailable) {
      System.out.println("Maximum Satisfaction - " + fileReader.getMaxSatisfaction());
    }
  }
}
