class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        int mid = (start + end + 1) / 2;
        if(end == 0) return 0;
        if(arr[0] > arr[1]) return 0;
        if(arr[end] > arr[end - 1]) return end;
        while(start < mid && end > mid) {
            if(arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) return mid;
            if(arr[mid] > arr[mid - 1] && arr[mid] < arr[mid + 1]) start = mid;
            if(arr[mid] < arr[mid - 1] && arr[mid] > arr[mid + 1]) end = mid;
            mid = (start + end + 1) / 2;
        }
        return end;

    }
}