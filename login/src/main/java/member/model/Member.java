package member.model;

public class Member {
    private String id;
    private String name;
    private String pwd;

    public Member(String id, String name, String pwd) {
        this.id = id;
        this.name = name;
        this.pwd = pwd;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public boolean matchPassword(String password) {
        return pwd.equals(password);
    }

    public void changePassword(String newPwd) {
        this.pwd = newPwd;
    }
}
