package user;

/**
 *
 * @author genel
 */
public class User {

    private String un;
    private String pw;
    
    //getters and setters to return the value so we can check users credentials

    public User(String un, String pw) {
        this.un = un;
        this.pw = pw;
    }

    public String getUn() {
        return un;
    }

    public String getPw() {
        return pw;
    }
}
