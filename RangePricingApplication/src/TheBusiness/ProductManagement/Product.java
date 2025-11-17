package TheBusiness.ProductManagement;

import java.util.UUID;

/**
 *
 * @author kal bugrara
 */
public class Product {

    private final String productId;
    private String name;

    // Pricing
    private double targetPrice;
    private double floorPrice;
    private double ceilingPrice;

    // --- New fields to support pricing analytics / final report ---
    private double oldTargetPrice;      // target price before changes
    private int unitsSold;              // total units sold across all orders
    private double revenue;             // total revenue (actual price * quantity)
    private int belowTargetCount;       // # of sales below target price
    private int aboveTargetCount;       // # of sales above target price
    private double oldMargin;           // margin before price change
    private double newMargin;           // margin after price change

    public Product(String name, double targetPrice, double floorPrice, double ceilingPrice) {
        this.productId = UUID.randomUUID().toString();
        this.name = name;
        this.targetPrice = targetPrice;
        this.floorPrice = floorPrice;
        this.ceilingPrice = ceilingPrice;

        // initialize analytics fields
        this.oldTargetPrice = targetPrice;
        this.unitsSold = 0;
        this.revenue = 0.0;
        this.belowTargetCount = 0;
        this.aboveTargetCount = 0;
        this.oldMargin = 0.0;
        this.newMargin = 0.0;
    }

    // ------------------ ID & Name ------------------
    public String getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // ------------------ Pricing ------------------
    public double getTargetPrice() {
        return targetPrice;
    }

    /**
     * When target price is changed, keep track of the original target price so
     * that old vs new can be reported.
     */
    public void setTargetPrice(double targetPrice) {
        // preserve the first target as oldTargetPrice
        if (this.oldTargetPrice == 0) {
            this.oldTargetPrice = this.targetPrice;
        }
        this.targetPrice = targetPrice;
    }

    public double getFloorPrice() {
        return floorPrice;
    }

    public void setFloorPrice(double floorPrice) {
        this.floorPrice = floorPrice;
    }

    public double getCeilingPrice() {
        return ceilingPrice;
    }

    public void setCeilingPrice(double ceilingPrice) {
        this.ceilingPrice = ceilingPrice;
    }

    // ------------------ Analytics getters (used by FinalReportPanel) ------------------
    public double getOldTargetPrice() {
        return oldTargetPrice;
    }

    public int getUnitsSold() {
        return unitsSold;
    }

    public double getRevenue() {
        return revenue;
    }

    public int getBelowTargetCount() {
        return belowTargetCount;
    }

    public int getAboveTargetCount() {
        return aboveTargetCount;
    }

    public double getOldMargin() {
        return oldMargin;
    }

    public double getNewMargin() {
        return newMargin;
    }

    /**
     * Percentage change between old and new margin.
     */
    public double getChangePercent() {
        if (oldMargin == 0) {
            return 0.0;
        }
        return ((newMargin - oldMargin) / oldMargin) * 100.0;
    }

    // ------------------ Helpers to update analytics (to be called from order logic) ------------------
    /**
     * Call this from your Order/OrderItem logic whenever a sale happens.
     */
    public void recordSale(int quantity, double actualPrice) {
        unitsSold += quantity;
        revenue += actualPrice * quantity;

        if (actualPrice < targetPrice) {
            belowTargetCount++;
        } else if (actualPrice > targetPrice) {
            aboveTargetCount++;
        }
        // margins can be set elsewhere after computing costs
    }

    public void setOldTargetPrice(double oldTargetPrice) {
        this.oldTargetPrice = oldTargetPrice;
    }

    public void setOldMargin(double oldMargin) {
        this.oldMargin = oldMargin;
    }

    public void setNewMargin(double newMargin) {
        this.newMargin = newMargin;
    }

    @Override
    public String toString() {
        return name + " (Target $" + targetPrice + ")";
    }
}
