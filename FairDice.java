import java.util.Random;
import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;

public class FairDice {
    public static void main(String[] args){
        int[] dice_Array = {1,2,3,4,5,6,7,8,9,10};
        int[] random_Array = new int [10];
        Random randm = new Random();
        int numOfrandmElem = 10;
        System.out.println("Selecting element randomly from the list: ");
        for(int i = 0; i < numOfrandmElem; i++){
            int randmIndx = randm.nextInt(dice_Array.length);
            int randmElem = (int) Array.get(dice_Array,randmIndx);
            random_Array[i] = randmElem;
            System.out.println(randmElem + "");   
        }
        

        // Her sayının tekrar sayısı
        Map<Integer, Integer> tekrarSayilari = new HashMap<>();
        for (int sayi : random_Array) {
            if (tekrarSayilari.containsKey(sayi)) {
                tekrarSayilari.put(sayi, tekrarSayilari.get(sayi) + 1);
            } else {
                tekrarSayilari.put(sayi, 1);
            }
        }
        System.out.println("\nTekrar sayıları: ");
        for (int sayi : dice_Array) {
            int tekrarSayisi = tekrarSayilari.getOrDefault(sayi, 0);
            System.out.println(sayi + ".yüzü " + tekrarSayisi + " kez tekrar ediyor.");
        }
    
      
    }
}
 