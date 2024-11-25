class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for( char c : tasks) count[c - 'A']++;
        int maxFrequency = Arrays.stream(count).max().orElse(1); 
        int taskMaxCount = (int) Arrays.stream(count).filter(cnt -> cnt == maxFrequency).count();
        return Math.max((maxFrequency - 1)* (n + 1) + taskMaxCount, tasks.length);
    }
}