// Main class to test the functionality of the Car Rental System
public class Main {
    public static void main(String[] args) {
        // Create a rental agency
        RentalAgency agency = new RentalAgency();
        
        // Create and add cars to the agency
        Car car1 = new Car("KAZ 123u", "Subaru Impreza");
        Car car2 = new Car("KBU 539w", "Audi A4");
        agency.addCar(car1);
        agency.addCar(car2);
        
         // Create the first customer
         Customer customer1 = new Customer("Collince Korir", "CTV275");
        
         // Attempt to rent a car for the first customer
         Rental rental1 = agency.rentCar(customer1, 5);
         
         // Print the rental transaction outcome for the first customer
         if (rental1 != null) {
             System.out.println(customer1.getName() + " rented a " + rental1.getCar().getModel());
         } else {
             System.out.println("No cars available for " + customer1.getName());
         }
         // Create the second customer
         Customer customer2 = new Customer("Davis Wanyoike", "WCS873");
         
         // Attempt to rent a car for the second customer
         Rental rental2 = agency.rentCar(customer2, 3);
         
         // Print the rental transaction outcome for the second customer
         if (rental2 != null) {
             System.out.println(customer2.getName() + " rented a " + rental2.getCar().getModel());
         } else {
             System.out.println("No cars available for " + customer2.getName());
         }
     }
    }

