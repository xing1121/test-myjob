package com.sf.wdx.job.test;

import java.util.Date;

import com.sf.wdx.job.core.JobDetail;
import com.sf.wdx.job.core.Scheduler;
import com.sf.wdx.job.core.Trigger;

/**
 * 描述：测试自定义的Job，为Job指定Trigger，并将Job注册到Scheduler。
 * @author 80002888
 * @date   2018年9月27日
 */
public class TestMyJob {
	
	/**
	 * 测试MyJob，超过上次触发时间也只会触发一次
	 *	@ReturnType	void 
	 *	@Date	2018年9月27日	下午2:41:17
	 *  @Param  @param args
	 */
	public static void main(String[] args) {
		// 新建TriggerA，从3000s之前的时间开始，每隔5s运行一次
		Trigger triggerA = new Trigger(new Date(System.currentTimeMillis() - 3000000), 5L);
		
		// 新建TriggerB，从10s后开始运行，每隔10s运行一次
		Trigger triggerB = new Trigger(new Date(System.currentTimeMillis() + 10000), 10L);
		
		// 新建JobA并注册到调度器
		Scheduler scheduler = new Scheduler();
		scheduler.schedule(new JobDetail(()->{
			System.out.println("JobA--------------------------------" );
		}, triggerA, "任务A"));
		
		// 新建JobB并注册到调度器
		scheduler.schedule(new JobDetail(()->{
			System.out.println("JobB--------------------------------" );
		}, triggerB, "任务B"));
		
		// 启动调度器
		scheduler.start();
	}

}
