package vehicle;

import java.awt.Color;
import java.awt.Graphics;
import javax.persistence.Entity;

@Entity
public class SAM extends vehicle{

	public SAM () {
		this.ID=ID;
		this.z = 0;
		this.dz = 0.1;
		this.type = "SAM";
		
		
	}
	
	public SAM(String ID, double x, double y, double z, double speed, int direction) {
		this.ID = ID;
		this.x = x;
		this.y = y;
		this.z = z;
		this.speed = speed;
		this.direction = direction;
	}
	
	@Override
	public void move() {
		if (!isCrashed) {
			this.z = this.z + this.dz;
			if(this.z>100) {
				this.isCrashed=true;
			}
		}
	}
	
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.GREEN);
		g.fillRect((int)this.x, -(int)this.y, this.vWidth, this.vHeight);
	}

}
