public class RunnableExample implements Runnable {
        private String threadName;
        public int counter;
        private int waitTimeWhileLoop;
        //we are overriding how run will gonna work!
        public RunnableExample(String threadName,int counter,int waitTimeWhileLoop){
            this.threadName=threadName;
            this.counter=counter;
            this.waitTimeWhileLoop=waitTimeWhileLoop;
        }
        public void run(){
            while (counter<10){
                counter++;
            try{
                Thread.sleep(waitTimeWhileLoop);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(threadName +":"+counter);

        }
        }


        public static void main(String[] args){
            RunnableExample thread1=new RunnableExample("THREAD_A",0,0);
            RunnableExample thread2=new RunnableExample("THREAD_B",0,100);
            RunnableExample thread3=new RunnableExample("THREAD_C",0,200);
Thread t1=new Thread(thread1);
            Thread t2 = new Thread(thread2);
            Thread t3 = new Thread(thread3);

            // Starting threads
            t1.start();
            t2.start();
            t3.start();
            //System.out.println(thread1.counter);
            //System.out.println(thread2.counter);
            //System.out.println(thread3.counter);
        }
    }

