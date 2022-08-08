package pojo;

public class Data {
    private Integer id;
    private String name;
    private String gender;
    private String email;

    private String status;

    public Data() {
    }

    ;

    public Data(String name, String gender, String email) {
        this.name = name;
        this.gender = gender;
        this.email = email;
    }

    public Data(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public Data(String status) {
        this.status = status;

    }

    public Data(String name, String gender, String email, String status) {
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "dataPojo [id=" + id + ", name=" + name + ", email=" + email + ", gender=" + gender + ", status=" + status
                + "]";
    }
}
