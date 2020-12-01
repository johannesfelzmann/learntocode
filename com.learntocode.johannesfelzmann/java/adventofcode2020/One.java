package adventofcode2020;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class One {

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        try {
            File numbers = new File("C:\\Users\\Johannes\\Documents\\learntocode\\com.learntocode.johannesfelzmann\\java\\adventofcode2020\\numbers.txt");
            Scanner myReader = new Scanner(numbers);
            while (myReader.hasNextLine()) {
                list.add(Integer.parseInt(myReader.nextLine()));
            }

            //part one
            /*for (Integer i: list){
                for(Integer j: list){
                    if((i + j) == 2020){
                        System.out.println(i*j);
                    }
                }
            }*/

            //part two
            for (Integer i: list) {
                for (Integer j : list) {
                    for (Integer k : list) {
                        if ((i + j + k) == 2020) {
                            System.out.println(i * j * k);
                        }
                    }
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

}
