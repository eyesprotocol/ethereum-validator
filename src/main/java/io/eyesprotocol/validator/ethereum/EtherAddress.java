/*
 * Copyright (c) 2021-2022 EYES Protocol
 * SPDX-Short-Identifier: LGPL-3.0-or-later
 */
package io.eyesprotocol.validator.ethereum;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Annotation to validate the Ethereum address format <br>
 * By default, null is considered a valid value. You can use <code>@EtherAddress(nullable = false)</code> to consider it invalid.
 *
 * @see io.eyesprotocol.validator.ethereum.EtherAddressValidator
 * @since 0.1.0
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

    /**
     * Whether to evaluate null as a valid value (Default: true)
     *
     * @return true is nullable, false is not null
     * @since 1.0.0
     */
    boolean nullable() default true;
}
