import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.net.URL;
import javax.imageio.ImageIO;

/*
 Main Class - Restaurant Management System GUI Application
 OOP CONCEPT: ENCAPSULATION - This class encapsulates all the GUI functionalities
 */
public class SwingUI{
    /*
     MenuItem Class - Represents a food item in the restaurant menu
     OOP CONCEPTS:
     1. ENCAPSULATION: Private attributes with public getters
     2. ABSTRACTION: Represents a real-world menu item
     */
    static class MenuItem{
        //Defining private attributes ENCAPSULATION
        private String name;
        private double price;
        private String imagePath;

        //Implementing the constructor
        public MenuItem(String name, double price, String imagePath){
            this.name = name;
            this.price = price;
            this.imagePath = imagePath;
        }

        //Getter methods (ENCAPSULATION)
        public String getName(){
            return name;
        }
        public double getPrice(){
            return price;
        }
        public String getImagePath(){
            return imagePath;
        }
    }

    /*
     Order Class - Represents a customer's order
     OOP CONCEPTS:
     1. ENCAPSULATION: Private attributes
     2. COMPOSITION: Contains MenuItem object
     */
    static class Order{
        //Defining private attributes ENCAPSULATION
        private MenuItem item;
        private int quantity;

        //Implementing the constructor
        public Order(MenuItem item, int quantity){
            this.item = item;
            this.quantity = quantity;
        }

        //Calculating the total price per item
        public double calculateTotal(){
            return item.getPrice() * quantity;
        }

        //Getter methods (ENCAPSULATION)
        public MenuItem getItem(){
            return item;
        }
    }

    /*
     Staff Class - Represents restaurant staff
     OOP CONCEPTS:
     1. ENCAPSULATION: Private attributes with getters
     */
    static class Staff{
        //Defining private attributes ENCAPSULATION
        private int id;
        private String name;
        private double salary;

        //Implementing the constructor
        public Staff(int id, String name, double salary){
            this.id = id;
            this.name = name;
            this.salary = salary;
        }

        //Getter methods (ENCAPSULATION)
        public int getId(){
            return id;
        }
        public String getName(){
            return name;
        }
        public double calculateSalary(){
            return salary;
        }
    }

    /*
     RestaurantManagementSystem Class - Main backend system
     OOP CONCEPTS:
     1. ENCAPSULATION: Private collections
     2. COMPOSITION: Contains collections of MenuItem and Staff
     3. ABSTRACTION: Hides complex data management from GUI
     */
    static class RestaurantManagementSystem{
        //Defining private attributes (ENCAPSULATION)
        private ArrayList<MenuItem> menuItems;
        private ArrayList<Staff> staffList;

        //Implementing the constructor
        public RestaurantManagementSystem(){
            menuItems = new ArrayList<>();
            staffList = new ArrayList<>();

            //Initializing menu items with image URLs
            menuItems.add(new MenuItem("Burger", 250.00,
                    "https://images.unsplash.com/photo-1568901346375-23c9450c58cd?w=300&h=200&fit=crop"));
            menuItems.add(new MenuItem("Pizza", 500.00,
                    "https://images.unsplash.com/photo-1604068549290-dea0e4a305ca?w=300&h=200&fit=crop"));
            menuItems.add(new MenuItem("Pasta", 350.00,
                    "https://images.unsplash.com/photo-1563379926898-05f4575a45d8?w=300&h=200&fit=crop"));
            menuItems.add(new MenuItem("Salad", 200.00,
                    "https://images.unsplash.com/photo-1540420773420-3366772f4999?w=300&h=200&fit=crop"));
            menuItems.add(new MenuItem("Fries", 150.00,
                    "https://images.unsplash.com/photo-1573080496219-bb080dd4f877?w=300&h=200&fit=crop"));
            menuItems.add(new MenuItem("Lemonade", 100.00,
                    "https://images.unsplash.com/photo-1575596510825-f748919a2bf7?q=80&w=687&auto=format&fit=crop"));
            menuItems.add(new MenuItem("Chocolate Doughnut", 150.00,
                    "https://images.unsplash.com/photo-1694612804151-89ceeab9115c?q=80&w=1173&auto=format&fit=crop"));
            menuItems.add(new MenuItem("Toast", 480.00,
                    "https://images.unsplash.com/photo-1612827788868-c8632040ab64?q=80&w=1170&auto=format&fit=crop"));
            menuItems.add(new MenuItem("Vanilla Milkshake", 320.00,
                    "https://plus.unsplash.com/premium_photo-1695868328902-b8a3b093da74?q=80&w=687&auto=format&fit=crop"));
            menuItems.add(new MenuItem("Chocolate Milkshake", 340.00,
                    "https://images.unsplash.com/photo-1553787499-6f9133860278?q=80&w=687&auto=format&fit=crop"));
            menuItems.add(new MenuItem("Potato Wedges", 300.00,
                    "https://images.unsplash.com/photo-1633959639799-6d3f66e05710?q=80&w=1074&auto=format&fit=crop"));
            menuItems.add(new MenuItem("Chocolate Cake 1kg", 520.00,
                    "https://images.unsplash.com/photo-1626263468007-a9e0cf83f1ac?q=80&w=1170&auto=format&fit=crop"));
            menuItems.add(new MenuItem("Chicken Sandwich", 350.00,
                    "https://images.unsplash.com/photo-1666819604716-7b60a604bb76?q=80&w=687&auto=format&fit=crop"));
            menuItems.add(new MenuItem("Brownie", 230.00,
                    "https://images.unsplash.com/photo-1624353365286-3f8d62daad51?q=80&w=1170&auto=format&fit=crop"));
            menuItems.add(new MenuItem("Blueberry Pie", 600.00,
                    "https://images.unsplash.com/photo-1476887334197-56adbf254e1a?q=80&w=687&auto=format&fit=crop"));
            menuItems.add(new MenuItem("Sausage Pastry", 150.00,
                    "https://images.unsplash.com/photo-1619445832874-8b153f60ae78?q=80&w=1073&auto=format&fit=crop"));
            menuItems.add(new MenuItem("Iced Coffee", 300.00,
                    "https://images.unsplash.com/photo-1517701550927-30cf4ba1dba5?q=80&w=687&auto=format&fit=crop"));
            menuItems.add(new MenuItem("Orange Juice", 220.00,
                    "https://images.unsplash.com/photo-1600271886742-f049cd451bba?q=80&w=687&auto=format&fit=crop"));
            menuItems.add(new MenuItem("Vanilla Ice Cream", 320.00,
                    "https://images.unsplash.com/photo-1560008581-09826d1de69e?q=80&w=744&auto=format&fit=crop"));
            menuItems.add(new MenuItem("Marshmallow Bowl", 400.00,
                    "https://images.unsplash.com/photo-1623828721561-45afe998d064?q=80&w=735&auto=format&fit=crop"));

            //Initializing staff data
            staffList.add(new Staff(1, "John Doe", 50000.00));
            staffList.add(new Staff(2, "Jane Smith", 55000.00));
            staffList.add(new Staff(3, "Bob Wilson", 48000.00));
        }

