package posguestui.controllers;

import pos.model.Table;

public interface ICheckOutCtrlr {

	public abstract void invokeCheckOut();

	public abstract void checkOutTableSelected(Table table) throws Exception;

}