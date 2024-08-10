public class LoginService {


    public void check(String login, String password, String confirmPassword) {
        checkLogin(login);
        checkPassword(password,confirmPassword);
    }
    private void checkPassword(String password, String confirmPassword) {

        if (password.length() > 20) {
            throw new WrongPasswordException("Пароль не может быть длиннее 20 символов");
        }
        if (isStringError(password)) {
           throw new WrongPasswordException("Пароль должен содержать цифры или латинские" +
                   " буквы или символ нижнего подчеркивания. Другие символы не допускаются!");
        }

        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Пароли не совпадают");
        }
    }

    private void checkLogin(String login) {
        if (login.length() > 20) {
            throw new WrongPasswordException("Логин не может быть длиннее 20 символов");
        }
        if (isStringError(login)) {
            throw new WrongLoginException("Логин должен содержать цифры или латинские" +
                    " буквы или символ нижнего подчеркивания. Другие символы не допускаются!");
        }
    }



    private boolean isStringError(String string) {

        String validatorTemplate = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890_";
        for (int i = 0; i < string.length(); i++) {
            final char charVerify = string.charAt(i);
            boolean isCharFound = false;
            for (int j = 0; j < validatorTemplate.length(); j++) {
                 if (charVerify == validatorTemplate.charAt(j)) {
                     isCharFound = true;
                     break;
                 }
            }
            if (!isCharFound) {
                return true;
            }
        }
        return false;
    }
}
