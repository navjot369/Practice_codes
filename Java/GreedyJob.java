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
        int JobArray[][] = {{4, 20}, {1, 10}, {1, 40}, {1, 30}};

        ArrayList<Job> JobInfo = new ArrayList<>();

        for(int i = 0; i < JobArray.length; i++) {
            JobInfo.add(new Job(i, JobArray[i][0], JobArray[i][1]));
        }

        
    }
}
