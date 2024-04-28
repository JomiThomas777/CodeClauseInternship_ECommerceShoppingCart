import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Product {
    private int productId;
    private String name;
    private double price;
    private String description;

    public Product(int productId, String name, double price, String description) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }
}

class ShoppingCart {
    private List<Product> items = new ArrayList<>();

    public void addItem(Product product) {
        items.add(product);
    }

    public void removeItem(Product product) {
        items.remove(product);
    }

    public List<Product> getItems() {
        return items;
    }

    public double getTotalPrice() {
        double totalPrice = 0;
        for (Product item : items) {
            totalPrice += item.getPrice();
        }
        return totalPrice;
    }
}

public class ECommerceSystem {
    private static List<Product> products = new ArrayList<>();
    private static ShoppingCart cart = new ShoppingCart();

    public static void main(String[] args) {
        initializeProducts();
        displayProducts();

        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n1. Add to cart\n2. View cart\n3. Checkout\n4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addToCart(scanner);
                    break;
                case 2:
                    viewCart();
                    break;
                case 3:
                    checkout(scanner);
                    break;
                case 4:
                    System.out.println("Thank you for shopping with us!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
    }

    private static void initializeProducts() {
        products.add(new Product(1, "Smartphone", 499.99, "A high-performance smartphone with advanced features."));
        products.add(new Product(2, "Laptop", 899.99, "A powerful laptop designed for productivity and entertainment."));
        products.add(new Product(3, "Headphones", 149.99, "Premium headphones with immersive sound quality."));
        products.add(new Product(4, "Smart Watch", 199.99, "A stylish smartwatch with fitness tracking and notification features."));
        products.add(new Product(5, "Wireless Earbuds", 79.99, "Sleek wireless earbuds for on-the-go audio enjoyment."));
        products.add(new Product(6, "Bluetooth Speaker", 129.99, "Portable Bluetooth speaker with rich sound output."));
        products.add(new Product(7, "External Hard Drive", 79.99, "High-capacity external hard drive for data storage."));
        products.add(new Product(8, "Gaming Console", 399.99, "Next-generation gaming console for immersive gaming experiences."));
        products.add(new Product(9, "Tablet", 329.99, "Versatile tablet for work, entertainment, and creativity."));
        products.add(new Product(10, "Camera", 699.99, "Professional-grade camera for capturing stunning photos and videos."));

    }

    private static void displayProducts() {
        System.out.println("'########:'##::::'##::'#######::'##::::'##::::'###:::::'######::'####:\r\n" + //
                        "... ##..:: ##:::: ##:'##.... ##: ###::'###:::'## ##:::'##... ##: ####:\r\n" + //
                        "::: ##:::: ##:::: ##: ##:::: ##: ####'####::'##:. ##:: ##:::..::. ##::\r\n" + //
                        "::: ##:::: #########: ##:::: ##: ## ### ##:'##:::. ##:. ######::'##:::\r\n" + //
                        "::: ##:::: ##.... ##: ##:::: ##: ##. #: ##: #########::..... ##:..::::\r\n" + //
                        "::: ##:::: ##:::: ##: ##:::: ##: ##:.:: ##: ##.... ##:'##::: ##:::::::\r\n" + //
                        "::: ##:::: ##:::: ##:. #######:: ##:::: ##: ##:::: ##:. ######::::::::\r\n" + //
                        ":::..:::::..:::::..:::.......:::..:::::..::..:::::..:::......:::::::::\r\n" + //
                        ":'######::'##::::'##:'########::'########:'########::'##::::'##::::'###::::'########::'########:\r\n" + //
                        "'##... ##: ##:::: ##: ##.... ##: ##.....:: ##.... ##: ###::'###:::'## ##::: ##.... ##:... ##..::\r\n" + //
                        " ##:::..:: ##:::: ##: ##:::: ##: ##::::::: ##:::: ##: ####'####::'##:. ##:: ##:::: ##:::: ##::::\r\n" + //
                        ". ######:: ##:::: ##: ########:: ######::: ########:: ## ### ##:'##:::. ##: ########::::: ##::::\r\n" + //
                        ":..... ##: ##:::: ##: ##.....::: ##...:::: ##.. ##::: ##. #: ##: #########: ##.. ##:::::: ##::::\r\n" + //
                        "'##::: ##: ##:::: ##: ##:::::::: ##::::::: ##::. ##:: ##:.:: ##: ##.... ##: ##::. ##::::: ##::::\r\n" + //
                        ". ######::. #######:: ##:::::::: ########: ##:::. ##: ##:::: ##: ##:::: ##: ##:::. ##:::: ##::::\r\n" + //
                        ":......::::.......:::..:::::::::........::..:::::..::..:::::..::..:::::..::..:::::..:::::..:::::\r\n" + //
                        "");
        System.out.println("Available Products:");
        for (Product product : products) {
            System.out.println(product.getProductId() + ". " + product.getName() + " - $" + product.getPrice());
        }
    }

    private static void addToCart(Scanner scanner) {
        System.out.print("Enter product ID to add to cart: ");
        int productId = scanner.nextInt();
        Product selectedProduct = getProductById(productId);
        if (selectedProduct != null) {
            cart.addItem(selectedProduct);
            System.out.println(selectedProduct.getName() + " added to cart.");
        } else {
            System.out.println("Product not found.");
        }
    }

    private static Product getProductById(int productId) {
        for (Product product : products) {
            if (product.getProductId() == productId) {
                return product;
            }
        }
        return null;
    }

    private static void viewCart() {
        List<Product> items = cart.getItems();
        if (items.isEmpty()) {
            System.out.println("Your cart is empty.");
        } else {
            System.out.println("Your Cart:");
            for (Product item : items) {
                System.out.println(item.getName() + " - $" + item.getPrice());
            }
            System.out.println("Total Price: $" + cart.getTotalPrice());
        }
    }

    private static void checkout(Scanner scanner) {
        if (cart.getItems().isEmpty()) {
            System.out.println("Your cart is empty. Nothing to checkout.");
        } else {
            System.out.println("Total Price: $" + cart.getTotalPrice());
            System.out.print("Proceed to checkout? (yes/no): ");
            String choice = scanner.next();
            if (choice.equalsIgnoreCase("yes")) {
                System.out.println("Checkout successful! Thank you for your purchase.");
                cart.getItems().clear(); // Empty the cart after checkout
            } else {
                System.out.println("Checkout cancelled.");
            }
        }
    }
}
