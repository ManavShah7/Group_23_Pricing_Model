/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UserInterface.PricingManagement;

import TheBusiness.Business.Business;
import TheBusiness.OrderManagement.Order;
import TheBusiness.OrderManagement.OrderItem;
import TheBusiness.ProductManagement.Product;
import TheBusiness.Supplier.Supplier;
import UserInterface.PricingManagement.PricingManagerWorkAreaPanel;
import javax.swing.JPanel;
import java.awt.CardLayout;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author priyankavadivel
 */
public class BrowseProductPerformanceJPanel extends javax.swing.JPanel {

    private Business business;
    private JPanel mainWorkArea;

    /**
     * Creates new form BrowseProductPerformanceJPanel
     */
    public BrowseProductPerformanceJPanel(Business business, JPanel mainWorkArea) {
        initComponents();
        this.business = business;
        this.mainWorkArea = mainWorkArea;

        populateTable();
        tblPerformance.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPerformanceMouseClicked(evt);
            }
        });

    }

    private void populateTable() {
        // TODO: implement logic to fill the JTable
        DefaultTableModel model = (DefaultTableModel) tblPerformance.getModel();
        model.setRowCount(0);   // clear previous data

        // Loop through all suppliers in the business
        for (Supplier supplier : business.getSupplierDirectory().getSupplierList()) {

            // Loop through all products of each supplier
            for (Product product : supplier.getProductCatalog().getProductList()) {

                // ---- Step 1: Prepare counters for statistics ----
                double totalActualPrice = 0.0;
                int totalQty = 0;
                int count = 0;
                int belowCount = 0;
                int aboveCount = 0;
                double revenue = 0.0;

                // ---- Step 2: Iterate through ALL orders in the system ----
                for (Order order : business.getMasterOrderList().getOrders()) {

                    for (OrderItem oi : order.getOrderItems()) {

                        // Only include items of THIS product
                        if (oi.getProduct().equals(product)) {

                            double price = oi.getActualPrice();
                            int qty = oi.getQuantity();

                            totalActualPrice += price;
                            totalQty += qty;
                            count++;
                            revenue += price * qty;

                            if (price < product.getTargetPrice()) {
                                belowCount++;
                            }
                            if (price > product.getTargetPrice()) {
                                aboveCount++;
                            }
                        }
                    }
                }

                // ---- Step 3: Compute statistics ----
                double avgPrice = (count == 0 ? 0.0 : totalActualPrice / count);

                // ---- Step 4: Add row to table ----
                Object row[] = new Object[8];
                row[0] = supplier.getSupplierName();
                row[1] = product.getName();
                row[2] = product.getTargetPrice();
                row[3] = avgPrice;
                row[4] = totalQty;
                row[5] = revenue;
                row[6] = belowCount;
                row[7] = aboveCount;

                model.addRow(row);
            }
        }
    }

    private void tblPerformanceMouseClicked(java.awt.event.MouseEvent evt) {
        int row = tblPerformance.getSelectedRow();
        if (row < 0) {
            return;  // no selection
        }
        DefaultTableModel model = (DefaultTableModel) tblPerformance.getModel();

        // Read values from the table
        String supplier = model.getValueAt(row, 0).toString();
        String product = model.getValueAt(row, 1).toString();
        String targetPrice = model.getValueAt(row, 2).toString();
        String avgActualPrice = model.getValueAt(row, 3).toString();
        String totalQty = model.getValueAt(row, 4).toString();
        String revenue = model.getValueAt(row, 5).toString();
        String belowTarget = model.getValueAt(row, 6).toString();
        String afterTarget = model.getValueAt(row, 7).toString();

        // Set values in the text fields
        txtSupplier.setText(supplier);
        txtProduct.setText(product);
        txtTargetPrice.setText(targetPrice);
        txtAvgActualPrice.setText(avgActualPrice);
        txtTotalQuantity.setText(totalQty);
        txtRevenue.setText(revenue);
        txtBelowTarget.setText(belowTarget);
        txtAfterTarget.setText(afterTarget);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPerformance = new javax.swing.JTable();
        btnBack = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        lblSupplier = new javax.swing.JLabel();
        lblProduct = new javax.swing.JLabel();
        lblTargetPrice = new javax.swing.JLabel();
        lblAvgActualPrice = new javax.swing.JLabel();
        lblTotalQuantity = new javax.swing.JLabel();
        lblRevenue = new javax.swing.JLabel();
        lblBelowTarget = new javax.swing.JLabel();
        lblAfterTarget = new javax.swing.JLabel();
        txtProduct = new javax.swing.JTextField();
        txtTargetPrice = new javax.swing.JTextField();
        txtSupplier = new javax.swing.JTextField();
        txtAvgActualPrice = new javax.swing.JTextField();
        txtTotalQuantity = new javax.swing.JTextField();
        txtRevenue = new javax.swing.JTextField();
        txtBelowTarget = new javax.swing.JTextField();
        txtAfterTarget = new javax.swing.JTextField();

        lblTitle.setText("Product Price Performance");

        tblPerformance.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sup", "Pro", "TP", "Avg AP", "TQ", "Revenue", "BT", "AT"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblPerformance);
        if (tblPerformance.getColumnModel().getColumnCount() > 0) {
            tblPerformance.getColumnModel().getColumn(0).setResizable(false);
            tblPerformance.getColumnModel().getColumn(1).setResizable(false);
            tblPerformance.getColumnModel().getColumn(2).setResizable(false);
            tblPerformance.getColumnModel().getColumn(3).setResizable(false);
            tblPerformance.getColumnModel().getColumn(4).setResizable(false);
            tblPerformance.getColumnModel().getColumn(5).setResizable(false);
            tblPerformance.getColumnModel().getColumn(6).setResizable(false);
            tblPerformance.getColumnModel().getColumn(7).setResizable(false);
        }

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        lblSupplier.setText("Supplier");

        lblProduct.setText("Product");

        lblTargetPrice.setText("Target Price");

        lblAvgActualPrice.setText("Avg Actual Price");

        lblTotalQuantity.setText("Total Quantity");

        lblRevenue.setText("Revenue");

        lblBelowTarget.setText("Below Target");

        lblAfterTarget.setText("After Target");

        txtTargetPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTargetPriceActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(213, 213, 213)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblAvgActualPrice)
                                    .addGap(23, 23, 23)
                                    .addComponent(txtAvgActualPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(txtProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblTargetPrice)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(49, 49, 49)
                                            .addComponent(txtSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtTargetPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblTotalQuantity)
                                    .addComponent(lblRevenue)
                                    .addComponent(lblBelowTarget)
                                    .addComponent(lblSupplier)
                                    .addComponent(lblProduct)
                                    .addComponent(lblAfterTarget, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(37, 37, 37)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtTotalQuantity, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                                    .addComponent(txtRevenue)
                                    .addComponent(txtBelowTarget)
                                    .addComponent(txtAfterTarget)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnBack)
                                .addGap(151, 151, 151)
                                .addComponent(lblTitle)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnRefresh)
                                .addGap(20, 20, 20))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 604, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitle)
                    .addComponent(btnBack)
                    .addComponent(btnRefresh))
                .addGap(23, 23, 23)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSupplier)
                    .addComponent(txtSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProduct)
                    .addComponent(txtProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTargetPrice)
                    .addComponent(txtTargetPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAvgActualPrice)
                    .addComponent(txtAvgActualPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTotalQuantity)
                    .addComponent(txtTotalQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRevenue)
                    .addComponent(txtRevenue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBelowTarget)
                    .addComponent(txtBelowTarget, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAfterTarget)
                    .addComponent(txtAfterTarget, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        CardLayout layout = (CardLayout) mainWorkArea.getLayout();
        layout.show(mainWorkArea, PricingManagerWorkAreaPanel.CARD_NAME);

    }//GEN-LAST:event_btnBackActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        // TODO add your handling code here:
        populateTable();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void txtTargetPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTargetPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTargetPriceActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAfterTarget;
    private javax.swing.JLabel lblAvgActualPrice;
    private javax.swing.JLabel lblBelowTarget;
    private javax.swing.JLabel lblProduct;
    private javax.swing.JLabel lblRevenue;
    private javax.swing.JLabel lblSupplier;
    private javax.swing.JLabel lblTargetPrice;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTotalQuantity;
    private javax.swing.JTable tblPerformance;
    private javax.swing.JTextField txtAfterTarget;
    private javax.swing.JTextField txtAvgActualPrice;
    private javax.swing.JTextField txtBelowTarget;
    private javax.swing.JTextField txtProduct;
    private javax.swing.JTextField txtRevenue;
    private javax.swing.JTextField txtSupplier;
    private javax.swing.JTextField txtTargetPrice;
    private javax.swing.JTextField txtTotalQuantity;
    // End of variables declaration//GEN-END:variables
}
