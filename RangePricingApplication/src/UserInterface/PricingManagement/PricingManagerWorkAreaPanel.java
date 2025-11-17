package UserInterface.PricingManagement;

import TheBusiness.Business.Business;
import java.awt.CardLayout;
import javax.swing.JPanel;

public class PricingManagerWorkAreaPanel extends javax.swing.JPanel {

    public static final String CARD_NAME = "PricingManagerWorkAreaPanel";

    private JPanel mainWorkArea;
    private Business business;

    public PricingManagerWorkAreaPanel(Business business, JPanel mainWorkArea) {
        this.business = business;
        this.mainWorkArea = mainWorkArea;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnbrowseProductPerformance = new javax.swing.JButton();
        btnadjustTargetPrices = new javax.swing.JButton();
        btnrunPriceSimulation = new javax.swing.JButton();
        btngenerateFinalReport = new javax.swing.JButton();

        btnbrowseProductPerformance.setText("Browse Product Performance");
        btnbrowseProductPerformance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbrowseProductPerformanceActionPerformed(evt);
            }
        });

        btnadjustTargetPrices.setText("Adjust Target Prices");
        btnadjustTargetPrices.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnadjustTargetPricesActionPerformed(evt);
            }
        });

        btnrunPriceSimulation.setText("Run Price Simulation");
        btnrunPriceSimulation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnrunPriceSimulationActionPerformed(evt);
            }
        });

        btngenerateFinalReport.setText("Generate Final Report");
        btngenerateFinalReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btngenerateFinalReportActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnrunPriceSimulation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnbrowseProductPerformance, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(71, 71, 71)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnadjustTargetPrices, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btngenerateFinalReport, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE))
                .addContainerGap(106, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnbrowseProductPerformance)
                    .addComponent(btnadjustTargetPrices))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnrunPriceSimulation)
                    .addComponent(btngenerateFinalReport))
                .addContainerGap(240, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnbrowseProductPerformanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbrowseProductPerformanceActionPerformed
        // TODO add your handling code here:
        BrowseProductPerformanceJPanel panel = new BrowseProductPerformanceJPanel(business, mainWorkArea);

        mainWorkArea.add("BrowseProductPerformanceJPanel", panel);
        ((CardLayout) mainWorkArea.getLayout()).next(mainWorkArea);

    }//GEN-LAST:event_btnbrowseProductPerformanceActionPerformed

    private void btnadjustTargetPricesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnadjustTargetPricesActionPerformed
        // TODO add your handling code here:
        AdjustTargetPricePanel panel
                = new AdjustTargetPricePanel(business, mainWorkArea);

        mainWorkArea.add("AdjustTargetPricePanel", panel);
        ((CardLayout) mainWorkArea.getLayout()).next(mainWorkArea);
    }//GEN-LAST:event_btnadjustTargetPricesActionPerformed

    private void btnrunPriceSimulationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnrunPriceSimulationActionPerformed
        // TODO add your handling code here:
        RunSimulationPanel panel = new RunSimulationPanel(business, mainWorkArea);

        mainWorkArea.add("RunSimulationPanel", panel);
        ((CardLayout) mainWorkArea.getLayout()).next(mainWorkArea);
    }//GEN-LAST:event_btnrunPriceSimulationActionPerformed

    private void btngenerateFinalReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btngenerateFinalReportActionPerformed
        // TODO add your handling code here:
        FinalReportPanel panel = new FinalReportPanel(business, mainWorkArea);

        mainWorkArea.add("FinalReportPanel", panel);
        ((CardLayout) mainWorkArea.getLayout()).next(mainWorkArea);
    }//GEN-LAST:event_btngenerateFinalReportActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnadjustTargetPrices;
    private javax.swing.JButton btnbrowseProductPerformance;
    private javax.swing.JButton btngenerateFinalReport;
    private javax.swing.JButton btnrunPriceSimulation;
    // End of variables declaration//GEN-END:variables
}
