/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package users;

/**
 *
 * @author nguyenhongphat0
 */
public class RegistrationInsertError {
    private String usernameLengthError;
    private String passwordLengthError;
    private String fullnameLengthError;
    private String confirmPasswordNotMatch;
    private String usernameIsExisted;

    public RegistrationInsertError() {
    }

    public RegistrationInsertError(String usernameLengthError, String passwordLengthError, String fullnameLengthError, String confirmPasswordNotMatch, String usernameIsExisted) {
        this.usernameLengthError = usernameLengthError;
        this.passwordLengthError = passwordLengthError;
        this.fullnameLengthError = fullnameLengthError;
        this.confirmPasswordNotMatch = confirmPasswordNotMatch;
        this.usernameIsExisted = usernameIsExisted;
    }

    public String getUsernameLengthError() {
        return usernameLengthError;
    }

    public void setUsernameLengthError(String usernameLengthError) {
        this.usernameLengthError = usernameLengthError;
    }

    public String getPasswordLengthError() {
        return passwordLengthError;
    }

    public void setPasswordLengthError(String passwordLengthError) {
        this.passwordLengthError = passwordLengthError;
    }

    public String getFullnameLengthError() {
        return fullnameLengthError;
    }

    public void setFullnameLengthError(String fullnameLengthError) {
        this.fullnameLengthError = fullnameLengthError;
    }

    public String getConfirmPasswordNotMatch() {
        return confirmPasswordNotMatch;
    }

    public void setConfirmPasswordNotMatch(String confirmPasswordNotMatch) {
        this.confirmPasswordNotMatch = confirmPasswordNotMatch;
    }

    public String getUsernameIsExisted() {
        return usernameIsExisted;
    }

    public void setUsernameIsExisted(String usernameIsExisted) {
        this.usernameIsExisted = usernameIsExisted;
    }
}
