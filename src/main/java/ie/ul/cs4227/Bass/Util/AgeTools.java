package ie.ul.cs4227.Bass.Util;

import java.util.Calendar;
import java.util.Date;

public class AgeTools implements Tools{

	@Override
	public int getAge(Date birthDay) throws Exception {
	        Calendar cal = Calendar.getInstance(); 
	        if (cal.before(birthDay)) { //�����������ڵ�ǰʱ�䣬�޷�����
	            throw new IllegalArgumentException(
	                    "The birthDay is before Now.It's unbelievable!");
	        }
	        int yearNow = cal.get(Calendar.YEAR);  //��ǰ���
	        int monthNow = cal.get(Calendar.MONTH);  //��ǰ�·�
	        int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH); //��ǰ����
	        cal.setTime(birthDay); 
	        int yearBirth = cal.get(Calendar.YEAR);
	        int monthBirth = cal.get(Calendar.MONTH);
	        int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);  
	        int age = yearNow - yearBirth;   //����������
	            if (monthNow <= monthBirth) {
	            if (monthNow == monthBirth) {
	                if (dayOfMonthNow < dayOfMonthBirth) age--;//��ǰ����������֮ǰ�������һ
	            }else{
	                age--;//��ǰ�·�������֮ǰ�������һ
	       } } 
	            return age; 
	}  

}
