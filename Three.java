import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Three{

    public List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0; i<nums.length; i++){
            if(i>0 && nums[i]==nums[i-1]) continue;
            int j=i+1;
            int k=nums.length-1;
            while(j<k){
                int sum = nums[i]+nums[j]+nums[k];
                if(sum<0) j++;
                else if(sum>0) k--;
                else{
                    List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k]);
                    res.add(temp);
                    j++;
                    k--;
                    while(j<k && nums[j]==nums[j-1]) j++;
                    while(j<k && nums[k]==nums[k+1]) k--;
                }
            }
            
        }
        return res;
    }

    public void showTriplets(List<List<Integer>> arr){
        for(List<Integer> l: arr){
            for(int i: l){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        int[] arr = {-1,0,1,2,-1,-4};
        var obj = new Three();
        List<List<Integer>> triplets = obj.threeSum(arr);
        obj.showTriplets(triplets);
    }
}