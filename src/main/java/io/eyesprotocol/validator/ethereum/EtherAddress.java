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
 * Ethereum address validate annotation
 *
 * @see io.eyesprotocol.validator.ethereum.EtherAddressValidator
 * @since 2021-11-30
 */
@SuppressWarnings("unused")
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EtherAddressValidator.class)
public @interface EtherAddress {
    String message() default "{io.eyesprotocol.validator.ethereum.EtherWalletAddress.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
