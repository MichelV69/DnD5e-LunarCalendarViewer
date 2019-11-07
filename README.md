#Lunar Calendar Viewer
***For Fantasy Worlds Settings such as Dungeons & Dragons***

## Purpose
Most fantasy settings have different skies and calendars that the the one 
visible from Earth.

This application allows you to "see" the sky on an arbitrary "night" on your 
world, based on the orbital periods of up to three lunar-orbital bodies.

## Sample Output

```Text
Calendar Geometry: Year Length: 400 days | Recorded date of all-new-moons: Y52-D1 .
Orbital Data: Tiana:24 days, Star Belt:28 days, Anait:32 days
Observation Date:  Y52-D77
 * Tiana is currently 1/4 waxing in the sky
 * Star Belt is currently 5/8 waning in the sky
 * Anait is currently 3/4 waxing in the sky

Press 'Q' to Quit

      'R' to Reverse the ObservationDayOfYear to 76
      'A' to Advance the ObservationDayOfYear to 78
          ... or any other key to pick another Observation Year/Day
```

## How To Use
* Download JAR file, or source and compile your own
* Execute `java -jar my-CLILunarCalendar-1.1.1.jar`
* Fill in prompts describing the "**Calendar Geometry**" of your fantasy 
  world's sky
  * `YearZero` and `DayZero` are the reference date at which it is "known" 
  that all moons / orbital objects were observed to be in the "new" phase.
* Fill in prompts describing the "***Orbital Periods***" of the lunar objects of 
  your fantasy world's sky.
  * If you only have 1 or 2 lunar orbit objects, leave the name of the 
  "empty orbit" blank and just press `[ENTER]`
* Fill in the prompts for the "***Date of Observation***".  That is, the 
absolute calendar date when your character(s) are looking at the night sky.

## Saving Settings / Permanent Calendars
If you are commonly entering the same "**Calendar Geometry**" each use, you 
can skip that work by creating a file containing the required information.

See the included `example_calendar.properties` as a guide.  To create your own,
I recommend you just copy and modify the included `example_calendar.properties`.
You then access the stored "**Calendar Geometry**" by including the file name 
as part of the command to launch the application.  For example:

`java -jar my-CLILunarCalendar-1.1.1.jar \some\path\example_calendar.properties`
