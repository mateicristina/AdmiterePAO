import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.*;

public class StergeCandidat extends JFrame {
    private JTextField numeText;
    private JTextField prenumeText;
    private JButton stergeCandidatul;
    private JButton inapoi;
    private JPanel panelStergeCandidat;

    public StergeCandidat() {


        add(panelStergeCandidat);
        setTitle("Stergeti Facultati");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        stergeCandidatul.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String nume = numeText.getText();
                numeText.setText("");
                String prenume = prenumeText.getText();
                prenumeText.setText("");

                try {
                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/admitere?autoReconnect=true&useSSL=false", "root", "root1234");
                    PreparedStatement pst = conn.prepareStatement("delete from candidati where nume=? and prenume=?");
                    pst.setString(1, nume);
                    pst.setString(2, prenume);
                    pst.executeUpdate();

                } catch (SQLException ex) {
                    System.out.println("Eroare la conectarea la BD");
                }

                Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                setService("stergeCandidatul", timestamp);

            }



        });


        inapoi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MyForm myForm = new MyForm();
                myForm.setVisible(true);
//                myForm.pack();
                dispose();
                Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                setService("inapoi", timestamp);
            }
        });
    }
    public void setService(String actiune, Timestamp timestamp) {
        try (PrintWriter writer = new PrintWriter(new File("actiuni.csv"))) {

            StringBuilder sb = new StringBuilder();

//                    System.out.println(timestamp);
            sb.append(actiune);
            sb.append(',');
            sb.append(timestamp);
            sb.append('\n');

            writer.write(sb.toString());

            System.out.println("done!");

        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        panelStergeCandidat = new JPanel();
        panelStergeCandidat.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(3, 2, new Insets(0, 0, 0, 0), -1, -1));
        final JLabel label1 = new JLabel();
        label1.setText("Nume");
        panelStergeCandidat.add(label1, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        numeText = new JTextField();
        panelStergeCandidat.add(numeText, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JLabel label2 = new JLabel();
        label2.setText("Prenume");
        panelStergeCandidat.add(label2, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        prenumeText = new JTextField();
        panelStergeCandidat.add(prenumeText, new com.intellij.uiDesigner.core.GridConstraints(1, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        stergeCandidatul = new JButton();
        stergeCandidatul.setText("Sterge Candidatul");
        panelStergeCandidat.add(stergeCandidatul, new com.intellij.uiDesigner.core.GridConstraints(2, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        inapoi = new JButton();
        inapoi.setText("Inapoi");
        panelStergeCandidat.add(inapoi, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return panelStergeCandidat;
    }

}