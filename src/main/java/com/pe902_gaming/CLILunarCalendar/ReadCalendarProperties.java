package com.pe902_gaming.CLILunarCalendar;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadCalendarProperties
{
  // properties
  private String PropertiesFileName = "";

    // constructor
  public ReadCalendarProperties(String propertiesFileName)
  {
    PropertiesFileName = propertiesFileName;
    System.out.println("Will load calendar configuration from [" + PropertiesFileName + "]" );
  } // end method ReadCalendarProperties

  // other methods 
  public void setPropertiesFileName (String newFileName)
  {
    if (!newFileName.isEmtpy()) 
    {
      PropertiesFileName = newFileName;
    }
  } // end setPropertiesFileName

  public String getPropertiesFileName ()
  {
    return PropertiesFileName;
  }

} //end class ReadCalendarProperties