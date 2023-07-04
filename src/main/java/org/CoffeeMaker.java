package org;

import java.util.function.Supplier;

public class CoffeeMaker implements Handler {
	private Handler next;
	private Supplier<Boolean> condition;

	@Override
	public void setNext(Handler handler) {
		this.next = handler;
	}

	@Override
	public void handle(Coffee coffee) {
		if (condition == null || condition.get()) {

			System.out.println("Starting the coffee maker...");
			// The coffee is getting ready
			coffee.setCoffeeMade(true);
			if (next != null) {
				next.handle(coffee);
			}
		}
	}

	@Override
	public void setCondition(Supplier<Boolean> condition) {
		this.condition = condition;
		
	}
}
