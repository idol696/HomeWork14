public class Main {
    public static void main(String[] args) {

        LoginService loginService = new LoginService();
        String login = "Iam_Deer2";
        String password = "BlaBlaDer100";
        String confirmPassword = "BlaBlaDer100";
        try {
            loginService.check(login, password, confirmPassword);
        } catch (WrongLoginException e) {
            System.out.println("Ошибка логина: " + e.getMessage());
        } catch (WrongPasswordException e) {
            System.out.println("Ошибка пароля: " + e.getMessage());
        } finally {
            System.out.println("Обработка данных завершена");
        }
    }
}
