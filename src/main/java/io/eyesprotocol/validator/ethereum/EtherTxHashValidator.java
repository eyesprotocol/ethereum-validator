/*
 * Copyright (c) 2021-2022 EYES Protocol
 * SPDX-Short-Identifier: LGPL-3.0-or-later
 */

package io.eyesprotocol.validator.ethereum;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Check that string the character valid Ethereum transaction hash.
 *
 * @since 0.1.0
 */
public class EtherTxHashValidator implements ConstraintValidator<EtherTxHash, String> {

    /**
     * @since 1.0.0
     */
    private boolean nullable;

    @Override
    public void initialize(EtherTxHash annotation) {
        this.nullable = annotation.nullable();
    }


    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return nullable;
        }

        return value.matches("^0x([A-Fa-f0-9]{64})$");
    }
}
