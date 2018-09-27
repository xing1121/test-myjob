package com.sf.stms.job.core;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 描述：模拟quartz
 * @author 80002888
 * @date   2018年6月28日
 */
public class Scheduler {
	
	private List<JobDetail> jobsDetails;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public void start(){
		if (jobsDetails == null || jobsDetails.size() == 0) {
			return;
		}
		for (JobDetail jobDetail : jobsDetails) {
			Trigger trigger = jobDetail.getTrigger();
			String jobName = jobDetail.getJobName();
			Job job = jobDetail.getJob();
			new Thread(()->{
				while (true) {
					if(System.currentTimeMillis() >= trigger.getStartTime().getTime()){
						long start = System.currentTimeMillis();
						job.execute();
						System.out.println(jobName + "执行完毕，现在时间" + sdf.format(new Date()));
						trigger.setStartTime(new Date(start + (trigger.getPeriodSecond() * 1000)));
					}
				}
			}).start();
		}
	}
	
	public void schedule(JobDetail jobsDetail){
		if (jobsDetails == null) {
			this.jobsDetails = new ArrayList<>(10);
		}
		jobsDetails.add(jobsDetail);
	}
	
}
