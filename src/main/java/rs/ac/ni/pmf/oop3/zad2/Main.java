package rs.ac.ni.pmf.oop3.zad2;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main
{
	private static final Random _rand = new Random();

	public static void main(String[] args)
	{
		final ExecutorService executorService = Executors.newCachedThreadPool();
		final Watcher watcher = new Watcher();
		watcher.start();

		for (int i = 0; i < 10; i++)
		{
			final Worker worker = new Worker("Worker_" + i, _rand.nextInt(5), _rand.nextInt(10));
			watcher.addWorker(worker);
			executorService.submit(worker);
		}

		executorService.shutdown();
	}
}
