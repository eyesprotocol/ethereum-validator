/*
 * Copyright (c) 2021 EYES Protocol
 * SPDX-Short-Identifier: LGPL-3.0-or-later
 */

package io.eyesprotocol.validator.ethereum;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @since 2021-12-01
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EtherTxHashValidator.class)
public @interface EtherTxHash {
    String message() default "{io.eyesprotocol.validator.ethereum.EtherTxHash.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
