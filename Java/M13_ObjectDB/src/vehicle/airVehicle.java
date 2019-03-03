package vehicle;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.persistence.Entity;

@Entity
public class airVehicle extends vehicle {
	double pedal = 50;
	String vertAllign = "Level";
	int[] directions = {0,90,180,270};
	
	
	public airVehicle () {
		this.x = 10;
		this.y = -10;
		this.z = 0;
	}
	
	public airVehicle(String ID, double x, double y, double z, double speed, int direction) {
		this.ID = ID;
		this.x = x;
		this.y = y;
		this.z = z;
		this.speed = speed;
		this.direction = direction;
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
