package core.model;

import java.util.Objects;

public class Location {
	public final int x; //Public because it is impossible to modify the object, and getting it directly is easier than using getters
	public final int y;
	private Location(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public static Location of(int x, int y) {
		return new Location(x, y);
	}
	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Location))
			return false;
		Location other = (Location) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Location [x=" + x + ", y=" + y + "]";
	}
	
}