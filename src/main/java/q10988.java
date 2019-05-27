import java.util.*;
import java.io.*;

/*
    문제 : 팰린드롬인지 확인하기

    문제 출처 : https://www.acmicpc.net/problem/10988

    이슈 사항
    1.
*/

public class q10988 {
    public int isPalindrom(){
        try {
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(bf.readLine());
            String ans = st.nextToken();
            int middle;
            if(ans.length()%2==0)
                middle = ans.length()/2;
            else
                middle = ans.length()/2+1;
            String a1 = ans.substring(0,middle);
            String temp = ans.substring(middle);
            String a2 = "";
            for(int i =temp.length()-1;i>=0;i--){
                a2 += temp.charAt(i);
            }

            for(int i=0;i<a2.length();i++){
                if(a1.charAt(i) == a2.charAt(i))
                    continue;
                else
                    return 0;
            }
            return 1;
        }catch(IOException e){
            e.printStackTrace();
            return 0;
        }
    }
}

