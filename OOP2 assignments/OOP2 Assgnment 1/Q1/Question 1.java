import java.util.ArrayList;
import java.util.List;

// Car class
// Represents a car available for rent
class Car {
    private String licensePlate;
    private String model;
    private boolean isRented;

    // Constructor to initialize car details
    public Car(String licensePlate, String model) {
        this.licensePlate = licensePlate;
        this.model = model;
        this.isRented = false;
    }

    // Getters to access car properties
    public String getLicensePlate() {
        return licensePlate;
    }

    public String getModel() {
        return model;
    }

    public boolean isRented() {
        return isRented;
    }

    // Marks the car as rented
    public void rentCar() {
        isRented = true;
    }

    // Marks the car as available again
    public void returnCar() {
        isRented = false;
    }
}

// Customer class
// Represents a customer renting a car
class Customer {
    private String name;
    private String driverLicense;

    // Constructor to initialize customer details
    public Customer(String name, String driverLicense) {
        this.name = name;
        this.driverLicense = driverLicense;
    }

    // Getters to access customer properties
    public String getName() {
        return name;
    }

    public String getDriverLicense() {
        return driverLicense;
    }
}

// Rental class
// Represents a rental transaction between a customer and a car
class Rental {
    private Car car;
    private Customer customer;

    // Getter to access the customer
    public Customer getCustomer() {
        return customer;
    }
    private int days;

    // Getter to access the rental duration in days
    public int getDays() {
        return days;
    }

    // Constructor to initialize rental details and mark car as rented
    public Rental(Car car, Customer customer, int days) {
        this.car = car;
        this.customer = customer;
        this.days = days;
        car.rentCar();
    }

    // Ends the rental and marks the car as available
    public void endRental() {
        car.returnCar();
    }

    // Getter to access the car
    public Car getCar() {
        return car;
    }
}

// RentalAgency class
// Manages the rental process and available cars

class RentalAgency {
    private List<Car> cars; // List of available cars
    private List<Rental> rentals; // List of active rentals

    // Constructor to initialize the rental agency
    public RentalAgency() {
        cars = new ArrayList<>();
        rentals = new ArrayList<>();
    }

    // Adds a car to the rental agency
    public void addCar(Car car) {
        cars.add(car);
    }

    // Finds an available car for rent
    public Car findAvailableCar() {
        for (Car car : cars) {
            if (!car.isRented()) {
                return car;
            }
        }
        return null;
    }

    // Processes a rental transaction
    public Rental rentCar(Customer customer, int days) {
        Car availableCar = findAvailableCar();
        if (availableCar != null) {
            Rental rental = new Rental(availableCar, customer, days);
            rentals.add(rental);
            return rental;
        }
        return null;
    }
}

