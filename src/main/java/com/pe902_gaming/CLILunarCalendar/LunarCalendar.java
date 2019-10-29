package com.pe902_gaming.CLILunarCalendar;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

public class LunarCalendar
{
  private double CalendarYearInDays;
  private Integer YearZero;
  private Integer DayZero;

  private String Object1Name;
  private double Object1PeriodInDays;
  private String Object2Name;
  private double Object2PeriodInDays;
  private String Object3Name;
  private double Object3PeriodInDays;

  private Integer DateObservationYear;
  private Integer DateObservationDayOfYear;

  public final String ORBIT_IS_EMPTY = "(empty orbit)";
  public final String[] MOON_PHASES = { "new moon", "1/8 waxing", "1/4 waxing", "3/8 waxing", "1/2 waxing", "5/8 waxing", "3/4 waxing", "7/8 waxing", "full moon", "7/8 waning", "3/4 waning", "5/8 waning", "1/2 waning", "3/8 waning", "1/4 waning", "1/8 waning" };

  // constructor
  public LunarCalendar ()
  {
    CalendarYearInDays = 0.0;
    YearZero = 0;
    DayZero = 0;

    Object1Name = "(empty orbit)";
    Object1PeriodInDays = 0.0;
    Object2Name = "(empty orbit)";
    Object2PeriodInDays = 0.0;
    Object3Name = "(empty orbit)";
    Object3PeriodInDays = 0.0;

    DateObservationYear = 0;
    DateObservationDayOfYear = 0;
  }

  // get / set methods
  public double getCalendarYearInDays()
  {
    return CalendarYearInDays;
  }

  public void setCalendarYearInDays(double calendarYearInDays)
  {
    CalendarYearInDays = calendarYearInDays;
  }

  public void setYearZero(Integer yearZero) {
    YearZero = yearZero;
  }

  public Integer getYearZero() {
    return YearZero;
  }

  public void setDayZero(Integer dayZero) {
    DayZero = dayZero;
  }

  public Integer getDayZero()
  {
    return DayZero;
  }

  public String getObject1Name()
  {
    return Object1Name;
  }

  public void setObject1Name(String object1Name)
  {
    Object1Name = object1Name;
  }

  public double getObject1PeriodInDays()
  {
    return Object1PeriodInDays;
  }

  public void setObject1PeriodInDays(double object1PeriodInDays)
  {
    Object1PeriodInDays = object1PeriodInDays;
  }

  public String getObject2Name()
  {
    return Object2Name;
  }

  public void setObject2Name(String object2Name)
  {
    Object2Name = object2Name;
  }

  public double getObject2PeriodInDays()
  {
    return Object2PeriodInDays;
  }

  public void setObject2PeriodInDays(double object2PeriodInDays)
  {
    Object2PeriodInDays = object2PeriodInDays;
  }

  public String getObject3Name()
  {
    return Object3Name;
  }

  public void setObject3Name(String object3Name)
  {
    Object3Name = object3Name;
  }

  public double getObject3PeriodInDays()
  {
    return Object3PeriodInDays;
  }

  public void setObject3PeriodInDays(double object3PeriodInDays)
  {
    Object3PeriodInDays = object3PeriodInDays;
  }

  public Integer getDateObservationYear()
  {
    return DateObservationYear;
  }

  public void setDateObservationYear(Integer dateObservationYear)
  {
    DateObservationYear = dateObservationYear;
  }

  public Integer getDateObservationDayOfYear()
  {
    return DateObservationDayOfYear;
  }

  public void setDateObservationDayOfYear(int dateObservationDayOfYear) 
  {
    // we might get 'bad math' from on-high.
    // check that the ODOY is equal or lower than the value of CalendarYearInDays
    // if it _isn't_ then do some math and advance the dateObservationYear as well

    if (dateObservationDayOfYear <= CalendarYearInDays) 
    {
      DateObservationDayOfYear = dateObservationDayOfYear;
    }
    else
    {
      int YearDelta =  (int)(dateObservationDayOfYear / CalendarYearInDays);
      DateObservationDayOfYear = (int)(dateObservationDayOfYear % CalendarYearInDays);
      if (DateObservationDayOfYear == 0 ) 
      {
        DateObservationDayOfYear = 1;  
      }
      DateObservationYear = DateObservationYear + YearDelta;
    }
  }

  // override
  @Override
  public String toString()
  {
    final String CalendarGeometryFormatString = "Calendar Geometry: Year Length: {0} days | Recorded date of all-new-moons: Y{1}-D{2} .";
    String line1 = MessageFormat.format(CalendarGeometryFormatString, CalendarYearInDays, YearZero, DayZero);

    final String PanelOrbitalDataFormatString = "Orbital Data: {0}:{1} days, {2}:{3} days, {4}:{5} days ";
    String line2 = MessageFormat.format(PanelOrbitalDataFormatString, getObject1Name(), getObject1PeriodInDays(), getObject2Name(), getObject2PeriodInDays(), getObject3Name(), getObject3PeriodInDays());

    final String ObservationDataFormatString = "Observation Date:  Y{0}-D{1}";
    String line3 = MessageFormat.format(ObservationDataFormatString, getDateObservationYear(), getDateObservationDayOfYear());

    return line1 + "\n" + line2 + "\n" + line3;
  }

