package member.service;

import java.util.Map;

public class JoinRequest {
    private String id;
    private String name;
    private String pwd;
    private String confirmPwd;

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

    public String getConfirmPwd() {
        return confirmPwd;
    }

    public void setConfirmPwd(String confirmPwd) {
        this.confirmPwd = confirmPwd;
    }

    public boolean isPasswordEqualToConfirm() {
        return pwd != null && pwd.equals(confirmPwd);
    }

    public void validate(Map<String, Boolean> errors) {
        checkEmpty(errors, id, "id");
        checkEmpty(errors, name, "name");
        checkEmpty(errors, pwd, "pwd");
        checkEmpty(errors, confirmPwd, "confirmPwd");
        if (!isPasswordEqualToConfirm()){
            errors.put("notMatch", Boolean.TRUE);
        }
    }

    private void checkEmpty(Map<String,Boolean> errors,
            String value, String fieldName) {
        if(value == null || value.isEmpty())
            errors.put(fieldName, Boolean.TRUE);
    }
}
