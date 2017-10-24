package com.kamazz.contactsTask.validator;


import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

@Component
public class RequestParamValidatorImpl implements RequestParamValidator {
    @Override
    public Map<String, String> validate(String requestParam) {
        Map<String, String> errorMap = new HashMap<>();
        paramValidate(requestParam, errorMap);
        paramRegexSyntaxValidate(requestParam, errorMap);
        return errorMap;
    }

    private void paramRegexSyntaxValidate(String requestParam, Map<String, String> errorMap) {
        try {
            Pattern.compile(requestParam);
        } catch (PatternSyntaxException ex) {
            errorMap.put("requestParam", "The string is not a regular expression.");
        }

    }

    private void paramValidate(String requestParam, Map<String, String> errorMap) {
        if (requestParam.isEmpty()) {
            errorMap.put("requestParam", "Query String is empty.");
        } else if (requestParam.length() == 0) {
            errorMap.put("requestParam", "The length of the query string can not be 0. ");
        }
    }
}
