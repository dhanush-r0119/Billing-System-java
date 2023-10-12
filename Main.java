import java.util.*;

class Customer {
    public int id;
    public String name;
    public String phone;
    public String purchased_product;
    public int purchased_quantity;
    public float amount;
    static int customer_count = 0;

    Customer(String name, String phone, String purchased_product, int purchased_quantity, float amount) {
        this.id = ++customer_count;
        this.name = name;
        this.phone = phone;
        this.purchased_product = purchased_product;
        this.purchased_quantity = purchased_quantity;
        this.amount = purchased_quantity * amount;
    }
}

class Product {
    public int product_id;
    public String product_name;
    public int product_stock;
    public float price;
    static int count = 0;

    Product(int product_id, String product_name, int product_stock, float price) {
        this.product_id = ++count;
        this.product_name = product_name;
        this.product_stock = product_stock;
        this.price = price;
    }
}

class Bill {
    public int Bill_no;
    public String Customer_name;
    public int tot_quantity;
    public float bill_price;
    static int count = 0;

    Bill(String Customer_name, int product_quantity, float price, Customer c1, Product p1) {
        this.Bill_no = ++count;
        this.Customer_name = c1.name;
        this.tot_quantity = product_quantity;
        this.bill_price = product_quantity * p1.price;
    }
}

class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        List<Product> products = new ArrayList<>(); 
        products.add(new Product(1, "iPhone-11", 5, 40000));
        products.add(new Product(2, "iPhone-12", 5, 50000));
        products.add(new Product(3, "iPhone-13", 5, 60000));
        products.add(new Product(4, "iPhone-14", 5, 70000));
        
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("Dhanush", "70109228697", "iPhone-13", 2, 60000));
        customers.add(new Customer("karthi", "6547863254", "iPhone-12", 1, 50000));
        customers.add(new Customer("surya", "87569423658", "iPhone-11", 3, 40000));
        
        while (true) {
            System.out.println("1. Product Details");
            System.out.println("2. Add new Product");
            System.out.println("3. Customer Details");
            System.out.println("4. Add new Customer");
            System.out.println("5. Exit");
            System.out.print("Your Option : ");
            int option = sc.nextInt();
            sc.nextLine(); // Consume the newline character
            
            if (option == 1) {
                System.out.println("--------------Product Details---------------");
                System.out.println("ID" + "\t" + "Name" + "\t" + "      Stock" + "\t" + "  Price");
                for (Product product : products) {
                    System.out.println("--------------------------------------------");
                    System.out.println(product.product_id + "\t" + product.product_name + "\t" + product.product_stock + "\t" + product.price);
                }
            } else if (option == 2) {
                System.out.println("--------------------------------------------");
                System.out.println("Enter details for a new product:");
                //sc.nextLine();
                System.out.print("Product Name: ");
                String productName = sc.nextLine();
                System.out.print("Stock: ");
                int stock = sc.nextInt();
                System.out.print("Price: ");
                float productPrice = sc.nextFloat();
                System.out.println("-----------Product added Successfully-----------");
                Product new_product = new Product(products.size() + 1, productName, stock, productPrice);
                products.add(new_product);
                //System.out.println("-----------Product added Successfully-----------");
            } else if (option == 3) {
                System.out.println("-------------Customer Details---------------");
                System.out.println("ID" + "\t" + "Name" + "\t   " + "  Mobile.No" + "\t " + "Purchased" + "\t   " + "Quantity" + "\t" + "Amount");
                for (Customer customer : customers) {
                    System.out.println(customer.id + "\t" + customer.name + "\t" + "\t" + customer.phone + "\t" + customer.purchased_product + "\t" + customer.purchased_quantity + "\t" + customer.amount);
                }
                System.out.println("--------------------------------------------");
            } else if (option == 4) {
                System.out.println("--------------------------------------------");
                System.out.println("Enter the new Customer Details:");
                System.out.print("Customer Name : ");
                String new_customer_name = sc.nextLine();
                System.out.print("Phone Number: ");
                String new_phone = sc.nextLine();
                System.out.print("Purchased Product: ");
                String new_product_name = sc.nextLine();
                System.out.print("Purchased Quantity: ");
                int new_purchased_quantity = sc.nextInt();
                System.out.print("Amount: ");
                float new_amount = sc.nextFloat();
                
                Customer new_customer = new Customer(new_customer_name, new_phone, new_product_name, new_purchased_quantity, new_amount);
                customers.add(new_customer);
                System.out.println("---------------Customer added Successfully----------------");
            } else if (option == 5) {
                break;
            }
        }
    }
}
