
/**
 * Write a description of class Product here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Product
{
    
    private String productCode;
    private String productName;
    private String category;
    private double unitPrice;
    private int quantityInStock;
    private int reorderLevel;

    
    public Product() {
        this.productCode = "UNKNOWN";
        this.productName = "UNKNOWN";
        this.category = "UNKNOWN";
        this.unitPrice = 0;
        this.quantityInStock = 0;
        this.reorderLevel = 10;
    }

    public Product(String productCode, String productName,
                             String category, double unitPrice, int quantityInStock) {
        this.productCode = productCode;
        this.productName = productName;
        this.category = category;
        setUnitPrice(unitPrice);
        setQuantityInStock(quantityInStock);
        this.reorderLevel = 10;
    }

    public String getProductCode() {
        return productCode;
    }

    public String getProductName() {
        return productName;
    }

    public String getCategory() {
        return category;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public int getReorderLevel() {
        return reorderLevel;
    }

    public void setUnitPrice(double unitPrice) {
        if (unitPrice > 0) {
            this.unitPrice = unitPrice;
        } else {
            System.out.println("Unit price must be greater than 0.");
        }
    }

    public void setQuantityInStock(int quantityInStock) {
        if (quantityInStock >= 0) {
            this.quantityInStock = quantityInStock;
        } else {
            System.out.println("Quantity cannot be negative.");
        }
    }

    public void setReorderLevel(int reorderLevel) {
        if (reorderLevel > 0) {
            this.reorderLevel = reorderLevel;
        } else {
            System.out.println("Reorder level must be greater than 0.");
        }
    }

    public void addStock(int quantity) {
        if (quantity > 0) {
            quantityInStock += quantity;
            System.out.println(quantity + " units added to stock.");
        }
    }
    public boolean sellProduct(int quantity) {
        if (quantity > 0 && quantity <= quantityInStock) {
            quantityInStock -= quantity;
            System.out.println(quantity + " units sold.");
            return true;
        } else {
            System.out.println("Insufficient stock to sell.");
            return false;
        }
    }

    public double calculateStockValue() {
        return unitPrice * quantityInStock;
    }

    public boolean needsReorder() {
        return quantityInStock <= reorderLevel;
    }

    public void applyDiscount(double percentage) {
        if (percentage > 0 && percentage <= 100) {
            unitPrice -= unitPrice * (percentage / 100);
            System.out.println("Discount of " + percentage + "% applied.");
        }
    }

    public void displayProductInfo() {
        System.out.println("----- PRODUCT INFO -----");
        System.out.println("Code: " + productCode);
        System.out.println("Name: " + productName);
        System.out.println("Category: " + category);
        System.out.println("Unit Price: " + unitPrice);
        System.out.println("Stock Quantity: " + quantityInStock);
        System.out.println("Reorder Level: " + reorderLevel);
        System.out.println("Stock Value: " + calculateStockValue());
        System.out.println("Needs Reorder: " + (needsReorder() ? "YES" : "NO"));
        System.out.println("------------------------\n");
    }


    public static void main(String[] args) {
        System.out.println("=== Product Inventory Exercise ===\n");

        Product product1 =new Product("PRD001", "Laptop", "Electronics", 1500000, 25);

        Product product2 =new Product("PRD002", "Office Chair", "Furniture", 350000, 8);

        Product product3 =new Product("PRD003", "Notebook", "Stationery", 5000, 100);

        product1.displayProductInfo();
        product2.displayProductInfo();
        product3.displayProductInfo();

        product1.sellProduct(20);

        System.out.println("Product2 needs reorder? " + product2.needsReorder());

        product2.addStock(50);

        product3.applyDiscount(15);

        product1.displayProductInfo();
        product2.displayProductInfo();
        product3.displayProductInfo();

        System.out.println("=== Exercise Complete ===");
    }
}