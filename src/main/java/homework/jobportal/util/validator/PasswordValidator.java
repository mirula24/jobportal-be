package homework.jobportal.util.validator;


import java.util.regex.Pattern;

public class PasswordValidator {
    public static boolean passwordValidator(String password){
        String regex = ".*[a-zA-Z0-9].*";
        Pattern pattern = Pattern.compile(regex);
        boolean validate = pattern.matcher(password).matches();
        return validate;
    }
}
