package com.pe902_gaming.CLILunarCalendar;

import java.io.FileInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadCalendarProperties
{
  // properties
  private String PropertiesFileName = "";
  public  Properties CalProp = new Properties();
  private Boolean FileDidLoadOK = false;

    // constructor
  public ReadCalendarProperties()
  {
    // PropertiesFileName = propertiesFileName;
    // System.out.println("Will load calendar configuration from [" + PropertiesFileName + "]" );
  } // end method ReadCalendarProperties

  // other methods 
  public void setPropertiesFileName (String newFileName)
  {
    if (!newFileName.isEmpty()) 
    {
      PropertiesFileName = newFileName;
    }
  } // end setPropertiesFileName

  public String getPropertiesFileName ()
  {
    return PropertiesFileName;
  } // end getPropertiesFileName

  public boolean getFileDidLoadOK ()
  {
    return FileDidLoadOK;
  }

  public Boolean FileExists()
  {
    return new File(PropertiesFileName).isFile();
  } // end FileExists

  public void LoadFromFile()
  {
    try (FileInputStream filePointer = new FileInputStream(PropertiesFileName))
    {
      CalProp.load(filePointer);
      filePointer.close();
      FileDidLoadOK = true;
    }
    catch (IOException ex) 
    {
      ex.printStackTrace();
    }
  } // end LoadFromFile

} //end class ReadCalendarProperties