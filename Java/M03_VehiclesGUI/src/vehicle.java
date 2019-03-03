import java.awt.Graphics;

public abstract class vehicle extends Thread {
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
			this.boundCheck();
			System.out.println("x/y/z" + this.x + "," + this.y + "," + this.z);
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
	
	public abstract void paint(Graphics g);
	
	public void boundCheck(){
		if (this.x > 500 || this.x < 0) {
			this.dx = this.dx * -1;
			if (this.direction == 90) {
				this.direction = 270;
			} else {
				this.direction = 90;
			}
		}
		
		if (this.y > 0 || this.y < -500) {
			this.dy = this.dy * -1;
			if (this.direction == 0) {
				this.direction = 180;
			} else {
				this.direction = 0;
			}
		}
		
		
	}
}
