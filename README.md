# Ethereum validator with JSR380(aka Bean validation)

## Features
 - `@EtherAddress`: Ethereum address validator
   - Original: [web3.js][LINK_SOURCE]
 - `@EtherTxHash`: Ethereum transaction hash (aka TX ID) validator

## Requirements
 - JDK 1.8 or higher

## Usages

**gradle:**
```groovy
repositories {
    mavenCentral()
}

dependencies {
    implementation("io.eyesprotocol.validator:ethereum-validator:1.0.0")
}
```

## License and credit
This project under the [GNU Lesser General Public License v3.0](./LICENSE)
 - [ChainSafe/web3.js][LINK_WEB3] (LGPL-3.0)

[LINK_WEB3]: https://github.com/ChainSafe/web3.js
[LINK_SOURCE]: https://github.com/ChainSafe/web3.js/blob/2279a67e0702343764db5cae2dffc04048083952/packages/web3-utils/src/utils.js#L85
