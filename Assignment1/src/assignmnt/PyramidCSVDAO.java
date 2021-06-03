package assignmnt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class PyramidCSVDAO {
	
	
	

	ArrayList<Pyramid> pyramids ;
	
	public PyramidCSVDAO( ) {
		
		ArrayList<Pyramid> pyramids = new ArrayList<Pyramid>() ;
		
	}
	
	
	public ArrayList<Pyramid> readPyramidsFromCSV(String filename) {
		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		        String[] values = line.split(",");
		        pyramids.add(new Pyramid(values[0], values[1], values[2], Integer.parseInt(values[3]), values[4], Double.parseDouble(values[5]),
		        		Double.parseDouble(values[6]), Double.parseDouble(values[7]), values[8] == null ? -1 : Double.parseDouble(values[8]), values[9] == null ? -1 :  Double.parseDouble(values[9]),
		        		Double.parseDouble(values[10]), Double.parseDouble(values[11]), values[12], values[13] == null ? "" :  values[13], values[14], values[15] == null ? "" : values[15]));
		    }
		}
		catch(Exception e) {
			  //  Block of code to handle errors
			System.out.println(e.toString());
			System.out.println("Check file name");
			}
		return pyramids;
		
	}
	
	
	
	
	
}
