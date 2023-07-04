package org;

import java.util.function.Supplier;

public class HandlerChainBuilder {
    private Handler head;
    private Handler tail;

    public static HandlerChainBuilder create() {
        return new HandlerChainBuilder();
    }

    public HandlerChainBuilder handler(Handler handler) {
        if (head == null) {
            head = handler;
            tail = handler;
        } else {
            tail.setNext(handler);
            tail = handler;
        }
        return this;
    }

    public HandlerChainBuilder mediator(Handler mediator) {
        return handler(mediator);
    }

    public HandlerChainBuilder when(Supplier<Boolean> condition) {
        if (tail != null) {
            tail.setCondition(condition);
        }
        return this;
    }

    public Coffee buildAndResult(Coffee coffee) {
        if (head != null) {
            head.handle(coffee);
        }
        System.out.println("finished process.");
        return coffee;
    }
}