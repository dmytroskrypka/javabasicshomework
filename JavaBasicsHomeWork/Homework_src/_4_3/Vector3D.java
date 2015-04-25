package _4_3;

public class Vector3D {
 private int x;
 private int y;
 private int z;

 public Vector3D() {
 x=0;
 y=0;
 z=0;
}
public Vector3D(int x, int y, int z) {
	this.x = x;
	this.y = y;
	this.z = z;
}
public int getX() {
	return x;
}
public void setX(int x) {
	this.x = x;
}
public int getY() {
	return y;
}
public void setY(int y) {
	this.y = y;
}
public int getZ() {
	return z;
}
public void setZ(int z) {
	this.z = z;
}



@Override
public String toString() {
	return "Vector3D [x=" + x + ", y=" + y + ", z=" + z + "]";
}

public int SumProduct(Vector3D a) {
	return this.x * a.getX() +
			this.y * a.getY() +
			this.z * a.getZ();
}

public static int SumProduct(Vector3D a, Vector3D b) {
	return b.getX() * a.getX() +
			b.getY() * a.getY() +
			b.getZ() * a.getZ();
}

public Vector3D CrossProduct(Vector3D a) {
	Vector3D c = new Vector3D(
			this.y*a.getZ()-this.z*a.getY(),
			this.z*a.getX()-this.x*a.getZ(),
			this.x*a.getY()-this.y*a.getX());
	
		return c;
}

public static Vector3D CrossProduct(Vector3D a, Vector3D b) {
	Vector3D c = new Vector3D(
			a.getY()*b.getZ()-a.getZ()*b.getY(),
			a.getZ()*b.getX()-a.getX()*b.getZ(),
			a.getX()*b.getY()-a.getY()*b.getX());
	
		return c;
}  
}
