package assignmnt;

/**
 * @author hassan
 *
 */
public class Pyramid {
	public String pharaoh ;
	public String ancientName ;
	public String modernName ;
	public int dynasty ;
	public String site ;
	public double base1 ;
	public double base2 ;
	public double height ;
	public double slope ;
	public double volume ;
	public double latitude ;
	public double longitude ;
	public String Type ;
	public String lepsius;
	public String material ;
	public String comment ;
	
	public Pyramid(String pharaoh, String ancientName, String modernName, int dynasty, String site, double base1,
			double base2, double height, double slope, double volume, double latitude, double longitude, String type,
			String lepsius, String material, String comment) {
		super();
		this.pharaoh = pharaoh;
		this.ancientName = ancientName;
		this.modernName = modernName;
		this.dynasty = dynasty;
		this.site = site;
		this.base1 = base1;
		this.base2 = base2;
		this.height = height;
		this.slope = slope;
		this.volume = volume;
		this.latitude = latitude;
		this.longitude = longitude;
		Type = type;
		this.lepsius = lepsius;
		this.material = material;
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "Pyramid [pharaoh=" + pharaoh + ", ancientName=" + ancientName + ", modernName=" + modernName
				+ ", dynasty=" + dynasty + ", site=" + site + ", base1=" + base1 + ", base2=" + base2 + ", height="
				+ height + ", slope=" + slope + ", volume=" + volume + ", latitude=" + latitude + ", longitude="
				+ longitude + ", Type=" + Type + ", lepsius=" + lepsius + ", material=" + material + ", comment="
				+ comment + "]";
	}
	
}
