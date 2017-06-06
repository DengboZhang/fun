package cn.swu.fun.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


/**
 * 用于取出当天0点比较时间
 * 
 * @author zdb
 *
 */
public class DateUtil {
	 
	//将date日期转化为字符串 yy-mm-dd格式
	public static String dateToString(Date date){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        String time=sdf.format(date);
		return time;
	}
}
