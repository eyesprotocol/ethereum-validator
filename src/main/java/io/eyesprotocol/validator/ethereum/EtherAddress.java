/*
 * Copyright (c) 2021 EYES Protocol
 * SPDX-Short-Identifier: LGPL-3.0-or-later
 */
package io.eyesprotocol.validator.ethereum;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Annotation to validate the Ethereum address format <br>
 * <b>NOTE</b>: null elements are considered valid.
 *
 * @see io.eyesprotocol.validator.ethereum.EtherAddressValidator
 * @since 2021-11-30
 */
@Documented
@SuppressWarnings("unused")
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EtherAddressValidator.class)
public @interface EtherAddress {
    String message() default "{io.eyesprotocol.validator.ethereum.EtherWalletAddress.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
