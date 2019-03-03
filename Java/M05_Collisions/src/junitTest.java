import static org.junit.Assert.*;

import org.junit.Test;

public class junitTest {

	@Test
	public void test() {
		//air vehicle and land with same x,y,z
		airVehicle a = new airVehicle(1,1,0);
		landVehicle b = new landVehicle(1,1,0);
		boolean result = a.collisionCheck(b);
		boolean expected = true;
		assertEquals(result, expected);
		
		//air vehicle and land with same x + z, y hitboxes will collide
		airVehicle a2 = new airVehicle(1,11,0);
		landVehicle b2 = new landVehicle(1,1,0);
		boolean result2 = a2.collisionCheck(b2);
		boolean expected2 = true;
		assertEquals(result2, expected2);
		
		//air vehicle and land with same x + z, near miss on y hitboxes
		airVehicle a3 = new airVehicle(1,12,0);
		landVehicle b3 = new landVehicle(1,1,0);
		boolean result3 = a3.collisionCheck(b3);
		boolean expected3 = false;
		assertEquals(result2, expected2);
		
		//air and land with same x,y, different z, will miss
		airVehicle a4 = new airVehicle(1,1,1);
		landVehicle b4 = new landVehicle(1,1,0);
		boolean result4 = a4.collisionCheck(b4);
		boolean expected4 = false;
		assertEquals(result4, expected4);
		
		//air and air with same x,y,z, will hit
		airVehicle a5 = new airVehicle(1,1,1);
		airVehicle b5 = new airVehicle(1,1,1);
		boolean result5 = a5.collisionCheck(b5);
		boolean expected5 = true;
		assertEquals(result5, expected5);
		
		//Checking against itself, should fail
		airVehicle a6 = new airVehicle(1,1,1);
		boolean result6 = a6.collisionCheck(a6);
		boolean expected6 = false;
		assertEquals(result6, expected6);
		
		//WAYYY off
		airVehicle a7 = new airVehicle(1,1,1);
		airVehicle b7 = new airVehicle(100,100,10);
		boolean result7 = a7.collisionCheck(a7);
		boolean expected7 = false;
		assertEquals(result7, expected7);
		
		//air vehicle and land with same z, x + y hitboxes will collide
		airVehicle a8 = new airVehicle(11,11,0);
		landVehicle b8 = new landVehicle(1,1,0);
		boolean result8 = a8.collisionCheck(b8);
		boolean expected8 = true;
		assertEquals(result8, expected8);
		
		//air vehicle and land with same z, x hitboxes will collide, y won't
		airVehicle a9 = new airVehicle(11,12,0);
		landVehicle b9 = new landVehicle(1,1,0);
		boolean result9 = a9.collisionCheck(b9);
		boolean expected9 = false;
		assertEquals(result9, expected9);
		
		//Check for two land vehicles. Same x/y/z
		landVehicle a10 = new landVehicle(1,1,0);
		landVehicle b10 = new landVehicle(1,1,0);
		boolean result10 = a10.collisionCheck(b10);
		boolean expected10 = true;
		assertEquals(result10,expected10);
		
		
	}

}
