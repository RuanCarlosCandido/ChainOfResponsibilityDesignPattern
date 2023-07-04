package org;

import java.util.function.Supplier;

public class CoffeeServer implements Handler {
	private Handler next;
	private Supplier<Boolean> condition;

	@Override
	public void setNext(Handler handler) {
		this.next = handler;
	}

	@Override
	public void handle(Coffee coffee) {
		if (condition == null || condition.get()) {
			System.out.println("Serving the coffee...");
			// The coffee is served, it's ready to be consumed
			coffee.setCoffeeServed(true);
			coffee.setCoffeeReady(true);
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