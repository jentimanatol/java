public class DemandFactors {
    private double popularity;
    private double performance;
    private double opponentQuality;
    private double incomeLevel;

    public DemandFactors(double popularity, double performance, double opponentQuality, double incomeLevel) {
        this.popularity = popularity;
        this.performance = performance;
        this.opponentQuality = opponentQuality;
        this.incomeLevel = incomeLevel;
    }

    public double getPopularity() {
        return popularity;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    public double getPerformance() {
        return performance;
    }

    public void setPerformance(double performance) {
        this.performance = performance;
    }

    public double getOpponentQuality() {
        return opponentQuality;
    }

    public void setOpponentQuality(double opponentQuality) {
        this.opponentQuality = opponentQuality;
    }

    public double getIncomeLevel() {
        return incomeLevel;
    }

    public void setIncomeLevel(double incomeLevel) {
        this.incomeLevel = incomeLevel;
    }

    // Getters and setters...



    
}