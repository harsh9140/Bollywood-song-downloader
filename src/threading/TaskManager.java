package threading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class TaskManager {

    private int threadCount;
    private ExecutorService executorService;

    public TaskManager(int threadCount) {
        this.threadCount = threadCount;
        this.executorService =
                Executors.newFixedThreadPool(threadCount);
    }

    public void waitTillQueueIsFreeAndAddTask(Runnable runnable) {

        while (getQueueSize() >= threadCount) {

            try {
                System.out.println("Sleeping");
                Thread.sleep(1000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        addTask(runnable);
    }

    public int getQueueSize() {

        ThreadPoolExecutor executor =
                (ThreadPoolExecutor) executorService;

        return executor.getQueue().size();
    }

    public void addTask(Runnable runnable) {
        executorService.submit(runnable);
    }
    public void shutdown() {
        executorService.shutdown();
    }
}