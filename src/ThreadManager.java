import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadManager {
    private int poolSize;
    private ExecutorService executorService;
    public ThreadManager(int poolSize){
        this.poolSize=poolSize;
        executorService=Executors.newFixedThreadPool(poolSize);
    }
    public void execute(Runnable runnable){
        executorService.submit(runnable);
    }
    public void shutdown(){
        executorService.shutdown();
    }
    //public static void main(String[] args) {

       // ThreadManager threadManager = new ThreadManager(100);
        //executorService=; //Executors.newFixedThreadPool(10);
       // for (int i = 0; i < 10000; i++) {
         //   RunnableExample temp = new RunnableExample("THREAD-No-" + i, 0,100);
         //   threadManager.execute(temp);
      //  }
        // executorService.submit(new RunnableExample("THREAD-A",0,500));
        //executorService.submit(new RunnableExample("THREAD-B",0,1000));
        //executorService.submit(new RunnableExample("THREAD-C",0,2000));

   // }
}
