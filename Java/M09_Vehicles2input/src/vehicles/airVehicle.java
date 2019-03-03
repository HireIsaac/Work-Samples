package vehicles;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class airVehicle extends vehicle {
	double pedal = 50;
	String vertAllign = "Level";
	
	Random rand = new Random();
	int[] directions = {0,90,180,270};
	
	
	public airVehicle (int ID) {
		this.ID=ID;
		this.x = rand.nextInt(10) +10;
		this.y = -10;
		this.z = 0;
		this.direction = directions[rand.nextInt(3)];
	}
	
	public void turn(String wheelAllign) {
		this.wheelAllign=wheelAllign;
	}
	
	
	
	public void registerVertTurn() {
		if (this.vertAllign == "Level") {
			return;
		} else {
			if (this.vertAllign == "Up") {
				this.pedal += 1;
				this.vertAllign = "Level";
				return;
				
			} else {
				this.pedal -= 1;
				this.vertAllign = "Level";
				return;
			}
		}
		
	}
	
	
	
	
	@Override
	public void move() {
		if (!isCrashed) {
			this.speed = this.pedal;
			this.dz = this.pedal - 50;
			
			
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
			this.registerVertTurn();
			
			this.x= this.x + this.dx/1000;
			this.y= this.y + this.dy/1000;
			this.z=this.z + this.dz;
		}
	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.BLUE);
		g.fillRect((int)this.x, -(int)this.y, this.vWidth, this.vHeight);
		
		
	}
	
	

}
