
public class GiftShop {
   public static void main(String[] arguments) {
        Storefront store = new Storefront();
        store.addItem("C01", "MUG", "9.99", "150");
        store.addItem("C02", "LG MUG", "12.99", "82");
        store.addItem("C03", "MOUSEPAD", "10.49", "800");
        store.addItem("D01", "T SHIRT", "16.99", "90");
        store.sort();

        for (int i = 0; i < store.getSize(); i++) {
            Item show = (Item) store.getItem(i);
            System.out.println("\nItem ID: " + show.getId() +
                "\nName: " + show.getName() +
                "\nRetail Price: $" + show.getRetail() +
                "\nPrice: $" + show.getPrice() +
                "\nQuantity: " + show.getQuantity());
        }
    }
}


import java.util.*;
public class Storefront {
    private LinkedList catalog = new LinkedList();

    public void addItem(String id, String name, String price,
        String quant) {

        Item it = new Item(id, name, price, quant);
        catalog.add(it);
    }

    public Item getItem(int i) {
        return (Item) catalog.get(i);
    }

    public int getSize() {
        return catalog.size();
    }

    public void sort() {
        Collections.sort(catalog);
    }
}


public class Item implements Comparable {
    private String id;
    private String name;
    private double retail;
    private int quantity;
    private double price;

    Item(String idIn, String nameIn, String retailIn, String qIn) {
        id = idIn;
        name = nameIn;
        retail = Double.parseDouble(retailIn);
        quantity = Integer.parseInt(qIn);

        if (quantity > 400)
            price = retail * .5D;
        else if (quantity > 200)
            price = retail * .6D;
        else
            price = retail * .7D;
        price = Math.floor( price * 100 + .5 ) / 100;
    }

    public int compareTo(Object obj) {
        Item temp = (Item) obj;
        if (this.price < temp.price) {
            return 1;
        } else if (this.price > temp.price) {
            return -1;
        }
        return 0;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getRetail() {
        return retail;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }
}

