public class BinarySearch{
    // returns the correct location of an item in a sorted array or the compliment of the spot it should be in
    public static int binarySearch(int[] arr,int val){
        int front=0;
        int back=arr.length-1;
        int mid=0;
        while(front<=back){
            mid=(front+back)/2;
            if(arr[mid]==val)
                return mid;
            else if(arr[mid]>val)
                back=mid-1;
            else
                front=mid+1;
        }
        return front>mid ? -(front+1) : -(mid+1);
    }
}