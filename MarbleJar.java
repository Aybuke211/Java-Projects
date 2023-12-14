public class MarbleJar {
    public static void addMarble(){
        int totalAmount = 10;
        int maxAmount = 15;
        boolean openJar = true;
        if(openJar == true && totalAmount <= maxAmount){
            totalAmount++;
            System.out.println("Total amount of the marble in jar: " +totalAmount);
        }
        else{
            System.out.println("Any marbles can't add to the jar!"); 
            
        }
            
        }
    public static void removeMarble(){
        int totalAmount = 0;
        int minAmount = 0;
        boolean openJar = true;
        if(openJar == true && totalAmount > minAmount  ){
            totalAmount--;
            System.out.println("Total amount of marbles in the jar: "+totalAmount);
        }
        else{
            System.out.println("Any marbles can't remove from the jar! ");
        }
    }
    public static void main(String[] args){
        addMarble();
        removeMarble();

    }
}








