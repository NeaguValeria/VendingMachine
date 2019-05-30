import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
        if(inventory.containsValue(item)){
            inventory.put(item, inventory.get(item) + quantity);
        } else {
            inventory.put(item, quantity);
        }
     }
    public void clear(){
        inventory.clear();
    }

    @Override
    public String toString() {
        String response = null;
        Integer total = 0;
        List<String> lista = new ArrayList<>();
        for (Map.Entry<T, Integer> map: inventory.entrySet()){
            total = total + map.getValue();
            response = response + " " + map.getKey().toString() + " " + map.getValue() + " ";
        }
        return response + "total = " + total;
    }
}
