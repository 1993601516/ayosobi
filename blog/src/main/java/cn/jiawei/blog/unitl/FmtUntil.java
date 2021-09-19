package cn.jiawei.blog.unitl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FmtUntil {
    public Date dateFmt(Date date){
        Date date1 = null;
        String str_date = date.toString();
        str_date=str_date.replace("T", "");
        SimpleDateFormat sdf  = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            date1= sdf.parse(str_date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date1;
    }
}
