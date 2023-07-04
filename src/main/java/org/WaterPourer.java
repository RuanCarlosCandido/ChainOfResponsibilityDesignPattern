package org;

import java.util.function.Supplier;

public class WaterPourer implements Handler {
	private Handler next;
	private Supplier<Boolean> condition;

	@Override
	public void setNext(Handler handler) {
		this.next = handler;
	}

	@Override
	public void handle(Coffee coffee) {
		if (condition == null || condition.get()) {

			System.out.println("Pouring water into the coffee maker...");
			// The coffee is still not ready
			coffee.setWaterPoured(true);
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
