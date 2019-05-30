import java.util.Collections;
import java.util.List;

public class VendingMachineImpl implements VendingMachine {

    private Inventory<Coin> cashInventory;
    private Inventory<Item> itemInventory;
    private long totalSales;
    private Item currentItem;
    private long currentBalance;

    public VendingMachineImpl() {
        initialize();
    }

    void initialize() {
        for (Coin c : Coin.values()) {
            cashInventory.put(c, 5);
        }
        for (Item i : Item.values()) {
            itemInventory.put(i, 5);
        }
    }

    @Override
    public long selectItemAndGetPrice(Item item) throws SoldOutException {
        if (itemInventory.hasItem(item)) {
            currentItem = item;
            return currentItem.getPrice();
        } else {
            throw new SoldOutException("S-au vindut toate " + item.getName());
        }
    }

    @Override
    public void insertCoin(Coin coin) {
        currentBalance = currentBalance + coin.getValue();
        cashInventory.add(coin);
    }

    public void updateCashInventory(List change) {

    }

    public boolean isFullyPaid() {
        if (currentBalance >= currentItem.getPrice()) {
            return true;
        } else {
            return false;
        }
    }

    public List<Coin> getChange(long amount) throws NotSufficientChangeException {
        List<Coin> changes = Collections.EMPTY_LIST;
        long balance = amount;
        while (balance > 0) {
            if (balance >= Coin.FIFTY.getValue() && cashInventory.hasItem(Coin.FIVE)) {
                changes.add(Coin.FIFTY);
                balance = balance - Coin.FIFTY.getValue();
                continue;
            } else if (balance >= Coin.TWENTY.getValue() && cashInventory.hasItem(Coin.TWENTY)) {
                changes.add(Coin.TWENTY);
                balance = balance - Coin.TWENTY.getValue();
                continue;
            } else if (balance >= Coin.TEN.getValue() && cashInventory.hasItem(Coin.TEN)) {
                changes.add(Coin.TEN);
                balance = balance - Coin.TEN.getValue();
                continue;
            } else if (balance >= Coin.FIFTY.getValue() && cashInventory.hasItem(Coin.FIFTY)) {
                changes.add(Coin.FIFTY);
                balance = balance - Coin.FIFTY.getValue();
                continue;
            } else {
                throw new NotSufficientChangeException("NotSufficientChange");
            }
        }
        return changes;
    }

    private boolean hasSufficientChangeForAmount(long amount) {
        boolean hasChange = true;
        try {
            getChange(amount);
        } catch (NotSufficientChangeException nsce) {
            return hasChange = false;
        }
        return hasChange;
    }

    private boolean hasSufficientChange() {
        return hasSufficientChangeForAmount(currentBalance - currentItem.getPrice());
    }

    private Item collectItem() throws NotSufficientChangeException {
        if (isFullyPaid()) {
            if (hasSufficientChange()) {
                itemInventory.decrease(currentItem);
                return currentItem;
            }
            throw new NotSufficientChangeException("Not Sufficient change in Inventory");
        }
        return currentItem;
    }

    public List<Coin> collectChange() throws NotSufficientChangeException {
        long changeAmount = currentBalance - currentItem.getPrice();
        List<Coin> change = getChange(changeAmount);
        updateCashInventory(change);
        currentBalance = 0;
        currentItem = null;
        return change;
    }

    public PurchaseAndCoins<Item, List<Coin>> colletItemAndGetChange() throws NotSufficientChangeException {
        Item item = collectItem();
        totalSales = totalSales + currentItem.getPrice();
        List<Coin> change = collectChange();
        return new PurchaseAndCoins<Item, List<Coin>>(item, change);
    }

    @Override
    public List<Coin> refund() throws NotSufficientChangeException {
        List<Coin> refund = getChange(currentBalance);
        updateCashInventory(refund);
        currentBalance = 0;
        currentItem = null;
        return refund;
    }

    @Override
    public void reset() {
        itemInventory.clear();
        cashInventory.clear();
        totalSales = 0;
        currentItem = null;
        currentBalance = 0;
    }

    public void printStats() {
        System.out.println("total sales: " + totalSales);
        System.out.println("current item inventory: " + itemInventory);
        System.out.println("current cash inventory: " + cashInventory);
    }

    public long getTotalSales() {
        return totalSales;
    }
}
