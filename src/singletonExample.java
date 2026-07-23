public class singletonExample {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Singleton obj1= Singleton.getSingletonInstance(90);
        Singleton obj2= Singleton.getSingletonInstance(56);
        obj1.data=90;
        obj2.data=56;
        System.out.printf(obj1.data+" & "+obj2.data);


    }
}
