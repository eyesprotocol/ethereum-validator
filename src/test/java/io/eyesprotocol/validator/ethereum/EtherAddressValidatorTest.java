/*
 * Copyright (c) 2021 EYES Protocol
 * SPDX-Short-Identifier: LGPL-3.0-or-later
 */
package io.eyesprotocol.validator.ethereum;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author Jonathan
 * @since 0.1.0
 */
@SuppressWarnings("SpellCheckingInspection")
class EtherAddressValidatorTest {

    @Test
    @DisplayName("Valid ethereum addresses")
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
        valid(null);
    }

    @Test
    @DisplayName("Invalid ethereum addresses")
    void isInvalid() {
        // invalid
        invalid("6xAff4d6793F584a473348EbA058deb8caad77a288");
        invalid("0x02fcd51aAbB814FfFe17908fbc888A8975D839A5");
        invalid("0XD1220A0CF47C7B9BE7A2E6BA89F429762E7B9ADB");
        invalid("aFf4d6793f584a473348ebA058deb8caad77a2885");
        invalid("0xff4d6793F584a473");
        invalid("");

        EtherValidatorTestUtils.invalid(new ConstraintNotNull(null));
    }

    @Test
    @DisplayName("Localization format test")
    void localizationTest() {
        EtherValidatorTestUtils.localizationTest("Invalid Ethereum address format", new Constraint(""));
    }

    private void valid(String address) {
        EtherValidatorTestUtils.valid(new Constraint(address));
    }
    private void invalid(String address) {
        EtherValidatorTestUtils.invalid(new Constraint(address));
    }

    class Constraint {
        @EtherAddress
        String address;

        public Constraint(String address) {
            this.address = address;
        }
    }

    class ConstraintNotNull {
        @EtherAddress(nullable = false)
        String address;

        public ConstraintNotNull(String address) {
            this.address = address;
        }
    }
}
