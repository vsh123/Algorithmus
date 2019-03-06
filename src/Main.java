import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args){
        TravelPath test = new TravelPath();
        String[][] tickets =
                {{"ICN", "SFO"}, {"ICN", "ATL"}, {SFO, ATL}, {ATL, ICN}, {ATL,SFO}}
        test.solution(tickets);
    }
}
