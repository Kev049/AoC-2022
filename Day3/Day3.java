package Day3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day3 {

    public static void main(String[] args) throws Exception {
        List<String> inputList = convertFileToString();
        solutionPart1(inputList);
        solutionPart2(inputList);
    }

    private static void solutionPart1(List<String> inputList) {
        Set<Character> s1 = new HashSet<Character>();
        Set<Character> s2 = new HashSet<Character>();

        int score = 0;
        
        for (String a : inputList) {
            String word1 = a.substring(0, a.length()/2);
            String word2 = a.substring(a.length()/2, a.length());

            for (char c : word1.toCharArray()) {
                s1.add(c);
            }
            for (char c : word2.toCharArray()) {
                s2.add(c);
            }

            Set<Character> intersection = new HashSet<Character>(s1);
            intersection.retainAll(s2);
            char commonCharacter = intersection.iterator().next();

            if (Character.isLowerCase(commonCharacter)) {
                score += commonCharacter - 'a' + 1;
            } else {
                score += commonCharacter - 'A' + 27;
            }

            s1.clear();
            s2.clear();
        }
        System.out.println(score);
    }

    private static void solutionPart2(List<String> inputList) {
        Set<Character> s1 = new HashSet<Character>();
        Set<Character> s2 = new HashSet<Character>();
        Set<Character> s3 = new HashSet<Character>();

        int counter = 1;
        int score = 0;

        for (String bag : inputList) {
            for (char c : bag.toCharArray()) {
                if (counter == 1) {
                    s1.add(c);
                } else if (counter == 2) {
                    s2.add(c);
                } else {
                    s3.add(c);
                }   
            }
            
            if (counter == 1) {
                counter = 2;
            } else if (counter == 2) {
                counter = 3;
            } else {
                counter = 1;

                Set<Character> intersection = new HashSet<Character>(s1);
                intersection.retainAll(s2);
                intersection.retainAll(s3);
                char commonCharacter = intersection.iterator().next();

                if (Character.isLowerCase(commonCharacter)) {
                    score += commonCharacter - 'a' + 1;
                } else {
                    score += commonCharacter - 'A' + 27;
                }
                s1.clear();
                s2.clear();
                s3.clear();
            }  
        }
        System.out.println(score);
    }

    public static List<String> convertFileToString() throws IOException{
        File file = new File("C:\\Users\\kevin\\Desktop\\AoC-2022\\Day3\\input.txt");
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
    
}
