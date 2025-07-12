

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CarParkingSystemGUI extends JFrame {
    private CardLayout cardLayout;
    private JPanel mainPanel, loginPanel, registerPanel, vehiclePanel, reportPanel, contentPanel;
    private double totalEarnings;
    private VehicleRegistration vehicleRegistration;
    private Register registeredUser;
    private boolean isLogin;

    public CarParkingSystemGUI() {
        setTitle("Car Parking System");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        contentPanel = new JPanel(cardLayout);

        // Initialize panels
        mainPanel = new JPanel(new GridBagLayout());
        loginPanel = new JPanel(new GridBagLayout());
        registerPanel = new JPanel(new GridBagLayout());
        vehiclePanel = new JPanel(new GridBagLayout());
        reportPanel = new JPanel(new GridBagLayout());

        totalEarnings = 0;
        vehicleRegistration = new VehicleRegistration();

        // Header panel with logo and title
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(new Color(0, 102, 204));
        JLabel headerLabel = new JLabel("CAR PARKING SYSTEM", SwingConstants.CENTER);
        headerLabel.setFont(new Font("Arial", Font.BOLD, 28));
        headerLabel.setForeground(Color.WHITE);
        // Replace "path/to/logo.png" with the actual path to your logo image
        ImageIcon logoIcon = new ImageIcon("E:\\Sheeraz\\Parking_GUI\\car.png");
        
        Image image = logoIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        // Create resized ImageIcon
        ImageIcon resizedLogoIcon = new ImageIcon(image);
        // Set resized logo to JLabel
        JLabel logoLabel = new JLabel(resizedLogoIcon);
        // Add logoLabel to headerPanel
        headerPanel.add(logoLabel);
     
        headerPanel.add(logoLabel, BorderLayout.WEST);
        headerPanel.add(headerLabel, BorderLayout.CENTER);

        // Add header to the main frame
        add(headerPanel, BorderLayout.NORTH);
        add(contentPanel, BorderLayout.CENTER);

     // Load logo image
       // ImageIcon logoIcon = new ImageIcon("path/to/logo.png");
        // Resize logo image
        

        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        // Login Panel
        JLabel loginTitle = new JLabel("Login", SwingConstants.CENTER);
        loginTitle.setFont(new Font("Arial", Font.BOLD, 24));
        loginTitle.setForeground(new Color(0, 102, 204));
        JTextField loginEmailField = new JTextField(15);
        JPasswordField loginPasswordField = new JPasswordField(15);
        JButton loginButton = new JButton("Login");
        JButton registerButton = new JButton("Register");

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        loginPanel.add(loginTitle, gbc);

        gbc.gridy++;
        gbc.gridwidth = 1;
        loginPanel.add(new JLabel("Email:"), gbc);
        gbc.gridx++;
        loginPanel.add(loginEmailField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        loginPanel.add(new JLabel("Password:"), gbc);
        gbc.gridx++;
        loginPanel.add(loginPasswordField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        loginPanel.add(loginButton, gbc);
        gbc.gridx++;
        loginPanel.add(registerButton, gbc);

        // Register Panel
        JLabel registerTitle = new JLabel("Register", SwingConstants.CENTER);
        registerTitle.setFont(new Font("Arial", Font.BOLD, 24));
        registerTitle.setForeground(new Color(0, 102, 204));
        JTextField regNameField = new JTextField(15);
        JTextField regEmailField = new JTextField(15);
        JPasswordField regPasswordField = new JPasswordField(15);
        JTextField regPhoneField = new JTextField(15);
        JRadioButton maleRadioButton = new JRadioButton("Male");
        JRadioButton femaleRadioButton = new JRadioButton("Female");
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleRadioButton);
        genderGroup.add(femaleRadioButton);
        JButton submitRegisterButton = new JButton("Submit");

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        registerPanel.add(registerTitle, gbc);

        gbc.gridy++;
        gbc.gridwidth = 1;
        registerPanel.add(new JLabel("Name:"), gbc);
        gbc.gridx++;
        registerPanel.add(regNameField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        registerPanel.add(new JLabel("Email:"), gbc);
        gbc.gridx++;
        registerPanel.add(regEmailField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        registerPanel.add(new JLabel("Password:"), gbc);
        gbc.gridx++;
        registerPanel.add(regPasswordField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        registerPanel.add(new JLabel("Phone:"), gbc);
        gbc.gridx++;
        registerPanel.add(regPhoneField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        registerPanel.add(new JLabel("Gender:"), gbc);
        gbc.gridx++;
        registerPanel.add(maleRadioButton, gbc);
        gbc.gridy++;
        registerPanel.add(femaleRadioButton, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        registerPanel.add(submitRegisterButton, gbc);

        // Main Panel
        JLabel mainTitle = new JLabel("Main Menu", SwingConstants.CENTER);
        mainTitle.setFont(new Font("Arial", Font.BOLD, 24));
        mainTitle.setForeground(new Color(0, 102, 204));
        JButton vehicleRegButton = new JButton("Vehicle Registration");
        JButton reportButton = new JButton("Report");
        JButton searchButton = new JButton("Search");
        JButton bookSlotButton = new JButton("Book Slot");
        JButton logoutButton = new JButton("Logout");

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        mainPanel.add(mainTitle, gbc);

        gbc.gridy++;
        gbc.gridwidth = 1;
        mainPanel.add(vehicleRegButton, gbc);

        gbc.gridx = 1;
        mainPanel.add(reportButton, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        mainPanel.add(searchButton, gbc);

        gbc.gridx = 1;
        mainPanel.add(bookSlotButton, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        mainPanel.add(logoutButton, gbc);

        // Vehicle Panel
        JLabel vehicleTitle = new JLabel("Vehicle Registration", SwingConstants.CENTER);
        vehicleTitle.setFont(new Font("Arial", Font.BOLD, 24));
        vehicleTitle.setForeground(new Color(0, 102, 204));
        JTextField modelNameField = new JTextField(15);
        JTextField yearField = new JTextField(15);
        JTextField companyField = new JTextField(15);
        JTextField numberPlateField = new JTextField(15);
        JTextField removePlateField = new JTextField(15);
        JButton addVehicleButton = new JButton("Add Vehicle");
        JButton removeVehicleButton = new JButton("Remove Vehicle");
        JButton showVehiclesButton = new JButton("Show Vehicles");
        JButton backToMainButton = new JButton("Back");

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        vehiclePanel.add(vehicleTitle, gbc);

        gbc.gridy++;
        gbc.gridwidth = 1;
        vehiclePanel.add(new JLabel("Model Name:"), gbc);
        gbc.gridx++;
        vehiclePanel.add(modelNameField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        vehiclePanel.add(new JLabel("Year:"), gbc);
        gbc.gridx++;
        vehiclePanel.add(yearField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        vehiclePanel.add(new JLabel("Company:"), gbc);
        gbc.gridx++;
        vehiclePanel.add(companyField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        vehiclePanel.add(new JLabel("Number Plate:"), gbc);
        gbc.gridx++;
        vehiclePanel.add(numberPlateField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        vehiclePanel.add(addVehicleButton, gbc);

        gbc.gridy++;
        vehiclePanel.add(new JLabel("Remove Plate:"), gbc);
        gbc.gridx++;
        vehiclePanel.add(removePlateField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        vehiclePanel.add(removeVehicleButton, gbc);

        gbc.gridy++;
        vehiclePanel.add(showVehiclesButton, gbc);

        gbc.gridy++;
        gbc.gridwidth = 2;
        vehiclePanel.add(backToMainButton, gbc);

        // Report Panel
        JLabel reportTitle = new JLabel("Reports", SwingConstants.CENTER);
        reportTitle.setFont(new Font("Arial", Font.BOLD, 24));
        reportTitle.setForeground(new Color(0, 102, 204));
        JButton dailyEarningsButton = new JButton("Daily Earnings");
        JButton vehicleUsageButton = new JButton("Vehicle Usage");
        JButton slotUsageButton = new JButton("Slot Usage");
        JButton regVehiclesButton = new JButton("Registered Vehicles");
        JButton backButton = new JButton("Back");

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        reportPanel.add(reportTitle, gbc);

        gbc.gridy++;
        gbc.gridwidth = 1;
        reportPanel.add(dailyEarningsButton, gbc);

        gbc.gridx = 1;
        reportPanel.add(vehicleUsageButton, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        reportPanel.add(slotUsageButton, gbc);

        gbc.gridx = 1;
        reportPanel.add(regVehiclesButton, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        reportPanel.add(backButton, gbc);

        // Add panels to CardLayout
        contentPanel.add(mainPanel, "Main");
        contentPanel.add(loginPanel, "Login");
        contentPanel.add(registerPanel, "Register");
        contentPanel.add(vehiclePanel, "Vehicle");
        contentPanel.add(reportPanel, "Report");

        // Add action listeners
        loginButton.addActionListener(e -> {
            String email = loginEmailField.getText();
            String password = new String(loginPasswordField.getPassword());
            Login login = new Login(email, password);
            if (registeredUser != null && login.login(registeredUser)) {
                isLogin = true;
                JOptionPane.showMessageDialog(this, "Login successful!");
                cardLayout.show(contentPanel, "Main");
            } else {
                JOptionPane.showMessageDialog(this, "Login failed. Incorrect email or password.");
            }
        });

        registerButton.addActionListener(e -> cardLayout.show(contentPanel, "Register"));

        submitRegisterButton.addActionListener(e -> {
            String name = regNameField.getText();
            String email = regEmailField.getText();
            String password = new String(regPasswordField.getPassword());
            String phone = regPhoneField.getText();
            String gender = maleRadioButton.isSelected() ? "Male" : "Female";
            registeredUser = new Register();
            registeredUser.setname(name);
            registeredUser.setemail(email);
            registeredUser.setpassword(password);
            registeredUser.setphoneNumber(phone);
            registeredUser.setgender(gender);
            JOptionPane.showMessageDialog(this, "Registration successful!");
            cardLayout.show(contentPanel, "Login");
        });

        vehicleRegButton.addActionListener(e -> cardLayout.show(contentPanel, "Vehicle"));

        reportButton.addActionListener(e -> cardLayout.show(contentPanel, "Report"));

        searchButton.addActionListener(e -> JOptionPane.showMessageDialog(this, "Search functionality to be implemented."));

        bookSlotButton.addActionListener(e -> {
            if (vehicleRegistration.getCount() == 0) {
                JOptionPane.showMessageDialog(this, "No vehicles registered. Please register a vehicle first.");
                return;
            }
            String[] registeredVehicles = vehicleRegistration.getVehicleNumbers();
            String selectedVehicle = (String) JOptionPane.showInputDialog(this, "Select vehicle:", "Book Slot",
                    JOptionPane.QUESTION_MESSAGE, null, registeredVehicles, registeredVehicles[0]);
            if (selectedVehicle != null) {
                String hoursStr = JOptionPane.showInputDialog(this, "Enter hours:");
                int hours = Integer.parseInt(hoursStr);
                BookSlot bookSlot = new BookSlot();
                bookSlot.bookSlot(hours);
                Payment payment = new Payment(100.0);
                double bill = payment.generateBill(hours);
                totalEarnings += bill;
                saveBillToFile(selectedVehicle, hours, bill);
            }
        });

        logoutButton.addActionListener(e -> {
            isLogin = false;
            JOptionPane.showMessageDialog(this, "Logged out successfully.");
            cardLayout.show(contentPanel, "Login");
        });

        addVehicleButton.addActionListener(e -> {
            String modelName = modelNameField.getText();
            int year = Integer.parseInt(yearField.getText());
            String company = companyField.getText();
            String numberPlate = numberPlateField.getText();
            vehicleRegistration.addVehicle(modelName, year, company, numberPlate);
        });

        removeVehicleButton.addActionListener(e -> {
            String numberPlate = removePlateField.getText();
            vehicleRegistration.removeVehicle(numberPlate);
        });

        showVehiclesButton.addActionListener(e -> {
            StringBuilder vehicles = new StringBuilder("Registered Vehicles:\n");
            for (Vehicle vehicle : vehicleRegistration.getVehicles()) {
                vehicles.append(vehicle.toString()).append("\n");
            }
            JOptionPane.showMessageDialog(this, vehicles.toString());
        });

        backToMainButton.addActionListener(e -> cardLayout.show(contentPanel, "Main"));

        backButton.addActionListener(e -> cardLayout.show(contentPanel, "Main"));

        dailyEarningsButton.addActionListener(e -> JOptionPane.showMessageDialog(this, "Total earnings: " + totalEarnings));

        vehicleUsageButton.addActionListener(e -> JOptionPane.showMessageDialog(this, "Vehicle usage report to be implemented."));

        slotUsageButton.addActionListener(e -> JOptionPane.showMessageDialog(this, "Slot usage report to be implemented."));

        regVehiclesButton.addActionListener(e -> {
            StringBuilder vehicles = new StringBuilder("Registered Vehicles:\n");
            for (Vehicle vehicle : vehicleRegistration.getVehicles()) {
                vehicles.append(vehicle.toString()).append("\n");
            }
            JOptionPane.showMessageDialog(this, vehicles.toString());
        });

        // Set initial panel
        cardLayout.show(contentPanel, "Login");
    }

    private void saveBillToFile(String vehicle, int hours, double bill) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("parking_bills.txt", true))) {
            writer.write("Vehicle: " + vehicle + ", Hours: " + hours + ", Bill: " + bill + "\n");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error saving bill to file.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CarParkingSystemGUI().setVisible(true));
    }
}

class Vehicle {
    private String modelName;
    private int year;
    private String company;
    private String numberPlate;

    public Vehicle(String modelName, int year, String company, String numberPlate) {
        this.modelName = modelName;
        this.year = year;
        this.company = company;
        this.numberPlate = numberPlate;
    }

    public String getModelName() {
        return modelName;
    }

    public int getYear() {
        return year;
    }

    public String getCompany() {
        return company;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    @Override
    public String toString() {
        return "Model Name: " + modelName + ", Year: " + year + ", Company: " + company + ", Number Plate: " + numberPlate;
    }
}

class VehicleRegistration {
    private Vehicle[] vehicles;
    private int count;

    public VehicleRegistration() {
        vehicles = new Vehicle[5];
        count = 0;
    }

    public void addVehicle(String modelName, int year, String company, String numberPlate) {
        if (count < vehicles.length) {
            vehicles[count++] = new Vehicle(modelName, year, company, numberPlate);
            JOptionPane.showMessageDialog(null, "Vehicle added successfully.");
        } else {
            JOptionPane.showMessageDialog(null, "Cannot add more vehicles. The limit is 5.");
        }
    }

    public void removeVehicle(String numberPlate) {
        for (int i = 0; i < count; i++) {
            if (vehicles[i].getNumberPlate().equals(numberPlate)) {
                vehicles[i] = vehicles[--count];
                vehicles[count] = null;
                JOptionPane.showMessageDialog(null, "Vehicle removed successfully.");
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Vehicle not found.");
    }

    public Vehicle[] getVehicles() {
        Vehicle[] registeredVehicles = new Vehicle[count];
        System.arraycopy(vehicles, 0, registeredVehicles, 0, count);
        return registeredVehicles;
    }

    public String[] getVehicleNumbers() {
        String[] vehicleNumbers = new String[count];
        for (int i = 0; i < count; i++) {
            vehicleNumbers[i] = vehicles[i].getNumberPlate();
        }
        return vehicleNumbers;
    }

    public int getCount() {
        return count;
    }
}

class BookSlot {
    public void bookSlot(int hours) {
        JOptionPane.showMessageDialog(null, "Slot booked for " + hours + " hours.");
    }
}

class Payment {
    private double pricePerHour;

    public Payment(double pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    public double generateBill(int hours) {
        double totalAmount = pricePerHour * hours;
        JOptionPane.showMessageDialog(null, "Bill generated: " + totalAmount + " for " + hours + " hours.");
        return totalAmount;
    }
}

class Register {
    private String name;
    private String email;
    private String password;
    private String phoneNumber;
    private String gender;

    public void setname(String name) {
        this.name = name;
    }

    public void setemail(String email) {
        this.email = email;
    }

    public void setpassword(String password) {
        this.password = password;
    }

    public void setphoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setgender(String gender) {
        this.gender = gender;
    }

    public String getemail() {
        return email;
    }

    public String getpassword() {
        return password;
    }
}

class Login {
    private String email;
    private String password;

    public Login(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public boolean login(Register registeredUser) {
        return registeredUser != null && registeredUser.getemail().equals(email) && registeredUser.getpassword().equals(password);
    }
}
