import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class MyClass {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Hotel[] h = new Hotel[4];

        // Input hotels
        for(int i = 0; i < h.length; i++) {
            int a = in.nextInt();
            in.nextLine();
            String b = in.nextLine();
            String c = in.nextLine();
            int d = in.nextInt();
            in.nextLine();
            String e = in.nextLine();
            double f = in.nextDouble();

            h[i] = new Hotel(a, b, c, d, e, f);
        }

        // Read month and wifi option
        in.nextLine();
        String inputmonth = in.nextLine();
        String inputwifi = in.nextLine();

        // Calculate booked rooms
        int countroom = noOfRoomsBookedInGivenMonth(h, inputmonth);

        // Output booked rooms count
        if(countroom > 0) {
            System.out.println(countroom);
        } else {
            System.out.println("No rooms booked in the given month");
        }

        // Search for hotel by wifi option
        Hotel obj = searchHotelByWifiOption(h, inputwifi);

        // Output hotel ID
        if(obj == null) {
            System.out.println("No such option is available");
        } else {
            System.out.println(obj.getHotelId());
        }
    }

    public static int noOfRoomsBookedInGivenMonth(Hotel[] h, String inputmonth) {
        int total = 0;
        //System.out.println("Input Month: " + inputmonth); // Debugging

        // Iterate through hotels
        for(Hotel hotel : h) {
            // Get month from booking date
            String str = hotel.getDateOfBooking().substring(3, 6);
           // System.out.println("Hotel Booking Date Month: " + str + " - Rooms: " + hotel.getNoOfRoomsBooked()); // Debugging

            // Check if month matches
            if(str.equalsIgnoreCase(inputmonth)) {
                total += hotel.getNoOfRoomsBooked();
            }
        }
        return total;
    }

    public static Hotel searchHotelByWifiOption(Hotel[] h, String inputwifi) {
       /* Hotel[] matchingHotels = Arrays.stream(h)
                .filter(hotel -> hotel.getWifiFacility().equalsIgnoreCase(inputwifi))
                .toArray(Hotel[]::new);*/
        List<Hotel> matchingHotels = new ArrayList<>();

        for(Hotel hotel:h){
            if(hotel.getWifiFacility().equalsIgnoreCase(inputwifi)){
                matchingHotels.add(hotel);
            }
        }

        // If less than 2 hotels match, return null
        if (matchingHotels.size() < 2) {
            return null;
        }

        // Sort the matching hotels by totalBill in descending order
        matchingHotels.sort((h1, h2) -> Double.compare(h2.getTotalBill(), h1.getTotalBill()));

        // Return the hotel with the second-highest total bill
        return matchingHotels[1];


    }
}


class Hotel {
    private int hotelId;
    private String hotelName;
    private String dateOfBooking;
    private int noOfRoomsBooked;
    private String wifiFacility;
    private double totalBill;

    public Hotel(int hotelId, String hotelName, String dateOfBooking, int noOfRoomsBooked, String wifiFacility, double totalBill) {
        this.hotelId = hotelId;
        this.hotelName = hotelName;
        this.dateOfBooking = dateOfBooking;
        this.noOfRoomsBooked = noOfRoomsBooked;
        this.wifiFacility = wifiFacility;
        this.totalBill = totalBill;
    }

    public int getHotelId() {
        return hotelId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public String getDateOfBooking() {
        return dateOfBooking;
    }

    public int getNoOfRoomsBooked() {
        return noOfRoomsBooked;
    }

    public String getWifiFacility() {
        return wifiFacility;
    }

    public double getTotalBill() {
        return totalBill;
    }
}
