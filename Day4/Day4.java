package Day4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day4 {

    public static void main(String[] args) throws Exception {
        List<String> input = convertFileToString();
        solutionPart1(input);
        solutionPart2(input);
    }

    private static void solutionPart1(List<String> input) {
        int assignmentPairsThatContainSubset = 0;

        for (String line : input) {
            boolean shouldIncreaseCount = true;
            List<Integer> boundsList = new ArrayList<>();

            for (String s : line.split("\\W+")) {
                boundsList.add(Integer.valueOf(s));
            }

            List<Integer> sections1 = new ArrayList<>();
            List<Integer> sections2 = new ArrayList<>();

            for (int i = boundsList.get(0); i <= boundsList.get(1); i++) {
                sections1.add(i);
            }
            for (int i = boundsList.get(2); i <= boundsList.get(3); i++) {
                sections2.add(i);
            }

            if (sections1.size() > sections2.size()) {
                for (int i : sections2) {
                    if (!sections1.contains(i)){
                        shouldIncreaseCount = false;
                    }
                }
            } else {
                for (int i : sections1) {
                    if (!sections2.contains(i)){
                        shouldIncreaseCount = false;
                    }
                }
            }

            // if (sections1.size() > sections2.size()) {
            //     for (int i : sections2) {
            //         if (!sections1.contains(i)){
            //             shouldIncreaseCount = false;
            //         }
            //     }

            // } else if (sections1.size() < sections2.size()) {
            //     for (int i : sections1) {
            //         if (!sections2.contains(i)){
            //             shouldIncreaseCount = false;
            //         }
            //     }

            // } else {
            //     if (sections1.equals(sections2)) {
            //         shouldIncreaseCount = true;
            //     } else {
            //         shouldIncreaseCount = false;
            //     }
            // }

            if (shouldIncreaseCount)
                assignmentPairsThatContainSubset += 1;
        }
        System.out.println(assignmentPairsThatContainSubset);
    }

    private static void solutionPart2(List<String> input) {
        int assignmentPairsThatContainSubset = 0;

        for (String line : input) {
            boolean shouldIncreaseCount = false;
            List<Integer> boundsList = new ArrayList<>();

            for (String s : line.split("\\W+")) {
                boundsList.add(Integer.valueOf(s));
            }

            List<Integer> sections1 = new ArrayList<>();
            List<Integer> sections2 = new ArrayList<>();

            for (int i = boundsList.get(0); i <= boundsList.get(1); i++) {
                sections1.add(i);
            }
            for (int i = boundsList.get(2); i <= boundsList.get(3); i++) {
                sections2.add(i);
            }

            if (sections1.size() > sections2.size()) {
                for (int i : sections2) {
                    if (sections1.contains(i)){
                        shouldIncreaseCount = true;
                        break;
                    }
                }
            } else {
                for (int i : sections1) {
                    if (sections2.contains(i)){
                        shouldIncreaseCount = true;
                        break;
                    }
                }
            }

            if (shouldIncreaseCount)
                assignmentPairsThatContainSubset += 1;
        }
        System.out.println(assignmentPairsThatContainSubset);
    }

    public static List<String> convertFileToString() throws IOException{
        File file = new File("C:\\Users\\kevin\\Desktop\\AoC-2022\\Day4\\input.txt");
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
