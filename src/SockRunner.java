import java.util.Collections;
import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SockRunner {
    static Semaphore mutex = new Semaphore(1);
    static LinkedList<Integer> socks = new LinkedList<Integer>();
    static LinkedList<Integer> washer = new LinkedList<Integer>();

    public static void main(String[] args) {
	int sockCount = 27;
	for (int i = 0; i < sockCount; i++) {
	    socks.push(0);
	}
	Runnable wearer = new SockWearer();
	Runnable washer = new WashingMachine();
	ExecutorService pool = Executors.newFixedThreadPool(2);
	int runCount = 500;
	for (int i = 0; i < runCount; i++) {
	    pool.execute(wearer);
	    pool.execute(washer);
	}
	pool.shutdown();
	try {
	    pool.awaitTermination(10, TimeUnit.SECONDS);
	    double max = Collections.max(socks);
	    double min = Collections.min(socks);
	    double difference = max - min;
	    double avgRuns = runCount / sockCount;

	    System.out.println("max: " + max);
	    System.out.println("min: " + min);
	    System.out.println("Difference: " + difference);
	    System.out.println("avgRuns: " + avgRuns);
	    System.out.println("Percent diff: " + (difference/max*100));
//	    LinkedList<Integer> result = new LinkedList<Integer>();
//	    socks.forEach(sock -> {
//		result.add(-1 * (sock - max));
//	    });
//	    System.out.println(((double)Collections.max(result)) / runCount * 100.0);
	} catch (InterruptedException e) {
//	    e.printStackTrace();
	}
    }

}
