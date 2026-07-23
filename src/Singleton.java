//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Singleton {
    public int data;
    private static Singleton singleton;
    private Singleton(int data){
this.data=data;
System.out.println("Constructor was call"+data);
    }
public static Singleton getSingletonInstance(int data){
        if(singleton==null) {
            singleton  = new Singleton( data);

        }
        return singleton;
}

}