import java.util.*;

public class NumberMagicEasy {

    public void magic(){
        String answer = "YNYY";
        System.out.println(theNumber(answer));
    }
    public int theNumber(String answer){
        String[] c ={
                "YYYYYYYYNNNNNNNN",
                "YYYYNNNNYYYYNNNN",
                "YYNNYYNNYYNNYYNN",
                "YNYNYNYNYNYNYNYN"
        };

        for(int i=0;i<=15;i++){
            String temp ="";
            for(int j =0 ;j<4;j++){
                temp+=c[j].charAt(i);
            }
            if(temp.equals(answer))
               return i+1;
        }
        return 0;
    }
}
