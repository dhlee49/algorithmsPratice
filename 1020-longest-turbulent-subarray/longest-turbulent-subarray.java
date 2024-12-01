class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int maxSize = 1;
        int size = 1;
        for(int i = 1; i < arr.length; i++) {
            //Even
            if(i % 2 == 0) {
                if(arr[i - 1] > arr[i]) {
                    size++;
                } else {
                    size = 1;
                }
            } else { //Odd
                if(arr[i - 1] < arr[i]) {
                    size++;
                } else {
                    size = 1;
                }
            }
            maxSize = Math.max(size, maxSize);
            System.out.println("I : "  + i + " & " + size);
        }
        size = 1;
        for(int i = 1; i < arr.length; i++) {
            //Even
            if(i % 2 == 0) {
                if(arr[i - 1] < arr[i]) {
                    size++;
                } else {
                    size = 1;
                }
            } else { //Odd
                if(arr[i - 1] > arr[i]) {
                    size++;
                } else {
                    size = 1;
                }
            }
            maxSize = Math.max(size, maxSize);
            System.out.println("I : "  + i + " & " + size);
        }
        return maxSize;
    }
}