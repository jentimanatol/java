public class UtilityCalculator {
    // Prices
    public static final double SWING_PRICE = 10.0;
    public static final double SALSA_PRICE = 12.0;

    // Initial data
    public static final int[] QUANTITY_SWING = {1, 2, 3, 5, 6, 8};
    public static final int[] QUANTITY_SALSA = {2, 3, 5, 6, 5, 9};
    public static final int[] MARGINAL_UTILITY_SWING = {14, 27, 60, 100, 120, 145};
    public static final int[] MARGINAL_UTILITY_SALSA = {18, 26, 75, 120, 110, 150};

    public static double[] calculateSwingRatios() {
        double[] swingRatios = new double[QUANTITY_SWING.length];
        for (int i = 0; i < QUANTITY_SWING.length; i++) {
            swingRatios[i] = (double) MARGINAL_UTILITY_SWING[i] / SWING_PRICE;
        }
        return swingRatios;
    }

    public static double[] calculateSalsaRatios() {
        double[] salsaRatios = new double[QUANTITY_SALSA.length];
        for (int i = 0; i < QUANTITY_SALSA.length; i++) {
            salsaRatios[i] = (double) MARGINAL_UTILITY_SALSA[i] / SALSA_PRICE;
        }
        return salsaRatios;
    }
}
