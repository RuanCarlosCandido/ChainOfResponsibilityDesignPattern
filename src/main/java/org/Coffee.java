package org;

public class Coffee {
	private boolean isCoffeeAdded = false;
	private boolean isWaterPoured = false;
	private boolean isCoffeeMade = false;
	private boolean isCoffeeServed = false;
	private boolean isCoffeeReady = false;

	public boolean isCoffeeAdded() {
		return isCoffeeAdded;
	}

	public void setCoffeeAdded(boolean isCoffeeAdded) {
		this.isCoffeeAdded = isCoffeeAdded;
	}

	public boolean isWaterPoured() {
		return isWaterPoured;
	}

	public void setWaterPoured(boolean isWaterPoured) {
		this.isWaterPoured = isWaterPoured;
	}

	public boolean isCoffeeMade() {
		return isCoffeeMade;
	}

	public void setCoffeeMade(boolean isCoffeeMade) {
		this.isCoffeeMade = isCoffeeMade;
	}

	public boolean isCoffeeServed() {
		return isCoffeeServed;
	}

	public void setCoffeeServed(boolean isCoffeeServed) {
		this.isCoffeeServed = isCoffeeServed;
	}

	public boolean isCoffeeReady() {
		return isCoffeeReady;
	}

	public void setCoffeeReady(boolean isCoffeeReady) {
		this.isCoffeeReady = isCoffeeReady;
	}

}
