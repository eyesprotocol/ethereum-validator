/*
 * Copyright (c) 2021 EYES Protocol
 * SPDX-Short-Identifier: LGPL-3.0-or-later
 */
package io.eyesprotocol.validator.ethereum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Jonathan
 * @since 2021-11-30
 */
class EtherAddressValidatorTest {
    private static Validator validator;

    @BeforeAll
    static void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    @SuppressWarnings("SpellCheckingInspection")
    void isValid() {
        // valid
        valid("0xE37c0D48d68da5c5b14E5c1a9f1CFE802776D9FF");
        valid("0xa00354276d2fC74ee91e37D085d35748613f4748");
        valid("0xAff4d6793F584a473348EbA058deb8caad77a288");
        valid("0xc6d9d2cd449a754c494264e1809c50e34d64562b");
        valid("0x52908400098527886E0F7030069857D2E4169EE7");
        valid("0x8617E340B3D01FA5F11F306F4090FD50E238070D");
        valid("0xde709f2102306220921060314715629080e2fb77");
        valid("0x27b1fdb04752bbc536007a920d24acb045561c26");
        valid("0x5aAeb6053F3E94C9b9A09f33669435E7Ef1BeAed");
        valid("0xfB6916095ca1df60bB79Ce92cE3Ea74c37c5d359");
        valid("0xdbF03B407c01E7cD3CBea99509d93f8DDDC8C6FB");
        valid("0xD1220A0cf47c7B9Be7A2E6BA89F429762e7b9aDb");
    }

    @Test
    void isInvalid() {
        // invalid
        invalid("6xAff4d6793F584a473348EbA058deb8caad77a288");
        invalid("0x02fcd51aAbB814FfFe17908fbc888A8975D839A5");
        invalid("0XD1220A0CF47C7B9BE7A2E6BA89F429762E7B9ADB");
        invalid("aFf4d6793f584a473348ebA058deb8caad77a2885");
        invalid("0xff4d6793F584a473");
    }

    private void valid(String address) {
        Set<ConstraintViolation<Constraint>> violations = validator.validate(new Constraint(address));
        Assertions.assertEquals(0, violations.size(), address);
    }

    private void invalid(String address) {
        Set<ConstraintViolation<Constraint>> violations = validator.validate(new Constraint(address));
        assertTrue(violations.size() > 0);
    }

    static class Constraint {
        @EtherAddress
        String address;

        public Constraint(String address) {
            this.address = address;
        }
    }
}
