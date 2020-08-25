public class Student {
    private String fNmae;
    private String lName;
    private  String id;

    public Student(String fNmae, String lName, String id) {
        this.fNmae = fNmae;
        this.lName = lName;
        this.id = id;
    }

    public Student() {

    }

    public String getfNmae() {
        return fNmae;
    }

    public void setfNmae(String fNmae) {
        this.fNmae = fNmae;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student First Name : " + this.fNmae;
    }
}
