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
public class ParamenterValidator {
    private  Map<String, String> errors;

    public ParamenterValidator() {
        this.errors = new HashMap<>();
    }

    public Map<String, String> getErrors() {
        return errors;
    }
    
    public void setError(String errorName, String errorDescription) {
        errors.put(errorName, errorDescription);
    }
    
    public void checkLength(String param, int min, int max, String errorName, String errorDescription) {
        int length = param.trim().length();
        if (length < min || length > max) {
            errors.put(errorName, errorDescription);
        }
    }
    
    public float checkFloat(String param, String errorName, String errorDescription) {
        try {
            float x = Float.parseFloat(param);
            return x;
        } catch (NumberFormatException e) {
            errors.put(errorName, errorDescription);
        }
        return 0;
    }
    
    public int checkInt(String param, String errorName, String errorDescription) {
        try {
            int x = Integer.parseInt(param);
            return x;
        } catch (NumberFormatException e) {
            errors.put(errorName, errorDescription);
        }
        return 0;
    }
}