        //Getter methods (ENCAPSULATION)
        public ArrayList<MenuItem> getItem(){
            return menuItems;
        }
        public ArrayList<Staff> getStaffList(){
            return staffList;
        }
    }

    // =========================================================================
    // APPLICATION STATE (Static variables used for application data)
    // =========================================================================
    private static RestaurantManagementSystem rms = new RestaurantManagementSystem();
    private static ArrayList<Order> cart = new ArrayList<>();
    private static double dailyIncome = 0.0;
    private static final String ADMIN_PASSWORD = "admin123";

    // =========================================================================
    // MAIN METHOD - Application Entry Point
    // =========================================================================
    public static void main(String[] args){
        //Ensures that GUI occurs on EDT
        SwingUtilities.invokeLater(() -> showLandingPage());
    }

    // =========================================================================
    // LANDING PAGE METHODS
    // =========================================================================

    /*
     SWING FEATURES USED:
     1. JFrame - Main application window
     2. BorderLayout - Layout manager
     3. JPanel - Grouping components container
     4. JLabel - Displaying text and images
     5. MouseAdapter - Handling hover effects
     */
    private static void showLandingPage(){
        //Creating the main window (JFrame)
        JFrame landingFrame = new JFrame("Restaurant Management System");
        landingFrame.setSize(800, 600);
        landingFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        landingFrame.setLayout(new BorderLayout());
        landingFrame.setLocationRelativeTo(null);

        // Setting background color
        landingFrame.getContentPane().setBackground(new Color(245, 245, 245));

        //Creating the Header Panel
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(new Color(25, 25, 112));
        headerPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));

        //Adding the Title
        JLabel titleLabel = new JLabel("Welcome Back!", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 36));
        titleLabel.setForeground(Color.WHITE);
        headerPanel.add(titleLabel, BorderLayout.CENTER);

        //Adding the Subtitle
        JLabel subtitleLabel = new JLabel("At Your Convenience & Service", SwingConstants.CENTER);
        subtitleLabel.setFont(new Font("Segoe UI", Font.ITALIC, 16));
        subtitleLabel.setForeground(new Color(25, 25, 112));
        headerPanel.add(subtitleLabel, BorderLayout.SOUTH);

        landingFrame.add(headerPanel, BorderLayout.NORTH);

        //Creating the Main Content Panel
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(40, 100, 40, 100));
        mainPanel.setBackground(new Color(245, 245, 245));

        //Creating the Welcome Message Panel
        JPanel welcomePanel = new JPanel();
        welcomePanel.setBackground(new Color(245, 245, 245));
        JLabel welcomeLabel = new JLabel(
                "<html><div style='text-align: center;'>"
                        + "<p style='font-size: 14px; color: #666;'>Please select your login type to continue</p>"
                        + "</div></html>",
                SwingConstants.CENTER
        );
        welcomeLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        welcomePanel.add(welcomeLabel);

        mainPanel.add(welcomePanel, BorderLayout.NORTH);

        //Creating the Login Options Panel using GridLayout
        JPanel loginPanel = new JPanel(new GridLayout(2, 1, 20, 20));
        loginPanel.setBackground(new Color(245, 245, 245));
        loginPanel.setBorder(BorderFactory.createEmptyBorder(30, 0, 30, 0));

        //Creating the User Login Card
        JPanel userCard = createLoginCard("👤", "User Login",
                "Access the restaurant menu and place orders",
                new Color(15, 73, 70));

        //Creating the Admin Login Card
        JPanel adminCard = createLoginCard("🔒", "Admin Login",
                "View staff details and financial reports",
                new Color(228, 45, 60));

        /*
        SWING FEATURE:
        1. MouseAdapter
        OOP CONCEPT:
        1. POLYMORPHISM - MouseAdapter is an abstract class which is extended
        to create inner classes
        */
        userCard.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                landingFrame.dispose(); //Closing current window
                showUserMenu(); //Opening user menu
            }
        });

        adminCard.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                showAdminLogin(landingFrame); //Showing admin login dialog
            }
        });

        loginPanel.add(userCard);
        loginPanel.add(adminCard);

        mainPanel.add(loginPanel, BorderLayout.CENTER);

        //Creating the Footer Panel
        JPanel footerPanel = new JPanel();
        footerPanel.setBackground(new Color(245, 245, 245));
        JLabel footerLabel = new JLabel("© 2026 Restaurant Management System | Version 26.1");
        footerLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        footerLabel.setForeground(Color.GRAY);
        footerPanel.add(footerLabel);

        mainPanel.add(footerPanel, BorderLayout.SOUTH);

        landingFrame.add(mainPanel, BorderLayout.CENTER);
        landingFrame.setVisible(true); //making the window visible
    }

    //OOP CONCEPT: ABSTRACTION - Hides complex card creation details

    private static JPanel createLoginCard(String icon, String title, String description, Color color){
        JPanel card = new JPanel(new BorderLayout(10, 10));
        card.setBackground(Color.WHITE);
        card.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(220, 220, 220), 1),
                BorderFactory.createEmptyBorder(20, 20, 20, 20)
        ));
        card.setCursor(new Cursor(Cursor.HAND_CURSOR)); //Changes the cursor to hand

        //SWING FEATURE: MouseAdapter
        card.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent e){
                card.setBackground(new Color(250, 250, 250));
            }
            public void mouseExited(MouseEvent e){
                card.setBackground(Color.WHITE);
            }
        });

        //Creating the Icon and Title Panel
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        topPanel.setBackground(Color.WHITE);

        JLabel iconLabel = new JLabel(icon);
        iconLabel.setFont(new Font("Segoe UI", Font.PLAIN, 36));

        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
        titleLabel.setForeground(color);

        topPanel.add(iconLabel);
        topPanel.add(titleLabel);

        //Creating the Description Label with HTML formatting
        JLabel descLabel = new JLabel("<html><div style='text-align: center; color: #666;'>" + description + "</div></html>");
        descLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        card.add(topPanel, BorderLayout.NORTH);
        card.add(descLabel, BorderLayout.CENTER);

        return card;
    }

    // =========================================================================
    // ADMIN LOGIN METHODS
    // =========================================================================

    /*
    SWING FEATURES:
    1. JDialog - Modal dialog window
    2. JPasswordField - For secure password input
    3. ActionListener - For button click events
    */
    private static void showAdminLogin(JFrame parentFrame){
        //Creating modal dialog
        JDialog loginDialog = new JDialog(parentFrame, "Admin Authentication", true);
        loginDialog.setSize(400, 250);
        loginDialog.setLayout(new BorderLayout());
        loginDialog.setLocationRelativeTo(parentFrame);

        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        //Creating the Header Label
        JLabel headerLabel = new JLabel("🔒 Admin Login Required", SwingConstants.CENTER);
        headerLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
        headerLabel.setForeground(new Color(27, 27, 136));

        //Creating the Password Input Panel
        JPanel passwordPanel = new JPanel(new GridLayout(2, 1, 5, 10));
        passwordPanel.setBorder(BorderFactory.createTitledBorder("Enter Admin Password"));

        //SWING FEATURE: JPasswordField - masks input characters
        JPasswordField passwordField = new JPasswordField(15);
        passwordField.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        JLabel hintLabel = new JLabel("Hint: Default password is 'admin123'");
        hintLabel.setFont(new Font("Segoe UI", Font.ITALIC, 11));
        hintLabel.setForeground(Color.GRAY);

        passwordPanel.add(passwordField);
        passwordPanel.add(hintLabel);

        //Creating the Buttons Panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));

        JButton loginBtn = new JButton("Login");
        loginBtn.setBackground(new Color(26, 96, 93));
        loginBtn.setForeground(Color.WHITE);
        loginBtn.setFocusPainted(false); //Removes focus border

        JButton cancelBtn = new JButton("Cancel");
        cancelBtn.setBackground(new Color(220, 20, 60));
        cancelBtn.setForeground(Color.WHITE);
        cancelBtn.setFocusPainted(false);

        buttonPanel.add(loginBtn);
        buttonPanel.add(cancelBtn);

        //Creating the Status Label for error messages
        JLabel statusLabel = new JLabel(" ", SwingConstants.CENTER);
        statusLabel.setForeground(Color.RED);
        statusLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));

        mainPanel.add(headerLabel, BorderLayout.NORTH);
        mainPanel.add(passwordPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        loginDialog.add(mainPanel, BorderLayout.CENTER);
        loginDialog.add(statusLabel, BorderLayout.SOUTH);

        /*
        SWING FEATURE: ActionListener
        OOP CONCEPT: POLYMORPHISM - Using anonymous inner class
        */
        loginBtn.addActionListener(e ->{
            char[] password = passwordField.getPassword();
            if(new String(password).equals(ADMIN_PASSWORD)){
                loginDialog.dispose(); //Closes dialog
                parentFrame.dispose(); //Closes landing page
                showAdminDashboard(); //Opens admin dashboard
            }else{
                statusLabel.setText("Incorrect password! Please try again.");
                passwordField.setText(""); //Clears password field
                passwordField.requestFocus(); //Returns focus to password field
            }
        });

        cancelBtn.addActionListener(e ->{
            loginDialog.dispose(); //Closes dialog without action
        });

        //Adding the Enter key support for password field
        passwordField.addActionListener(e -> loginBtn.doClick());

        loginDialog.setVisible(true);
    }

    // =========================================================================
    // USER MENU METHODS
    // =========================================================================

    /*
    SWING FEATURES:
    1. JScrollPane - For scrollable content
    2. GridLayout - For arranging menu items in grids
    3. ImageIcon - For displaying food images
    4. JSpinner - For quantity selection
    */
    private static void showUserMenu(){
        JFrame menuFrame = new JFrame("Restaurant Menu - Order Food");
        menuFrame.setSize(900, 650);
        menuFrame.setLayout(new BorderLayout(10, 10));
        menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuFrame.setLocationRelativeTo(null);

        //Creating the Header Panel with navigation
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(new Color(25, 25, 112));
        headerPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        JLabel titleLabel = new JLabel("🍽️ Restaurant Menu", SwingConstants.LEFT);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);

        JButton backBtn = new JButton("← Back to Home");
        backBtn.setBackground(Color.WHITE);
        backBtn.setForeground(new Color(25, 25, 112));
        backBtn.setFocusPainted(false);

        headerPanel.add(titleLabel, BorderLayout.WEST);
        headerPanel.add(backBtn, BorderLayout.EAST);

        menuFrame.add(headerPanel, BorderLayout.NORTH);

        //Creating the Main Menu Panel with scrollable content
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new GridLayout(0, 3, 15, 15));
        menuPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        menuPanel.setBackground(Color.WHITE);

        //OOP CONCEPT: POLYMORPHISM - Iterating through MenuItem objects
        for(MenuItem item : rms.getItem()){
            JPanel itemPanel = createMenuItemPanel(item, menuFrame);
            menuPanel.add(itemPanel);
        }

        //SWING FEATURE: JScrollPane - Makes menu scrollable
        JScrollPane scrollPane = new JScrollPane(menuPanel);
        scrollPane.setBorder(null);
        menuFrame.add(scrollPane, BorderLayout.CENTER);

        //Creating the Cart Panel (Fixed at bottom)
        JPanel cartPanel = createCartPanel(menuFrame);
        menuFrame.add(cartPanel, BorderLayout.SOUTH);

        //Creating the Action listener for back button
        backBtn.addActionListener(e ->{
            menuFrame.dispose();
            showLandingPage(); //Returns to landing page
        });

        menuFrame.setVisible(true);
    }

    //Creating a panel for a single menu item
    private static JPanel createMenuItemPanel(MenuItem item, JFrame parentFrame){
        JPanel itemPanel = new JPanel();
        itemPanel.setLayout(new BorderLayout(5, 5));
        itemPanel.setBackground(Color.WHITE);
        itemPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(220, 220, 220), 1),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));

        //Creating the Image Panel with asynchronous loading
        JPanel imagePanel = new JPanel(new BorderLayout());
        imagePanel.setPreferredSize(new Dimension(200, 150));
        imagePanel.setBackground(new Color(240, 240, 240));

        JLabel imageLabel = new JLabel("Loading image...", SwingConstants.CENTER);
        imageLabel.setFont(new Font("Segoe UI", Font.ITALIC, 11));
        imageLabel.setForeground(Color.GRAY);
        imagePanel.add(imageLabel, BorderLayout.CENTER);

        //MULTI-THREADING: Loads images in background thread
        new Thread(() ->{
            try{
                URL imageUrl = new URL(item.getImagePath());

                //SWING FEATURE: ImageIcon for displaying images
                ImageIcon originalIcon = new ImageIcon(imageUrl);
                Image scaledImage = originalIcon.getImage().getScaledInstance(200, 150, Image.SCALE_SMOOTH);
                ImageIcon finalIcon = new ImageIcon(scaledImage);

                //SWING FEATURE: SwingUtilities.invokeLater() - Updates GUI components from background thread
                SwingUtilities.invokeLater(() ->{
                    imageLabel.setIcon(finalIcon);
                    imageLabel.setText("");
                });
            }catch (Exception e){
                //Uses text placeholder if the image fails to load
                SwingUtilities.invokeLater(() ->{
                    imageLabel.setText("📷 " + item.getName());
                });
            }
        }).start();

        //Creating Item Details Panel
        JPanel detailsPanel = new JPanel(new BorderLayout(5, 5));
        detailsPanel.setBackground(Color.WHITE);

        JLabel nameLabel = new JLabel(item.getName());
        nameLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
        nameLabel.setForeground(new Color(50, 50, 50));

        JLabel priceLabel = new JLabel("Rs. " + String.format("%.2f", item.getPrice()));
        priceLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        priceLabel.setForeground(new Color(34, 139, 34));

        //Creating the Quantity selector using JSpinner
        JPanel quantityPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 0));
        quantityPanel.setBackground(Color.WHITE);

        JLabel quantityLabel = new JLabel("Qty:");

        //SWING FEATURE: JSpinner for numeric input
        JSpinner quantitySpinner = new JSpinner(new SpinnerNumberModel(1, 1, 10, 1));
        quantitySpinner.setPreferredSize(new Dimension(50, 25));

        quantityPanel.add(quantityLabel);
        quantityPanel.add(quantitySpinner);

        detailsPanel.add(nameLabel, BorderLayout.NORTH);
        detailsPanel.add(priceLabel, BorderLayout.CENTER);
        detailsPanel.add(quantityPanel, BorderLayout.SOUTH);

        //Adding to Cart Button
        JButton addButton = new JButton("Add to Cart");
        addButton.setBackground(new Color(25, 25, 112));
        addButton.setForeground(Color.WHITE);
        addButton.setFocusPainted(false);
        addButton.setFont(new Font("Segoe UI", Font.BOLD, 12));

        //OOP CONCEPT: ENCAPSULATION
        addButton.addActionListener(e ->{
            int quantity = (Integer) quantitySpinner.getValue();
            cart.add(new Order(item, quantity));

            //Shows success message
            JOptionPane.showMessageDialog(parentFrame,
                    quantity + " x " + item.getName() + " added to cart!\n" +
                            "Price: Rs." + String.format("%.2f", item.getPrice() * quantity),
                    "Added to Cart",
                    JOptionPane.INFORMATION_MESSAGE);

            quantitySpinner.setValue(1); //Resets spinner to 1
        });

        //Assembles the item panel
        itemPanel.add(imagePanel, BorderLayout.CENTER);
        itemPanel.add(detailsPanel, BorderLayout.NORTH);
        itemPanel.add(addButton, BorderLayout.SOUTH);

        return itemPanel;
    }

    //Creating the cart panel that shows at bottom of user menu
    private static JPanel createCartPanel(JFrame parentFrame){
        JPanel cartPanel = new JPanel(new BorderLayout());
        cartPanel.setBackground(new Color(248, 249, 250));
        cartPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(1, 0, 0, 0, new Color(220, 220, 220)),
                BorderFactory.createEmptyBorder(15, 20, 15, 20)
        ));

        //Creating the Cart Summary Label
        JLabel cartSummary = new JLabel("🛒");
        cartSummary.setFont(new Font("Segoe UI", Font.BOLD, 14));
        cartSummary.setForeground(new Color(108, 117, 125));

        //Creating the Buttons Panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 0));
        buttonPanel.setBackground(new Color(248, 249, 250));

        JButton viewCartBtn = new JButton("View Cart Details");
        viewCartBtn.setBackground(new Color(108, 117, 125));
        viewCartBtn.setForeground(Color.WHITE);
        viewCartBtn.setFocusPainted(false);

        JButton emptyCartBtn = new JButton("Empty Cart");
        emptyCartBtn.setBackground(new Color(220, 53, 69));
        emptyCartBtn.setForeground(Color.WHITE);
        emptyCartBtn.setFocusPainted(false);

        JButton checkoutBtn = new JButton("Proceed to Checkout");
        checkoutBtn.setBackground(new Color(107, 250, 139));
        checkoutBtn.setForeground(Color.WHITE);
        checkoutBtn.setFocusPainted(false);

        buttonPanel.add(viewCartBtn);
        buttonPanel.add(emptyCartBtn);
        buttonPanel.add(checkoutBtn);

        //OOP CONCEPT: POLYMORPHISM - Using lambda expression for Runnable
        Runnable updateCart = () ->{
           if(cart.isEmpty()){
                cartSummary.setText("🛒");
                cartSummary.setForeground(new Color(108, 117, 125));
           }else{
                //OOP CONCEPT: STREAM API (Functional Programming)
               double total = cart.stream().mapToDouble(Order::calculateTotal).sum();
                int itemCount = cart.size();
               cartSummary.setText(String.format("🛒 %d items | Total: Rs.%.2f", itemCount, total));
                cartSummary.setForeground(new Color(25, 25, 112));
           }
        };

        //Adding the action listeners to buttons
        viewCartBtn.addActionListener(e -> showCartDetails(parentFrame, updateCart));

        emptyCartBtn.addActionListener(e ->{
            if(!cart.isEmpty()){
                int confirm = JOptionPane.showConfirmDialog(parentFrame,
                        "Are you sure you want to empty your cart?",
                        "Empty Cart",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.WARNING_MESSAGE);

                if(confirm == JOptionPane.YES_OPTION){
                    cart.clear(); //Clears the cart
                    updateCart.run(); //Updates the display
                    JOptionPane.showMessageDialog(parentFrame, "Cart emptied successfully!");
                }
            }else{
                JOptionPane.showMessageDialog(parentFrame, "Your cart is already empty!");
            }
        });

        checkoutBtn.addActionListener(e -> processCheckout(parentFrame, updateCart));

        //Initializing and storing update function
        updateCart.run();
        parentFrame.getRootPane().putClientProperty("updateCart", updateCart);

        cartPanel.add(cartSummary, BorderLayout.WEST);
        cartPanel.add(buttonPanel, BorderLayout.EAST);

        return cartPanel;
    }


    private static void showCartDetails(JFrame parentFrame, Runnable updateCart){
        if(cart.isEmpty()){
            JOptionPane.showMessageDialog(parentFrame, "Your cart is empty!");
            return;
        }

        JDialog cartDialog = new JDialog(parentFrame, "Cart Details", true);
        cartDialog.setSize(500, 400);
        cartDialog.setLayout(new BorderLayout());
        cartDialog.setLocationRelativeTo(parentFrame);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        //Displaying Cart Items using JTextArea
        JTextArea cartArea = new JTextArea();
        cartArea.setEditable(false);
        cartArea.setFont(new Font("Monospaced", Font.PLAIN, 12));

        StringBuilder sb = new StringBuilder();
        sb.append("==============================\n");
        sb.append("        CART DETAILS\n");
        sb.append("==============================\n\n");

        double total = 0;
        //OOP CONCEPT: ITERATION - Processing each Order object in the cart collection

        for(Order order : cart){
            double itemTotal = order.calculateTotal();
            total += itemTotal;
            sb.append(String.format("%-20s x %-3d Rs.%8.2f\n",
                    order.getItem().getName(), 1, itemTotal));
        }

        sb.append("\n==============================\n");
        sb.append(String.format("TOTAL: Rs.%20.2f\n", total));
        sb.append("==============================\n");

        cartArea.setText(sb.toString());

        //Creating the Close button
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton closeBtn = new JButton("Close");
        closeBtn.addActionListener(e -> cartDialog.dispose());

        buttonPanel.add(closeBtn);

        mainPanel.add(new JScrollPane(cartArea), BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        cartDialog.add(mainPanel);
        cartDialog.setVisible(true);
    }

    //Processing the checkout
    private static void processCheckout(JFrame parentFrame, Runnable updateCart) {
        if (cart.isEmpty()) {
            JOptionPane.showMessageDialog(parentFrame,
                    "Your cart is empty! Add items to proceed.",
                    "Empty Cart",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        double total = cart.stream().mapToDouble(Order::calculateTotal).sum();

        //Building order summary
        StringBuilder summary = new StringBuilder();
        summary.append("══════════════════════════════════════════\n");
        summary.append("           ORDER CONFIRMATION\n");
        summary.append("══════════════════════════════════════════\n\n");

        for(Order order : cart){
            summary.append(String.format("  %-20s Rs.%8.2f\n",
                    order.getItem().getName(), order.calculateTotal()));
        }

        summary.append("\n══════════════════════════════════════════\n");
        summary.append(String.format("  TOTAL AMOUNT:     Rs.%8.2f\n", total));
        summary.append("══════════════════════════════════════════\n");

        //Creating the payment method selection dialog
        JPanel paymentPanel = new JPanel(new GridLayout(2, 1, 10, 10));
        paymentPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(25, 25, 112), 2),
                "Select Payment Method"
        ));

        JRadioButton cashButton = new JRadioButton("💵 Cash Payment");
        JRadioButton cardButton = new JRadioButton("💳 Credit/Debit Card");

        //Styling the radio buttons
        Font paymentFont = new Font("Segoe UI", Font.PLAIN, 14);
        cashButton.setFont(paymentFont);
        cardButton.setFont(paymentFont);

        //Grouping the radio buttons for payment methods
        ButtonGroup paymentGroup = new ButtonGroup();
        paymentGroup.add(cashButton);
        paymentGroup.add(cardButton);

        //Keeping cash by default
        cashButton.setSelected(true);

        //Adding the radio buttons to panel
        paymentPanel.add(cashButton);
        paymentPanel.add(cardButton);

        //Creating the main dialog panel
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        //Creating Order summary text area
        JTextArea summaryArea = new JTextArea(summary.toString());
        summaryArea.setEditable(false);
        summaryArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        summaryArea.setBackground(new Color(248, 249, 250));

        JScrollPane summaryScroll = new JScrollPane(summaryArea);
        summaryScroll.setBorder(BorderFactory.createTitledBorder("Order Summary"));
        summaryScroll.setPreferredSize(new Dimension(400, 200));

        mainPanel.add(summaryScroll, BorderLayout.CENTER);
        mainPanel.add(paymentPanel, BorderLayout.SOUTH);

        //Displaying confirmation dialog with payment options
        int option = JOptionPane.showConfirmDialog(parentFrame,
                mainPanel,
                "Confirm Order & Select Payment Method",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE);

        if(option == JOptionPane.OK_OPTION){
            //Determining the selected payment method
            String paymentMethod = cashButton.isSelected() ? "Cash" : "Credit/Debit Card";

            //Processing the payment based on selected method
            boolean paymentSuccess = processPayment(parentFrame, total, paymentMethod);

            if(paymentSuccess){
                dailyIncome += total; //Updates daily income
                cart.clear(); //Clears the cart
                updateCart.run(); //Updates display

                //Displaying confirmation message with payment method
                showReceipt(parentFrame, total, paymentMethod);
            }
        }
    }

    //Processing payment based on the selected method
    private static boolean processPayment(JFrame parentFrame, double amount, String paymentMethod){
        if(paymentMethod.equals("Cash")){
            //Cash payment
            JOptionPane.showMessageDialog(parentFrame,
                    "💰 Please pay Rs." + String.format("%.2f", amount) + " in cash to the cashier.\n\n" +
                            "Thank you for your order!",
                    "Cash Payment",
                    JOptionPane.INFORMATION_MESSAGE);
            return true;
        }else{
            //Card payment
            return processCardPayment(parentFrame, amount);
        }
    }

    //Implementing a separate method to process card payments
    private static boolean processCardPayment(JFrame parentFrame, double amount){
        //Creating card details panel
        JPanel cardPanel = new JPanel(new BorderLayout(10, 10));
        cardPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        //Top panel with amount
        JPanel topPanel = new JPanel(new BorderLayout());
        JLabel amountLabel = new JLabel(
                "<html><div style='text-align: center; font-size: 16px;'>" +
                        "<b>Card Payment</b><br>" +
                        "Amount: <font color='green' size='5'>Rs." + String.format("%.2f", amount) + "</font>" +
                        "</div></html>",
                SwingConstants.CENTER
        );
        topPanel.add(amountLabel, BorderLayout.CENTER);

        //Creating card details form
        JPanel formPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createTitledBorder("Enter Card Details"));

        JTextField cardNumberField = new JTextField();
        cardNumberField.setColumns(19); //16 digits + spaces in between

        JTextField expiryField = new JTextField();
        JTextField cvvField = new JPasswordField();
        JTextField nameField = new JTextField();

        //Adding placeholders
        cardNumberField.setText("1234 5678 9012 3456");
        expiryField.setText("12/25");
        cvvField.setText("123");
        nameField.setText("John Doe");

        formPanel.add(new JLabel("Card Number:"));
        formPanel.add(cardNumberField);
        formPanel.add(new JLabel("Expiry (MM/YY):"));
        formPanel.add(expiryField);
        formPanel.add(new JLabel("CVV:"));
        formPanel.add(cvvField);
        formPanel.add(new JLabel("Cardholder Name:"));
        formPanel.add(nameField);

        cardPanel.add(topPanel, BorderLayout.NORTH);
        cardPanel.add(formPanel, BorderLayout.CENTER);

        int result = JOptionPane.showConfirmDialog(parentFrame,
                cardPanel,
                "Card Payment - Rs." + String.format("%.2f", amount),
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE);

        if(result == JOptionPane.OK_OPTION){
            //Validating the information
            String cardNum = cardNumberField.getText().replaceAll("\\s+", "");
            String cvv = cvvField.getText().trim();
            String name = nameField.getText().trim();

            if(cardNum.length() < 16 || !cardNum.matches("\\d+")){
                JOptionPane.showMessageDialog(parentFrame,
                        "Please enter a valid 16-digit card number!",
                        "Invalid Card Number",
                        JOptionPane.ERROR_MESSAGE);
                return false;
            }

            if(cvv.length() < 3 || !cvv.matches("\\d+")){
                JOptionPane.showMessageDialog(parentFrame,
                        "Please enter a valid 3-digit CVV!",
                        "Invalid CVV",
                        JOptionPane.ERROR_MESSAGE);
                return false;
            }

            if(name.isEmpty()){
                JOptionPane.showMessageDialog(parentFrame,
                        "Please enter cardholder name!",
                        "Name Required",
                        JOptionPane.ERROR_MESSAGE);
                return false;
            }

            //Creating payment processing
            JOptionPane.showMessageDialog(parentFrame,
                    "✅ Card Payment Successful!\n\n" +
                            "Card: **** **** **** " + cardNum.substring(12) + "\n" +
                            "Amount: Rs." + String.format("%.2f", amount) + "\n" +
                            "Transaction ID: TXN" + System.currentTimeMillis() + "\n" +
                            "Thank you for your order!",
                    "Payment Approved",
                    JOptionPane.INFORMATION_MESSAGE);
            return true;
        }
        return false;
    }

    //Displaying the receipt after transaction
    private static void showReceipt(JFrame parentFrame, double total, String paymentMethod){
        StringBuilder receipt = new StringBuilder();
        receipt.append("══════════════════════════════════════════\n");
        receipt.append("           RESTAURANT RECEIPT\n");
        receipt.append("══════════════════════════════════════════\n\n");
        receipt.append("Order ID: #").append(String.format("%06d", (int)(Math.random() * 1000000))).append("\n");
        receipt.append("Date: ").append(java.time.LocalDate.now()).append("\n");
        receipt.append("Time: ").append(java.time.LocalTime.now().format(java.time.format.DateTimeFormatter.ofPattern("hh:mm a"))).append("\n");
        receipt.append("Payment: ").append(paymentMethod).append("\n\n");

        receipt.append("ITEMS ORDERED:\n");
        receipt.append("══════════════════════════════════════════\n");
        receipt.append(String.format("Total Items: %d\n\n", cart.size()));

        receipt.append("══════════════════════════════════════════\n");
        receipt.append(String.format("SUBTOTAL:        Rs.%8.2f\n", total));
        receipt.append(String.format("TAX (5%%):        Rs.%8.2f\n", total * 0.05));
        receipt.append(String.format("TOTAL:           Rs.%8.2f\n", total * 1.05));
        receipt.append("══════════════════════════════════════════\n");
        receipt.append("Payment Method: ").append(paymentMethod).append("\n");
        receipt.append("Status: PAID ✅\n\n");
        receipt.append("Thank you for dining with us!\n");
        receipt.append("Your food will be ready shortly.\n");
        receipt.append("══════════════════════════════════════════\n");

        JTextArea receiptArea = new JTextArea(receipt.toString());
        receiptArea.setEditable(false);
        receiptArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        receiptArea.setBackground(new Color(255, 255, 240));

        JScrollPane receiptScroll = new JScrollPane(receiptArea);
        receiptScroll.setPreferredSize(new Dimension(500, 350));

        JOptionPane.showMessageDialog(parentFrame,
                receiptScroll,
                "🎉 Order Complete - Receipt",
                JOptionPane.INFORMATION_MESSAGE);
    }

    // =========================================================================
    // ADMIN DASHBOARD METHODS
    // =========================================================================

    /*
    SWING FEATURES:
    1. GridLayout - For splitting dashboard into sections
    2. JTextArea - For displaying formatted text
    3. BorderFactory - For creating borders
     */
    private static void showAdminDashboard(){
        JFrame adminFrame = new JFrame("Admin Dashboard");
        adminFrame.setSize(800, 600);
        adminFrame.setLayout(new BorderLayout(10, 10));
        adminFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        adminFrame.setLocationRelativeTo(null);

        //Creating the Header Panel
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(new Color(25, 25, 112));
        headerPanel.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));

        JLabel titleLabel = new JLabel("🔐 Admin Dashboard", SwingConstants.LEFT);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);

        JButton backBtn = new JButton("← Back to Home");
        backBtn.setBackground(Color.WHITE);
        backBtn.setForeground(new Color(25, 25, 112));
        backBtn.setFocusPainted(false);

        headerPanel.add(titleLabel, BorderLayout.WEST);
        headerPanel.add(backBtn, BorderLayout.EAST);

        adminFrame.add(headerPanel, BorderLayout.NORTH);

        //Creating the Main Content Panel with two sections
        JPanel mainPanel = new JPanel(new GridLayout(1, 2, 20, 20));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        mainPanel.setBackground(Color.WHITE);

        // Staff Information Panel
        JPanel staffPanel = createInfoPanel("👥 Staff Details",
                getStaffInfo(), new Color(216, 108, 20));

        //Creating the Financial Information Panel
        JPanel financePanel = createInfoPanel("💰 Financial Report",
                getFinanceInfo(), new Color(58, 204, 58));

        mainPanel.add(staffPanel);
        mainPanel.add(financePanel);

        adminFrame.add(mainPanel, BorderLayout.CENTER);

        //Creating the Bottom Panel with action buttons
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        bottomPanel.setBackground(Color.WHITE);

        JButton refreshBtn = new JButton("🔄 Refresh Dashboard");
        refreshBtn.setBackground(new Color(108, 117, 125));
        refreshBtn.setForeground(Color.WHITE);
        refreshBtn.setFocusPainted(false);

        JButton logoutBtn = new JButton("🚪 Logout");
        logoutBtn.setBackground(new Color(220, 53, 69));
        logoutBtn.setForeground(Color.WHITE);
        logoutBtn.setFocusPainted(false);

        refreshBtn.addActionListener(e ->{
            adminFrame.dispose();
            showAdminDashboard();
        });

        logoutBtn.addActionListener(e ->{
            adminFrame.dispose();
            showLandingPage(); //Returns to landing page
        });

        bottomPanel.add(refreshBtn);
        bottomPanel.add(logoutBtn);

        adminFrame.add(bottomPanel, BorderLayout.SOUTH);

        backBtn.addActionListener(e ->{
            adminFrame.dispose();
            showLandingPage();
        });

        adminFrame.setVisible(true);
    }

    private static JPanel createInfoPanel(String title, String content, Color color){
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(color, 2),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));

        //Creating the Title Label
        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
        titleLabel.setForeground(color);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        //Creating the Content Area
        JTextArea contentArea = new JTextArea(content);
        contentArea.setEditable(false);
        contentArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        contentArea.setBackground(new Color(248, 249, 250));
        contentArea.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        panel.add(titleLabel, BorderLayout.NORTH);
        panel.add(new JScrollPane(contentArea), BorderLayout.CENTER);

        return panel;
    }

    private static String getStaffInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("ID    Name                Salary\n");
        sb.append("═══════════════════════════════════════\n");

        //OOP CONCEPT: ENCAPSULATION

        for(Staff s : rms.getStaffList()){
            sb.append(String.format("%-5d %-20s Rs.%10.2f\n",
                    s.getId(), s.getName(), s.calculateSalary()));
        }

        sb.append("═══════════════════════════════════════\n");
        sb.append(String.format("Total Staff: %d\n", rms.getStaffList().size()));

        return sb.toString();
    }

    private static String getFinanceInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("═══════════════════════════════════════\n");
        sb.append("        DAILY FINANCIAL REPORT\n");
        sb.append("═══════════════════════════════════════\n\n");

        sb.append(String.format("Income of the day: Rs.%15.2f\n\n", dailyIncome));

        sb.append("═══════════════════════════════════════\n");
        sb.append("     RECENT ORDERS (ESTIMATED)\n");
        sb.append("═══════════════════════════════════════\n\n");

        int orderCount = (int) (dailyIncome / 250);
        sb.append(String.format("Total Orders Today: %d\n", orderCount));
        sb.append(String.format("Average Order Value: Rs.%.2f\n",
                orderCount > 0 ? dailyIncome / orderCount : 0));

        return sb.toString();
    }
}