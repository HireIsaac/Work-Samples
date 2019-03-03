import java.util.ArrayList;

public class test {

	public static void main(String[] args) {

		ArrayList<Thread> vehicles = new ArrayList<Thread>();
		myCar a;
		myCar b;
		myCar c;
		myPlane d;
		myPlane e;
		myPlane f;
		vehicles.add(a = new myCar(1));
		vehicles.add(b = new myCar(2));
		vehicles.add(c = new myCar(3));
		vehicles.add(d = new myPlane(4));
		vehicles.add(e = new myPlane(5));
		vehicles.add(f = new myPlane(6));
		
		for(Thread v :vehicles) {
			v.start();
		}
		
	}

}
