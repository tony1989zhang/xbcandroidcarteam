package www.lvchehui.com.carteam.evebus;

/**
 * Created by 张灿能 on 2016/8/9.
 * 作用：对公转账
 */
public class BankAccEvent {
    private String bankName;
    private String bankArea;
    private String bankType;
    private String bankAcc;

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankArea() {
        return bankArea;
    }

    public void setBankArea(String bankArea) {
        this.bankArea = bankArea;
    }

    public String getBankType() {
        return bankType;
    }

    public void setBankType(String bankType) {
        this.bankType = bankType;
    }

    public String getBankAcc() {
        return bankAcc;
    }

    public void setBankAcc(String bankAcc) {
        this.bankAcc = bankAcc;
    }
}
