package vehicles;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class motorcycle extends vehicle {
	double gasPedal = 0;
	double brakePedal = 0;
	
	
	Random rand = new Random();
	int[] directions = {0,90,180,270};
	
	
	public motorcycle (int ID) {
		this.ID=ID;
		this.x = rand.nextInt(10) +10;
		this.y = -10;
		this.z = 0;
		this.direction = directions[rand.nextInt(3)];
	}
	
	
	
	
	
	public void setGas(int gas) {
		this.gasPedal=gas;
	}
	public void setBrake(int brake) {
		this.brakePedal=brake;
	}
	
	
	
	
	
	@Override
	public void move() {
		if (!isCrashed) {
			this.setGas(500);
			this.speed = (this.gasPedal - this.brakePedal);
			
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
			this.x = this.x + (this.dx/1000);
			this.y = this.y + (this.dy/1000);
		
		}
	}
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.BLACK);
		g.fillRect((int)this.x, -(int)this.y, this.vWidth, this.vHeight);
		
	}
	
	
	@Override
	public void collide() {
		this.dx=0;
		this.dy=0;
		this.isCrashed = true;

	}

}
