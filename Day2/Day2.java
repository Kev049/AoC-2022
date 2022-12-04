package Day2;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Day2 {

    public static void main(String[] args) throws Exception{
        List<String> inputList = convertFileToString();        
        part1(inputList);
        part2(inputList);
    }

    public static List<String> convertFileToString() throws IOException{
        File file = new File("C:\\Users\\kevin\\Desktop\\AoC-2022\\Day2\\input.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        List<String> input = new ArrayList<>();

        String line = br.readLine();
        while (line != null) {
            input.add(line);
            line = br.readLine();
        }
        
        br.close();
        return input;
    }

    public static void part1(List<String> inputList) {

        HashMap<String, Integer> partOneMap = new HashMap<>();

        partOneMap.put("A X", 4);
        partOneMap.put("A Y", 8);
        partOneMap.put("A Z", 3);

        partOneMap.put("B X", 1);
        partOneMap.put("B Y", 5);
        partOneMap.put("B Z", 9);

        partOneMap.put("C X", 7);
        partOneMap.put("C Y", 2);
        partOneMap.put("C Z", 6);

        int score = 0;

        for (String round : inputList) {
            score += partOneMap.get(round);
        }
        System.out.println(score);
    }

    public static void part2(List<String> inputList) {

        HashMap<String, Integer> partOneMap = new HashMap<>();

        partOneMap.put("A X", 3);
        partOneMap.put("A Y", 4);
        partOneMap.put("A Z", 8);

        partOneMap.put("B X", 1);
        partOneMap.put("B Y", 5);
        partOneMap.put("B Z", 9);

        partOneMap.put("C X", 2);
        partOneMap.put("C Y", 6);
        partOneMap.put("C Z", 7);

        int score = 0;

        for (String round : inputList) {
            score += partOneMap.get(round);
        }
        System.out.println(score);
    }
}
