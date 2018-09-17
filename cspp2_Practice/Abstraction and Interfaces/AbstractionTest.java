/**
 * Abstact class can have the following in its decleraion.
 * Must be declared with abstract keyword.
 * Can have both abstract and non-abstract methods.
 * It cannot be instantiated.
 * It can have final method and cannot be overridden.
 * It can have constructor and also static methods.
 */
/**
 * Class for bike.
 */
abstract class Bike {
	Bike() {
		System.out.println("Bike is created.");
	}
	/**
	 * abstract method run
	 */
	abstract void run();
	void changeGear(){
		System.out.println("Gear changed in Bike");
	}
	/**
	 * idle and it cannot be overriden.
	 *
	 * @return     { description_of_the_return_value }
	 */
	final void idle(){
		System.out.println("Idle.....");
	}
	/**
	 * Can be overidden but the keyword static must remain the same.
	 */
	static void engine(){
		System.out.println("Bike amazing");
	}
}

class Honda extends Bike {
	void run() {
		System.out.println("Honda bike running safely");
	}
	void changeGear() {
		System.out.println("Gear changed in Honda");
	}
	static void engine(){
		System.out.println("Honda amazing");
	}
}

class AbstractionTest {
	public static void main(String[] args) {
	//Bike b = new Bike(); throws compile time error as Bike is an abstract class and it can't be instantiated.
	//Bike b = new Honda(); But this works fine.
	Honda b = new Honda();
	b.run();
	b.changeGear();	
	b.idle();
	b.engine();
	}
}