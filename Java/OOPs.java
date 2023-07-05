public class OOPs{
    public static void main(String args[]){
    }
}

class Animal {
    boolean mouth = true;
}
interface Mammal {
    void eat();
}
class Bird extends Animal{
    static int speed = 40;
    Bird() {
        super();
        System.out.println("Bird is called");
    }
    public void eat(){
        System.out.println("Birds eat something");
    }
    public void fly() {
        System.out.println("Bird can fly");
    }
    void walk() {
        System.out.println("Bird sometimes walk");
    }

}