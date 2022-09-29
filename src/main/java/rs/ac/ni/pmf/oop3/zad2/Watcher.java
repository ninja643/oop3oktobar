package rs.ac.ni.pmf.oop3.zad2;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Watcher extends Thread
{
	private final Map<String, Worker> _workers = new ConcurrentHashMap<>();

	public Watcher()
	{
		super();
		setDaemon(true);
	}

	public void addWorker(final Worker worker)
	{
		_workers.put(worker.getWorkerName(), worker);
	}

	@Override
	public void run()
	{
		while (true)
		{
			WaitUtil.sleep(1);

			int waiting = 0;
			int working = 0;

			for (final Worker worker : _workers.values())
			{
				if (worker.getCurrentStatus() == Worker.Status.WAITING)
				{
					waiting++;
				}

				if (worker.getCurrentStatus() == Worker.Status.EXECUTING)
				{
					working++;
				}
			}

			log.info("Working statistics - waiting: {}, working: {}", waiting, working);
		}
	}
}
