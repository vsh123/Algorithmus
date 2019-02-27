import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args){
        BestAlbum test = new BestAlbum();
        String[] genres = {"classic", "pop", "classic", "classic", "pop","van","park"};
        int[] plays = {500,600,150,800,2500,20,50};
        test.solution(genres,plays);
    }
}
