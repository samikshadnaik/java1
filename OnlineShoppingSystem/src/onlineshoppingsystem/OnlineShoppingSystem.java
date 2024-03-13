package onlineshoppingsystem;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

class ShoppingCart {
    private Map<Product, Integer> items = new HashMap<>();

    public void addItem(Product product, int quantity) {
        items.put(product, items.getOrDefault(product, 0) + quantity);
    }

    public double calculateTotal() {
        double total = 0;
        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
            total += entry.getKey().getPrice() * entry.getValue();
        }
        return total;
    }

    public void displayCart() {
        System.out.println("Shopping Cart:");
        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
            System.out.println(entry.getKey().getName() + " - $" + entry.getKey().getPrice()
                    + " x " + entry.getValue() + " = $" + entry.getKey().getPrice() * entry.getValue());
        }
        System.out.println("Total: $" + calculateTotal());
    }
}

public class OnlineShoppingSystem {
    private static Map<String, User> usersDatabase = new HashMap<>();
    private static Map<String, Product> productsDatabase = new HashMap<>();
    private static ShoppingCart cart = new ShoppingCart();
    private static Scanner scanner = new Scanner(System.in);
    private static User currentUser = null;


    public static void main(String[] args) {
        initializeUsers();
        initializeProducts();

        while (true) {
            if (currentUser == null) {
                displayLoginMenu();
                int loginChoice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (loginChoice) {
                    case 1:
                        loginUser();
                        break;
                    case 2:
                        registerUser();
                        break;
                    case 3:
                        System.out.println("Thank you for using the online shopping system. Goodbye.");
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } else {
                displayMainMenu();
                int mainChoice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (mainChoice) {
                    case 1:
                        displayProducts();
                        break;
                    case 2:
                        addToCart();
                        break;
                    case 3:
                        viewCart();
                        break;
                    case 4:
                        checkout();
                        break;
                    case 5:
                        currentUser = null;
                        System.out.println("Logged out successfully.");
                        break;
                    case 6:
                        System.out.println("Thank you for using the online shopping system. Goodbye.");
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        }
    }

    private static void initializeUsers() {
        usersDatabase.put("user1", new User("user1", "password1"));
        usersDatabase.put("user2", new User("user2", "password2"));
    }

    private static void initializeProducts() {
        productsDatabase.put("product1", new Product("Mobile", 19.99));
        productsDatabase.put("product2", new Product("laptop", 29.99));
        productsDatabase.put("product3", new Product("Tv", 39.99));
    }

    private static void displayLoginMenu() {
        System.out.println("\nOnline Shopping System Login Menu:");
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void loginUser() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        User user = usersDatabase.get(username);

        if (user != null && user.getPassword().equals(password)) {
            currentUser = user;
            System.out.println("Login successful. Welcome, " + username + "!");
        } else {
            System.out.println("Invalid username or password. Please try again.");
        }
    }

    private static void registerUser() {
        System.out.print("Enter new username: ");
        String newUsername = scanner.nextLine();

        if (usersDatabase.containsKey(newUsername)) {
            System.out.println("Username already exists. Please choose a different username.");
            return;
        }

        System.out.print("Enter new password: ");
        String newPassword = scanner.nextLine();

        User newUser = new User(newUsername, newPassword);
        usersDatabase.put(newUsername, newUser);
        currentUser = newUser;

        System.out.println("Registration successful. Welcome, " + newUsername + "!");
    }

    private static void displayMainMenu() {
        System.out.println("\nOnline Shopping System Main Menu:");
        System.out.println("1. View Products");
        System.out.println("2. Add to Cart");
        System.out.println("3. View Cart");
        System.out.println("4. Checkout");
        System.out.println("5. Logout");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void displayProducts() {
        System.out.println("\nAvailable Products:");
        for (Map.Entry<String, Product> entry : productsDatabase.entrySet()) {
            System.out.println(entry.getKey() + ". " + entry.getValue().getName() + " - $"
                    + entry.getValue().getPrice());
        }
    }

    private static void addToCart() {
        displayProducts();
        System.out.print("Enter the product code to add to cart: ");
        String productCode = scanner.nextLine();

        Product selectedProduct = productsDatabase.get(productCode);

        if (selectedProduct != null) {
            System.out.print("Enter the quantity: ");
            int quantity = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            cart.addItem(selectedProduct, quantity);
            System.out.println(selectedProduct.getName() + " added to cart.");
        } else {
            System.out.println("Invalid product code.");
        }
    }

    private static void viewCart() {
        cart.displayCart();
    }

    private static void checkout() {
        if (cart.calculateTotal() > 0) {
            System.out.println("\nCheckout Summary:");
            cart.displayCart();
            System.out.println("Thank you for your purchase, " + currentUser.getUsername() + "!");
            cart = new ShoppingCart(); // Clear the cart after checkout
        } else {
            System.out.println("Your cart is empty. Add items before checking out.");
        }
    }
}
        