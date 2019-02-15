import java.util.*;
import java.io.*;

/*
    문제 : DSLR(BFS)
    문제 출처 : https://www.acmicpc.net/problem/9019
    이슈 사항
    1.

 */
//
//public class q9019 {
//    public void getDSLR(){
//        try{
//            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//            StringTokenizer st = new StringTokenizer(bf.readLine());
//            int N = Integer.parseInt(st.nextToken());
//            for(int i = 0; i<N;i++) {
//                st = new StringTokenizer(bf.readLine());
//                int A = Integer.parseInt(st.nextToken());
//                int B = Integer.parseInt(st.nextToken());
//                String answer = findDSLR(A,B);
//                System.out.println(answer);
//            }
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//    }
//
//    public String findDSLR(int A, int B){
//        Queue<stringnum> q = new LinkedList<stringnum>();
//        q.offer(new stringnum("", A));
//
//        while(!q.isEmpty()){
//            stringnum temp = q.poll();
//            String s = temp.name;
//            int num = temp.num;
//            if(num == B){
//                return s;
//            }
//            int Dnum = (2*num)%10000;
//            int Snum = num-1;
//            if(Snum == 0)
//                Snum = 9999;
//            String stemp = Integer.toString(num);
//            if(stemp.length()<4){
//                int size = 4 - stemp.length();
//                for(int i =0; i< size;i++){
//                    stemp ="0"+stemp;
//                    System.out.println(i);
//                }
//            }
//            System.out.println(stemp);
//            int Lnum = Integer.parseInt(stemp.substring(1)+stemp.substring(0,1));
//            int Rnum = Integer.parseInt(stemp.substring(3)+stemp.substring(0,3));
//            System.out.println(Dnum + " "+Snum+" "+ Lnum + " " + Rnum);
//            q.offer(new stringnum(s+"D",Dnum));
//            q.offer(new stringnum(s+"S",Snum));
//            q.offer(new stringnum(s+"L",Lnum));
//            q.offer(new stringnum(s+"R",Rnum));
//        }
//        return "1";
//    }
//}
//
//class stringnum{
//    String name;
//    int num;
//    public stringnum(String name, int num){
//        this.name =name;
//        this.num = num;
//    }
//}
