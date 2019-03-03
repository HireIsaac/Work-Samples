import java.util.Random;

public class myCar extends Thread implements vehicle, landVehicle {

	
	int x;
	int y;
	int z = 0;
	int dx;
	int dy;
	int dz;
	int direction = 0;
	int speed;
	int ID;
	int gasPedal = 0;
	int brakePedal = 0;
	String wheelAllign = "Center";
	Random rand = new Random();
	int[] directions = {0,90,180,270};
	
	public myCar (int ID) {
		this.ID=ID;
		this.x = rand.nextInt(10) +10;
		this.y = rand.nextInt(10) +10;
		this.z = rand.nextInt(10) +10;
		this.direction = directions[rand.nextInt(3)];
	}
	
	
	public void run() {
		
		for (int i = 0; i < 1000000; i++) {
			this.move();
			System.out.println("Current X/Y/Z: " + this.x + "," + this.y + "," + this.z);
			System.out.println();

			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	@Override
	public void turn(String wheelAllign) {
		this.wheelAllign=wheelAllign;
	}

	@Override
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

	@Override
	public void setGas(int gas) {
		this.gasPedal=gas;
		
	}

	@Override
	public void setBrake(int brake) {
		this.brakePedal=brake;
		
	}

	@Override
	public void move() {
this.speed = this.gasPedal - this.brakePedal;
		
		if (this.direction == 0) {
			this.dx = 0;
			this.dy = this.speed;
		}
		if (this.direction == 90) {
			this.dy = 0;
			this.dx = this.speed;
		}
		if (this.direction == 180) {
			this.dx = 0;
			this.dy = this.speed;
			this.dy = this.dy * -1;
		}
		if (this.direction == 270) {
			this.dy = 0;
			this.dx = this.speed;
			this.dx = this.dx * -1;
		}
		
		this.registerTurn();
		this.x = this.x + this.dx;
		this.y = this.y + this.dy;
		
	}

}