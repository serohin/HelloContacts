package com.kamazz.contactsTask.validator;

import java.util.Map;


    public interface Validator<T> {

        Map<String, String> validate(T entity);
    }

