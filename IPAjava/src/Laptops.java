import java.util.*;

class Class {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Laptop[] lp = new Laptop[4]; // Array of 4 Laptop objects

        // Taking input for 4 laptops
        for (int i = 0; i < 4; i++) {
            int a = in.nextInt(); in.nextLine(); // Laptop ID
            String b = in.nextLine(); // Brand
            String c = in.nextLine(); // OS type
            Double d = in.nextDouble(); in.nextLine(); // Price
            int e = in.nextInt(); in.nextLine(); // Rating
            lp[i] = new Laptop(a, b, c, d, e);
        }

        String brand = in.nextLine(); // Brand to search
        String osType = in.nextLine(); // OS type to search

        // Counting laptops by brand with rating > 3
        int count = countOfLaptopByBrand(lp, brand);
        if (count != 0) {
            System.out.println(count);
        } else {
            System.out.println("The given brand is not available");
        }

        // Searching laptops by OS type
        Laptop[] sos = searchLaptopByOsType(lp, osType);
        if (sos != null) {
            for (int i = sos.length-1; i >=0;  i--) { // Printing the Laptop IDs of found laptops
                System.out.println(sos[i].getLaptopId());
                System.out.println(sos[i].getRating());
            }
        } else {
            System.out.println("The given OS is not available");
        }
    }

    // Method to count laptops by brand with rating > 3
    public static int countOfLaptopByBrand(Laptop[] lp, String brand) {
        int count = 0;
        for (int i = 0; i < lp.length; i++) {
            if (lp[i].getBrand().equalsIgnoreCase(brand) && lp[i].getRating() > 3) {
                count++;
            }
        }
        return count;
    }

    // Method to search laptops by OS type
    public static Laptop[] searchLaptopByOsType(Laptop[] lp, String type) {
        Laptop[] res = new Laptop[0]; // Initialize empty array

        // Iterating over laptops and adding matching ones to the result array
        for (int i = 0; i < lp.length; i++) {
            if (lp[i].getosType().equalsIgnoreCase(type)) {
                res = Arrays.copyOf(res, res.length + 1); // Resize array
                res[res.length - 1] = lp[i]; // Add matching laptop
            }
        }

        // Return result array or null if no matching laptops are found
        return res.length > 0 ? res : null;
    }
}

// Laptop class definition
class Laptop {
    private int laptopId;
    private int rating;
    private String brand;
    private String osType;
    private Double price;

    // Constructor
    public Laptop(int laptopId, String brand, String osType, Double price, int rating) {
        this.laptopId = laptopId;
        this.brand = brand;
        this.osType = osType;
        this.price = price;
        this.rating = rating;
    }

    // Getter and setter methods for Laptop properties
    public int getLaptopId() {
        return laptopId;
    }

    public void setLaptopId(int laptopId) {
        this.laptopId = laptopId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getosType() {
        return osType;
    }

    public void setosType(String osType) {
        this.osType = osType;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
