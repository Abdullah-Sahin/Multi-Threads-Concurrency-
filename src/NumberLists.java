import java.util.List;

public class NumberLists implements Runnable{

    private List<Integer> allNumbers;
    private List<Integer> evenNumbers;
    private List<Integer> oddNumbers;
    private Object LOCK1 = new Object();
    int index;

    public NumberLists(List<Integer> allNumbers, List<Integer> evenNumbers, List<Integer> oddNumbers){

        this.allNumbers = allNumbers;
        this.evenNumbers = evenNumbers;
        this.oddNumbers = oddNumbers;
        this.index = 0;    

    }

    public List<Integer> getAllNumbers(){
        return allNumbers;
    }
    public List<Integer> getEvenNumbers(){
        return evenNumbers;
    }
    public List<Integer> getOddNumbers(){
        return oddNumbers;
    }

    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName() + " started process..");

        synchronized(LOCK1){

            while(index < allNumbers.size()){

                if(allNumbers.get(index) % 2 == 0){
                    evenNumbers.add(allNumbers.get(index));
                    System.out.println(Thread.currentThread().getName() + " added " + allNumbers.get(index) + " to evens.");
                }
                else{
                    oddNumbers.add(allNumbers.get(index));
                    System.out.println(Thread.currentThread().getName() + " added " + allNumbers.get(index) + " to odds.");
                }

                index++;                
                
            }  

        }

        System.out.println(Thread.currentThread().getName() + " finished process..");

    }
    
}
