package postable.biz;

import java.util.List;

import pos.model.Table;

public interface ITableBiz {

	public abstract int getNoOfTables();

	public abstract List<Table> getOccupiedTables();

	public abstract List<Table> getEmptyTables();

	public abstract void occupyTable(Table table, int noOfGuests, String waiter)
			throws Exception;

	public abstract void unOccupyTable(Table table) throws Exception;

	public abstract void canPayBill(Table table) throws Exception;

	public abstract void reconfigureTables(int newNoOfTables) throws Exception;

	public abstract void canTableTakeOrders(Table table) throws Exception;

}