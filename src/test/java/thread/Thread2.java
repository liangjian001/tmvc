package thread;

public class Thread2 implements Runnable {
	private String name;
	public Thread2(String str){
		this.name = str;
	}
	@Override
	public void run() {
		for (int i=0;i<5;i++){
			System.out.println(name+"运行："+i);
			try{
				Thread.sleep((int)Math.random()*10);
			}catch (InterruptedException ex){
				ex.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		new Thread(new Thread2("C")).start();
		new Thread(new Thread2("D")).start();;
	}
}
