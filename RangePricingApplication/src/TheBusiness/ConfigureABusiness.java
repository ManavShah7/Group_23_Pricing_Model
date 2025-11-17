package TheBusiness;

import MarketingManagement.MarketingPersonDirectory;
import MarketingManagement.MarketingPersonProfile;
import TheBusiness.Business.Business;
import TheBusiness.CustomerManagement.CustomerDirectory;
import TheBusiness.CustomerManagement.CustomerProfile;
import TheBusiness.ProductManagement.Product;
import TheBusiness.ProductManagement.ProductCatalog;
import TheBusiness.OrderManagement.Order;
import TheBusiness.Supplier.Supplier;
import TheBusiness.Supplier.SupplierDirectory;
import TheBusiness.MarketModel.Channel;
import TheBusiness.MarketModel.ChannelCatalog;
import TheBusiness.MarketModel.Market;
import TheBusiness.MarketModel.MarketCatalog;
import TheBusiness.MarketModel.MarketChannelAssignment;
import TheBusiness.MarketModel.MarketChannelComboCatalog;
import TheBusiness.SalesManagement.SalesPersonDirectory;
import TheBusiness.SalesManagement.SalesPersonProfile;
import TheBusiness.MarketModel.SolutionOfferCatalog;
import TheBusiness.UserAccountManagement.UserAccountDirectory;
import TheBusiness.OrderManagement.MasterOrderList;
import TheBusiness.Personnel.EmployeeProfile;
import TheBusiness.Personnel.Person;
import TheBusiness.Personnel.PersonDirectory;

import com.github.javafaker.Faker;

import java.util.List;
import java.util.Random;

/**
 * Configures the Business with full random data using Faker and Math.random().
 * No hard coding. Meets all requirement PDF rules: - 50 suppliers - Each
 * supplier has 50 products - 300 customers - Every customer gets 1–3 orders -
 * 1–10 order items per order - Uses markets, channels, combos - Uses random
 * actual prices
 */
public class ConfigureABusiness {

    private static final int NUM_SUPPLIERS = 50;
    private static final int NUM_PRODUCTS_PER_SUPPLIER = 50;
    private static final int NUM_CUSTOMERS = 300;

    private static final int NUM_MARKETS = 20;
    private static final int NUM_CHANNELS = 10;

    private static final int NUM_SALESPERSONS = 20;
    private static final int NUM_MARKETINGPERSONS = 10;

    private static final Random rand = new Random();
    private static final Faker faker = new Faker();

    public static Business initialize() {

        Business business = new Business("Range Pricing Business");

        // Core directories
        SupplierDirectory supplierDirectory = business.getSupplierDirectory();
        CustomerDirectory customerDirectory = business.getCustomerDirectory();
        PersonDirectory personDirectory = new PersonDirectory();
        
        SalesPersonDirectory salesPersonDirectory = business.getSalesPersonDirectory();
        MarketingPersonDirectory marketingPersonDirectory = business.getMarketingPersonDirectory();
        MasterOrderList masterOrderList = business.getMasterOrderList();
        MarketCatalog marketCatalog = business.getMarketCatalog();
        ChannelCatalog channelCatalog = business.getChannelCatalog();
        MarketChannelComboCatalog comboCatalog = business.getMarketChannelComboCatalog();
        SolutionOfferCatalog solutionOfferCatalog = business.getSolutionOfferCatalog();
        UserAccountDirectory userAccountDirectory = business.getUserAccountDirectory();

        // 1. Generate Markets
        List<Market> markets = generateMarkets(marketCatalog);

        // 2. Generate Channels
        List<Channel> channels = generateChannels(channelCatalog);

        // 3. Generate Market–Channel Combos
        List<MarketChannelAssignment> assignments = generateCombos(comboCatalog, markets, channels);

        // 4. Generate Suppliers + Products
        List<Supplier> suppliers = generateSuppliers(supplierDirectory);

        // 5. Generate SalesPersons
        List<SalesPersonProfile> salesPersons = generateSalesPersons(salesPersonDirectory, personDirectory, userAccountDirectory);

        // 6. Generate MarketingPersons
        List<MarketingPersonProfile> marketingPersons = generateMarketingPersons(marketingPersonDirectory, personDirectory, userAccountDirectory);

        // 7. Generate Customers
        List<CustomerProfile> customers = generateCustomers(customerDirectory, personDirectory, userAccountDirectory);

        // 8. Generate Orders for each Customer
        generateOrders(masterOrderList, customers, suppliers, salesPersons, assignments);

        // Create default system admin user
        Person adminPerson = personDirectory.addPerson("System Admin", "1234567890", "admin@business.com");
        EmployeeProfile adminProfile = new EmployeeProfile(adminPerson);
        userAccountDirectory.createUserAccount("admin", "admin", adminProfile);

        return business;
    }

    private static final Random random = new Random();

    private static void createSalesPeopleAndAccounts(Business business,
            PersonDirectory personDir,
            UserAccountDirectory userDir,
            int count,
            Faker faker) {

        SalesPersonDirectory salesDir = business.getSalesPersonDirectory();

        for (int i = 0; i < count; i++) {
            String name = faker.name().fullName();
            String phone = faker.phoneNumber().cellPhone();
            String email = faker.internet().emailAddress();

            Person p = personDir.addPerson(name, phone, email);
            SalesPersonProfile sp = salesDir.addSalesPerson(p);

            String username = "sales" + (i + 1);
            String password = "sales" + (1000 + i);

            userDir.createUserAccount(username, password, sp);
        }
    }

