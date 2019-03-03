
public class vehicle extends Thread {
	int x;
	int y;
	int z = 0;
	int dx;
	int dy;
	int dz;
	int direction = 0;
	int speed;
	int ID;
	
	
	public void run() {
		
		for (int i = 0; i < 1000000; i++) {
			this.move();
			System.out.println("Current X: " + this.x + "\nCurrent Y: " + this.y + "\nCurrent Z: " + this.z + "\nCurrent direction: " +this.direction + "\nID: " +this.ID);
			System.out.println();

			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void move() {
		
	}
}
