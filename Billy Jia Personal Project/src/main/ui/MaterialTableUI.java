package ui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Vector;
import java.io.*;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import javax.swing.table.*;

// A lot fo the structure of the code was based on https://coderanch.com/t/620911/java/Saving-Loading-content-JTable

public class MaterialTableUI extends JFrame {

    private String[] columnNames =
            {"Material Rarity", "Material Name", "Material Drop Rate", "Material Location", "Cost Per Run"};

    private Object[][] data =
            {};

    private JButton jbtAddRow = new JButton("Add new row");
    private JButton jbtSave = new JButton("Save Table");
    private JButton jbtLoad = new JButton("Load Table");
    private JButton jbtVictory = new JButton("Victory Sound");
    private JButton jbtCalculation = new JButton("Expected Value");
    private JTextField jtfInput = new JTextField();
    private JTextField jtfInput2 = new JTextField();
    private JLabel jlbCalculate = new JLabel();

    private DefaultTableModel tableModel = new DefaultTableModel(data, columnNames);
    private JTable myJTable = new JTable(tableModel);

    private JFileChooser fileSaver = new JFileChooser(new File("."));

    private void saveTable() {
        if (fileSaver.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            saveTable(fileSaver.getSelectedFile());
        }
    }
    // EFFECTS: Saves Table

    private void saveTable(File file) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(
                    new FileOutputStream(file));
            out.writeObject(tableModel.getDataVector());
            out.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    // EFFECTS: Loads Table

    private void loadTable() {
        if (fileSaver.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            loadTable(fileSaver.getSelectedFile());
        }
    }
    // EFFECTS: Loads Table

    private void loadTable(File file) {
        try {
            ObjectInputStream in = new ObjectInputStream(
                    new FileInputStream(file));
            Vector rowData = (Vector) in.readObject();
            Iterator itr = rowData.iterator();
            while (itr.hasNext()) {
                tableModel.addRow((Vector) itr.next());
            }
            in.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    // EFFECTS: Plays sound on the button labelled

    public static void playSound(String soundName) {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception ex) {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();
        }
    }
    // EFFECTS: Layout for the table

    public MaterialTableUI() {
        myJTable.setFont(new Font("Serif", Font.PLAIN, 20));
        myJTable.setRowHeight(myJTable.getRowHeight() + 10);

        add(jbtAddRow, BorderLayout.NORTH);

        add(new JScrollPane(myJTable), BorderLayout.CENTER);

        JPanel panel = new JPanel(new java.awt.GridLayout(3, 2));
        panel.add(jbtSave);
        panel.add(jbtLoad);
        panel.add(jbtCalculation);
        panel.add(jbtVictory);
        panel.add(jtfInput);
        panel.add(jtfInput2);
        panel.add(jlbCalculate);
        add(panel, BorderLayout.SOUTH);
        buttonPresser();
    }
    // EFFECTS: Code for multiple buttons

    public void buttonPresser() {
        jbtAddRow.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (myJTable.getSelectedRow() >= 0) {
                    tableModel.insertRow(myJTable.getSelectedRow(),
                            new java.util.Vector());
                } else {
                    tableModel.addRow(new java.util.Vector());
                }
            }
        });

        jbtVictory.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                playSound("Cpsc210Sound.wav");
            }
        });

        jbtSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saveTable();
            }
        });



        buttonPresser2();
    }
    // EFFECTS: Code for multiple buttons

    public void buttonPresser2() {
        jbtCalculation.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String converter = jtfInput.getText();
                    Double rateDouble = Double.parseDouble(converter);
                    String runConverter = jtfInput2.getText();
                    Double runDouble = Double.parseDouble(runConverter);
                    Double expectedValue = rateDouble * runDouble;
                    jlbCalculate.setText("You are expected to get " + expectedValue.toString() + " drops.");
                } catch (NumberFormatException ex) {
                    jlbCalculate.setText("No Value Inputted");
                }


            }


        });

        jbtLoad.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                loadTable();
            }
        });
    }





    //Effects: Runs the program
    public static void main(String[] args) {

        MaterialTableUI frame = new MaterialTableUI();
        frame.setTitle("Material Table");
        frame.setSize(800, 400);
        frame.setLocationRelativeTo(null); // Center the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

}