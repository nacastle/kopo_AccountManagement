package User.UserVO;

public class UserVO {

    private String id;
    private String pwd;

    public UserVO() {
    }

    public UserVO(String id) {
        this.id = id;
    }

    public UserVO(String id, String pwd) {
        this.id = id;
        this.pwd = pwd;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
