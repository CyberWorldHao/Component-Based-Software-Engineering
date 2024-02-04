package posguestui.controllers;

import pos.model.Table;

public interface ICheckInCtrlr {

	public abstract void invokeCheckIn();

	public abstract void checkIn(Table table, int noOfGuests, String waiter)
			throws Exception;

}