/*
 * Copyright (c) 2021 EYES Protocol
 * SPDX-Short-Identifier: LGPL-3.0-or-later
 */

package io.eyesprotocol.validator.ethereum;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.eyesprotocol.validator.ethereum.EtherValidatorTestUtils.invalid;
import static io.eyesprotocol.validator.ethereum.EtherValidatorTestUtils.valid;

/**
 * @since 2021-12-01
 */
@SuppressWarnings("SpellCheckingInspection")
class EtherTxHashValidatorTest {

    @Test
    @DisplayName("Validate ethereum txhash")
    void isValid() {
        valid(new Constraint("0x582c0cf18f49fcc7c4d4812411441d258cfcc3c55241a6467613127d049f17e0"));
        valid(new Constraint("0x83d244f753659b31cdeddd330714b22c0a5b59e55990d7b0bb90781238c8b25a"));
        valid(new Constraint("0xb5c8bd9430b6cc87a0e2fe110ece6bf527fa4f170a4bc8cd032f768fc5219838"));
    }

    @Test
    @DisplayName("Invalid ethereum txhash")
    void isInvalid() {
        invalid(new Constraint("0xa6c2285e15e439662daa586f6d5b163263775e9f"));
        invalid(new Constraint("0x0000000000000000000000000000000000000000"));
    }

    @Test
    @DisplayName("Localization format test")
    void localizationTest() {
        EtherValidatorTestUtils.localizationTest("Invalid Ethereum transaction hash format", new Constraint(""));
    }

    class Constraint {
        @EtherTxHash
        String txHash;

        public Constraint(String txHash) {
            this.txHash = txHash;
        }
    }
}
