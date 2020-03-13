package core;

public class User {

    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String major;
    private String username;
    private String password;
    private int questionID;
    private String question;
    //private BigDecimal salary;

    public User(String firstName, String lastName, String email,
            String major, String username, String password, int questionID, String question) {

        this(0, firstName, lastName, email, major, username, password, questionID, question);
    }

    public User(int id, String firstName, String lastName, String email,
            String major, String username, String password, int questionID, String question) {
        //super();
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.major = major;
        this.username = username;
        this.password = password;
        this.questionID = questionID;
        this.question = question;
    }

    public int getID() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getMajor() {
        return major;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    public int getQuestionID() {
        return questionID;
    }
    public String getQuestion() {
        return question;
    }
    @Override
    public String toString() {
        return String
                .format("User [id=%s, firstName=%s, lastName=%s, email=%s, major=%s, username=%s, password=%s]",
                        id, firstName, lastName, email, major, username, password);
    }
}
