import java.util.Collections;
import java.util.LinkedList;
import java.util.concurrent.Semaphore;

public class WashingMachine implements Runnable {
    Semaphore mutex = SockRunner.mutex;
    LinkedList<Integer> socks = SockRunner.socks;
    LinkedList<Integer> washer = SockRunner.washer;

    @Override
    public void run() {
	try {
	    mutex.acquire();
	    if (washer.size() > 15) {
		Collections.shuffle(washer);
		socks.addAll(washer);
		
		washer.clear();
	    }
	    mutex.release();
	} catch (InterruptedException e) {
//	    e.printStackTrace();
	}
    }

}
