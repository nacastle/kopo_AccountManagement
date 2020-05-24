package Account.AccountUI;

public class WrongInput {
    public void wrongInput() {
        System.out.println("잘못된 입력입니다.");
        new ExitUI().exitUI();
    }
}
