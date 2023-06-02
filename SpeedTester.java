import java.util.Arrays;
public class EmptyTester{
    public static void main(String[] args){
        long avg=0;
        long startTime=0;
        long endTime=0;
        long duration=0;
        for(int i=0;i<10000;i++){
            startTime=System.nanoTime();
            isEverywhere(new int[]{1, 2, 1, 2, 3, 2, 5},2);
            endTime=System.nanoTime();
            duration=endTime-startTime;
            avg+=duration;
        }
        avg/=10000;
        System.out.println("Execution time 1st algorithm: "+avg+" nanoseconds");
        System.out.println("Execution time 1st algorithm: "+avg/1000000+" milliseconds");
        avg=0;
        for(int i=0;i<10000;i++){
            startTime=System.nanoTime();
            isEverywhere1(new int[]{1, 2, 1, 2, 3, 2, 5},2);
            endTime=System.nanoTime();
            duration=endTime-startTime;
            avg+=duration;
        }
        avg/=10000;
        System.out.println("Execution time 2nd algorithm: "+avg+" nanoseconds");
        System.out.println("Execution time 2nd algorithm: "+avg/1000000+" milliseconds");
    }
    public static boolean isEverywhere(int[] nums,int val){
      int length=nums.length;
      for(int i=0;i<length-1;i++)
        if(nums[i]!=val && nums[i+1]!=val)
          return false;
        else if(nums[i+1]==val)
          i++;
      return true;
    }
    public static boolean isEverywhere1(int[] nums,int val){
      int length=nums.length;
      for(int i=0;i<length-1;i++)
        if(nums[i]!=val && nums[i+1]!=val)
          return false;
      return true;
    }
}