public class Main {

    public static void main(String[] args) {
        VendingMachineImpl vm = new VendingMachineImpl();

        vm.printStats();
        try {
            vm.selectItemAndGetPrice(Item.MARS);
            vm.insertCoin(Coin.TEN);
            vm.insertCoin(Coin.TWENTY);
            vm.collectItemAndChange();
            vm.printStats();
        } catch (SoldOutException e) {
            e.printStackTrace();
        } catch (NotSufficientChangeException e) {
            e.printStackTrace();
        }

    }
}
