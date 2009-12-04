/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * TestHelper.java
 *
 * Created on 2009-03-27, 22:43:52
 */

package pl.rdk.vision2;

import java.util.ResourceBundle;
import pl.rdk.vision2.tests.Test;

/**
 *
 * @author robkar
 */
public class TestHelper extends javax.swing.JFrame {
    Test t;
    private ResourceBundle labels;

    /** Creates new form TestHelper */
    public TestHelper(Test t) {
        this.t=t;
        labels = ResourceBundle.getBundle("pl/rdk/vision2/languages/i18n");
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextFieldResult = new javax.swing.JTextField();
        jLabelResult = new javax.swing.JLabel();
        jButtonCancel = new javax.swing.JButton();
        jLabelDefect = new javax.swing.JLabel();
        jTextFieldDefect = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle(labels.getString("currentResult")); // NOI18N
        setAlwaysOnTop(true);

        jTextFieldResult.setEditable(false);

        jLabelResult.setText(labels.getString("result")); // NOI18N

        jButtonCancel.setText(labels.getString("cancel")); // NOI18N
        jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelActionPerformed(evt);
            }
        });

        jLabelDefect.setText(labels.getString("error")); // NOI18N

        jTextFieldDefect.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelResult, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelDefect, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldDefect, javax.swing.GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE)
                    .addComponent(jTextFieldResult, javax.swing.GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.CENTER, layout.createSequentialGroup()
                .addGap(168, 168, 168)
                .addComponent(jButtonCancel)
                .addGap(169, 169, 169))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDefect)
                    .addComponent(jTextFieldDefect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldResult, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelResult))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonCancel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelActionPerformed
        t.exit();
        dispose();
}//GEN-LAST:event_jButtonCancelActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JLabel jLabelDefect;
    private javax.swing.JLabel jLabelResult;
    public javax.swing.JTextField jTextFieldDefect;
    public javax.swing.JTextField jTextFieldResult;
    // End of variables declaration//GEN-END:variables

}
