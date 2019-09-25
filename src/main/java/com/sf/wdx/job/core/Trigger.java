package com.sf.wdx.job.core;

import java.util.Date;

public class Trigger {

	/**
	 * 开始时间
	 */
	private Date startTime;
	
	/**
	 * 间隔秒数
	 */
	private Long periodSecond;

	public Trigger(Date startTime, Long periodSecond) {
		this.startTime = startTime;
		this.periodSecond = periodSecond;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Long getPeriodSecond() {
		return periodSecond;
	}

	public void setPeriodSecond(Long periodSecond) {
		this.periodSecond = periodSecond;
	}

	@Override
	public String toString() {
		return "Trigger [startTime=" + startTime + ", periodSecond=" + periodSecond + "]";
	}
	
}
