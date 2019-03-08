import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args){
        IslandConnect test = new IslandConnect();
        int[][] costs =
                {{0,1,1},
                        {0,2,2},
                        {1,2,5},
                        {1,3,1},
                        {2,3,8}};
        test.solution(	4, costs);
    }
}
