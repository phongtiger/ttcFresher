package ttcfresher;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.Calendar;
import java.util.Date;

public class Part3 {

    public static void main(String[] args) throws ParseException {
        //Cau1
        System.out.println("Cau 1");
        String s = "2012-12-06 14:20:01";
        System.out.println("Input: " + s);
        try {
            Date resultC1 = changeC1(s);
            System.out.println("Output: "+ resultC1);
        } catch (Exception e){
            System.out.println("C1 fail!!");
        }

        //Cau2
        System.out.println(" ");
        System.out.println("Cau 2");
        System.out.println("Input: " + s);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date date = sdf.parse(s);
        Calendar calendar = dateToCalendar(date);
        calendar.set(Calendar.DAY_OF_MONTH,1);
        System.out.println(" ");
        System.out.println("Ngay dau thang " + calendar.getTime());
        calendar.set(Calendar.DAY_OF_MONTH,calendar.getActualMaximum(Calendar.DATE));
        System.out.println("Ngay cuoi thang: " + calendar.getTime());
        System.out.println(" ");
        Date monday = getMonday(date);
        calendar.set(Calendar.DAY_OF_WEEK, calendar.getFirstDayOfWeek());
        calendar.roll(Calendar.DATE,1);
        System.out.println("Ngay dau tuan: "+ calendar.getTime());
        calendar.set(Calendar.DATE, 100);
        System.out.println("100 ngay sau: " + calendar.getTime());


        //Cau3
        String a = "2012-03-1";
        String b = "2012-07-6";
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = sdf2.parse(a);
        Date date2 = sdf2.parse(b);
        System.out.println(" ");
        System.out.println("Cau 3");
        System.out.println("Day a: "+ a);
        System.out.println("Day b: "+ b);
        System.out.println("Output: ");
        if(date1.compareTo(date2) == 0){
            System.out.println("Hai ngay trung nhau");
        }else if (date1.compareTo(date2) > 0){
            System.out.println("a sau b");
        } else if(date1.compareTo(date2) < 0){
            System.out.println("a truoc b");
        }

        //Cau4
        System.out.println(" ");
        System.out.println("Cau 4");
        System.out.println("Input: ");

        String dateStart = "2012-03-1";
        String dateStop = "2012-07-14";
        System.out.println("DateStart: "+ dateStart);
        System.out.println("DateStop: "+ dateStop);

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date d1 = null;
        Date d2 = null;
        try {
            d1 = format.parse(dateStart);
            d2 = format.parse(dateStop);

        } catch (ParseException e) {
            System.out.println("error format");
        }
        assert d1 != null;
        assert d2 != null;
        Instant instant1 = Instant.ofEpochMilli(d1.getTime());
        LocalDate localDate1 = LocalDateTime.ofInstant(instant1, ZoneId.systemDefault()).toLocalDate();
        Instant instant2 = Instant.ofEpochMilli(d2.getTime());
        LocalDate localDate2 = LocalDateTime.ofInstant(instant2, ZoneId.systemDefault()).toLocalDate();
        Period different = Period.between(localDate1,localDate2);

        System.out.println("Khoảng cách giữa 2 ngày nhập là: "
                + different.getDays()
                + " ngày , "
                + different.getMonths()
                +" tháng và "
                + different.getYears()
                + " năm");

        //Cau5
        String s3 = "2016/03/15 11:06:20";
        System.out.println(" ");
        System.out.println("Cau 5");
        System.out.println("Input: "+ s3);
        DateFormat dateFormat2 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date3 = dateFormat2.parse(s3);
        Timestamp timestamp = new Timestamp(date3.getTime());
        System.out.println("Date sang Timestamp");
        System.out.println(timestamp);
        System.out.println("Nguoc lai sang date");
        Date last = new Date(timestamp.getTime());
        System.out.println(last);

        //Cau6
        System.out.println(" ");
        DateFormat dateFormat6 = new SimpleDateFormat("yyyy/MM/dd HH:mm");
        try {
            Date date4 = dateFormat6.parse(s3);
            System.out.println("Cau 6");
            System.out.println("Input: "+ s3);
            Timestamp timestamp1 = new Timestamp(date4.getTime());
            System.out.println("Output: ");
            System.out.println(timestamp1);
        } catch (Exception e){
            System.out.println("error");
        }
        //Cau7
        System.out.println(" ");
        System.out.println("Cau 7");
        System.out.println("Input: "+ s3);
        SimpleDateFormat dateFormat7a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat dateFormat7b = new SimpleDateFormat("MMM yyyy,dd HH:mm:ss");
        String strDate1 = dateFormat7a.format(date3);
        System.out.println("Output1: "+ strDate1);
        String strDate2 = dateFormat7b.format(date3);
        System.out.println("Output2: "+ strDate2);
    }

    private static Calendar dateToCalendar(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }

    public static Date changeC1(String date) throws ParseException {
        String shortDate = date.substring(0,10);
        String newShortDate = shortDate.replace("-","/");
        return new SimpleDateFormat("yyyy/MM/dd").parse(newShortDate);
    }

    public static Date getMonday(Date date){
        Date date1 = new Date();
        for(int i = date.getDate(); i>0;i--){
            date1.setDate(i);
            date1.setMonth(date.getMonth());
            date1.setYear(date.getYear());;
            if(date1.getDay() ==1){
                 break;
            }
        }
        return date1;
    }
}
