import java.util.*;

public class GreedyJob {
    static class Job{
        int id;
        int deadline;
        int profit;

        Job(int i, int d, int p) {
            this.id = i;
            this.deadline = d;
            this.profit = p;
        }
    }

    public static void main(String args[]) {
        int JobArray[][] = {{4, 20}, {2, 10}, {1, 40}, {3, 30}};

        ArrayList<Job> JobInfo = new ArrayList<>();

        for(int i = 0; i < JobArray.length; i++) {
            JobInfo.add(new Job(i, JobArray[i][0], JobArray[i][1]));
        }

        Collections.sort(JobInfo, (j1, j2) -> j2.profit - j1.profit);

        int time = 0;
        ArrayList<Integer> sequence = new ArrayList<>();

        for(int i = 0; i < JobInfo.size(); i++) {
            Job curr = JobInfo.get(i);
            if(curr.deadline > time) {
                sequence.add(curr.id);
                time++;
            }
        }

        for(int i = 0; i < sequence.size(); i++) {
            System.out.print(sequence.get(i) + "  ");
        }
        System.out.println();
    }
}
