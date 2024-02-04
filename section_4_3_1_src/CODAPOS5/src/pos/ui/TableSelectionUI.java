package pos.ui;

import java.util.List;

import pos.model.Table;

public class TableSelectionUI extends BaseUI {

	@Override
	protected boolean doDisplayUI() {
		return false;
	}
	
    public Table selectTable(List<Table> tables) {
    	
		System.out.println();
		System.out.println(center("------------------", 30));
		System.out.println(center("Available tables", 30));
		System.out.println(center("------------------", 30));
		
    	for (Table table : tables) {
			System.out.println(center("Table No. "+Integer.toString(table.getTableNo()), 30));
		}
    	
    	System.out.println("\nPlease select a table:");
    	
    	System.out.print(">>");

		int choice = scanInt();
		
		for (Table table : tables) {
			if (table.getTableNo() == choice)
				return table;
		}
		
		return null;
		
	}

}
