import java.util.Random;
import java.lang.String;

public class Rock_Paper_Scissors {
    static int userScore = 0;
    static int computerScore = 0;
    
public static void main(String args[]){
        String choice[] = {"Rock", "Paper", "Scissors"};
        int i = 0;

        while(i < 3){

            Random random = new Random();
            int randomIndex = random.nextInt(choice.length);
            String userRand = choice[randomIndex];
            System.out.println("User: " +userRand);
            int compChoice = getComp();
            int userChoice = userRand.equals(choice[0])?0:(userRand.equals(choice[1])?1:2);
            getDecision(compChoice, userChoice);
            System.out.println("Computer: " +choice[compChoice]);
            System.out.println("User: " +userScore+ " Comp: " +computerScore);
            i++;
            }
            getResult();
        }

        public static int getComp(){
            Random obj = new Random();
            int move = obj.nextInt(3);
            return move;
        }

        public static void getDecision(int choice1, int choice2){
            if(choice1 == choice2){
                System.out.print("Togetherness => ");
            }
            else{
                switch(choice1){
                    case 0: if(choice2 == 2)
                    computerScore += 1;
                    else
                    userScore += 1;
                    break;
                    case 1: if(choice2 == 0)
                    computerScore += 1;
                    else
                    userScore += 1;
                    break;
                    case 2: if(choice2 == 1)
                    computerScore +=1;
                    else
                    userScore +=1;
                    break;
                }
            }
        }
        public static void getResult(){
            if(userScore > computerScore)
            System.out.println("User Wins ");
            else if(computerScore > userScore)
            System.out.println("Computer wins ");
            else
            System.out.println("It is a togetherness ");
        }
    }
