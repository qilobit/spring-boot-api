package models;

import java.util.List;

public interface HeadphoneDao {

	List<Headphone> findAll();
	void insertEmployee(Headphone headp);
	void updateEmployee(Headphone headp);
	void executeUpdateEmployee(Headphone headp);
	public void deleteEmployee(Headphone headp);
	
}
