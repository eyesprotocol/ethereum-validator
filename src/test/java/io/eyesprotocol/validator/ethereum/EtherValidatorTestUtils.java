/*
 * Copyright (c) 2021-2022 EYES Protocol
 * SPDX-Short-Identifier: LGPL-3.0-or-later
 */

package io.eyesprotocol.validator.ethereum;

import org.junit.jupiter.api.Assertions;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @since 0.1.0
 */
public class EtherValidatorTestUtils {
    public static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    public static <T> void valid(T obj) {
        Set<ConstraintViolation<T>> violations = validator.validate(obj);
        Assertions.assertEquals(0, violations.size(), obj.toString());
    }

    public static <T> void invalid(T obj) {
        Set<ConstraintViolation<T>> violations = validator.validate(obj);
        assertTrue(violations.size() > 0);
    }

    public static <T> void localizationTest(String expect, T obj) {
        String message = validator
                .validate(obj)
                .stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.joining());

        assertEquals(expect, message);
    }
}
