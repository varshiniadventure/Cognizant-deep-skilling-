import java.util.*;

public class FinancialForecast {
    public static List<Double> movingAverage(List<Double> prices, int windowSize) {
        List<Double> forecast = new ArrayList<>();
        double sum = 0.0;
        int n = prices.size();

        for (int i = 0; i < windowSize; i++) {
            sum += prices.get(i);
        }
        forecast.add(sum / windowSize);

        for (int i = windowSize; i < n; i++) {
            sum += prices.get(i) - prices.get(i - windowSize);
            forecast.add(sum / windowSize);
        }

        return forecast;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of days of price data: ");
        int n = scanner.nextInt();
        List<Double> prices = new ArrayList<>();

        System.out.println("Enter stock prices:");
        for (int i = 0; i < n; i++) {
            prices.add(scanner.nextDouble());
        }

        System.out.print("Enter window size for moving average (e.g., 3): ");
        int windowSize = scanner.nextInt();

        if (windowSize > n) {
            System.out.println("Window size should be less than or equal to number of prices.");
            return;
        }

        List<Double> result = movingAverage(prices, windowSize);

        System.out.println("Forecasted Moving Averages:");
        for (double avg : result) {
            System.out.printf("%.2f ", avg);
        }

        scanner.close();
    }
}
