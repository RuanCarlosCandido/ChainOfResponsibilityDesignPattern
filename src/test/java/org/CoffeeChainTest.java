package org;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoffeeChainTest {
    @Test
    void testHandlerWithoutBuild() {
        Coffee coffee = new Coffee();
        Handler grinder = new Grinder();
        Handler coffeeAdder = new CoffeeAdder();

        // Without calling buildAndResult(), the chain won't be executed
        HandlerChainBuilder.create()
                .handler(grinder)
                .mediator(coffeeAdder);

        // Since the chain was not executed, the coffee is not ready
        assertFalse(coffee.isCoffeeReady());
    }

    @Test
    void testHandlerWithoutMediator() {
        Coffee coffee = new Coffee();
        Handler grinder = new Grinder();
        Handler waterPourer = new WaterPourer();

        // Without a mediator after the grinder, the waterPourer won't be executed
        HandlerChainBuilder.create()
                .handler(grinder)
                .handler(waterPourer)
                .buildAndResult(coffee);

        // Since the waterPourer was not executed, the coffee is not ready
        assertFalse(coffee.isCoffeeReady());
    }

    @Test
    void testCompleteChain() {
        Coffee coffee = new Coffee();
        Handler grinder = new Grinder();
        Handler coffeeAdder = new CoffeeAdder();
        Handler waterPourer = new WaterPourer();
        Handler coffeeMaker = new CoffeeMaker();
        Handler coffeeServer = new CoffeeServer();

        HandlerChainBuilder.create()
                .handler(grinder)
                .mediator(coffeeAdder)
                .handler(waterPourer).when(coffee::isCoffeeAdded)
                .mediator(coffeeMaker)
                .handler(coffeeServer).when(coffee::isCoffeeMade)
                .buildAndResult(coffee);

        // After executing the complete chain, the coffee should be ready
        assertTrue(coffee.isCoffeeReady());
    }
    
    @Test
    void testHandlerStopsWhenConditionNotMet() {
        Coffee coffee = new Coffee();
        Handler grinder = new Grinder();
        Handler waterPourer = new WaterPourer();
        Handler coffeeMaker = new CoffeeMaker();
        Handler coffeeServer = new CoffeeServer();

        // We add a condition that the coffee is ready before the coffeeMaker, which it isn't, so the chain should stop there
        HandlerChainBuilder.create()
                .handler(grinder)
                .mediator(waterPourer).when(coffee::isCoffeeReady)
                .handler(coffeeMaker)
                .mediator(coffeeServer)
                .buildAndResult(coffee);

        // The coffee is not ready, as the chain was stopped
        assertFalse(coffee.isCoffeeReady());
    }

    @Test
    void testChainWithoutHandlers() {
        Coffee coffee = new Coffee();

        // Create a chain without any handlers
        HandlerChainBuilder.create()
                .buildAndResult(coffee);

        // The coffee is not ready, as there were no handlers to prepare it
        assertFalse(coffee.isCoffeeReady());
    }
}