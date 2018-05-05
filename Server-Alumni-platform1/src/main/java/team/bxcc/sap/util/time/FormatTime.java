package team.bxcc.sap.util.time;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatTime {
    public static String formatDate(Date date){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:MM:ss");
        return sdf.format(date);
    }


}
