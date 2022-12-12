package practice;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class CalculateDaysBetween {
  public static void main(String[] args) throws Exception {
    String[] arr = {"2016-08-12",
            "2018-07-09",
            "2019-01-03",
            "2020-01-07",
            "2022-01-04" };

    String[] dep = {"2018-06-23",
            "2018-11-29",
            "2019-12-05",
            "2021-11-25",
            "2022-05-27"};

    for(int i=0; i<arr.length; i++) {
      //System.out.println("Arr---------");
      Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(arr[i]);
      //Date dd = new SimpleDateFormat("dd-MMM-yyyy").parse(arr[i]);
      System.out.print(arr[i] + "\t");

      //System.out.println("Dep---------");
      Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse(dep[i]);

      long dateBeforeInMs = date1.getTime();
      long dateAfterInMs = date2.getTime();
      long timeDiff = Math.abs(dateAfterInMs - dateBeforeInMs);
      long daysDiff = TimeUnit.DAYS.convert(timeDiff, TimeUnit.MILLISECONDS);
      System.out.println(daysDiff);
    }

  }
}
