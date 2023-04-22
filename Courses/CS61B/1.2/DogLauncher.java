/** The DogLauncher class will "test drive" the Dog class */
public class DogLauncher {
	public static void main(String[] args) {
		Dog smallDog; //declaration of a Dog variable
		new Dog(20); //instantiation of the Dog class as a Dog object
		smallDog = new Dog(5); //instantiate and assignment;
		Dog hugeDog = new Dog(150); //declaration, instantiation, assignmet
		smallDog.makeNoise();
		hugeDog.makeNoise();
	}
}