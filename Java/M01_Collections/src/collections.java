
import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.Random;

public class collections {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] words = { "Wagon", "Bumbo", "Quart", "Pool", "Nickelodiadood", "Girchle", "Willyummy", "Zork", "Death",
				"Please" };
		populateSet(words);
		carHash();
		shapeHash();
	}

	public static void populateSet(String[] words) {

		SortedSet<String> bigboyset = new TreeSet<String>();

		for (String x : words) {
			bigboyset.add(x);

		}
		;
		System.out.println(bigboyset);

	};

	public static void carHash() {
		HashMap<String, String> carLot = new HashMap<String, String>();
		carLot.put("Model", "Ranger");
		carLot.put("Year", "1802");
		carLot.put("Color", "Red");
		carLot.put("Price", "20$");
		System.out.println("");
		System.out.println("Car Lot information: ");
		for (Map.Entry m : carLot.entrySet()) {
			System.out.println(m.getKey() + " : " + m.getValue());
		}

	};

	public enum shapes {
		SQUARE, CIRCLE, TRIANGLE, CUBE
	};

	public enum colors {
		GREEN, BLUE, BLACK, RED, ORANGE
	};

	private static shapes getRandomshape(shapes[] s) {
		int rnd = new Random().nextInt(s.length);
		return s[rnd];
	};

	private static colors getRandomcolor(colors[] c) {
		int rnd = new Random().nextInt(c.length);
		return c[rnd];
	};

	public static void shapeHash() {
		HashMap<String, Object> shapeHash = new HashMap<String, Object>();
		shapes[] s = { shapes.SQUARE, shapes.CIRCLE, shapes.TRIANGLE, shapes.CUBE };
		colors[] c = { colors.GREEN, colors.BLUE, colors.BLACK, colors.RED, colors.ORANGE };
		Random random = new Random();

		shapeHash.put("Shape", getRandomshape(s));
		shapeHash.put("Size", random.nextInt(50 + 1 + 0) - 50);
		shapeHash.put("Color", getRandomcolor(c));
		shapeHash.put("Position", random.nextInt(50 + 1 + 0) - 50);

		System.out.println("");
		System.out.println("Shape Hash information: ");

		for (Map.Entry m : shapeHash.entrySet()) {
			System.out.println(m.getKey() + " : " + m.getValue().toString());
		}

	}

}
