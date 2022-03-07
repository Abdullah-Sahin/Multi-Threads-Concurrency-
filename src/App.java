import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App{

    public static void main(String[] args){    
    
        List<Integer> group1 = new ArrayList<>();
        for(int i = 1; i < 6; i++){
            group1.add(i);
        }
        List<Integer> group2 = new ArrayList<>();
        for(int i = 6; i < 11; i++){
            group2.add(i);
        }
        List<Integer> group3 = new ArrayList<>();
        for(int i = 11; i < 16; i++){
            group3.add(i);
        }
        List<Integer> group4 = new ArrayList<>();
        for(int i = 16; i < 21; i++){
            group4.add(i);
        }

        List<Integer> evenNumbers = new ArrayList<>();
        List<Integer> oddNumbers = new ArrayList<>();

        System.out.println("Main Thread started...");
        
        NumberLists n1 = new NumberLists(group1, evenNumbers, oddNumbers);
        NumberLists n2 = new NumberLists(group2, evenNumbers, oddNumbers);
        NumberLists n3 = new NumberLists(group3, evenNumbers, oddNumbers);
        NumberLists n4 = new NumberLists(group4, evenNumbers, oddNumbers);

        List<Thread> threads = new ArrayList<>();
        
        /*
        ExecutorService pool = Executors.newFixedThreadPool(4);
        for(int i = 0; i < 8; i++){
            if(i / 2 == 0){
                pool.execute(n1);
            }
            else if(i / 2 == 1){
                pool.execute(n2);
            }
            else if(i / 2 == 2){
                pool.execute(n3);
            }
            else{
                pool.execute(n4);
            }
        }
        
        pool.shutdown(); */

        for(int i = 0; i < 8; i++){
            if(i / 2 == 0){
                threads.add(new Thread(n1));
            }
            else if(i / 2 == 1){
                threads.add(new Thread(n2));
            }
            else if(i / 2 == 2){
                threads.add(new Thread(n3));
            }
            else{
                threads.add(new Thread(n4));
            }
            
        }

        for(int i = 0; i < threads.size(); i++){
            threads.get(i).start();
        }
        for(int i = 0; i < threads.size(); i++){
            try {
                threads.get(i).join();
            } catch (InterruptedException e) {
                System.out.println("**********Joinde hata çıktı*********");
            }
        }

        System.out.println("Even numbers: " + evenNumbers.toString() + " Size: " + evenNumbers.size());
        System.out.println("Odd numbers: " + oddNumbers.toString() + " Size: " + oddNumbers.size());

        System.out.println("Main Thread finished...");
    }

}

    
