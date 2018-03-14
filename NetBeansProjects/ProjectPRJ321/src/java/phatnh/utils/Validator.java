/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phatnh.utils;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author nguyenhongphat0
 */
public class Validator {
    private Map<String, String> errors;

    public Validator() {
        errors = new HashMap<>();
    }

    public Map<String, String> getErrors() {
        return errors;
    }
    
    public Validator checkLength(String value, int min, int max, String errorName, String errorDescription) {
        int length = value.trim().length();
        if (length < min || length > max) {
            errors.put(errorName, errorDescription);
        }
        return this;
    }
    
    public Validator checkFormat(String value, String regex, String errorName, String errorDescription) {
        if (!value.matches(regex)) {
            errors.put(errorName, errorDescription);
        }
        return this;
    }
    
    public Validator checkConfirm(String value, String confirm, String errorName, String errorDescription) {
        if (!value.equals(confirm)) {
            errors.put(errorName, errorDescription);
        }
        return this;
    }
    
    public Validator setError(String errorName, String errorDescription) {
        errors.put(errorName, errorDescription);
        return this;
    }
    
    public boolean isValid() {
        return this.errors.isEmpty();
    }
}
