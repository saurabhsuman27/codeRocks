package com.saurabh;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.saurabh.fileProcessor.MenuException;
import com.saurabh.fileProcessor.MenuFileFinder;
import com.saurabh.fileProcessor.MenuFileReader;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MenuApplicationTests {

  @Autowired
  private MenuFileReader menuFileReader;
  
  @Autowired
  private MenuFileFinder menuFileListner;
  
  @Test
  public void contextLoads() {

  }
  
  @Test
  public void testValidateFilePath() throws MenuException {
    assertTrue(menuFileListner.validateFilePath());
  }
  
  @Test
  public void testCheckFileAvailablility(){
    assertTrue(menuFileReader.checkFileAvailablility());
  }
  
  @Test
  public void testGetMaxSatisfaction() throws MenuException{
    menuFileListner.validateFilePath();
    assertEquals(99098,menuFileReader.getMaxSatisfaction());
  }

}
