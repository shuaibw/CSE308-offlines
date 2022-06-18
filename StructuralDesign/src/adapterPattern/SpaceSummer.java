package adapterPattern;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SpaceSummer implements AbstractSpaceSummer {
    @Override
    public int computeSpaceSum(String file) {
        Scanner fs=null;
        try {
            fs = new Scanner(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            System.out.println("Opening file failed");
        }
        int sum = 0;
        if (fs==null) return -1;
        String[] nums = fs.nextLine().split(" ");
        for (String num : nums) {
            sum+=Integer.parseInt(num);
        }
        return sum;
    }
}
