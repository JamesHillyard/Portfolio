package objects;

import javax.validation.constraints.*;

public class Numbers {

    @Min(10)
    private int minimum;

    @Max(100)
    private int maximum;

    @Min(1)
    @Max(5)
    private int quantity;

    @DecimalMax("1.0")
    private double decimalMax;

    @DecimalMin("1.5")
    private double decimalMin;

    @Negative
    private int negative;

    @NegativeOrZero
    private int negativeOrZero;

    @Positive
    private int positive;

    @PositiveOrZero
    private int positiveOrZero;

    @Digits(integer = 3, fraction = 2)
    private double digits;

    // Constructor

    public Numbers(int minimum, int maximum, int quantity, double decimalMax, double decimalMin, int negative, int negativeOrZero, int positive, int positiveOrZero, double digits) {
        this.minimum = minimum;
        this.maximum = maximum;
        this.quantity = quantity;
        this.decimalMax = decimalMax;
        this.decimalMin = decimalMin;
        this.negative = negative;
        this.negativeOrZero = negativeOrZero;
        this.positive = positive;
        this.positiveOrZero = positiveOrZero;
        this.digits = digits;
    }


    // Getter & Setter

    public int getMinimum() {
        return minimum;
    }

    public void setMinimum(int minimum) {
        this.minimum = minimum;
    }

    public int getMaximum() {
        return maximum;
    }

    public void setMaximum(int maximum) {
        this.maximum = maximum;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getDecimalMax() {
        return decimalMax;
    }

    public void setDecimalMax(double decimalMax) {
        this.decimalMax = decimalMax;
    }

    public double getDecimalMin() {
        return decimalMin;
    }

    public void setDecimalMin(double decimalMin) {
        this.decimalMin = decimalMin;
    }

    public int getNegative() {
        return negative;
    }

    public void setNegative(int negative) {
        this.negative = negative;
    }

    public int getNegativeOrZero() {
        return negativeOrZero;
    }

    public void setNegativeOrZero(int negativeOrZero) {
        this.negativeOrZero = negativeOrZero;
    }

    public int getPositive() {
        return positive;
    }

    public void setPositive(int positive) {
        this.positive = positive;
    }

    public int getPositiveOrZero() {
        return positiveOrZero;
    }

    public void setPositiveOrZero(int positiveOrZero) {
        this.positiveOrZero = positiveOrZero;
    }

    public double getDigits() {
        return digits;
    }

    public void setDigits(double digits) {
        this.digits = digits;
    }
}
