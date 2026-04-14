import java.util.ArrayList;
import java.util.Scanner;

class Parcel {
    private String parcelId;
    private String status;

    // Constructor
    public Parcel(String parcelId) {
        this.parcelId = parcelId;
        this.status = "Dispatched";
    }

    // Update status
    public void updateStatus(String newStatus) {
        this.status = newStatus;
    }

    // Get methods
    public String getParcelId() {
        return parcelId;
    }

    public String getStatus() {
        return status;
    }
}

public class CourierSystem {
    static ArrayList<Parcel> parcelList = new ArrayList<>();

    // Add Parcel
    public static void addParcel(String id) {
        parcelList.add(new Parcel(id));
        System.out.println("✔ Parcel Added: " + id);
    }

    // Search Parcel
    public static Parcel searchParcel(String id) {
        for (Parcel p : parcelList) {
            if (p.getParcelId().equals(id)) {
                return p;
            }
        }
        return null;
    }

    // Display All Parcels (Grid Style)
    public static void displayParcels() {
        System.out.println("\nParcel List:");
        int count = 0;

        for (Parcel p : parcelList) {
            System.out.print("[" + p.getParcelId() + "] ");
            count++;
            if (count % 3 == 0) System.out.println();
        }

        // Fill empty slots
        while (count < 9) {
            System.out.print("[----] ");
            count++;
            if (count % 3 == 0) System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Sample Data
        addParcel("P101");
        addParcel("P102");
        addParcel("P103");

        displayParcels();

        // Search
        System.out.print("\nSearching for Parcel ID: ");
        String id = sc.nextLine();

        Parcel found = searchParcel(id);

        if (found != null) {
            System.out.println("✔ Found");
            System.out.println("Status: " + found.getStatus());
        } else {
            System.out.println("✖ Parcel Not Found");
        }

        // Update
        System.out.print("\nEnter Parcel ID to Update: ");
        String updateId = sc.nextLine();

        Parcel updateParcel = searchParcel(updateId);

        if (updateParcel != null) {
            System.out.print("Enter New Status: ");
            String newStatus = sc.nextLine();
            updateParcel.updateStatus(newStatus);
            System.out.println("✔ Status Updated");
        } else {
            System.out.println("✖ Parcel Not Found");
        }

        // Check again
        System.out.print("\nSearch Again (Enter ID): ");
        String checkId = sc.nextLine();

        Parcel check = searchParcel(checkId);

        if (check != null) {
            System.out.println("✔ Found");
            System.out.println("Status: " + check.getStatus());
        } else {
            System.out.println("✖ Parcel Not Found");
        }

        sc.close();
    }
}