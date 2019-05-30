import java.util.List;

public interface VendingMachine  {

    long selectItemAndGetPrice(Item item) throws SoldOutException;
    void insertCoin(Coin coin);
    List<Coin> refund() throws NotSufficientChangeException;
    PurchaseAndCoins<Item, List<Coin>> colletItemAndGetChange() throws NotSufficientChangeException;
    void reset();

}
