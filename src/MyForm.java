import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.*;

public class MyForm extends JFrame {

    private JPanel rootPanel;
    private JButton adaugaFacultateButton;
    private JButton afiseazaFacultatiButton;
    private JButton adaugaCandidatiButton;
    private JButton afiseazaCandidatiiButton;
    private JButton stergeFacultateButton;
    private JButton stergeCandidatButton;

    public MyForm() {
        add(rootPanel);
        setTitle("Admitere 2019");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        adaugaFacultateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InsertFacultate insertFacultate = new InsertFacultate();
                insertFacultate.setVisible(true);
                insertFacultate.pack();
                dispose();
                Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                setService("adaugaFacultateButton", timestamp);
            }
        });
        adaugaCandidatiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InsertCandidat insertCandidat = new InsertCandidat();
                insertCandidat.setVisible(true);
                insertCandidat.pack();
                dispose();
                Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                setService("adaugaCandidatiButton", timestamp);
            }
        });
        afiseazaFacultatiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                AfisareFacultati afisareFacultati = new AfisareFacultati();
//                afisareFacultati.setVisible(true);
//                afisareFacultati.pack();
//                dispose();
                createAfisareFacultati();
                dispose();
                Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                setService("afiseazaFacultatiButton", timestamp);
            }
        });
        afiseazaCandidatiiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createAfisareCandidati();
                dispose();
                Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                setService("afiseazaCandidatiiButton", timestamp);
            }
        });
        stergeFacultateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StergeFacultate stergeFacultate = new StergeFacultate();
                stergeFacultate.setVisible(true);
                stergeFacultate.pack();
                dispose();
                Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                setService("stergeFacultateButton", timestamp);
            }
        });
        stergeCandidatButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StergeCandidat stergeCandidat = new StergeCandidat();
                stergeCandidat.setVisible(true);
                stergeCandidat.pack();
                dispose();
                Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                setService("stergeCandidatiButton", timestamp);
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

    public void createAfisareFacultati() {
        final JFrame frame = new JFrame("Afisarea Facultatilor");
        frame.setLayout(new GridLayout(0, 1));
        frame.add(new JButton(new AbstractAction("Inapoi") {
            @Override
            public void actionPerformed(ActionEvent e) {
                MyForm myForm = new MyForm();
                myForm.setVisible(true);
                frame.dispose();
            }
        }));

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/admitere?autoReconnect=true&useSSL=false", "root", "root1234");
            Statement st = conn.createStatement();
            String qry = "select nume from facultati";
            ResultSet rs = st.executeQuery(qry);
            while (rs.next()) {
                frame.add(new JTextField("Facultatea de " + rs.getString("nume")));
                frame.validate();
                frame.repaint();
            }


        } catch (SQLException ex) {
            System.out.println("Eroare la conecatrea la BD");
        }


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setVisible(true);
    }


    public void createAfisareCandidati() {
        final JFrame frame = new JFrame("Afisarea Candidatilor");
        frame.setLayout(new GridLayout(0, 1));
        frame.add(new JButton(new AbstractAction("Inapoi") {
            @Override
            public void actionPerformed(ActionEvent e) {
                MyForm myForm = new MyForm();
                myForm.setVisible(true);
                frame.dispose();
            }
        }));

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/admitere?autoReconnect=true&useSSL=false", "root", "root1234");
            Statement st = conn.createStatement();
            String qry = "select nume, prenume from candidati";
            ResultSet rs = st.executeQuery(qry);
            while (rs.next()) {
                frame.add(new JTextField(rs.getString("nume") + " " + rs.getString("prenume")));
                frame.validate();
                frame.repaint();
            }


        } catch (SQLException ex) {
            System.out.println("Eroare la conecatrea la BD");
        }


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setVisible(true);
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
        rootPanel = new JPanel();
        rootPanel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(7, 1, new Insets(0, 0, 0, 0), -1, -1));
        adaugaFacultateButton = new JButton();
        adaugaFacultateButton.setText("Adauga Facultate");
        rootPanel.add(adaugaFacultateButton, new com.intellij.uiDesigner.core.GridConstraints(4, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        afiseazaFacultatiButton = new JButton();
        afiseazaFacultatiButton.setText("Afiseaza Facultati");
        rootPanel.add(afiseazaFacultatiButton, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label1 = new JLabel();
        label1.setText("Meniu");
        rootPanel.add(label1, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(37, 69), null, 0, false));
        adaugaCandidatiButton = new JButton();
        adaugaCandidatiButton.setText("Adauga Candidati");
        rootPanel.add(adaugaCandidatiButton, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        afiseazaCandidatiiButton = new JButton();
        afiseazaCandidatiiButton.setText("Afiseaza Candidatii");
        rootPanel.add(afiseazaCandidatiiButton, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        stergeFacultateButton = new JButton();
        stergeFacultateButton.setText("Sterge Facultate");
        rootPanel.add(stergeFacultateButton, new com.intellij.uiDesigner.core.GridConstraints(5, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        stergeCandidatButton = new JButton();
        stergeCandidatButton.setText("Sterge Candidat");
        rootPanel.add(stergeCandidatButton, new com.intellij.uiDesigner.core.GridConstraints(6, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return rootPanel;
    }

}
