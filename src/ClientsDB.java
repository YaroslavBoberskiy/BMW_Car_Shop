import java.util.ArrayList;

/**
 * Created by YB on 02.11.2015.
 */
public class ClientsDB {

    // TilteBeforeClientName personTitle, String firstName, String lastName, String birthDate, String telNumber,
    // String eMail, boolean isVIP

    private ArrayList<Client> clientsDB = new ArrayList<Client>();

    // Test data

    private Client c0 = new Client(TilteBeforeClientName.Dr, "John", "Walker", "23.11.1967", "077-66-22-33", "jw@mail.com", "male", true);
    private Client c1 = new Client(TilteBeforeClientName.Mr, "Bob", "Ashley", "11.09.1986", "077-99-00-11", "jba@mail.com", "male", false);
    private Client c2 = new Client(TilteBeforeClientName.Ms, "Niki", "Brens", "09.04.1972", "088-11-77-33", "nb@mail.com", "female", false);
    private Client c3 = new Client(TilteBeforeClientName.Sen, "Albert", "Tap", "07.07.1977", "077-77-77-33", "at@mailx.com", "male", true);
    private Client c4 = new Client(TilteBeforeClientName.Dr, "Elizabeth", "Koh", "23.11.1957", "077-99-00-31", "eh@mailx.com", "female", true);

    public void fillDbWithTestClients() {
        clientsDB.add(c0);
        clientsDB.add(c1);
        clientsDB.add(c2);
        clientsDB.add(c3);
        clientsDB.add(c4);
    }

    public void addNewClientToDB(Client c) {
        if (c instanceof Client) {
            clientsDB.add(c);
        }
    }

    public void showClients() {
        for (Client c : clientsDB) {
            System.out.println(c.getPersonTitle() + " " + c.getFirstName() + " " + c.getLastName());
        }
    }

    public ArrayList<Client> getClientsDB() {
        return clientsDB;
    }

    public String[] getClientsDBbyNames() {
        String[] clientsByNames = new String[clientsDB.size()];
        for (int i = 0; i < clientsByNames.length; i++) {
            clientsByNames[i] = clientsDB.get(i).getPersonTitle() + " " + clientsDB.get(i).getFirstName() + " " + clientsDB.get(i).getLastName();
        }
        return clientsByNames;
    }

}
