package com.nokia.connect.order;


public class OrderResponse {
	
	private String nr;
	private String name;
	private String blank1;
	private String work_queue;
	private String blank2;
	private String status;
	private String requested_start_date;
	private String start_date;
	private String end_date;
	private String duration;

	public OrderResponse() {}

	public void add(int column, String cellText){
		switch(column){
		case 0: setNr(cellText);break;
		case 1: setName(cellText);break;
		case 2: setWork_queue(cellText);break;
		case 3: setStatus(cellText);break;
		case 6: setRequested_start_date(cellText);break;
		case 7: setStart_date(cellText);break;
		case 8: setEnd_date(cellText);break;
		case 9: setDuration(cellText);break;
		}
			
	}
	
	@Override
	public String toString() {
		return "OrderResponse: nr=" + nr + ", name=" + name + ", work_queue=" + work_queue + ", status=" + status
				+ ", requested_start_date=" + requested_start_date + ", start_date=" + start_date + ", end_date="
				+ end_date + ", duration=" + duration + "!";
	}

	public String getNr() {
		return nr;
	}

	public String getName() {
		return name;
	}

	public String getWork_queue() {
		return work_queue;
	}

	public String getStatus() {
		return status;
	}

	public String getRequested_start_date() {
		return requested_start_date;
	}

	public String getStart_date() {
		return start_date;
	}

	public String getEnd_date() {
		return end_date;
	}

	public String getDuration() {
		return duration;
	}

	public String getBlank1() {
		return blank1;
	}

	public String getBlank2() {
		return blank2;
	}

	public void setNr(String nr) {
		this.nr = nr;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setBlank1(String blank1) {
		this.blank1 = blank1;
	}

	public void setWork_queue(String work_queue) {
		this.work_queue = work_queue;
	}

	public void setBlank2(String blank2) {
		this.blank2 = blank2;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setRequested_start_date(String requested_start_date) {
		this.requested_start_date = requested_start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}
}
