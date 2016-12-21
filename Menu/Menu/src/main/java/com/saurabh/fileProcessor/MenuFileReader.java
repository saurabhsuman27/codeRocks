package com.saurabh.fileProcessor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MenuFileReader {

  @Autowired
  private MenuFileFinder fileListner;

  public boolean checkFileAvailablility() {
    boolean status = false;
    try {
      status = fileListner.validateFilePath();
    } catch (Exception exception) {
      System.out.println(exception.getMessage());
    }
    return status;
  }

  public int getMaxSatisfaction() {
    File file = null;
    int maxSatisfaction = 0;
    int totalTime = 0;
    int totalItemInMenu = 0;
    int timeToTaste = 0;
    int satisfaction = 0;
    int sumOfTime = 0;
    FileInputStream inputStream = null;
    BufferedReader bufferReader = null;
    String recordsSplit[] = null;
    String records = null;
    try {
      file = fileListner.getMenuFile();
      inputStream = new FileInputStream(file);
      bufferReader = new BufferedReader(new InputStreamReader(inputStream));

      records = bufferReader.readLine();
      recordsSplit = records.split(" ");
      totalTime = Integer.parseInt(recordsSplit[0]);
      totalItemInMenu = Integer.parseInt(recordsSplit[1]);
      for (int i = 0; i < totalItemInMenu; i++) {
        records = bufferReader.readLine();
        recordsSplit = records.split(" ");
        satisfaction = Integer.parseInt(recordsSplit[0]);
        timeToTaste = Integer.parseInt(recordsSplit[1]);
        sumOfTime = sumOfTime + timeToTaste;
        if (maxSatisfaction < satisfaction) {
          maxSatisfaction = satisfaction;
        }
        if (sumOfTime > totalTime) {
          break;
        }
      }

    } catch (Exception exception) {

    } finally {
      try {
        bufferReader.close();
      } catch (IOException exception2) {

      }
    }
    return maxSatisfaction;
  }
}
