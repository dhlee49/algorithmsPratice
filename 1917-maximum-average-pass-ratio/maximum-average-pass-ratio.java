class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        double current = Arrays.stream(classes).mapToDouble(x -> (double) x[0] / (double) x[1]).sum() / classes.length;
        PriorityQueue<double[]> maxHeap = new PriorityQueue<>((a,b) -> Double.compare(b[0],a[0]));
        for(int i = 0; i < classes.length; i++) {
            double curr = (double) classes[i][0] / (double) classes[i][1];
            double potential = (double) (classes[i][0] + 1) / (double) (classes[i][1] + 1);
            double diff = potential - curr;
            maxHeap.offer(new double[] { diff, i });
        }
        for(int i = 0;  i < extraStudents; i++) {
            double[] curEntry = maxHeap.poll();
            current += curEntry[0] / classes.length;
            int idx = (int) curEntry[1];
            classes[idx][0]++;
            classes[idx][1]++;
            double curr = (double) classes[idx][0] / (double) classes[idx][1];
            double potential = (double) (classes[idx][0] + 1) / (double) (classes[idx][1] + 1);
            double diff = potential - curr;
            maxHeap.offer(new double[] { diff, idx });
        }
        return current;
    }
}