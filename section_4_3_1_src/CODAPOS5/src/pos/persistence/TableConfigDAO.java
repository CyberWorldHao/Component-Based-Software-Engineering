package pos.persistence;

import pos.model.TableConfig;

public interface TableConfigDAO extends BaseDAO {
	
	public TableConfig findTableConfig();

}