  // validations
  public List<String> ValidateInputs (String PageID)
  {
    List<String> ValidationErrorsDetails = new ArrayList<String>();

    switch (PageID)
    {
      case "PanelCalendarGeometry":
        if (CalendarYearInDays < 1)
          ValidationErrorsDetails.add("CalendarYearInDays must be at least 1");
        if (YearZero < 0)
          ValidationErrorsDetails.add("YearZero must be at least 0");
        if (DayZero < 1)
          ValidationErrorsDetails.add("DayZero must be at least 1");
        if (CalendarYearInDays < DayZero)
          ValidationErrorsDetails.add("DayZero must be smaller than CalendarYearInDays");
        break;

      case "PanelOrbitalData":
        if (Object1Name.isEmpty() && Object1PeriodInDays > 0.0)
          ValidationErrorsDetails.add("Please provide a name for Object1Name");
        if (!Object1Name.isEmpty() && Object1PeriodInDays == 0.0)
          ValidationErrorsDetails.add("Please provide a time in days for Object1PeriodInDays");
        if (Object2Name.isEmpty() && Object2PeriodInDays > 0.0)
          ValidationErrorsDetails.add("Please provide a name for Object2Name");
        if (!Object2Name.isEmpty() && Object2PeriodInDays == 0.0)
          ValidationErrorsDetails.add("Please provide a time in days for Object2PeriodInDays");
        if (Object3Name.isEmpty() && Object3PeriodInDays > 0.0)
          ValidationErrorsDetails.add("Please provide a name for Object3Name");
        if (!Object3Name.isEmpty() && Object3PeriodInDays == 0.0)
          ValidationErrorsDetails.add("Please provide a time in days for Object3PeriodInDays");
        break;

    } // end switch
    return ValidationErrorsDetails;
  } // end ValidateInputs

  // other methods
  public String AstroCalc(int... IncomingOffset )
  {
    int ObservationDayOfYearOffset = 0;
    if ( IncomingOffset.length > 0 ) 
    {
      ObservationDayOfYearOffset = IncomingOffset[0] ;
    }

    // calculate number of days
    int ElapsedYears = getDateObservationYear() - getYearZero();
    double ElapsedDays = (ElapsedYears * getCalendarYearInDays()) + (getDateObservationDayOfYear() - getDayZero()) - ObservationDayOfYearOffset;

    //System.out.println("\n >>ElapsedYears:"+ElapsedYears);
    //System.out.println(" >>ElapsedDays:"+ElapsedDays);

    // do mathifications
    String Moon1CurrentPhase = ORBIT_IS_EMPTY;
    if (getObject1Name() != ORBIT_IS_EMPTY) 
    {
      Moon1CurrentPhase = getMoonPhase(ElapsedDays, getObject1PeriodInDays());
    }
    String Moon2CurrentPhase = ORBIT_IS_EMPTY;
    if (getObject2Name() != ORBIT_IS_EMPTY) 
    {
      Moon2CurrentPhase = getMoonPhase(ElapsedDays, getObject2PeriodInDays());
    }
    String Moon3CurrentPhase = ORBIT_IS_EMPTY;
    if (getObject3Name() != ORBIT_IS_EMPTY) 
    {
      Moon3CurrentPhase = getMoonPhase(ElapsedDays, getObject3PeriodInDays());
    }

    // make sentences
    final String MoonSentenceFormatString = " * {0} is currently {1} in the sky \n";
    String Sentence1 = MessageFormat.format(MoonSentenceFormatString, getObject1Name(), Moon1CurrentPhase);
    String Sentence2 = MessageFormat.format(MoonSentenceFormatString, getObject2Name(), Moon2CurrentPhase);
    String Sentence3 = MessageFormat.format(MoonSentenceFormatString, getObject3Name(), Moon3CurrentPhase);

    // make paragraph
    String OutputParagraph = Sentence1 + Sentence2 + Sentence3;

    // return paragraph
    return OutputParagraph;
  } // end String AstroCalc

  private String getMoonPhase(Double ElapsedDays, Double OrbitalPeriod)
  {
    final int NUMBER_OF_MOON_PHASES = MOON_PHASES.length;
    double Position = ElapsedDays % OrbitalPeriod;
    int CurrentMoonPhaseIndex = (int)((Position / OrbitalPeriod) * NUMBER_OF_MOON_PHASES);

    return MOON_PHASES[CurrentMoonPhaseIndex];
  } // end getMoonPhase

} // class LunarCalendar

// ----- end of file -----
