import java.util.*;
import java.io.FileNotFoundException;

public class Driver {
	public static void main (String[] args) throws FileNotFoundException {
		System.out.println();
		Scanner s = new Scanner(System.in);
		System.out.println("Stock Symbol: ");
		
		String stockSymbol = s.nextLine().trim();
		System.out.println("Starting date: ");
		
		String startingDate = s.nextLine().trim();
		s.close();
		
		DetectOutlier outlier = new DetectOutlier(stockSymbol, startingDate);
		outlier.getDateAndSymbol();
	}
}
