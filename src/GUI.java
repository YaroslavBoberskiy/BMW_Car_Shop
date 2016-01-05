import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;

/**
 * Created by YB on 05.01.2016.
 */
public class GUI extends JFrame {
    private JPanel controlPanel;
    private JPanel carPanel;
    private JPanel customerPanel;
    private JPanel sellButtonPanel;
    private JPanel chooseCarPanel;
    private JPanel carInfoPanel;
    private JTextField carDetailInfo;
    private JComboBox customersTitle;
    private JComboBox customerFirstName;
    private JComboBox customerLastName;
    private JComboBox carsList;
    private JButton sell;

    GUI () {
        super("Bye new car");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocation(500, 100);
        setResizable(false);
        this.setLayout(new BorderLayout());

        controlPanel = new JPanel();
        customerPanel = new JPanel();
        sellButtonPanel = new JPanel();
        carPanel = new JPanel();
        carInfoPanel = new JPanel();
        chooseCarPanel = new JPanel();
        customersTitle = new JComboBox();
        customerFirstName = new JComboBox();
        customerLastName = new JComboBox();
        carsList = new JComboBox();
        carDetailInfo = new JFormattedTextField();
        sell = new JButton("SELL");
        sell.setName("sell");

        controlPanel.setPreferredSize(new Dimension(300, 200));
        controlPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED), "Choose the customer: "));

        carPanel.setPreferredSize(new Dimension(300, 200));
        carPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED), "Choose the car: "));

        customerPanel.setPreferredSize(new Dimension(250, 250));
        customerPanel.setLayout(new FlowLayout());
        customerPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        sellButtonPanel.setPreferredSize(new Dimension(250, 50));

        customersTitle.setPreferredSize(new Dimension(50, 30));
        customersTitle.setRenderer(new MyComboBoxRenderer("Title"));
        customerFirstName.setPreferredSize(new Dimension(90, 30));
        customerFirstName.setRenderer(new MyComboBoxRenderer("First Name"));
        customerLastName.setPreferredSize(new Dimension(90, 30));
        customerLastName.setRenderer(new MyComboBoxRenderer("Last Name"));

        carDetailInfo.setPreferredSize(new Dimension(250, 200));
        carDetailInfo.setBackground(new Color(255, 255, 255));

        carsList.setPreferredSize(new Dimension(250, 30));
        carsList.setRenderer(new MyComboBoxRenderer("Choose car from warehouse"));

        customerPanel.add(customersTitle);
        customerPanel.add(customerFirstName);
        customerPanel.add(customerLastName);
        sellButtonPanel.add(sell);

        chooseCarPanel.add(carsList);
        carInfoPanel.add(carDetailInfo);

        controlPanel.add(customerPanel, BorderLayout.CENTER);
        controlPanel.add(sellButtonPanel, BorderLayout.NORTH);

        carPanel.add(chooseCarPanel, BorderLayout.SOUTH);
        carPanel.add(carInfoPanel, BorderLayout.CENTER);

        add(controlPanel, BorderLayout.CENTER);
        add(carPanel, BorderLayout.EAST);

    }

    public void showGUI() {
        this.setVisible(true);
    }

}

class MyComboBoxRenderer extends JLabel implements ListCellRenderer
{
    private String _title;

    public MyComboBoxRenderer(String title)
    {
        _title = title;
    }

    @Override
    public Component getListCellRendererComponent(JList list, Object value,
                                                  int index, boolean isSelected, boolean hasFocus)
    {
        if (index == -1 && value == null) setText(_title);
        else setText(value.toString());
        return this;
    }
}
