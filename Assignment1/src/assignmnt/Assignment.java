package assignmnt;

import java.util.ArrayList;

public class Assignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PyramidCSVDAO pDAO = new PyramidCSVDAO() ;
		
		ArrayList<Pyramid> pyramids = pDAO.readPyramidsFromCSV("pyramids.csv") ;
		
		int i = 0 ;
		for(Pyramid p:pyramids) {
			System.out.println(p) ;
		}
		
	}

}
