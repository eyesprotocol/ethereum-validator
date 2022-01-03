/*
 * Copyright (c) 2021 EYES Protocol
 * SPDX-Short-Identifier: LGPL-3.0-or-later
 */

package io.eyesprotocol.validator.ethereum;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Check that string the character valid Ethereum transaction hash.
 *
 * @since 2021-12-01
 */
public class EtherTxHashValidator implements ConstraintValidator<EtherTxHash, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }

        return value.matches("^0x([A-Fa-f0-9]{64})$");
    }
}
