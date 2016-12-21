package com.saurabh.fileProcessor;

import java.io.File;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MenuFileFinder{

  private boolean isFileAvailable;

  @Value("${menu.file.path.in}")
  private String menuFile;

 /* @Value("${menu.file.path.archive}")
  private String outDirectory;*/

  private File file;

  public boolean validateFilePath() throws MenuException {
    try {
      file = new File(menuFile);
      if (file.isFile()) {
        isFileAvailable = true;
      } else {
        throw new MenuException("00.01", "Give input path is not a directory");
      }
    } catch (Exception exception) {
      throw new MenuException(exception.getMessage());
    }
    return isFileAvailable;
  }

  public boolean getFileAvailable() {
    return isFileAvailable;
  }

  public File getMenuFile() {
    return this.file;
  }
}
