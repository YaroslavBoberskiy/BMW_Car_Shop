import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by YB on 05.01.2016.
 */
public class GUI_Sell extends JFrame implements ActionListener {
    private JPanel customerPanel;
    private JPanel carPanel;
    private JPanel chooseCustomerPanel;
    private JPanel sellButtonPanel;
    private JPanel chooseCarPanel;

    private JMenuBar menuBar;
    private JMenu fileMenu;
    private JMenuItem showTransactionsAction;

    private JTextArea carDetailInfo;
    private JTextArea customerDetailInfo;
    private JComboBox customerInfoComboBox;
    private JComboBox carsListComboBox;
    private JButton sellButton;
    private Shop carShop;
    private GUI_TransactionsInfo guiTransactionsInfo;

    GUI_Sell(Shop carShop) {
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
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        fileMenu = new JMenu("File");
        showTransactionsAction = new JMenuItem("Show all transactions");
        showTransactionsAction.setName("show_transact");
        fileMenu.add(showTransactionsAction);
        menuBar.add(fileMenu);
        customerInfoComboBox = new JComboBox(carShop.getCdb().getClientsDBbyNames());
        customerInfoComboBox.setSelectedIndex(0);
        carsListComboBox = new JComboBox(carShop.getCwh().getAvailableCarsDBbyVIN());
        carsListComboBox.setSelectedIndex(0);
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
        showTransactionsAction.addActionListener(this);

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

        guiTransactionsInfo = new GUI_TransactionsInfo(carShop);

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
                        "Birth Day: " + carShop.getCdb().getClientsDB().get(comboBox.getSelectedIndex()).getBirthDate() + "\n" +
                                "Email: " + carShop.getCdb().getClientsDB().get(comboBox.getSelectedIndex()).geteMail() + "\n" +
                                "Tel. num: " + carShop.getCdb().getClientsDB().get(comboBox.getSelectedIndex()).getTelNumber() + "\n" +
                                "VIP: " + carShop.getCdb().getClientsDB().get(comboBox.getSelectedIndex()).isVIP()
                );
            }

            if (comboBox.getName() == "carInfoCB") {
                carDetailInfo.setText(carShop.getCarInfoByVIN(String.valueOf(comboBox.getSelectedItem())));
            }
        }

        if (e.getSource() instanceof JButton) {
            JButton button = (JButton) e.getSource();
            if (button.getName() == "sell") {
                if (carShop.getCwh().getAvailableCarsDB().size() != 0) {
                    sellButton.setEnabled(true);
                    carShop.bayCar(carShop.getCwh().getAvailableCarsDB().get(carsListComboBox.getSelectedIndex()).getVinCode(),
                            carShop.getCdb().getClientsDB().get(customerInfoComboBox.getSelectedIndex()).getFirstName(),
                            carShop.getCdb().getClientsDB().get(customerInfoComboBox.getSelectedIndex()).getLastName(),
                            "07.01.16");

                    if (carsListComboBox.getSelectedItem() != null && carShop.getCwh().getAvailableCarsDB().size() >= 1) {
                        carsListComboBox.removeItemAt(carsListComboBox.getSelectedIndex());
                    } else {
                        carsListComboBox.removeAllItems();
                        carsListComboBox.addItem("All cars already sold!");
                    }

                    carDetailInfo.setText(carShop.getCarInfoByVIN(String.valueOf(carsListComboBox.getSelectedItem())));

                    System.out.println("================");
                    carShop.showAllOperations();
                    carShop.showWarehouse();

                    guiTransactionsInfo.repaint();

                } else {
                    sellButton.setEnabled(false);
                    carsListComboBox.removeAll();
                    carDetailInfo.setText("There is no cars in warehouse!");
                }
            }
        }

        if (e.getSource() instanceof JMenuItem) {
            JMenuItem menuItem = (JMenuItem) e.getSource();
            if (menuItem.getName() == "show_transact") {
                guiTransactionsInfo.setVisible(true);
            }
        }
    }
}

