package Entity;

import javax.persistence.*;

@Entity
@Table(name = "registrationdetails", schema = "db_furniture", catalog = "")
public class register {
    @Id
    @Column(name="at000", nullable = false)
    private int at000;
    @Column(name="at0011", nullable = false)
    private String at0011;
    @Column(name="at0012", nullable = false)
    private String at0012;
    @Column(name="at003", nullable = false)
    private String at003;
    @Column(name="at002", nullable = false)
    private String at002;
    @Column(name="at0021", nullable = false)
    private String at0021;
    @Column(name="at046", nullable = false)
    private String at046;

    public int getAt000() {
        return at000;
    }

    public void setAt000(int at000) {
        this.at000 = at000;
    }

    public String getAt0011() {
        return at0011;
    }

    public void setAt0011(String at0011) {
        this.at0011 = at0011;
    }

    public String getAt0012() {
        return at0012;
    }

    public void setAt0012(String at0012) {
        this.at0012 = at0012;
    }

    public String getAt003() {
        return at003;
    }

    public void setAt003(String at003) {
        this.at003 = at003;
    }

    public String getAt002() {
        return at002;
    }

    public void setAt002(String at002) {
        this.at002 = at002;
    }

    public String getAt0021() {
        return at0021;
    }

    public void setAt0021(String at0021) {
        this.at0021 = at0021;
    }

    public String getAt046() {
        return at046;
    }

    public void setAt046(String at046) {
        this.at046 = at046;
    }
}

