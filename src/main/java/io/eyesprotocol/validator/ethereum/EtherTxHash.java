/*
 * Copyright (c) 2021 EYES Protocol
 * SPDX-Short-Identifier: LGPL-3.0-or-later
 */

package io.eyesprotocol.validator.ethereum;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Annotation to validate the Ethereum transaction hash format <br>
 * <b>NOTE</b>: null elements are considered valid.
 *
 * @since 0.1.0
 */
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EtherTxHashValidator.class)
public @interface EtherTxHash {
    String message() default "{io.eyesprotocol.validator.ethereum.EtherTxHash.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
