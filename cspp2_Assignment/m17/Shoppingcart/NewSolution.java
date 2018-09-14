import java.util.Scanner;
import java.util.ArrayList;
class Item {
    private String productName;
    private int quantity;
    private int unitPrice;

    Item(final String name, final int quant, final int uprice) {
        this.productName = name;
        this.quantity = quant;
        this.unitPrice = uprice;
    }

    /**
     * Constructs the object.
     *
     * @param      name   The name
     * @param      quant  The quant
     */
    Item(final String name, final int quant) {
        this.productName = name;
        this.quantity = quant;
    }

    /**
     * Gets the productName.
     *
     * @return     The productName.
     */
    String getProductName() {
        return this.productName;
    }

    /**
     * Gets the quantity.
     *
     * @return     The quantity.
     */
    int getQuantity() {
        return this.quantity;
    }

    /**
     * Sets the quantity.
     *
     * @param      quantinp  The quantinp
     */
    void setQuantity(final int quantinp) {
        this.quantity = quantinp;
    }

    /**
     * Gets the unitPrice.
     *
     * @return     The unitPrice.
     */
    int getUnitPrice() {
        return this.unitPrice;
    }

    /**
     * Sets the unitPrice.
     *
     * @param      upricee  The upricee
     */
    void setUnitPrice(final int upricee) {
        this.unitPrice = upricee;
    }

    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        return this.productName + " " + this.quantity
               + " " + (double) this.unitPrice;
    }

    /**
     * similar to tostring.
     *
     * @return     representation of object.
     */
    String represent() {
        return this.productName + " " + this.quantity;
    }

}
class ShoppingCart {
    private double discount = 0;
    ArrayList<Item> catalog = new ArrayList<>();
    ArrayList<Item> cart = new ArrayList<>();


    public void addToCatalog(final Item item) {
        catalog.add(item);

    }
    public void addToCart(final Item item) {
        for (Item i : catalog) {
            if (i.getProductName().equals(item.getProductName())) {
                item.setUnitPrice(i.getUnitPrice());
                Item temp = null;
                for (Item j : cart) {
                    if (j.getProductName().equals(item.getProductName())) {
                        j.setQuantity(j.getQuantity() + item.getQuantity());
                        temp = j;
                        break;
                    }
                }
                if (temp == null) {
                    cart.add(item);
                }
                break;
            }
        }

    }
    public void removeFromCart(final Item item) {
        for (Item i : cart) {
            if (i.getProductName().equals(item.getProductName())) {
                i.setQuantity(i.getQuantity() - item.getQuantity());
                if (i.getQuantity() == 0) {
                    cart.remove(i);
                }
                break;

            }
        }

    }
    public void showCart() {
        for (Item item : cart) {
            System.out.println(item.represent());
        }

    }
    public void showCatalog() {
        for (Item item : catalog) {
            System.out.println(item);
        }

    }
    public double getTotalAmount() {
        double amount = 0;
        for (Item item : cart) {
            amount += (item.getQuantity() * item.getUnitPrice());

        }
        return amount;

    }
    public void applyCoupon(final int coupon) {
        final int ten = 10;
        final int twenty = 20;
        final int thirty = 30;
        final int fifty = 50;

        if (coupon != ten && coupon != twenty
                && coupon != thirty && coupon != fifty) {
            System.out.println("Invalid coupon");
            return;
        }
        double amount = this.getTotalAmount();
        this.discount = (amount * coupon) / 100;

    }
    public double getPayableAmount() {
        double tax = 1.15;
        return (getTotalAmount() - discount) * tax;

    }
    public void printInvoice() {
        //System.out.println("Name    quantity    Price");
        System.out.println("Name   quantity   Price");
        for(Item item : cart){
            System.out.println(item);
        }

        double tmp = this.getTotalAmount();


        System.out.println("Total:" + tmp);

        System.out.println("Disc%:" + this.discount);

        double tmp2 = tmp - this.discount;

        final double taxx = 0.15;

        System.out.println("Tax:" + (tmp2 * taxx));

        System.out.printf("Payable amount: %.1f\n", this.getPayableAmount());

    }
}

/**
 * Solution class.
 */
public final class NewSolution {

    /**
     * Constructs the object.
     */
    private NewSolution() {

    }

    /**
     * main method to drive program.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        //copy from prev works
        //chng the function calls

        ShoppingCart scart = new ShoppingCart();
        Scanner scan = new Scanner(System.in);
        int testCases = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < testCases; i++) {
            String[] tokens = scan.nextLine().replace(" ", ",").split(",");
            //System.out.println(Arrays.toString(tokens));
            switch (tokens[0]) {
            case "Item":
                final int three = 3;
                scart.addToCatalog(new Item(tokens[1],
                                            Integer.parseInt(tokens[2]),
                                            Integer.parseInt(tokens[three])));
                break;
            case "catalog":
                scart.showCatalog();
                break;
            case "show":
                scart.showCart();
                break;
            case "add":
                scart.addToCart(new Item(tokens[1],
                                         Integer.parseInt(tokens[2])));
                break;
            case "remove":
                scart.removeFromCart(new Item(tokens[1],
                                              Integer.parseInt(tokens[2])));
                break;
            case "totalAmount":
                System.out.println("totalAmount: " + scart.getTotalAmount());
                break;
            case "payableAmount":
                //String movienaam, String timings, String mobilenum
                //System.out.println(Arrays.toString(tokens));
                System.out.printf("Payable amount: %.1f\n",
                                  scart.getPayableAmount());
                break;
            case "print":
                scart.printInvoice();
                break;
            case "coupon":
                scart.applyCoupon(Integer.parseInt(
                                      tokens[1].replace("IND", "")));
            //scart.applyCoupon()
            default:
                break;

            }
        }
    }
}

