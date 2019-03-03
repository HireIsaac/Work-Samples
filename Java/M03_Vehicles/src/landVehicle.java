
import java.util.Random;

public class landVehicle extends vehicle {
	int gasPedal = 0;
	int brakePedal = 0;
	String wheelAllign = "Center";
	Random rand = new Random();
	int[] directions = {0,90,180,270};
	
	
	public landVehicle (int ID) {
		this.ID=ID;
		this.x = rand.nextInt(10) +10;
		this.y = rand.nextInt(10) +10;
		this.z = rand.nextInt(10) +10;
		this.direction = directions[rand.nextInt(3)];
	}
	
	
	public void turn(String wheelAllign) {
		this.wheelAllign=wheelAllign;
	}
	
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
	
	
	
	
	
	public void setGas(int gas) {
		this.gasPedal=gas;
	}
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
