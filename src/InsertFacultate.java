import com.participant.candidat.Candidat;
import com.unibuc.facultate.Facultate;
import com.unibuc.specializare.Specializare;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.List;
import javax.swing.*;
import javax.swing.text.JTextComponent;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

public class InsertFacultate extends JFrame {
    private JPanel panelFacultate;
    private JTextField introducetiNumeleFacultatiiTextField;
    private JTextField introducetiAdresaTextField;
    private JTextField nrTotalDeLocuriTextField;
    private JTextField nrSpecializariTextField;
    private JButton adaugaSpecializareButton;
    private JTextField numeSpecializareText;
    private JTextField nrLocuriText;
    private JTextField tipAdmitereText;
    private JButton AddFacultate;
    private JButton inapoi;

    private List<Specializare> specializari = new ArrayList<>();

    public InsertFacultate() {
        add(panelFacultate);
        setTitle("Intoduceti Facultate");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        adaugaSpecializareButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nume = numeSpecializareText.getText();
                String tip = tipAdmitereText.getText();
                Integer nrLoc = Integer.parseInt(nrLocuriText.getText());
                Integer nrCand = 0;
                List<Candidat> c = new ArrayList<Candidat>();

                Specializare s = new Specializare(nume, nrLoc, tip, nrCand, c);
                specializari.add(s);

                numeSpecializareText.setText("");
                tipAdmitereText.setText("");
                nrLocuriText.setText("");
            }
        });


        AddFacultate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fac = introducetiNumeleFacultatiiTextField.getText();
                String adresa = introducetiAdresaTextField.getText();
                Integer nrLoc = Integer.parseInt(nrTotalDeLocuriTextField.getText());
                Integer nrSpec = Integer.parseInt(nrSpecializariTextField.getText());

                Facultate f = new Facultate(fac, adresa, nrLoc, nrSpec, specializari);
