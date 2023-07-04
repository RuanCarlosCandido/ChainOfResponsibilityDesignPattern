package org;

import java.util.function.Supplier;

public class Grinder implements Handler {
	private Handler next;
	private Supplier<Boolean> condition;

	@Override
	public void setNext(Handler handler) {
		this.next = handler;
	}

	@Override
	public void handle(Coffee coffee) {
		if (condition == null || condition.get()) {
			System.out.println("Grinding coffee beans...");
			// Here you can put some logic to determine the state of the coffee
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