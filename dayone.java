class MyTask implements Runnable {
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
	}
}

public class dayone{
	public static void main(String[]args){
		Thread[] threadlist = new Thread[1000];
		for(int i = 0; i < 1000; i++){
			Thread t1 = new Thread(new MyTask());
			threadlist[i] = t1;
		}

	}
}