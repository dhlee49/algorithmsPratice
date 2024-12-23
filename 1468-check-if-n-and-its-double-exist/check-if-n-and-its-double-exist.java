class Solution {
    public boolean checkIfExist(int[] arr) {
        Set<Integer> set = new HashSet();
        for(int i : arr) {
            if(i % 2 == 0 && set.contains(i / 2)) return true;
            if(set.contains(i * 2)) return true;  
            set.add(i);
            
        }
        return false; 
    }
}