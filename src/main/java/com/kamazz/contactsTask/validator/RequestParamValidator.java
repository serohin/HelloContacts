package com.kamazz.contactsTask.validator;


import java.util.Map;

public interface RequestParamValidator extends Validator<String> {
    @Override
    Map<String, String> validate(String requestParam);
}
