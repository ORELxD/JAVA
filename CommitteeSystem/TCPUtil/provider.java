package TCPUtil;

import java.io.Serializable;

public class provider implements Serializable {

    /*vars*/
    private String name;
    private String usrname;
    private String type;
    private String phone;

    public provider(String name, String usrname, String type, String phone) {
        this.name = name;
        this.usrname = usrname;
        this.type = type;
        this.phone = phone;
    }

    /*getters*/
    public String getName() {
        return name;
    }

    public String getUsrname() {
        return usrname;
    }

    public String getType() {
        return type;
    }

    public String getPhone() {
        return phone;
    }
}
