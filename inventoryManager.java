import java.util.*;

class Product {
    String name;
    double price;
    int stock;

    Product(String name, double price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    @Override
    public String toString() {
        return name + " - ₹" + price + " | Stock: " + stock;
    }
}

public class InventoryManager {
    public static void main(String[] args) {
        // Step 1: Create a product list
        ArrayList<Product> inventory = new ArrayList<>();
        inventory.add(new Product("Laptop", 55000, 10));
        inventory.add(new Product("Notebook", 50, 2));
        inventory.add(new Product("Mobile", 20000, 8));
        inventory.add(new Product("Pen", 10, 3));
        inventory.add(new Product("Chair", 1200, 15));

        System.out.println("=== All Products ===");
        for (Product p : inventory) {
            System.out.println(p);
        }

        // Step 2: Remove low-stock items (stock < 5) using Iterator
        Iterator<Product> itr = inventory.iterator();
        while (itr.hasNext()) {
            Product p = itr.next();
            if (p.stock < 5) {
                itr.remove(); // safely removes while iterating
            }
        }

        System.out.println("\n=== After Removing Low Stock Products (<5) ===");
        for (Product p : inventory) {
            System.out.println(p);
        }

        // Step 3: Update prices using ListIterator
        ListIterator<Product> listItr = inventory.listIterator();
        while (listItr.hasNext()) {
            Product p = listItr.next();
            if (p.name.equalsIgnoreCase("Pen")) {
                p.price += 5; // Increase pen price by 5
                listItr.set(p); // Update product in list
            }
            if (p.name.equalsIgnoreCase("Laptop")) {
                p.price *= 1.10; // Increase laptop price by 10%
                listItr.set(p);
            }
        }

        System.out.println("\n=== After Updating Prices ===");
        for (Product p : inventory) {
            System.out.println(p);
        }
    }
}
