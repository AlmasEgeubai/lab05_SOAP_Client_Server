
import bmk01_soap.Answer;
import bmk01_soap.ICommunicationWithClient;
import java.awt.Color;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

public class JFrame extends javax.swing.JFrame {

    String address = "";
    ICommunicationWithClient server;

    public JFrame() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabelA = new javax.swing.JLabel();
        jLabelB = new javax.swing.JLabel();
        jLabelX = new javax.swing.JLabel();
        jLabelResult = new javax.swing.JLabel();
        jTextFieldA = new javax.swing.JTextField();
        jTextFieldB = new javax.swing.JTextField();
        jTextFieldX = new javax.swing.JTextField();
        jTextFieldAddress = new javax.swing.JTextField();
        jButtonClear = new javax.swing.JButton();
        jButtonSolve = new javax.swing.JButton();
        jLabelX1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SOAP Client Server");
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/primer.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(40, 80, 360, 190);

        jLabelA.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabelA.setText("A = ");
        getContentPane().add(jLabelA);
        jLabelA.setBounds(20, 320, 35, 24);

        jLabelB.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabelB.setText("B = ");
        getContentPane().add(jLabelB);
        jLabelB.setBounds(260, 320, 34, 24);

        jLabelX.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabelX.setText("Адрес:");
        getContentPane().add(jLabelX);
        jLabelX.setBounds(300, 420, 58, 24);

        jLabelResult.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabelResult.setText("Ответ: Y = ");
        getContentPane().add(jLabelResult);
        jLabelResult.setBounds(20, 420, 270, 24);

        jTextFieldA.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jTextFieldA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldAActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldA);
        jTextFieldA.setBounds(60, 320, 70, 25);

        jTextFieldB.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        getContentPane().add(jTextFieldB);
        jTextFieldB.setBounds(300, 320, 70, 25);

        jTextFieldX.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        getContentPane().add(jTextFieldX);
        jTextFieldX.setBounds(530, 320, 70, 25);

        jTextFieldAddress.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jTextFieldAddress.setText("http://localhost:1099/bmk/soap");
        getContentPane().add(jTextFieldAddress);
        jTextFieldAddress.setBounds(360, 420, 254, 25);

        jButtonClear.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jButtonClear.setText("Очистить");
        jButtonClear.setName(""); // NOI18N
        jButtonClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClearActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonClear);
        jButtonClear.setBounds(90, 370, 115, 33);

        jButtonSolve.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jButtonSolve.setText("Решить");
        jButtonSolve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSolveActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonSolve);
        jButtonSolve.setBounds(410, 370, 95, 33);

        jLabelX1.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabelX1.setText("X = ");
        getContentPane().add(jLabelX1);
        jLabelX1.setBounds(490, 320, 35, 24);

        setSize(new java.awt.Dimension(639, 493));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldAActionPerformed

    private void jButtonClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClearActionPerformed
        jTextFieldA.setText("");
        jTextFieldB.setText("");
        jTextFieldX.setText("");
        jTextFieldAddress.setText("http://localhost:1099/bmk/soap");
        jLabelResult.setText("Ответ: Y = ");
        jLabelResult.setForeground(Color.BLACK);
    }//GEN-LAST:event_jButtonClearActionPerformed

    private void jButtonSolveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSolveActionPerformed
        try {
            String newAddress = jTextFieldAddress.getText();

            if (!address.equals(newAddress)) {
                address = newAddress;
                JaxWsProxyFactoryBean factoryBean = new JaxWsProxyFactoryBean();
                factoryBean.setServiceClass(ICommunicationWithClient.class);
                factoryBean.setAddress(address);
                server = (ICommunicationWithClient) factoryBean.create();
            }
            double a = Double.parseDouble(jTextFieldA.getText());
            double b = Double.parseDouble(jTextFieldB.getText());
            double x = Double.parseDouble(jTextFieldX.getText());
            // Вызов удаленного метода на сервере через web-технологию SOAP
            Answer answer = server.solution(a, b, x);
            if (answer != null) {
                //jLabelResult.setText("Ответ: Y = " + answer.getY());
                jLabelResult.setForeground(Color.BLACK);
                jLabelResult.setText(String.format("Ответ: Y = %.3f", answer.getY()));
            } else {
                jLabelResult.setText("Ошибка");
                jLabelResult.setForeground(Color.red);
            }
        } catch (NumberFormatException e) {
            jLabelResult.setText("Ошибка");
            jLabelResult.setForeground(Color.red);
        }
    }//GEN-LAST:event_jButtonSolveActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> {
            new JFrame().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonClear;
    private javax.swing.JButton jButtonSolve;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelA;
    private javax.swing.JLabel jLabelB;
    private javax.swing.JLabel jLabelResult;
    private javax.swing.JLabel jLabelX;
    private javax.swing.JLabel jLabelX1;
    private javax.swing.JTextField jTextFieldA;
    private javax.swing.JTextField jTextFieldAddress;
    private javax.swing.JTextField jTextFieldB;
    private javax.swing.JTextField jTextFieldX;
    // End of variables declaration//GEN-END:variables
}
