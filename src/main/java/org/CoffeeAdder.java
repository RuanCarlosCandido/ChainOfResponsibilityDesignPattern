package org;

import java.util.function.Supplier;

public class CoffeeAdder implements Handler {
	private Handler next;
	private Supplier<Boolean> condition;

	@Override
	public void setNext(Handler handler) {
		this.next = handler;
	}

	@Override
	public void handle(Coffee coffee) {
		if (condition == null || condition.get()) {
			System.out.println("Adding coffee to the coffee maker...");
			coffee.setCoffeeAdded(true);
			// The coffee is not ready yet
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
