
import java.util.*;

public class HashMapClass {

	public static void main(String[] args){
		
		//Hash Table of Values and Keys that implement Map Interface
		//Part of the Collections Framework.
		//Similar to HashTable but this one allows the use of Null values and keys.
		//No garantee that the map keeps a constant order over time for methods other than Get and Put.
		//Performance is based on the HashMap capacity (too high) and the load factor (too low).
		//Load Factor: How full the hash needs to be before increasing automatically its capacity. (Default 0.75)
		//Each time the hash modifies its capacity every pair is rehashed.
		//This is not thread safe, it must be sunchronized externally with (Collections.synchronizedMap ())
		
		System.out.println("\n --- CONSTRUCTORS ---\n");
		
			//Create empty. Capacity (16) Load Factor (0.75).
			HashMap constructorTest0 = new HashMap();
			System.out.println("0.-  Empty:                                        " + constructorTest0);
			
			//Create from Initial Capacity.
			HashMap constructorTest1 = new HashMap(20);
			System.out.println("1.-  Initial Capacity (20):                        " + constructorTest1);
			
			//Create from Initial Capacity and Initial Load Factor
			HashMap constructorTest2 = new HashMap(20, 0.5f);
			System.out.println("2.-  Initial Capacity (20) and Load Factor (0.5):  " + constructorTest2);
			
			//Create from Other Map
			HashMap mapTest = new HashMap();
			mapTest.put(1, "Hello"); mapTest.put(2, " "); mapTest.put(3, "World!");
			HashMap constructorTest3 = new HashMap(mapTest);
			System.out.println("3.-  Copy Another Map:                             " + constructorTest3);
		
		System.out.println("\n --- METHODS ---\n");
		
			HashMap test = new HashMap();
			test.put(1, "a"); test.put(2, "b"); test.put(3, "c");
			
			System.out.println("0.-  Test HashMap:                                      " + test);
			
			//Clear the HashMap from every entry
			test.clear();
			System.out.println("1.-  Clear:                                             " + test);
			test.put(1, "a"); test.put(2, "b"); test.put(3, "c");
			
			//Clone one Hashmap into another.
			//Note that the copy is a (Shallow) copy, meaning any nested structures in the keys or values is ignored.
			HashMap test2 = new HashMap();
			test2 = (HashMap)test.clone();
			System.out.println("2.-  Clone:                                             " + test2);
			
			//Tests if the hash map contains a Value with the given Key
			System.out.println("3.-  Is there a Value with Key (2):                     " + test.containsKey(2));
			
			//Tests if the hash map contains a Key with the given Value
			System.out.println("4.-  Is there a Key with the Value (c):                 " + test.containsValue("c"));
			
			//Java 8 Method additions to the Map interface that use lambdas.
			//Compute allows to perform a function on some value and then return it back into the Hashmap
			test.compute(2, (k, oldV) -> (oldV = ( oldV + " Hi" )));
			System.out.println("5.-  Compute:                                           " + test);
			
			//If no key is found or its value is Null ONLY then try to compute its new value.
			//Note that in this case we use only the value since we are creating a new one from scratch.
			test.computeIfAbsent(4, newV -> (newV =  "d" ));
			System.out.println("6.-  Compute if Abset:                                  " + test);
			
			//If the key is found ONLY then try to compute its new value.
			test.computeIfPresent(1, (k, oldV) -> (oldV = ( oldV + " Hi" )));
			System.out.println("7.-  Compute if Present:                                " + test);
			
			//Returns the number of Paired Key and Values stored in this HashMap
			System.out.println("8.-  Size of HashMap:                                   " + test.size());
			
			//Tests if the HashMap is empty
			System.out.println("9.-  Is Empty:                                          " + test.isEmpty());
			
			//Returns a "Set View" of the HashMap. A (Set) object needs to be linked to the Hashmap.
			//Any changes in the Hashmap are reflected on the set and viceversa.
			//Remember that Sets cannot contain duplicate entries. Since keys are always unique we can do this.
			Set setTest = test.entrySet();
			System.out.println("9.-  Set Entries View:                                  " + setTest);
			
			//Returns a "Set View" of the Keys in the Hashmap.
			//Any changes in the Hashmap are reflected on the set and viceversa.
			Set setTest2 = test.keySet();
			System.out.println("10.- Set Key View:                                      " + setTest2);
			
			//Returns a "Collections View" of the Values in the Hashmap.
			//Any changes in the Hashmap are reflected on the Collection and viceversa.
			Collection collectionTest = test.values();
			System.out.println("11.- Collection Values View:                            " + collectionTest);
			
			//Appends every entry of one map into another.
			HashMap test3 = new HashMap();
			test3.put(5, "e"); test3.put(6, "f");
			test.putAll(test3);
			System.out.println("12.- Append entries from another Map:                   " + test);
			
			//Add an entry only if it does not already exist.
			test.putIfAbsent(7, "g");
			System.out.println("13.- Put if absent from the Hashmap:                    " + test);
			
			//Search and return the value based on the key
			System.out.println("14.- Get Value form Key (6):                            " + test.get(6));
			
			//Search and return the value based on the key, if it is not found return the second argument.
			System.out.println("15.- Get Value form Key (8) or default \"No\":            " + test.getOrDefault(8, "No"));
			
			//Apply a function to every entry on the map
			System.out.print("16.- Call a function for every entry:                  ");
			test.forEach( (k,v) -> System.out.print(" (" + k + " - " + v + ") ") );
			System.out.println();
			
			//Remove the Key (and therefore its value) from the Hashmap
			//This method returns the value that it deletes in case you want to store it somewhere.
			test.remove(5);
			System.out.println("17.- Remove Key from Hashmap (5):                       " + test);
			
			//Remove the Key (ant its value) from the Hashmap ONLY if it currently has the specified Value
			//This method returns true if the key had that value and was deleted succefully
			test.remove(3, "c");
			System.out.println("18.- Remove Key (3) if Value is (c):                    " + test);
			
			//Replace the value of a key if the key exists in the Hashmap
			//This method returns the value that it replaces in case you want to store it somewhere.
			test.replace(6, "x");
			System.out.println("19.- Replace Key (6) with value (x):                    " + test);
			
			//Replace the value of a key ONLY if it currently has the specified Value
			//This method returns true if the key had that value and was replaced succefully
			test.replace(4, "z", "d");
			System.out.println("20.- Replace Key (4) with value (z) if value is (d):    " + test);
			
			//Repace the Value for every Key entry on the map
			test.replaceAll( (k, v) -> "a" );
			System.out.println("21.- Replace every Key Value (a):                       " + test);
			
			
			//Merge two Hashmaps. If their keys are the same then perform a function to get the new value.
			HashMap test4 = new HashMap();
			test4.put(2, "T"); test4.put(6, "T");
			test4.forEach((k, v) -> test.merge(k, v, (v1, v2) -> v1.toString() + v2.toString()));
			System.out.println("22.- Merge Hashmaps with same keys (2 and 6):           " + test);
			
		
		
	}
	
}
