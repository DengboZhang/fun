package cn.swu.fun.util;
import java.util.Random;//导入Random包
import java.util.UUID;

/**
 * 
 * 生成激活码
 * @author 张登博
 *
 */
public class UUIDUtils {
   
	public static int getUUID(){
		
		int x;//定义两变量
        Random ne=new Random();//实例化一个random的对象
        x=ne.nextInt(9999-1000+1)+1000;//为变量赋随机值1000-9999
        System.out.println("本次服务产生的验证码是:"+x);//输出
        return x;
        
	}
}
