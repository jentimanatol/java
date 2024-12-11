
public class TicketPriceCalculator {
  private DemandFactors demandFactors;
  private SupplyFactors supplyFactors;

  public TicketPriceCalculator(DemandFactors demandFactors, SupplyFactors supplyFactors) {
      this.demandFactors = demandFactors;
      this.supplyFactors = supplyFactors;
  }

  public double calculateTicketPrice() {
      // This is a simplified example. In reality, the calculation might be more complex and based on more factors.
      return demandFactors.getPopularity() * demandFactors.getPerformance() * demandFactors.getOpponentQuality() * demandFactors.getIncomeLevel() / (supplyFactors.getStadiumSize() * supplyFactors.getNumberOfGames());
  }

  public static void main(String[] args) {
      DemandFactors demandFactors = new DemandFactors(1.0, 1.0, 1.0, 1.0);
      SupplyFactors supplyFactors = new SupplyFactors(1.0, 1.0);
      TicketPriceCalculator calculator = new TicketPriceCalculator(demandFactors, supplyFactors);
      double price = calculator.calculateTicketPrice();
      System.out.println("The calculated ticket price is: " + price);
  }
}