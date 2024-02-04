package posbillui.controllers;

import pos.model.Table;

public interface IPayBilCtrlr {

	public abstract void invokePayBill();

	public abstract void payBill(Table table) throws Exception;

	public abstract void invokeDisplayBills();

}