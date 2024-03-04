import java.util.*;

public class pattern1 {
    public static void main(String args[]) {
        int row = 5;
        int col = 20;
        int paper = 20;

        int highestnum = 0;

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        for(int np = 0; np < paper; np++) {

            for(int i = np; i < np+row; i++) {
                if(i == list.size()){
                    list.add(new ArrayList<Integer>());
                }
                ArrayList<Integer> item = list.get(i);
                for(int j = 0; j < np; j++) {
                    if(j == item.size()) {
                        item.add(0);
                    }
                }
                for(int j = np; j < np+col; j++) {
                    if(j == item.size()) {
                        item.add(1);
                    }
                    else {
                        item.set(j, item.get(j) + 1);
                        if(item.get(j) > highestnum) {
                            highestnum = item.get(j);
                        }
                    }
                }
            }
        }

        int len = (int)Math.floor(Math.log10(highestnum)) + 1;
        String fstr = "%" + len + "d";
        for(int i = 0; i < list.size(); i++){
            ArrayList<Integer> item = list.get(i);
            for(int j = 0; j < item.size(); j++) {
                if(item.get(j) == 0) {
                    System.out.print(String.valueOf(" ").repeat(len));
                }
                else{
                    System.out.printf(fstr, item.get(j));
                }
                System.out.print(" ");
            }
            System.out.println();
        }

    }
}
