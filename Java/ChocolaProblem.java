import java.util.*;

public class ChocolaProblem {
    public static void main(String args[]) {
        // int n = 4, m = 6;
        Integer costHor[] = {4, 1, 2};
        Integer costVer[] = {2, 1, 3, 1, 4};

        Arrays.sort(costVer, Collections.reverseOrder());
        Arrays.sort(costHor, Collections.reverseOrder());

        int h = 0, v = 0;
        int hp = 1, vp = 1;
        int cost = 0;

        while(h < costHor.length && v < costVer.length) {
            if(costHor[h] >= costVer[v]) {
                System.out.println("Horizontal " + h + " " + costHor[h] +" " + cost);
                cost += (vp * costHor[h]);
                hp++;
                h++;
            }
            else {
                System.out.println("Vertical: " + v + "  " + costVer[v] + " " + cost);
                cost += (hp * costVer[v]);
                vp++;
                v++;
            }
        }
        
        while(h < costHor.length) {
            System.out.println("Horizontal " + h + " " + costHor[h] +" " + cost);
            cost += (vp * costHor[h]);
            hp++;
            h++;
        }

        while(v < costVer.length) {
             System.out.println("Vertical: " + v + "  " + costVer[v] + " " + cost);
            cost += (hp * costVer[v]);
            vp++;
            v++;
        }

        System.out.println(cost);
    }
}
