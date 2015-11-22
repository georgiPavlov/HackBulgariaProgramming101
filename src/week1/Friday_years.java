package week1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by georgipavlov on 23.11.15.
 */
public class Friday_years {



    private int index=0;
    public int friday_years(String start, String end){
        int w;
        index=hasStartOneMoreFriday("0",start);
        w = hasStartOneMoreFriday(start,end);
        return w;
    }



    public int  hasStartOneMoreFriday(String start,String end){
        if((!march2(start)) || (!march2(end))){
            System.out.println("invalid input years must be positive and from 0 to 100000");
            return 0;
        }
        String[] days= {
                "SUNDAY", "MONDAY", "TUESDAY", "WEDNESDAY",
                "THURSDAY", "FRIDAY", "SATURDAY"
        };
        int startYear = Integer.parseInt(start);
        int endYear =Integer.parseInt(end);
        int count=8;
        int c=index;
        boolean isLeap=false;
        StringBuilder b = new StringBuilder();
        int weaks=0;
        for (int year = startYear; year <= endYear; year++) {
            if(((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)){
                count = 9;
                isLeap=true;
            }
            for (int j = 0; j < count; j++) {
                if(c > days.length){
                    c=0;
                }
                if(b.length() > 0){
                    b.setLength(0);
                }
                b.append(days[c]);
                c++;
            }
            if(isLeap || b.equals("FRIDAY")){
                weaks +=53;
                isLeap=false;
            }else {
                weaks +=52;
            }
            count=8;
        }
        return  index == 0 ? c : weaks;

    }

    public boolean march2(String number){
        final String USERNAME_PATTERN = "^[0-9]{0,1000000}$";
        pattern2 = Pattern.compile(USERNAME_PATTERN);
        matcher2 = pattern2.matcher(number);

        return matcher2.matches();

    }
    private Pattern pattern2;
    private Matcher matcher2;
}
