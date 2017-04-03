package com.nokia.connect.order;


public class SearchOrder {

	private String internalId;
	private String orderNo;
	private String extServiceId;
	private String targetPortId;
	private String extendedSearch;
	private String orderStatus;
	private String start_date;
	private String estimated_date;
	private String activities;
	
	public SearchOrder(){}

	@Override
	public String toString() {
		return "SearchOrder [internalId=" + internalId + ", orderNo=" + orderNo + ", extServiceId=" + extServiceId
				+ ", targetPortId=" + targetPortId + ", extendedSearch=" + extendedSearch + ", orderStatus="
				+ orderStatus + ", start_date=" + start_date + ", estimated_date=" + estimated_date + ", activities="
				+ activities + "]";
	}

	public void add(int coloana, String info){
		switch(coloana){
		case 0 : setInternalId(info);break;
		case 1 : setOrderNo(info);break;
		case 2 : setExtServiceId(info);break;
		case 3 : setTargetPortId(info);break;
		case 4 : setExtendedSearch(info);break;
		case 5 : setOrderStatus(info);break;
		case 8 : setStart_date(info);break;
		case 9 : setEstimated_date(info);break;
		case 10 : setActivities(info);break;
		}
	}
	
	public String getInternalId() {
		return internalId;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public String getExtServiceId() {
		return extServiceId;
	}

	public String getTargetPortId() {
		return targetPortId;
	}

	public String getExtendedSearch() {
		return extendedSearch;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public String getStart_date() {
		return start_date;
	}

	public String getEstimated_date() {
		return estimated_date;
	}

	public String getActivities() {
		return activities;
	}

	public void setInternalId(String internalId) {
		this.internalId = internalId;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public void setExtServiceId(String extServiceId) {
		this.extServiceId = extServiceId;
	}

	public void setTargetPortId(String targetPortId) {
		this.targetPortId = targetPortId;
	}

	public void setExtendedSearch(String extendedSearch) {
		this.extendedSearch = extendedSearch;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public void setEstimated_date(String estimated_date) {
		this.estimated_date = estimated_date;
	}

	public void setActivities(String activities) {
		this.activities = activities;
	}	
}
