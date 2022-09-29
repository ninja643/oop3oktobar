package rs.ac.ni.pmf.oop3.zad2;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
public class Worker implements Runnable
{
	private final String _workerName;
	private final int _initialWaitInSeconds;
	private final int _taskLengthInSeconds;

	public enum Status
	{
		WAITING,
		EXECUTING,
		FINISHED
	}

	private Status _currentStatus;

	public String getWorkerName()
	{
		return _workerName;
	}

	public synchronized Status getCurrentStatus()
	{
		return _currentStatus;
	}

	private synchronized void setCurrentStatus(final Status newStatus)
	{
		_currentStatus = newStatus;
	}

	@Override
	public void run()
	{
		status(Status.WAITING, "Waiting to start task");

		WaitUtil.sleep(_initialWaitInSeconds);

		status(Status.EXECUTING, "Starting the job");

		WaitUtil.sleep(_taskLengthInSeconds);

		status(Status.FINISHED, "Done");
	}

	private void status(final Status status, final String message)
	{
		setCurrentStatus(status);
		log.info("Worker {}: {}", this, message);
	}

	@Override
	public String toString()
	{
		return "Worker[" + _workerName
			+ ',' + _initialWaitInSeconds
			+ ',' + _taskLengthInSeconds
			+ ',' + _currentStatus + ']';
	}
}
