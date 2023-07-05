public class stringBuffer {
    public static void main(String args[]){
        // StringBuffer str1 = new StringBuffer(); //Empty string buffer
        StringBuffer str2 = new StringBuffer("Navjot"); //StringBuffer having value "Najvot"
        // StringBuffer str3 = new StringBuffer(19); //Stringbuffer with capacity of 19.
        //Default capacity for a stringBuffer is 16

        str2.append(" Singh");
        System.out.println("My name is " + str2);
        str2.insert(6, " and");
        System.out.println("My name is " + str2);
        str2.replace(1, 4, "trew");
        System.out.println(str2);
        str2.delete(8, 10);
        str2.reverse();
        System.out.println(str2.capacity());
        System.out.println(str2 + " have capatity " + str2.capacity());
        str2.ensureCapacity(24); //It will make capacity such that (old*2)+2;
        System.out.println(str2.capacity());
    }
}