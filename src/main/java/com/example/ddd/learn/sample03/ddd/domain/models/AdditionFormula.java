package com.example.ddd.learn.sample03.ddd.domain.models;

import java.util.Objects;

public class AdditionFormula {
    private final AdditionElement element1;
    private final AdditionElement element2;
    private final AdditionElement result;

    public AdditionFormula(AdditionElement e1, AdditionElement e2, AdditionElement result) {
        this.element1 = e1;
        this.element2 = e2;
        this.result = result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AdditionFormula)) return false;
        AdditionFormula that = (AdditionFormula) o;
        return Objects.equals(element1, that.element1) && Objects.equals(element2, that.element2) && Objects.equals(result, that.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(element1, element2, result);
    }

    public int getElement1Value() {
        return this.element1.getValue();
    }
    public int getElement2Value() {
        return this.element2.getValue();
    }
    public int getResultValue() {
        return this.result.getValue();
    }
}
