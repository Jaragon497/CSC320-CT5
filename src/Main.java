import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int avg = 0;
        boolean foundMonth = false;
        Scanner sc = new Scanner(System.in);

        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September",
                "October", "November", "December"};

        int[] monthlyTemps = new int[months.length];
        monthlyTemps[0] = 29;
        monthlyTemps[1] = 32;
        monthlyTemps[2] = 38;
        monthlyTemps[3] = 45;
        monthlyTemps[4] = 53;
        monthlyTemps[5] = 64;
        monthlyTemps[6] = 72;
        monthlyTemps[7] = 70;
        monthlyTemps[8] = 66;
        monthlyTemps[9] = 45;
        monthlyTemps[10] = 37;
        monthlyTemps[11] = 30;

        System.out.print("Enter month name to see average temp >> ");
        String user_month = sc.nextLine();
        sc.close();

        // If user wants YEARLY summary...
        if (user_month.equalsIgnoreCase("year")){
            int max_idx = 0;
            int min_idx = 0;

            for (int i = 0; i < monthlyTemps.length; i++){
                // If the temp at index i is greater than temp @ max index
                //  set max_idx to i
                if (monthlyTemps[i] > monthlyTemps[max_idx]) {
                    max_idx = i;
                }
                // Same as above but inverted for minimums
                else if (monthlyTemps[i] < monthlyTemps[min_idx]) {
                    min_idx = i;
                }
                // Prepare to calculate average
                avg += monthlyTemps[i];
                String formatted = String.format("%-10s %d",months[i], monthlyTemps[i]);
                System.out.println(formatted);
            }

            System.out.println();
            System.out.println("Yearly Avg: " + avg/12 + " degrees.");
            System.out.println("Highest:\t" + months[max_idx] + " @ " + monthlyTemps[max_idx] + " degrees.");
            System.out.println("Lowest:\t\t" + months[min_idx] + " @ " + monthlyTemps[min_idx] + " degrees.");
        }
        else{
            // Check if user_input matches month
            for (int i = 0; i < months.length; i++) {
                // If a match is found
                //  Print out average temp for that month
                //  change `foundMonth` to be true
                if (user_month.equalsIgnoreCase(months[i])) {
                    System.out.println(months[i] + " had an average temperature of " + monthlyTemps[i] + " degrees.");
                    foundMonth = true;
                }
            }
            // If no months found, print error message
            if (!foundMonth){
                System.out.println("Error: Please enter a proper month name.");
            }
        }
    }
}