package Account.VO;

public class AccountVO {
    private String id;
    private String nickname;
    private int accountNumber;
    private String bank;
    private String accountOwner;
    private long balance;

    public AccountVO() {
    }

    public AccountVO(String id, String nickname, int accountNumber, String bank, String accountOwner, long balance) {
        this.id = id;
        this.nickname = nickname;
        this.accountNumber = accountNumber;
        this.bank = bank;
        this.accountOwner = accountOwner;
        this.balance = balance;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getAccountOwner() {
        return accountOwner;
    }

    public void setAccountOwner(String accountOwner) {
        this.accountOwner = accountOwner;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }
}
