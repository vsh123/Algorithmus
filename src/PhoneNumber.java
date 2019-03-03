import java.util.*;

/*
    문제 : 전화번호 목록

    출처 : https://programmers.co.kr/learn/courses/30/lessons/42577?language=java

 */

public class PhoneNumber {
    Comparator<String> CompLen = new Comparator<String>(){
        @Override
        public int compare(String a, String b){
            return a.length() - b.length();
        }
    };

    public boolean solution(String[] phone_book) {
        boolean answer = true;
        List<Integer> len = new ArrayList<Integer>();
        Map<String, Integer> map = new HashMap<String, Integer>();
        Arrays.sort(phone_book,CompLen);
        len.add(phone_book[0].length());

        for(int i =1; i<phone_book.length;i++){
            if(len.get(len.size()-1)!= phone_book[i].length()){
                len.add(phone_book[i].length());
            }
        }

        for(int i = 0; i<phone_book.length;i++){
            map.put(phone_book[i],1);
        }

        for(int i = 0; i<phone_book.length;i++){
            for(int j =0; j<len.size();j++){
                if(phone_book[i].length() > len.get(j)){
                    String temp = phone_book[i].substring(0,len.get(j));
                    if(map.containsKey(temp)){
                        return false;
                    }
                }
                else
                    break;
            }
        }

        return true;
    }
}
/*
다른 사람의 풀이

class Solution {
    public boolean solution(String[] phoneBook) {
       for(int i=0; i<phoneBook.length-1; i++) {
            for(int j=i+1; j<phoneBook.length; j++) {
                if(phoneBook[i].startsWith(phoneBook[j])) {return false;}
                if(phoneBook[j].startsWith(phoneBook[i])) {return false;}
            }
        }
        return true;
    }
}

 */
