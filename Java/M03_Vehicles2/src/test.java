import java.util.ArrayList;

public class test {

	public static void main(String[] args) {

		ArrayList<vehicle> vehicles = new ArrayList<vehicle>();
		landVehicle a;
		landVehicle b;
		landVehicle c;
		airVehicle d;
		airVehicle e;
		airVehicle f;
		vehicles.add(a = new landVehicle(1));
		vehicles.add(b = new landVehicle(2));
		vehicles.add(c = new landVehicle(3));
		vehicles.add(d = new airVehicle(4));
		vehicles.add(e = new airVehicle(5));
		vehicles.add(f = new airVehicle(6));
		
		for(vehicle v :vehicles) {
			v.start();
		}
		
	}

}
