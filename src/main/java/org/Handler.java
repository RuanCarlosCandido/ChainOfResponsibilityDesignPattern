package org;

import java.util.function.Supplier;

// Handler.java
public interface Handler {
    void setNext(Handler handler);
    void handle(Coffee coffee);
    void setCondition(Supplier<Boolean> condition);
}