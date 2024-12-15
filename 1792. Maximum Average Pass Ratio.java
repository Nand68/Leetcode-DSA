import java.util.PriorityQueue;

class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> maxHeap = new PriorityQueue<>(
            (a, b) -> Double.compare(b[0], a[0])
        );

        for (int[] cls : classes) {
            int pass = cls[0];
            int total = cls[1];
            double initialGain = gain(pass, total);
            maxHeap.offer(new double[]{initialGain, pass, total});
        }

        while (extraStudents > 0) {
            double[] best = maxHeap.poll();
            int pass = (int) best[1];
            int total = (int) best[2];
            pass++;
            total++;
            extraStudents--;
            maxHeap.offer(new double[]{gain(pass, total), pass, total});
        }

        double totalAverage = 0.0;
        int n = classes.length;
        while (!maxHeap.isEmpty()) {
            double[] top = maxHeap.poll();
            int pass = (int) top[1];
            int total = (int) top[2];
            totalAverage += (double) pass / total;
        }

        return totalAverage / n;
    }

    private double gain(int pass, int total) {
        return ((double) (pass + 1) / (total + 1)) - ((double) pass / total);
    }
}
