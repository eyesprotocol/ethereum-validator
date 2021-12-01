/*
 * Copyright (c) 2021 EYES Protocol
 * SPDX-Short-Identifier: LGPL-3.0-or-later
 */

package io.eyesprotocol.validator.ethereum;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @since 2021-12-01
 */
public class EtherTxHashValidator implements ConstraintValidator<EtherTxHash, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value.matches("^0x([A-Fa-f0-9]{64})$");
    }
}