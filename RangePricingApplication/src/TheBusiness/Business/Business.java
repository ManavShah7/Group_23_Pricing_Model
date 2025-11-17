/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TheBusiness.Business;

import MarketingManagement.MarketingPersonDirectory;
import TheBusiness.MarketModel.ChannelCatalog;
import TheBusiness.CustomerManagement.CustomerDirectory;
import TheBusiness.MarketModel.MarketCatalog;
import TheBusiness.MarketModel.MarketChannelComboCatalog;
import TheBusiness.MarketModel.SolutionOfferCatalog;
import TheBusiness.SolutionOrders.MasterSolutionOrderList;
import TheBusiness.SalesManagement.SalesPersonDirectory;
import TheBusiness.Supplier.SupplierDirectory;
import TheBusiness.UserAccountManagement.UserAccountDirectory;
import TheBusiness.OrderManagement.MasterOrderList;

/**
 *
 * @author kal bugrara
 */
public class Business {

    private String name;
    private MarketCatalog marketCatalog;
    private ChannelCatalog channelCatalog;
    private MarketChannelComboCatalog marketChannelComboCatalog;
    private SupplierDirectory supplierDirectory;
    private CustomerDirectory customerDirectory;
    private SalesPersonDirectory salesPersonDirectory;
    private MarketingPersonDirectory marketingPersonDirectory;
    private SolutionOfferCatalog solutionOfferCatalog;
    private MasterSolutionOrderList masterSolutionOrderList;
    private UserAccountDirectory userAccountDirectory;
    private MasterOrderList masterOrderList;

    public Business(String name) {
        this.name = name;
        this.marketCatalog = new MarketCatalog();
        this.channelCatalog = new ChannelCatalog();
        this.marketChannelComboCatalog = new MarketChannelComboCatalog();
        this.supplierDirectory = new SupplierDirectory();
        this.customerDirectory = new CustomerDirectory();
        this.salesPersonDirectory = new SalesPersonDirectory();
        this.marketingPersonDirectory = new MarketingPersonDirectory();
        this.solutionOfferCatalog = new SolutionOfferCatalog();
        this.masterSolutionOrderList = new MasterSolutionOrderList();
        this.userAccountDirectory = new UserAccountDirectory();
        this.masterOrderList = new MasterOrderList();

    }

    public String getName() {
        return name;
    }

    public MarketCatalog getMarketCatalog() {
        return marketCatalog;
    }

    public ChannelCatalog getChannelCatalog() {
        return channelCatalog;
    }

    public MarketChannelComboCatalog getMarketChannelComboCatalog() {
        return marketChannelComboCatalog;
    }

    public SupplierDirectory getSupplierDirectory() {
        return supplierDirectory;
    }

    public CustomerDirectory getCustomerDirectory() {
        return customerDirectory;
    }

    public SalesPersonDirectory getSalesPersonDirectory() {
        return salesPersonDirectory;
    }

    public MarketingPersonDirectory getMarketingPersonDirectory() {
        return marketingPersonDirectory;
    }

    public SolutionOfferCatalog getSolutionOfferCatalog() {
        return solutionOfferCatalog;
    }

    public MasterSolutionOrderList getMasterSolutionOrderList() {
        return masterSolutionOrderList;
    }

    public UserAccountDirectory getUserAccountDirectory() {
        return userAccountDirectory;
    }

    public MasterOrderList getMasterOrderList() {
        return masterOrderList;
    }

    @Override
    public String toString() {
        return name;
    }

}
