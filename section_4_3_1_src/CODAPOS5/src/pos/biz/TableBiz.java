package pos.biz;

import java.util.ArrayList;
import java.util.List;

import pos.model.Order;
import pos.model.Table;
import pos.model.TableConfig;
import pos.persistence.TableConfigDAO;
import pos.persistence.db4o.DAOFactory;

public class TableBiz {
	
	
	private static TableBiz instance = new TableBiz();
	
	public static TableBiz getInstance() {
		return instance;
	}
	
	private TableConfigDAO tableConfigDAO = DAOFactory.getTableConfigDAO();
	private TableConfig tableConfig;

	List<Table> tables = new ArrayList<Table>();
	

	
	private TableBiz() {
		tableConfig = tableConfigDAO.findTableConfig();
		
		if (tableConfig == null) {
			tableConfig = new TableConfig();
			tableConfig.setNoOfTables(10);
			tableConfigDAO.create(tableConfig);
		}
		
		for (int tableNo=1; tableNo<=tableConfig.getNoOfTables(); tableNo++) {
			Table table = new Table(tableNo);
			tables.add(table);
		}
	}
	
	public int getNoOfTables() {
		return tableConfig.getNoOfTables();
	}
	

	public List<Table> getOccupiedTables() {
		
		List<Table> occupiedTables = new ArrayList<Table>();
		
		for (Table table : tables) {
			if (table.isOccupied())
				occupiedTables.add(table);
		} 
		
		return occupiedTables;
	}
	
	public List<Table> getEmptyTables() {
		
		List<Table> emptyTables = new ArrayList<Table>();
		
		for (Table table : tables) {
			if (!table.isOccupied())
				emptyTables.add(table);
		} 
		
		return emptyTables;
	}


	public void occupyTable(Table table, int noOfGuests, String waiter) throws Exception {
		
		if (table == null) {
			throw new Exception("Cannot checkin - Invalid Table");
		}
		
		if (table.isOccupied()) {
			throw new Exception("Table is already occupied");
		}
		

		if (noOfGuests == 0) {
			throw new Exception("Cannot checkin - Invalid number of guests");
		}

		if (waiter == null) {
			throw new Exception("Cannot checkin - Invalid waiter name");
		}

		Order order = new Order();
		
		table.occupy(noOfGuests, waiter, order);
	}

	public void unOccupyTable(Table table) throws Exception{
		
		if (table == null) {
			throw new Exception("Cannot checkout - Invalid Table");
		}
		
		if (!table.isOccupied()) {
			throw new Exception("Table is not occupied");
		}
		
		table.unOccupy();
		
		
	}
	
	public void canPayBill(Table table) throws Exception{
		
		if (table == null) {
			throw new Exception("Invalid Table");
		}
		
		if (!table.isOccupied()) {
			throw new Exception("Table is not occupied");
		}
		
		if (table.getOrder() == null) {
			throw new Exception("Table does not have active order");
		}
				
	}
	
	public void reconfigureTables(int newNoOfTables) throws Exception {

		if (newNoOfTables < 1) {
			throw new Exception("Invalid number of tables");
		}

		int currentNoOfTables = tableConfig.getNoOfTables();

		// Easiest case - no change required
		if (newNoOfTables == currentNoOfTables)
			return;

		// Easier case - more tables needed
		if (newNoOfTables > currentNoOfTables) {
			for (int tableNo = currentNoOfTables + 1; tableNo <= newNoOfTables; tableNo++) {
				Table table = new Table(tableNo);
				tables.add(table);
			}
		}
		// Rest is Not so easy - need to chop off tables
		else {
			int noOfOccupiedTables = getOccupiedTables().size();

			// Throw error if tables to be chopped are not empty
			if (noOfOccupiedTables > newNoOfTables) {
				throw new Exception(
						"Cannot reconfigure - More number of tables than desired number are currently occupied");
			}

			// Throw error if any of the table to be chopped is not empty
			for (Table table : getOccupiedTables()) {
				if (table.getTableNo() > newNoOfTables) {
					throw new Exception(
							"Cannot reconfigure - One of the tables to be removed is occupied");
				}
			}

			// Chop off...
			for (int tableNo = newNoOfTables + 1; tableNo <= currentNoOfTables; tableNo++) {
				tables.remove(tableNo);
			}

		}

		tableConfig.setNoOfTables(newNoOfTables);
		tableConfigDAO.update(tableConfig);

		
	}

	public void canTableTakeOrders(Table table) throws Exception {
		
		if (table == null) {
			throw new Exception("Invalid Table");
		}
		
		if (!table.isOccupied()) {
			throw new Exception("Table is not occupied");
		}
		
		if (table.getOrder() == null) {
			throw new Exception("Table does not have active order");
		}
		
	}
	
	
	
}
