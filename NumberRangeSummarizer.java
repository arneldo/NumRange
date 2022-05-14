package numberrangesummarizer;

import java.util.Collection;
import java.util.*;

/**
 * @author Werner
 *
 * Implement this Interface to produce a comma delimited list of numbers,
 * grouping the numbers into a range when they are sequential.
 *
 *
 * Sample Input: "1,3,6,7,8,12,13,14,15,21,22,23,24,31
 * Result: "1, 3, 6-8, 12-15, 21-24, 31"
 *
 * The code will be evaluated on
 *   - functionality
 *   - style
 *   - robustness
 *   - best practices
 *   - unit tests
 */
public interface NumberRangeSummarizer {

    //collect the input
    Collection<Integer> collect(String input);

    //get the summarized string
    String summarizeCollection(Collection<Integer> input);

}

class DemoClass implements NumberRangeSummarizer{

    public Collection<Integer> collect(String input){
        Collection<Integer> Vars = new ArrayList<Integer>();
        String inp = input;
        int pos;
        while(inp.contains(",")){
            System.out.println(inp);
            pos = inp.indexOf(",");
            Vars.add(Integer.valueOf(inp.substring(0,pos)));
            inp = inp.substring(pos+1);
        }
        Vars.add(Integer.valueOf(inp));
        return Vars;
    }

    public String summarizeCollection(Collection<Integer> input){
        String output = "";
        int prev = -5;
        int holder = 0;
        boolean begin = true;
        for (int nums: input){
            System.out.println(nums);
            if (begin){
                output = output + nums;
                begin = false;
            }
            else if (prev + 1 == nums){
                System.out.println("prev = "+ (prev+1));
                System.out.println("nums = "+nums);
                holder++;
            }
            else if(holder > 0){
                output = output + "-"+ (prev)+", "+nums;
                holder = 0;
            }
            else{
                output = output +", "+nums;
            }
            prev = nums;
        }

        return output;
    }

    public static void main(String[] args){
        DemoClass demo = new DemoClass();
        Collection<Integer> tester = demo.collect("1,3,6,7,8,12,13,14,15,21,22,23,24,31");
        System.out.println(demo.summarizeCollection(tester));
    }
}

