
import java.util.Random;
public class Crab_Game {
    

    public static void rollDice(){
        Random random = new Random();
        boolean isFirstTurn = true;
        while(isFirstTurn == true){
            int dice_1 = random.nextInt(6)+1;
            int dice_2 = random.nextInt(6)+1;
            int dice_1_1 = random.nextInt(6)+1;
            int dice_1_2 = random.nextInt(6)+1;
            System.out.println("rolling first player dice 1: " +dice_1+ " dice 2: " +dice_2);
            int total_1 = dice_1 + dice_2;
            int total_2 = dice_1_1 + dice_1_2;
            if(dice_1 == 6 && dice_2 == 6 || dice_1 == 5 && dice_2 == 5|| dice_1 == 3 && dice_2 == 3 || total_1 ==7){
                System.out.println("first player is win:)");
                break;
            }
            else{
                System.out.println("first player is lost!!");
            }
            System.out.println("rolling second player dice 1: "+dice_1_1+ " dice 2: " + dice_1_2);
            if(dice_1_1 == 6 && dice_1_2 == 6 || dice_1_1 == 5 && dice_1_2 == 5 || dice_1_1 == 3 && dice_1_2 == 3 || total_2 == 7){
                System.out.println("second player is win:)");
                break;
            }
            else{
                System.out.println("second player is lost!!");
                random = new Random();
                int dice_2_1 = random.nextInt(6)+1;
                int dice_2_2 = random.nextInt(6)+1;
                int dice_2_1_1 = random.nextInt(6)+1;
                int dice_2_1_2 = random.nextInt(6)+1;
                int new_total_1 = dice_2_1 + dice_2_2;
                int new_total_2 = dice_2_1_1 + dice_2_1_2;
                System.out.println("sum of dice in 2nd round: " +new_total_1+" sum of dice in 1st round:  " +total_1);
                if(new_total_1 == total_1 && new_total_1 !=7) {
                    System.out.println("first player is win in 2nd round:) and game over");
                    break;
                }
                else{
                    System.out.println("first player is lost in 2nd round");
                    System.out.println("sum of dice in 2nd round: " +new_total_2+" sum of dice in 1st round:  " +total_2);
                    if(new_total_2 == total_2 && new_total_2 != 7){
                        System.out.println("second player is win in 2nd round:) and game over");
                        break;
                    }
                    else{
                        System.out.println("second player is lost in 2nd round");
                        System.out.println("no winner!!!");
                        continue;
                    }
                }
            }
        }
    }
    public static void main(String[]args){
        rollDice();
        
    }

    
}
