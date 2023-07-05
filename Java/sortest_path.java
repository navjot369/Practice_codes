public class sortest_path {
    public static double short_path(String str){
        int x=0, y=0;
        int len = str.length();
        for(int i=0; i<len; i++){
            switch(str.charAt(i)){
                case 'N': y++;
                break;
                case 'W': x--;
                break;
                case 'E': x++;
                break;
                case 'S': y--;
                break;
            }
        }
        double ans = Math.pow((Math.pow(x, 2)+Math.pow(y, 2)), 0.5);
        return ans;
    }
    public static void main(String args[]){
        String str1 = "WNEENESENNN";
        double ans = short_path(str1);
        System.out.println("The shortest path is " + ans);
    }
}
