import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by YB on 05.01.2016.
 */
public class GUI extends JFrame implements ActionListener {
    private JPanel customerPanel;
    private JPanel carPanel;
    private JPanel chooseCustomerPanel;
    private JPanel sellButtonPanel;
    private JPanel chooseCarPanel;
    private JTextArea carDetailInfo;
    private JTextArea customerDetailInfo;
    private JComboBox customerInfoComboBox;
    private JComboBox carsListComboBox;
    private JButton sellButton;
    private Shop carShop;

    GUI(Shop carShop) {
        super("Bye new car");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocation(500, 100);
        setResizable(false);
        this.setLayout(new BorderLayout());
        customerPanel = new JPanel();
        chooseCustomerPanel = new JPanel();
        sellButtonPanel = new JPanel();
        carPanel = new JPanel();
        chooseCarPanel = new JPanel();
        customerInfoComboBox = new JComboBox(carShop.getCdb().getClientsDBbyNames());
        carsListComboBox = new JComboBox(carShop.getCwh().getAvailableCarsDBbyVIN());
        carDetailInfo = new JTextArea();
        customerDetailInfo = new JTextArea();
        sellButton = new JButton("SELL");
        sellButton.setName("sell");
        this.carShop = carShop;

        customerInfoComboBox.setName("customerInfoCB");
        carsListComboBox.setName("carInfoCB");

        customerInfoComboBox.addActionListener(this);
        carsListComboBox.addActionListener(this);
        sellButton.addActionListener(this);

        customerPanel.setPreferredSize(new Dimension(300, 200));
        customerPanel.setLayout(new BoxLayout(customerPanel, BoxLayout.Y_AXIS));
        customerPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED), "Choose the customer: "));

        carPanel.setPreferredSize(new Dimension(300, 200));
        carPanel.setLayout(new BoxLayout(carPanel, BoxLayout.Y_AXIS));
        carPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED), "Choose the car: "));

        sellButtonPanel.setPreferredSize(new Dimension(250, 50));

        customerInfoComboBox.setPreferredSize(new Dimension(250, 30));
        carsListComboBox.setPreferredSize(new Dimension(250, 30));

        carDetailInfo.setPreferredSize(new Dimension(250, 200));
        carDetailInfo.setBackground(new Color(255, 255, 255));

        customerDetailInfo.setPreferredSize(new Dimension(250, 200));
        customerDetailInfo.setBackground(new Color(255, 255, 255));

        chooseCustomerPanel.add(customerInfoComboBox);
        chooseCustomerPanel.setPreferredSize(new Dimension(250, 60));
        sellButtonPanel.add(sellButton);

        chooseCarPanel.add(carsListComboBox);
        chooseCarPanel.setPreferredSize(new Dimension(250, 60));

        customerPanel.add(chooseCustomerPanel);
        customerPanel.add(customerDetailInfo);

        carPanel.add(chooseCarPanel);
        carPanel.add(carDetailInfo);
        add(customerPanel, BorderLayout.WEST);
        add(carPanel, BorderLayout.EAST);
        add(sellButtonPanel, BorderLayout.SOUTH);

        this.pack();

    }

    public void showGUI() {
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() instanceof JComboBox) {

            JComboBox comboBox = (JComboBox) e.getSource();

            if (comboBox.getName() == "customerInfoCB") {
                customerDetailInfo.setText(
                        "Birth Day: " + carShop.getCdb().getClientsDB()[comboBox.getSelectedIndex()].getBirthDate() + "\n" +
                                "Email: " + carShop.getCdb().getClientsDB()[comboBox.getSelectedIndex()].geteMail() + "\n" +
                                "Tel. num: " + carShop.getCdb().getClientsDB()[comboBox.getSelectedIndex()].getTelNumber() + "\n" +
                                "VIP: " + carShop.getCdb().getClientsDB()[comboBox.getSelectedIndex()].isVIP()
                );
            }

            if (comboBox.getName() == "carInfoCB") {
                carDetailInfo.setText(
                        "Model: " + carShop.getCwh().getAvailableCarsDB()[comboBox.getSelectedIndex()].getModel() + "\n" +
                                "Body Type: " + carShop.getCwh().getAvailableCarsDB()[comboBox.getSelectedIndex()].getBodyType() + "\n" +
                                "Color: " + carShop.getCwh().getAvailableCarsDB()[comboBox.getSelectedIndex()].getColor() + "\n" +
                                "Engine type: " + carShop.getCwh().getAvailableCarsDB()[comboBox.getSelectedIndex()].getEngineType() + "\n" +
                                "Engine vol: " + carShop.getCwh().getAvailableCarsDB()[comboBox.getSelectedIndex()].getEngineSize() + "\n" +
                                "Price: " + carShop.getCwh().getAvailableCarsDB()[comboBox.getSelectedIndex()].getPrice()
                );
            }
        }
        if (e.getSource() instanceof JButton) {
            JButton button = (JButton) e.getSource();
            if (button.getName() == "sell") {
                if (customerInfoComboBox.getSelectedItem() != null && carsListComboBox.getSelectedItem() != null) {
                    carShop.bayCar(carShop.getCwh().getAvailableCarsDB()[carsListComboBox.getSelectedIndex()].getVinCode(),
                            carShop.getCdb().getClientsDB()[customerInfoComboBox.getSelectedIndex()].getFirstName(),
                            carShop.getCdb().getClientsDB()[customerInfoComboBox.getSelectedIndex()].getLastName(),
                            "06.01.16");

                    carShop.showAllOperations();
                }
            }
        }
    }
}

