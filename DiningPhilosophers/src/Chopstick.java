class Chopstick {
	Thread holder = null;

	public synchronized void grab() throws InterruptedException
	// public void grab() throws InterruptedException
	{
		while (holder != null)
			wait();
		holder = Thread.currentThread();
	}

	public synchronized void release()
	// public void release()
	{
		holder = null;
		notify();
	}

	public synchronized void releaseIfMine()
	// public void releaseIfMine()
	{
		if (holder == Thread.currentThread())
			holder = null;
		notify();
	}
}
