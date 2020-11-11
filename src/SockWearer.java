import java.util.LinkedList;
import java.util.concurrent.Semaphore;

public class SockWearer implements Runnable{
    Semaphore mutex = SockRunner.mutex;
    LinkedList<Integer> socks = SockRunner.socks;
    LinkedList<Integer> washer = SockRunner.washer;
    @Override
    public void run() {	
	try {
	    mutex.acquire();
	    Integer sock1 = socks.removeFirst();
	    Integer sock2 = socks.removeLast();
	    washer.add(sock1 + 1);
	    washer.add(sock2 + 1);
	    mutex.release();
	} catch (InterruptedException e) {
//	    e.printStackTrace();
	} finally {
	}
    }

}
