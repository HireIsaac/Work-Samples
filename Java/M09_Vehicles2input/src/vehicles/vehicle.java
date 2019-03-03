package vehicles;
import java.awt.Graphics;
import java.util.Random;

public abstract class vehicle extends Thread {
	double x;
	double y;
	double z = 0;
	double dx;
	double dy;
	double dz;
	int direction = 0;
	double speed;
	int ID;
	int vWidth = 10;
	int vHeight = 10;
	int screenW = 1000;
	int screenH = 1000;
	int marginScreen = 30;
	String wheelAllign = "Center";
	Random rand = new Random();
	boolean isCrashed = false;
	String type;
	
	public int getInitX() {
		return rand.nextInt(((screenW-marginScreen) - marginScreen) + 1) + marginScreen;
	}
	
	public int getInitY() {
		return rand.nextInt(((-1 * marginScreen) - ((-1 * screenH) - (-1 * marginScreen))) + 1) + (-1 * screenH) - (-1 * marginScreen);
	}
	
	public void run() {
		this.x = this.getInitX();
		this.y = this.getInitY();
		
		for (int i = 0; i < 1000000; i++) {
			
			this.move();
			this.boundCheck();
			//System.out.println("x/y/z" + this.x + "," + this.y + "," + this.z);
			//System.out.println();

			
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void move() {
		
	}
	
	public abstract void paint(Graphics g);
	
	
	public void registerTurn() {
		if (this.wheelAllign == "Center") {
			return;
		} else {
			if (this.wheelAllign == "Left") {
				this.direction -= 90;
				this.wheelAllign = "Center";
				if (this.direction == -90) {
					this.direction = 270;
				}
				return;
			}else {
				this.direction += 90;
				this.wheelAllign = "Center";
				if (this.direction == 360) {
					this.direction = 0;
				}
				return;
			}
		}
		
	}
	
	public void boundCheck(){
		if (this.x > this.screenW || this.x < 0) {
			this.dx = this.dx * -1;
			if (this.direction == 90) {
				this.direction = 270;
			} else {
				this.direction = 90;
			}
		}
		
		if (this.y > 0 || this.y < (-1 * this.screenH)) {
			this.dy = this.dy * -1;
			if (this.direction == 0) {
				this.direction = 180;
			} else {
				this.direction = 0;
			}
		}
		
		
	}
	

	public boolean collisionCheck(vehicle v2) {
		if (this == v2) {
			
			return false;
		}
		
		if (this.x >= v2.x && this.x <= v2.x + v2.vWidth) {
			
			if (this.y >= v2.y && this.y  <= v2.y + v2.vHeight) {
				
				if(this.z == v2.z) {

					return true;
				}
			}
		}
		return false;
		
	}
	
	public void collide() {
		this.direction += 180;
	
		if (this.direction == 360) {
			this.direction = 0;
		}
		if (this.direction == 450) {
			this.direction = 90;
		}
	}
	
	public void explode(vehicle v2) {
		this.isCrashed =true;
		this.dx=0;
		this.dy=0;
		this.dz=0;
		this.speed = 0;
		v2.isCrashed=true;
		v2.dx=0;
		v2.dy=0;
		v2.dz=0;
		v2.speed = 0;
		System.out.println("explode");
		
	}
	
	
	
	
	
	
}
