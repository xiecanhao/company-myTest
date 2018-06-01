package delay;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayJob implements Delayed {
	private String name;
	/** 任务执行时间 */
	private long fireTime;

	public DelayJob(String name, long fireTime) {
		super();
		this.name = name;
		this.fireTime = fireTime;
	}

	@Override
	public int compareTo(Delayed o) {
		DelayJob that = (DelayJob) o;
		if (this.fireTime > that.fireTime)
			return 1;
		else if (this.fireTime < that.fireTime)
			return -1;

		return 0;
	}

	@Override
	public long getDelay(TimeUnit unit) {
		return unit.convert(fireTime - System.currentTimeMillis(),
				TimeUnit.MILLISECONDS);
	}

	public void fire() {
		System.out.println(name + ":fireTask");
	}

}
