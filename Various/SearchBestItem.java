package Various;

import java.util.HashMap;

/**
 SearchBestItem
 <p>This program searches a list of items using a HasMap for the item(s) with a value equal to or lower than a specified max value.
 <p>If it finds multiple items it returns all of them.
 
 @author Dario Arzaba
 @version 1.0
 */

public class SearchBestItem {
	
	double maxPrice;
	HashMap<String, Double> listItems = new HashMap<String, Double>();
	
	/**
	 This constructor creates the Hashmap using seven default items as the data.
	 */
	public SearchBestItem() {
		listItems.put("Banana", 95.0);
		listItems.put("Pear", 83.89);
		listItems.put("Orange", 98.5);
		listItems.put("Pineapple", 114.0);
		listItems.put("Watermelon", 103.0);
		listItems.put("Peach", 200.0);
		listItems.put("Apple", 98.5);
		this.maxPrice = 100.0;
	}
	
	/**
	 This constructor allows the use of an independent hashmap and max value as the data for the search.
	 
	 @param list Hashmap of String and Double values to search for the best item(s).
	 */
	public SearchBestItem(HashMap<String, Double> list, double maxValue) {
		this.listItems = list;
		this.maxPrice = maxValue;
	}
	
	/**
	 This method iterates and generates the list of items that are closest to the max value.
	 @return bestOffers HashMap with the item(s) that where the closest to the specified max value.
	 */
	public HashMap<String, Double> getBestItems () {
		
		HashMap<String, Double> listItemsTemp = listItems;
		HashMap<String, Double> bestOffers = new HashMap<String, Double>();
		
		//Remove entries that are above de max value.
		listItemsTemp.entrySet().removeIf(entry -> (entry.getValue() > maxPrice) );
		
		//Search the entries in the list for the item with the max value
		double highestPrice = listItemsTemp.entrySet().stream().max( (e1, e2) -> (
				(e1.getValue()>e2.getValue()) ? 1 : -1
			)
		).get().getValue();
		
		//Put the entries that are equal to the highest value found on the results list.
		listItemsTemp.forEach( (item, value) -> {
			if (value == highestPrice){
				bestOffers.put(item, value);
			}
		});
		
		return bestOffers;
	
	}
	
	/**
	 This method prints the list of items that got closer to the specified max value.
	 */
	public void printBestItems () {
		HashMap<String, Double> bestOffers = getBestItems();
		System.out.println("Best Offers: \n");
		bestOffers.forEach( (item, price) -> {
			System.out.println("Product: " + item + "  Price: " + price);
		});
	}
	
	public double getMaxPrice() {
		return maxPrice;
	}
	public void setMaxPrice(double maxPrice) {
		this.maxPrice = maxPrice;
	}
	public HashMap<String, Double> getListItems() {
		return listItems;
	}
	public void setListItems(HashMap<String, Double> listItems) {
		this.listItems = listItems;
	}
	
}


