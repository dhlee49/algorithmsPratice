class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0;
        int right = arr.length - 1;
        int mid = (left + right) / 2;
        while(left <= right) {
            if(arr[mid] == x) break;
            if(arr[mid] < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
            mid = (left + right) / 2; 
        }
        if(arr[mid] > x) mid--;
        //Now mid is 3 cases -1, x.index, arr.length
        List<Integer> ans = new LinkedList<>();
        if(mid == -1) {
            for(int i = 0; i < Math.min(k, arr.length); i ++) ans.add(arr[i]);
        } else if(mid == arr.length) {
            for(int i = Math.min(k, arr.length); i > 0; i--) ans.add(arr[arr.length - i]);
        } else {
            left = mid;
            right = mid + 1;
            k = Math.min(arr.length, k);
            while(k > 0) {
                int leftDiff = 55555;
                int rightDiff = 55555;
                if(left > -1) leftDiff = Math.abs(x - arr[left]);
                if(right < arr.length) rightDiff = Math.abs(arr[right] - x);
                if(leftDiff <= rightDiff) {
                    ans.addFirst(arr[left]);
                    left--;
                } else {
                    ans.addLast(arr[right]);
                    right++;
                }
                k--;
            }
        }
        return ans;
    }
}