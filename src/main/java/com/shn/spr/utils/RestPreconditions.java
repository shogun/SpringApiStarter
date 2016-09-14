package com.shn.spr.utils;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.converter.HttpMessageNotWritableException;

public class RestPreconditions {

    public static <T> T checkFound(final T resource) {
        if (resource == null) {
            throw new ResourceNotFoundException();
        }
        return resource;
    }

    public static boolean checkId(Long id, Long entityId) {
        if (id.equals(entityId)) {
            return true;
        }

        throw new HttpMessageNotWritableException("Id can not be changed!");
    }
}
