import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class DetectOutlier {
	
	private final String CSV = ".csv";
	private String symbol;
	private String date;
	private LinkedList list;
	
	// constructor
	public DetectOutlier(String symbol, String date) {
		this.symbol = symbol;
		this.date = date;
		this.list = new LinkedList();
	}
	
	// getters
	
	public void getDateAndSymbol() throws FileNotFoundException {
		store();
		list.Output(date, symbol);
	}
	
	/**
	 * reformats the date
	 * @param date
	 * @return
	 * 		date in "YYYY-MM-DD" format
	 */
	public String convertDate(String date) {
		String[] array = date.split("/");
		String day = array[1].length() == 1 ? "0" + array[1] : array[1];
		String month = array[0].length() == 1 ? "0" + array[0] : array[0];
		String year = "20" + array[2];
		
		return year + "-" + month + "-" + day;
	}
	
	/**
	* scans the files and stores information
	*
	*/
	public void store() throws FileNotFoundException {
		symbol = symbol.toUpperCase();
		String newSymbol = "./" + symbol + CSV;
		String path = newSymbol;
		String line = "";
		Scanner scanner = new Scanner(new File(path));
		Scanner secondScanner;
		int i = 0;
		
		scanner.useDelimiter(",");
		while (scanner.hasNext()) {
			line = scanner.nextLine();
			secondScanner = new Scanner(line);
			secondScanner.useDelimiter(",");
			
			if (i > 0) {
				while (secondScanner.hasNext()) {
					String date = convertDate(secondScanner.next().trim());
					double openPrice = Double.parseDouble(secondScanner.next().trim());
					double highPrice = Double.parseDouble(secondScanner.next().trim());
					double lowPrice = Double.parseDouble(secondScanner.next().trim());
					double closePrice = Double.parseDouble(secondScanner.next().trim());
					double adjClosePrice = Double.parseDouble(secondScanner.next().trim());
					int volume = Integer.parseInt(secondScanner.next().trim());
					
					StockData data = new StockData(date, openPrice, highPrice, lowPrice,
							closePrice, adjClosePrice, volume);
					
					list.add(data);
				}
			}
			i++;
		}
		scanner.close();
	}
	
}
