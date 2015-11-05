/**
 * Created by YB on 02.11.2015.
 */
public class ClientsDB {

    // TilteBeforeClientName personTitle, String firstName, String lastName, String birthDate, String telNumber,
    // String eMail, boolean isVIP

    private Client clientsDB[] = new Client[30];

    // Test data

    private Client c0 = new Client(TilteBeforeClientName.Dr, "John", "Walker", "23.11.1967", "077-66-22-33", "jw@mail.com", "male", true);
    private Client c1 = new Client(TilteBeforeClientName.Mr, "Bob", "Ashley", "11.09.1986", "077-99-00-11", "jba@mail.com", "male", false);
    private Client c2 = new Client(TilteBeforeClientName.Ms, "Niki", "Brens", "09.04.1972", "088-11-77-33", "nb@mail.com", "female", false);
    private Client c3 = new Client(TilteBeforeClientName.Sen, "Albert", "Tap", "07.07.1977", "077-77-77-33", "at@mailx.com", "male", true);
    private Client c4 = new Client(TilteBeforeClientName.Dr, "Elizabeth", "Koh", "23.11.1957", "077-99-00-31", "eh@mailx.com", "female", true);

    public void fillDbWithTestClients() {
        clientsDB[0] = c0;
        clientsDB[1] = c1;
        clientsDB[2] = c2;
        clientsDB[3] = c3;
        clientsDB[4] = c4;
    }

    public void addNewClientToDB(Client c) {

        for (int i = 0; i < clientsDB.length; i++) {
            if (clientsDB[i] == null) {
                clientsDB[i] = c;
                break;
            }
        }
    }

    public void showClients() {
        for (int i = 0; i < clientsDB.length; i++) {
            if (clientsDB[i] != null) {
                System.out.println(clientsDB[i].getFirstName() + " " + clientsDB[i].getLastName());
            }
        }
    }

    public Client[] getClientsDB() {
        return clientsDB;
    }

}
