public class TableMain {
    public static void main(String[] args) {
        TableMaker table1 = new TableMaker();
        table1.addDataToHead("Product", "Quantity", "Price");
        table1.addDataToBody("Cocacola", "5", "Pounded 100");
        table1.addDataToBody("Malt", "6", "150");
        table1.addDataToBody("Pepsi", "15", "150");
        table1.addDataToFoot("Total", "26", "400");

        System.out.println(table1.getTableConstruct());
    }
}
