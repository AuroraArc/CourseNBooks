
public class Dog {
	public int weightInPounds; //instance variable

	public Dog(int startingWeight) { //constructor: determines how to instntiate the class
		weightInPounds = startingWeight;
	}
	public void makeNoise() { //non-static mathod
		if (weightInPounds < 10) {
			System.out.println("yip!");
		}
		else if (weightInPounds < 30) {
			System.out.println("Bark!");
		}
		else {
			System.out.println("woof!");
		}
	}
}