    // ----------------------------
    // MARKET GENERATION
    // ----------------------------
    private static List<Market> generateMarkets(MarketCatalog marketCatalog) {
        for (int i = 0; i < NUM_MARKETS; i++) {
            marketCatalog.addMarket(
                    faker.company().industry(),
                    faker.company().buzzword()
            );
        }
        return marketCatalog.getMarketList();
    }

    // ----------------------------
    // CHANNEL GENERATION
    // ----------------------------
    private static List<Channel> generateChannels(ChannelCatalog channelCatalog) {
        for (int i = 0; i < NUM_CHANNELS; i++) {
            channelCatalog.addChannel(faker.commerce().department());
        }
        return channelCatalog.getChannelList();
    }

    // ----------------------------
    // COMBO GENERATION
    // ----------------------------
    private static List<MarketChannelAssignment> generateCombos(
            MarketChannelComboCatalog comboCatalog,
            List<Market> markets,
            List<Channel> channels) {

        for (Market m : markets) {
            for (Channel c : channels) {
                comboCatalog.addCombo(m, c);
            }
        }
        return comboCatalog.getComboList();
    }

    // ----------------------------
    // SUPPLIER + PRODUCT GENERATION
    // ----------------------------
    private static List<Supplier> generateSuppliers(SupplierDirectory supplierDirectory) {

        for (int i = 0; i < NUM_SUPPLIERS; i++) {

            Supplier supplier = supplierDirectory.addSupplier(
                    faker.company().name()
            );

            ProductCatalog catalog = supplier.getProductCatalog();

            for (int j = 0; j < NUM_PRODUCTS_PER_SUPPLIER; j++) {

                double floorPrice = 10 + rand.nextInt(400);
                double ceilingPrice = floorPrice + 50 + rand.nextInt(400);
                double targetPrice = floorPrice + (ceilingPrice - floorPrice) * 0.5;

                catalog.addProduct(
                        faker.commerce().productName(),
                        targetPrice,
                        floorPrice,
                        ceilingPrice
                );
            }
        }

        return supplierDirectory.getSupplierList();
    }

    // ----------------------------
    // SALESPERSON GENERATION
    // ----------------------------
    private static List<SalesPersonProfile> generateSalesPersons(
            SalesPersonDirectory salesDir, PersonDirectory personDir, UserAccountDirectory userAccountDirectory) {

        for (int i = 0; i < NUM_SALESPERSONS; i++) {
            Person p = personDir.addPerson(
                    faker.name().fullName(),
                    faker.phoneNumber().cellPhone(),
                    faker.internet().emailAddress()
            );
            SalesPersonProfile sp = salesDir.addSalesPerson(p);
            userAccountDirectory.createUserAccount("sales" + i, "sales" + i, sp);
        }

        return salesDir.getSalesPersons();

    }

    // ----------------------------
    // MARKETING PERSON GENERATION
    // ----------------------------
    private static List<MarketingPersonProfile> generateMarketingPersons(
            MarketingPersonDirectory marketingDir, PersonDirectory personDir, UserAccountDirectory userAccountDirectory) {

        for (int i = 0; i < NUM_MARKETINGPERSONS; i++) {
            Person p = personDir.addPerson(
                    faker.name().fullName(),
                    faker.phoneNumber().cellPhone(),
                    faker.internet().emailAddress()
            );
            MarketingPersonProfile mp = marketingDir.addMarketingPerson(p);
            userAccountDirectory.createUserAccount("mkt" + i, "mkt" + i, mp);

        }
        return marketingDir.getMarketingPersons();

    }

    // ----------------------------
    // CUSTOMER GENERATION
    // ----------------------------
    private static List<CustomerProfile> generateCustomers(
            CustomerDirectory customerDir, PersonDirectory personDir, UserAccountDirectory userAccountDirectory) {

        for (int i = 0; i < NUM_CUSTOMERS; i++) {
            Person p = personDir.addPerson(
                    faker.name().fullName(),
                    faker.phoneNumber().cellPhone(),
                    faker.internet().emailAddress()
            );
            CustomerProfile customer = customerDir.addCustomer(p);
            userAccountDirectory.createUserAccount("cust" + i, "cust" + i, customer);

        }
        return customerDir.getCustomerList();
    }

    // ----------------------------
    // ORDER GENERATION
    // ----------------------------
    private static void generateOrders(
            MasterOrderList masterOrderList,
            List<CustomerProfile> customers,
            List<Supplier> suppliers,
            List<SalesPersonProfile> salesPersons,
            List<MarketChannelAssignment> assignments) {

        for (CustomerProfile customer : customers) {

            int ordersCount = 1 + rand.nextInt(3); // 1–3 orders

            for (int o = 0; o < ordersCount; o++) {

                SalesPersonProfile salesPerson = salesPersons.get(rand.nextInt(salesPersons.size()));
                MarketChannelAssignment assignment = assignments.get(rand.nextInt(assignments.size()));

                Order order = masterOrderList.addNewOrder(customer, salesPerson, assignment);

                int itemsCount = 1 + rand.nextInt(10); // 1–10 order items

                for (int k = 0; k < itemsCount; k++) {

                    Supplier supplier = suppliers.get(rand.nextInt(suppliers.size()));
                    ProductCatalog catalog = supplier.getProductCatalog();
                    List<Product> products = catalog.getProductList();
                    if (products.isEmpty()) {
                        continue; // or continue in a loop, depending on where this is
                    }

                    Product product = products.get(rand.nextInt(products.size()));

                    double floor = product.getFloorPrice();
                    double ceiling = product.getCeilingPrice();

                    double actualPrice = floor + rand.nextDouble() * (ceiling - floor);
                    int quantity = 1 + rand.nextInt(10);

                    order.addOrderItem(product, quantity, actualPrice);
                }
            }
        }
    }
}