//                System.out.println(f);
//                facultati.add(f);

                introducetiAdresaTextField.setText("");
                introducetiNumeleFacultatiiTextField.setText("");
                nrSpecializariTextField.setText("");
                nrTotalDeLocuriTextField.setText("");


                try {
                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/admitere?autoReconnect=true&useSSL=false", "root", "root1234");
                    Statement stFac = conn.createStatement();
                    String idMaxFac = "select max(id) from facultati";
                    ResultSet rsFac = stFac.executeQuery(idMaxFac);
                    Integer idxFac = 0, idxSpec = 0;
                    while (rsFac.next()) {
                        idxFac = rsFac.getInt("max(id)");
                    }
                    idxFac++;

//                    System.out.println("pe aici si io");

//                  indicele max pt specializare
                    Statement stSpec = conn.createStatement();
                    String idMaxSpec = "select max(id_specializare) from specializari";
                    ResultSet rsSpec = stSpec.executeQuery(idMaxSpec);
                    while (rsSpec.next()) {
                        idxSpec = rsSpec.getInt("max(id_specializare)");
                    }
                    idxSpec++;

//                    System.out.println("acusica");
                    PreparedStatement pst = conn.prepareStatement("INSERT INTO facultati" + " VALUES (?, ?, ?, ?, ?)");
                    pst.setInt(1, idxFac);
                    pst.setString(2, fac);
                    pst.setString(3, adresa);
                    pst.setInt(4, nrLoc);
                    pst.setInt(5, nrSpec);
                    pst.executeUpdate();
//                    System.out.println("undeva pe aici");

                    for (int i = 0; i < nrSpec; i++) {
//                        System.out.println("aicisa");
                        PreparedStatement specSTM = conn.prepareStatement("INSERT into specializari" + " VALUES (?,?,?,?,?)");
                        specSTM.setInt(1, idxSpec);
                        idxSpec++;
                        specSTM.setInt(2, idxFac);
                        specSTM.setString(3, specializari.get(i).getNumeSpecializare());
                        specSTM.setInt(4, specializari.get(i).getNrLocuriSpecializare());
                        specSTM.setInt(5, 0);
                        specSTM.executeUpdate();
                    }

//                    System.out.println("AICI");
                } catch (SQLException ex) {
                    System.out.println("Eroare la conectare la BD");
                }
                Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                setService("AddFacultate", timestamp);

            }
        });
        inapoi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MyForm myForm = new MyForm();
                myForm.setVisible(true);
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
        panelFacultate = new JPanel();
        panelFacultate.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(14, 2, new Insets(0, 0, 0, 0), -1, -1));
        introducetiNumeleFacultatiiTextField = new JTextField();
        introducetiNumeleFacultatiiTextField.setText("");
        panelFacultate.add(introducetiNumeleFacultatiiTextField, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        introducetiAdresaTextField = new JTextField();
        introducetiAdresaTextField.setText("");
        panelFacultate.add(introducetiAdresaTextField, new com.intellij.uiDesigner.core.GridConstraints(4, 0, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JLabel label1 = new JLabel();
        label1.setText("Numele Facultatii");
        panelFacultate.add(label1, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label2 = new JLabel();
        label2.setText("Adresa");
        panelFacultate.add(label2, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        nrTotalDeLocuriTextField = new JTextField();
        nrTotalDeLocuriTextField.setText("");
        panelFacultate.add(nrTotalDeLocuriTextField, new com.intellij.uiDesigner.core.GridConstraints(6, 0, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JLabel label3 = new JLabel();
        label3.setText("Nr specializari");
        panelFacultate.add(label3, new com.intellij.uiDesigner.core.GridConstraints(7, 0, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        nrSpecializariTextField = new JTextField();
        nrSpecializariTextField.setText("");
        panelFacultate.add(nrSpecializariTextField, new com.intellij.uiDesigner.core.GridConstraints(8, 0, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JLabel label4 = new JLabel();
        label4.setText("Nr total de locuri la admitere");
        panelFacultate.add(label4, new com.intellij.uiDesigner.core.GridConstraints(5, 0, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label5 = new JLabel();
        label5.setText("Intoduceti datele despre noua facultate");
        panelFacultate.add(label5, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        adaugaSpecializareButton = new JButton();
        adaugaSpecializareButton.setText("Adauga Specializare");
        panelFacultate.add(adaugaSpecializareButton, new com.intellij.uiDesigner.core.GridConstraints(9, 0, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label6 = new JLabel();
        label6.setText("Numele Specializarii");
        panelFacultate.add(label6, new com.intellij.uiDesigner.core.GridConstraints(10, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        numeSpecializareText = new JTextField();
        panelFacultate.add(numeSpecializareText, new com.intellij.uiDesigner.core.GridConstraints(10, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JLabel label7 = new JLabel();
        label7.setText("Nr locuri");
        panelFacultate.add(label7, new com.intellij.uiDesigner.core.GridConstraints(11, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        nrLocuriText = new JTextField();
        panelFacultate.add(nrLocuriText, new com.intellij.uiDesigner.core.GridConstraints(11, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JLabel label8 = new JLabel();
        label8.setText("Tip Admitere");
        panelFacultate.add(label8, new com.intellij.uiDesigner.core.GridConstraints(12, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        tipAdmitereText = new JTextField();
        panelFacultate.add(tipAdmitereText, new com.intellij.uiDesigner.core.GridConstraints(12, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        AddFacultate = new JButton();
        AddFacultate.setHorizontalAlignment(0);
        AddFacultate.setText("Salveaza Facultatea");
        panelFacultate.add(AddFacultate, new com.intellij.uiDesigner.core.GridConstraints(13, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        inapoi = new JButton();
        inapoi.setText("Inapoi");
        panelFacultate.add(inapoi, new com.intellij.uiDesigner.core.GridConstraints(13, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return panelFacultate;
    }

}
