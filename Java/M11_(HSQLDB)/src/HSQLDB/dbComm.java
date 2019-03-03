package HSQLDB;

import java.sql.ResultSet;
import java.util.ArrayList;

public class dbComm {
	
	
	
	private String getAllQuery = "SELECT * FROM v_table";
	private String createTable = "CREATE TABLE v_table(type VARCHAR(5), "
	+ "ID VARCHAR(1000), x DOUBLE, y DOUBLE, z DOUBLE, speed DOUBLE, direction INTEGER)";
	private String insertTable = "INSERT INTO v_table VALUES";
	private String updateTable = "UPDATE v_table SET ";
	
	public dbComm() {
		createTable();
	}
	
	private ResultSet queryDatabase() {
		ResultSet queriedVehicles = null;
		
		try {
			Database db = new Database("db_file");
			queriedVehicles = db.query(getAllQuery);
			db.shutdown();
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		return queriedVehicles;	
	}
	
	
	
	
	
	
	public void createTable() {
		try {
			Database db = new Database("db_file");
			db.update(createTable);
			db.shutdown();
		} catch (Exception e) {
			
		}
	}
	
	public void updateDB(vehicle input) {
		String type = getType(input);
		String inp = "";
		
		if(vExists(input, buildArray())) {
			inp = updateTable + "x = " + input.x + ", y = " + input.y + ", z = " 
			+ input.z + ", speed = " + input.speed + ", direction = " + input.direction 
			+ " WHERE ID = '" + input.ID + "';";
		} else {
			inp = insertTable + "('" + type + "', '" + input.ID + "', " + input.x + ", "
			+ input.y + ", " + input.z + ", " + input.speed + ", " + input.direction + ")";
		}
		
		try {
			Database db = new Database("db_file");
			db.update(inp);
			db.shutdown();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	
	public ArrayList<vehicle> buildArray() {
		ArrayList<vehicle> dbVehicles = new ArrayList<vehicle>();
		
		ResultSet data = queryDatabase();
		try {
			
			for(; data.next();) {
				
				vehicle newVehicle = null;
				String type = data.getString(1);
				String ID = data.getString(2);
				double x = data.getDouble(3);
				double y = data.getDouble(4);
				double z = data.getDouble(5);
				double speed = data.getDouble(6);
				int direction = data.getInt(7);
				if(type.equals("Air"))
					newVehicle = new airVehicle(ID, x, y, z, speed, direction);
				if(type.equals("Land"))
					newVehicle = new landVehicle(ID, x, y, z, speed, direction);
				if(type.equals("SAM"))
					newVehicle = new SAM(ID, x, y, z, speed, direction);
				if(type.equals("Moto"))
					newVehicle = new motorcycle(ID, x, y, z, speed, direction);
				if(newVehicle != null)
					dbVehicles.add(newVehicle);
				else
					System.out.println("Error processing vehicle");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dbVehicles;
	}
	
	public String getType(vehicle input) {
		String type = "";
		if(input instanceof airVehicle)
			type = "Air";
		if(input instanceof landVehicle)
			type = "Land";
		if(input instanceof SAM)
			type = "SAM";
		if(input instanceof motorcycle)
			type = "Moto";
		return type;
	}
	
	
	
	
	private boolean vExists(vehicle input, ArrayList<vehicle> array) {
		for(vehicle v1 : array) {
			if(input.ID.equals(v1.ID))
				return true;
		}
		return false;
	}
}
