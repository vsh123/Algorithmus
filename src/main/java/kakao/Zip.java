package kakao;

import java.util.HashMap;
import java.util.Map;

public class Zip {
    public int solution(String s) {
        int answer = 999999;

        for (int i = 1; i <= s.length(); i++) {
            String ans = "";
            String lastStr = "";
            int lastIdx = 0;
            int sidx = 0;
            while (true) {
                String sub = "";
                if (sidx + i <= s.length()) {
                    sub = s.substring(sidx, sidx + i);
                    sidx += i;
                } else {
                    sub = s.substring(sidx);
                    sidx += i;
                }
                if(lastStr.equals(sub)) {
                    lastIdx++;
                }
                else {
                    if(lastIdx != 0) {
                        if(lastIdx != 1) {
                            ans += lastIdx + lastStr;
                        }
                        else{
                            ans += lastStr;
                        }
                    }
                    lastIdx = 1;
                    lastStr = sub;
                }
                if (sidx >= s.length()) {
                    if(lastIdx != 1) {
                        ans += lastIdx + lastStr;
                    }
                    else{
                        ans += lastStr;
                    }
                    break;
                }
            }


            if(ans.length() < answer) {
                answer = ans.length();
            }
        }
        return answer;
    }
}
