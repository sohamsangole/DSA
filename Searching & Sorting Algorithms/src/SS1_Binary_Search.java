/**
 * Time Complexity:
 *      Best Case: O(1)
 *      Average Case: O(log N)
 *      Worst Case: O(log N)
 * ---------------------------------------------
 * Auxiliary Space: O(1)
 *      If the recursive call stack is considered
 *      then the auxiliary space will be O(logN).
 */
public class SS1_Binary_Search {
    public static int binarySearch(int[] arr,int l,int r,int target){
        if (l<=r){
            int mid = (l+r)/2;
            if (arr[mid] == target){
                return mid;
            }
            else if (arr[mid]>target){
                return binarySearch(arr,l,mid-1,target);
            }
            else {
                return binarySearch(arr,mid+1,r,target);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {2,4,6,8,10,12,14,16};
        System.out.println(binarySearch(arr,0,arr.length,16));
    }
}
