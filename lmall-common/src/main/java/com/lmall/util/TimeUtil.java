package com.lmall.util;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by reckywangbowen_i on 2019/03/06
 */
public class TimeUtil {
    public static Timestamp getCurrentTime(){
        Date date = new Date();
        return new Timestamp(date.getTime());
    }
}
