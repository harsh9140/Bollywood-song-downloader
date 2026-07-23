public class ThreadExample extends Thread {
    private String threadName;
    public int counter;
    //we are overriding how run will gonna work!
public ThreadExample(String threadName,int counter){
    this.threadName=threadName;
    this.counter=counter;
}
    public void run(){
//we will define what process we want to run parallely!!
       while (counter<1000){
           counter++;}
    }
    public static void main(String[] args){
ThreadExample thread1=new ThreadExample("THREAD_A",0);
        ThreadExample thread2=new ThreadExample("THREAD_B",500);
        ThreadExample thread3=new ThreadExample("THREAD_C",500);
        thread1.start();
        thread2.start();
        thread3.start();
System.out.println(thread1.counter);
       System.out.println(thread2.counter);
System.out.println(thread3.counter);
}
}