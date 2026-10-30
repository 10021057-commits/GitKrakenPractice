class MyTask implements Runnable {
	private long count;
	@Override
	public void run() {
		for(int i = 1; i <= 1000000; i++)
			count += i;

		System.out.println(Thread.currentThread().getName() + " " + count);
	}
}

public class dayone{
	public static void main(String[]args){
		Thread[] threadlist = new Thread[1000];
		for(int i = 0; i < 1000; i++){
			Thread t1 = new Thread(new MyTask());
			threadlist[i] = t1;
		}
		for(int i = 0; i < 1000; i++){
			threadlist[i].run();
			try {
				threadlist[i].join();
			 } catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			 }
		}
	}
}