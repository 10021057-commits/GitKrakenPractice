
class MyTask implements Runnable {

    // Shared variable that stores the running total.
    static long count;

    @Override
    public void run() {

        // Each thread adds the numbers from 1 to 1,000,000.
        for (int i = 1; i <= 1000000; i++)
            count += i;

        // Display the current thread's name and the total.
        System.out.println(Thread.currentThread().getName() + " " + count);
    }
}

public class dayone {

    public static void main(String[] args) {

        // Start the timer to measure program execution time.
        CodeTimer.start();

        // Create an array that will store 1,000 Thread objects.
        Thread[] threadlist = new Thread[1000];

        // Create 1,000 threads and store them in the array.
        for (int i = 0; i < 1000; i++) {
            Thread t1 = new Thread(new MyTask());
            threadlist[i] = t1;
        }

        // Loop through the array and execute each thread.
        for (int i = 0; i < 1000; i++) {

            // Start the thread's task.
            threadlist[i].start();

            try {
                // Wait for the thread to finish before continuing.
                threadlist[i].join();

            } catch (InterruptedException e) {

                // Restore the interrupted status if an interruption occurs.
                Thread.currentThread().interrupt();
            }
        }

        // Stop the timer and display the total execution time.
        System.out.println("time: " + CodeTimer.stop());
    }
}
