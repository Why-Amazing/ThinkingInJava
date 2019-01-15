# 并发
## 2.8 后台线程
### finally语句不会执行的场景
	class ADaemon implements Runnable {
		public void run(){
			try {
				system.out.println("Starting ADaemon");
				TimeUnit.SECONDS.sleep(1);
			} catch(InterruptedException e) {
				system.out.println("Exiting via InterruptedException");
			} finally {
				system.out.println("This shoud always run?"):
			}
		}
	}
	public class DaemonsDontRunFinally {
		public static void main(String[] args) throws Exception {
			Thread t = new Thread(new ADaemon());
			t.setDaemon(true);
			t.start();
		}
	}
	/*
	* Output:
	* Starting ADaemon
	*/
	
finally字句不会执行,注释掉setDaemon()后,则finally字句会执行;
	当最后一个非后台线程终止时,后台线程会"突然"终止.因此一旦main()退出,JVM就会立即来关闭后来现场.

