package TaskWorkHomework2.ITCompany;

public enum Rating {
    A(1.2),
    B(1.15),
    C(1.05),
    D(0),
    E(0.95);

    private final double value;

    Rating(double value) {
        this.value = value;
    }

    public double getRatingScore() {
        return value;
    }
}