import java.util.HashMap;
import java.util.Map;

public class Inventory <T>{

    private Map<T,Integer> inventory;

    public Inventory() {
        inventory = new HashMap<>();
    }

    public int getQuantity(T item){
        return inventory.get(item);

    }
    public void add (T item){
        inventory.put(item, inventory.get(item) + 1);

    }

    public boolean hasItem(T item){
        return inventory.containsKey(item);
        
    }

    public void decrease(T item){
        inventory.put(item, inventory.get(item) - 1);

    }

     public void put(T item, int quantity){
        inventory.put(item, inventory.get(item) + quantity);
     }
    public void clear(){
        inventory.clear();
    }
}
