package com.nokia.connect.order;


public class WorkflowObject {

	private String orderId;
	private int row;
	private String status;
	private int column;
	
	public WorkflowObject(){}
	
	public void add(int row, int column, String status){
		switch(column){
		case 1 : setOrderId(status);break;
		case 6 : setStatus(status);break;
		}
		setRow(row);
	}

	@Override
	public String toString() {
		return "WorkflowAction [orderId=" + orderId + ", row=" + row + ", status=" + status + "]";
	}

	public String getOrderId(){
		return orderId;
	}
	
	public int getRow() {
		return row;
	}

	public String getStatus() {
		return status;
	}

	public int getColumn() {
		return column;
	}
	
	public void setOrderId(String orderId){
		this.orderId = orderId;
	}
	
	public void setRow(int row) {
		this.row = row;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
