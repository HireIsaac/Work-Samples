package vehicles;

import java.awt.Color;
import java.awt.Graphics;

public class SAM extends vehicle{

	public SAM (int ID) {
		this.ID=ID;
		this.z = 0;
		this.dz = 0.1;
		this.type = "SAM";
		
		
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
