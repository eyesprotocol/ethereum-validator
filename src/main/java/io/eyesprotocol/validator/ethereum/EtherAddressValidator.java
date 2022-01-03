/*
 * Copyright (c) 2021 EYES Protocol
 * SPDX-Short-Identifier: LGPL-3.0-or-later
 */
package io.eyesprotocol.validator.ethereum;

import org.bouncycastle.jcajce.provider.digest.Keccak;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

/**
 * Check that string the character valid Ethereum address. <br>
 * <b>NOTE</b>: This source is implemented by referring to the web3.js isAddress function.
 *
 * @see <a href="https://github.com/ChainSafe/web3.js/blob/2279a67e0702343764db5cae2dffc04048083952/packages/web3-utils/src/utils.js#L85">Reference source code</a>
 * @since 2021-11-30
 */
public class EtherAddressValidator implements ConstraintValidator<EtherAddress, String> {
    Keccak.Digest256 digester = new Keccak.Digest256();

    @Override
    public boolean isValid(String address, ConstraintValidatorContext context) {

        // nullable
        if (address == null) {
            return true;
        }

        /// check basic requirements
        if (!address.matches("^0x[0-9a-fA-F]{40}$")) {
            return false;
        }

        // all lowercase or uppercase
        if (address.matches("^0x[0-9a-f]{40}$") || address.matches("^0x[0-9A-F]{40}$")) {
            return true;
        }

        // checksum verify
        String noPaddingAddress = address.replaceFirst("^0x", "");
        String hash = keccak256(noPaddingAddress.toLowerCase(Locale.ROOT).getBytes(StandardCharsets.UTF_8));

        for (int i = 0; i < 40; i++) {
            String letter = String.valueOf(hash.charAt(i));
            int letterHex = Integer.parseInt(letter, 16);

            String addressLetter = String.valueOf(noPaddingAddress.charAt(i));

            if (
                    (letterHex > 7 && !addressLetter.toUpperCase(Locale.ROOT).equals(addressLetter)) ||
                    (letterHex <= 7 && !addressLetter.toLowerCase(Locale.ROOT).equals(addressLetter))
            ) {
                return false;
            }
        }

        return true;
    }

    private String keccak256(byte[] input) {
        digester.reset();
        digester.update(input, 0, input.length);

        return toHexString(digester.digest());
    }

    private String toHexString(byte[] bytes) {
        StringBuilder sb = new StringBuilder();

        for (byte b : bytes) {
            String hex = Integer.toHexString(0xFF & b);

            if (hex.length() == 1) {
                sb.append('0');
            }

            sb.append(hex);
        }

        return sb.toString();
    }
}
