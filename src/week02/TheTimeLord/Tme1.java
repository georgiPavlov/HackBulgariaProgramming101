package week02.TheTimeLord;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by georgipavlov on 25.11.15.
 */
public class Tme1 {


        private Date date;

        public Tme1(Date date){
            this.date=date;
        }


        @Override
        public String toString() {
            String newDate = new SimpleDateFormat("hh:mm:ss dd.MM.YY").format(date);

            return   newDate;
        }

}
