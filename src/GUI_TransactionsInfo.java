import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * Created by YB on 14.01.2016.
 */
public class GUI_TransactionsInfo extends JFrame {
    private JTable transactionsInfoTable;
    private JScrollPane scrollPane;

    GUI_TransactionsInfo(Shop carShop) {
        super("All transactions info");
        setSize(500, 300);
        setLocation(700, 300);
        setResizable(false);
        this.setLayout(new BorderLayout());

        String columnNames[] = {"Transact. ID", "Date", "Client first name", "Client last name", "Car VIN code", "Car model", "Price"};

        transactionsInfoTable = new JTable(carShop.getJtableArr(), columnNames);

        // Add the table to a scrolling pane
        scrollPane = new JScrollPane(transactionsInfoTable);
        this.add( scrollPane, BorderLayout.CENTER );
    }
}
