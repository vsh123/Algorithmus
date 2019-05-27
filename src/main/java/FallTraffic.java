import java.util.*;
import java.text.*;

public class FallTraffic {
    public int solution(String[] lines) {
        int answer = 0;
        int max =0;
        try {
            DateFormat df = new SimpleDateFormat("HH:mm:ss.SSS");
            df.setTimeZone(TimeZone.getTimeZone("UTC"));    //TimeZone 설정을 안하니까 getTime이 음수가 나옴
            long[][] st = new long[lines.length][2];        //0 = start , 1 = end

            for (int i = 0; i < lines.length; i++) {
                String[] temp = lines[i].split(" ");      //0 = 날짜, 1 = 완료 시간, 2 = 걸리는 시간
                Date edate = df.parse(temp[1]);
                Date sdate = df.parse(temp[1]);
                temp[2] = temp[2].replace(".","");
                temp[2] = temp[2].replace("s","");
                while(true){
                    if(temp[2].length()==4)
                        break;
                    temp[2] = temp[2]+"0";
                }
                int milli = Integer.parseInt(temp[2]);
                sdate.setTime(edate.getTime() - milli+1);
                st[i][0] = sdate.getTime();
                st[i][1] = edate.getTime();
            }

            for(int i =0;i<st.length;i++){
                int temp =1;
                long comp = st[i][1] + 999;
                for(int j = i+1;j<st.length;j++){
                    if(st[j][0]<=comp)
                        temp++;
                    else if(st[j][1] >= comp+3000)
                        break;
                }
                max = Math.max(max,temp);
            }

        } catch (ParseException e){
            e.printStackTrace();
        }
        return max;
    }
}
