package com.sf.stms.job.core;

public class JobDetail {

	private Job job;
	
	private Trigger trigger;
	
	private String jobName;

	public JobDetail() {
	}

	public JobDetail(Job job, Trigger trigger, String jobName) {
		this.job = job;
		this.trigger = trigger;
		this.jobName = jobName;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public Trigger getTrigger() {
		return trigger;
	}

	public void setTrigger(Trigger trigger) {
		this.trigger = trigger;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	@Override
	public String toString() {
		return "JobDetail [job=" + job + ", trigger=" + trigger + ", jobName=" + jobName + "]";
	}
	
}
