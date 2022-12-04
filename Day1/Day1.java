package Day1;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day1 {
    public static void main(String[] args) throws Exception {
        solutionPart1();
        solutionPart2();        
    }

    private static void solutionPart1() throws Exception {
        File file = new File("C:\\Users\\kevin\\Desktop\\AoC-2022\\Day1\\input.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        int currentElfCalories = 0;
        int highestCalories = 0;
        String line = br.readLine();

        while (line != null) {
            if (!line.isBlank()) {
                currentElfCalories += Integer.parseInt(line);
            } else {
                if (currentElfCalories > highestCalories)
                    highestCalories = currentElfCalories;
                currentElfCalories = 0;
            }
            line = br.readLine();
        }
        br.close();
        System.out.println(highestCalories);
    }

    private static void solutionPart2() throws Exception {
        File file = new File("C:\\Users\\kevin\\Desktop\\AoC-2022\\Day1\\input.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        List<Integer> caloriesOfElves = new ArrayList<>();
        int currentElfCalories = 0;
        int caloriesForTop3Elves = 0;
        String line = br.readLine();

        while (line != null) {
            if (!line.isBlank()) {
                currentElfCalories += Integer.parseInt(line);
            } else {
                caloriesOfElves.add(currentElfCalories);
                currentElfCalories = 0;
            }
            line = br.readLine();
        }

        br.close();
        
        Collections.sort(caloriesOfElves, Collections.reverseOrder());
        for (int i = 0; i < 3; i++) {
            caloriesForTop3Elves += caloriesOfElves.get(i);
        }

        System.out.println(caloriesForTop3Elves);
    }
}