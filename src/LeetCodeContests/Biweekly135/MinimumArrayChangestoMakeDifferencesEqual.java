package LeetCodeContests.Biweekly135;

import java.util.HashMap;
import java.util.Map;

public class MinimumArrayChangestoMakeDifferencesEqual {
    public static void main(String[] args) {
        int[] nums = {0,1,2,3,3,6,5,4};
        int k = 6;
        System.out.println(minChanges(nums,k));
    }

    public static int minChanges(int[] nums, int k) {
        int n = nums.length;
        Map<Integer,Integer> curDiffCount = new HashMap<>();//store all the differences with count
        int[] oneOp = new int[k + 1];//max possible diff in one op

        for(int i = 0 ; i < n / 2; i++){
            int diff = Math.abs(nums[i] - nums[n - i - 1]);
            curDiffCount.put(diff,curDiffCount.getOrDefault(diff,0)+1);//store all the diffs

            int minEle = Math.min(nums[i],nums[n - i - 1]);
            int maxEle = Math.max(nums[i],nums[ n - i - 1]);
            //two possible ways to achieve max diff with one op
            int maxDiff = Math.max(k - minEle,maxEle - 0);
            oneOp[maxDiff]++;//store it
        }
        //suffix sum
        for(int maxAchievalbeDiff = k - 1; maxAchievalbeDiff >= 0 ; maxAchievalbeDiff--){
            oneOp[maxAchievalbeDiff] += oneOp[maxAchievalbeDiff + 1];
            //propogate the ans, say 'x' no of pairs can achieve a max diff of 18, then those x pairs also can
            //achieve diff of 18,17...0(0 is reduntant and need to be subtracted in later steps). so we propogate
            //such that we can query, for any possible div(not pax possible) what is the max diff that can be achieved
        }

        int ans = Integer.MAX_VALUE;
        for(Map.Entry<Integer,Integer> entry: curDiffCount.entrySet()){
            int diff = entry.getKey(), count = entry.getValue();
            int oneExtra = oneOp[diff] - count;//subtract 0 count(0 op required)
            int two = (n / 2) - oneExtra - count;//n/2 - oneOp[diff];
            ans = Math.min(ans,oneExtra + ( 2 * two));
        }
        return ans;
    }
}
