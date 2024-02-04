package posadmin.ui;

import java.util.List;

import pos.model.Table;
import posadmin.controllers.TableAdminCtrlr;

public class TableAdminUI extends BaseUI {

	private TableAdminCtrlr tableAdminCtrlr;

	public TableAdminUI(TableAdminCtrlr tableAdminCtrlr) {
		this.tableAdminCtrlr = tableAdminCtrlr;
	}

	@Override
	protected boolean doDisplayUI() {
		System.out.println("\n------------------------");
		System.out.println("    TABLE MANAGEMENT    ");
		System.out.println("------------------------\n");
		System.out.println("Select an operation:\n");
		System.out.println("1. Configure Number of Tables");
		System.out.println("2. Show Occupied Tables");
		System.out.println("3. Show Empty Tables");
		System.out.println("0. Exit");
		System.out.println();

		System.out.print(">>");
		int operationChoice = scanInt();

		switch (operationChoice) {
		case 1:
			tableAdminCtrlr.configureInvoked();
			break;

		case 2:
			tableAdminCtrlr.showOccupiedInvoked();
			break;

		case 3:
			tableAdminCtrlr.showEmptyInvoked();
			break;

		default:
			return false;
		}

		return true;

	}

	public void displayConfigScreen(int currentNoOfTables) {
		System.out.println("\n---------------");
		System.out.println("Configure Tables");
		System.out.println("---------------\n");
		System.out
				.println("\nCurrently configured number of tables in resturant : "
						+ currentNoOfTables);
		System.out.println("\nEnter new number of tables to be configured");
		System.out.print(">>");
		int newNoOfTables = scanInt();
		try {
			tableAdminCtrlr.tablesConfigured(newNoOfTables);
		} catch (Exception e) {
			displayError(e.getMessage());
		}
	}

	public void displayConfigSuccess() {
		System.out
				.println("\n**** SUCCESS - Tables configured successfully ****\n");
	}

	public void displayOccupiedTables(List<Table> tables) {
		displayTables("Occupied Tables", tables);
	}

	public void displayEmptyTables(List<Table> tables) {
		displayTables("Empty Tables", tables);
	}

	private void displayTables(String header, List<Table> tables) {
		System.out.println("\n--------------------");
		System.out.println(center(header, 20));
		System.out.println("--------------------");
		for (Table table : tables) {
			System.out.println(center("Table No. " + table.getTableNo(), 20));
		}
		System.out.println("--------------------\n");
	}

}
