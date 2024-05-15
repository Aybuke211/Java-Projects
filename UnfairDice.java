import java.util.HashMap;
import java.util.Map;

public class UnfairDice {
        private Map<Integer, Double> probabilities;
        private int roll_count;
        private Map<Integer, Integer> side_counts;
    
        public UnfairDice() {
            probabilities = new HashMap<>();
            probabilities.put(1, 0.05);
            probabilities.put(2, 0.10);
            probabilities.put(3, 0.20);
            probabilities.put(4, 0.05);
            probabilities.put(5, 0.05);
            probabilities.put(6, 0.05);
            probabilities.put(7, 0.05);
            probabilities.put(8, 0.05);
            probabilities.put(9, 0.10);
            probabilities.put(10, 0.30);
    
            roll_count = 0;
            side_counts = new HashMap<>();
            for (int i = 1; i <= 10; i++) {
                side_counts.put(i, 0);
            }
        }
    
        public int roll() {
            double rand = Math.random();
            double cumulativeProb = 0.0;
    
            for (int side = 1; side <= 10; side++) {
                cumulativeProb += probabilities.get(side);
                if (rand <= cumulativeProb) {
                    roll_count++;
                    side_counts.put(side, side_counts.get(side) + 1);
                    return side;
                }
            }
    
            return 0; 
        }
    
        public int getRollCount() {
            return roll_count;
        }
    
        public int getSideCount(int side) {
            return side_counts.get(side);
        }

        public class ReportGenerator {
            public String generateReport(UnfairDice dice) {
                StringBuilder report = new StringBuilder("Dice has been Rolled " + dice.getRollCount() + " times\n");
                for (int side = 1; side <= 10; side++) {
                    report.append(side).append(": >").append(dice.getSideCount(side)).append(", ");
                }
                report.setLength(report.length() - 2); 
                return report.toString();
            }
        }
        public class Main {
            public static void main(String[] args) {
                UnfairDice dice = new UnfairDice();
                ReportGenerator reportGenerator = dice.new ReportGenerator();
               
        
                for (int i = 0; i < 20; i++) {
                    int rollResult = dice.roll();
                    System.out.println("Rolled: " + rollResult);
                }
        
                String report = reportGenerator.generateReport(dice);
                System.out.println(report);
            }
        }
    }
       


    

