package com.ademkose.casesolving.util;


import com.ademkose.casesolving.model.Presentation;
import java.util.List;

public class Utils {

  public static final int MAX_MINUTE = 240;
  public static final int BEFORE_LUNCH_MINUTE = 180;
  public static final int LUNCH_MINUTE = 60;
  public static final int MINUMUM_PRESENTATION_MINUTE = 5;
  public static final int MINUMUM_PRESENTATION_NAME_LENTGH = 5;
  public static final int START_TIME_AS_MINUTE = 540; // 540/60 = 09:00AM


  public static final String LUNCH_TIME = "12:00PM";
  public static final String LUNCH_NAME = "******   LUNCH   ******";
  public static final String EOD_NAME = "---------- END OF THE DAY ----------";
  public static final String NETWORKING_NAME = "****** Networking";

  public static String minuteToTimeAMPM(int minute, String pmOrAm) {
    String timePress;
    int hours = (minute / 60);
    int min = (minute % 60);
    if (hours < 10) {
      timePress = "0" + hours;
    } else {
      timePress = Integer.toString(hours);
    }

    timePress = timePress + ":";

    if (min < 10) {
      timePress = timePress + "0" + min;
    } else {
      timePress = timePress + min;

    }

    return timePress + pmOrAm;

  }

  public static List<Presentation> setTime(List<Presentation> tracksDisplayList) {
    int startDayTime = Utils.START_TIME_AS_MINUTE;
    String pmOrAM = "AM";
    for (int i = 0; i < tracksDisplayList.size(); i++) {
      Presentation tempPres = tracksDisplayList.get(i);
      if (tempPres.getId() == 0) {
        pmOrAM = pmOrAM.equals("PM") ? "AM" : "PM";

      } else if (tempPres.getId() == -1) //reset the day. set 09:00AM
      {
        startDayTime = Utils.START_TIME_AS_MINUTE;
        continue;
      }
      if (tempPres.getTime() == null) {
				tempPres.setTime(Utils.minuteToTimeAMPM(startDayTime, pmOrAM));
      }
      tracksDisplayList.set(i, tempPres);
      startDayTime = startDayTime + tempPres.getMinute();
      if (tempPres.getId() == 0) {
        startDayTime = startDayTime - (12 * 60);
      }
    }

    return tracksDisplayList;
  }


}