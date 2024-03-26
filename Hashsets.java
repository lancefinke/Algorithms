import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Hashsets {

    private static HashMap<String, Double> items = new HashMap<>();

    private static Scanner input = new Scanner(System.in);

    public static void addItem(){
        System.out.println("Enter an Item: ");
        String key = input.nextLine();
        System.out.println("Enter a Price: ");
        double value = input.nextDouble();
        input.nextLine();
        items.put(key,value);
    }

    public static void removeItem(){
        System.out.println("Enter an Item to delete: ");
        String item= input.nextLine();
        if(!items.containsKey(item)){
            System.out.println("Item not found.");
        }
        else{
            items.remove(item);
        }
    }

    public static void viewItems(){
        if(items.size()==0){
            System.out.println("Item List is Empty.");
        }
        else{
            for(Map.Entry<String,Double> entry : items.entrySet()){
                System.out.println(entry.getKey()+" $"+entry.getValue());
            }
        }
    }

    public static void sortItems(){
        ArrayList<Map.Entry<String, Double>> sortedItems = new ArrayList<>(items.entrySet());
        sortedItems.sort(Map.Entry.comparingByValue());
        for (Map.Entry<String, Double> entry : sortedItems) {
            System.out.println(entry.getKey() + ": $" + entry.getValue());
        }

    }

    public static void displayMenu(){
        System.out.println("1. ADD item\n"+"2. REMOVE item\n"+"3. SORT items\n"+"4. DISPLAY items\n"+"5. EXIT");
        System.out.println("Select an option: ");
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, Double> items = new HashMap<>();
        int choice = 0;
        do {
            displayMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (choice) {
                case 1:
                    addItem();
                    break;
                case 2:
                    removeItem();
                    break;
                case 3:
                    sortItems();
                    break;
                case 4:
                    viewItems();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);
    }
}
