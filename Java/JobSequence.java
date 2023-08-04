import java.util.*;

public class JobSequence {
    static class Job {
        char JobId;
        int deadline;
        int profit;

        Job(char id, int deadline, int profit) {
            this.JobId = id;
            this.deadline = deadline;
            this.profit = profit;
        }
    }

    public static void maxProfit(ArrayList<Job> arr) {
        Collections.sort(arr, (a, b) -> {
            return a.deadline - b.deadline;
        });
        int size = arr.size();
        
        ArrayList<Job> result = new ArrayList<Job>();
        PriorityQueue<Job> maxHeap = new PriorityQueue<Job>( (a, b) -> {
            return b.profit - a.profit;
        });
        for(int i = size - 1; i > -1; i--) {
            int slots;
            if(i == 0) {
                slots = arr.get(i).deadline;
            } else {
                slots = arr.get(i).deadline - arr.get(i - 1).deadline;
            }
            maxHeap.add(arr.get(i));
            while(slots > 0 && maxHeap.size() > 0) {
                Job job = maxHeap.poll();
                result.add(job);
                slots--;
            }
        }

        Collections.sort(result, (a, b) -> {
            return a.deadline - b.deadline;
        });

        for(Job job:result) {
            System.out.print(job.JobId + "  ");
        }
        System.out.println();
    }

    public static void main(String args[]) {
        ArrayList<Job> al = new ArrayList<Job>();
        al.add(new Job('a', 2, 100));
        al.add(new Job('b', 1, 19));
        al.add(new Job('c', 2, 27));
        al.add(new Job('d', 1, 25));
        al.add(new Job('e', 3, 15));

        maxProfit(al);

    }
}
