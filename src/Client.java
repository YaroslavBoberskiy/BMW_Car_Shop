/**
 * Created by YB on 02.11.2015.
 */
public class Client {

    private String firstName;
    private String lastName;
    private TilteBeforeClientName personTitle;
    private String birthDate;
    private String telNumber;
    private String eMail;
    private String gender;
    private boolean isVIP;

    Client() {
        firstName = "-";
        lastName = "-";
        personTitle = TilteBeforeClientName.UNKNOWN;
        birthDate = "-";
        telNumber = "-";
        eMail = "-";
        gender = "-";
        isVIP = false;
    }

    Client(TilteBeforeClientName personTitle, String firstName, String lastName, String birthDate, String telNumber,
           String eMail, String gender, boolean isVIP) {

        this.personTitle = personTitle;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.telNumber = telNumber;
        this.eMail = eMail;
        this.gender = gender;
        this.isVIP = isVIP;

    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public TilteBeforeClientName getPersonTitle() {
        return personTitle;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public String geteMail() {
        return eMail;
    }

    public boolean isVIP() {
        return isVIP;
    }
}
