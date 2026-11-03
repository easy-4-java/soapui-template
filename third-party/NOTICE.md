# Third-party materials used by the SoapUI tests

This notice applies only to the paths listed below. The project's root
`LICENSE` continues to describe the project's own code.

## SmartBear SoapUI test fixtures

The files in `src/test/resources/wsdls/` and
`src/test/resources/soapui-projects/` were copied from SmartBear's SoapUI
repository at commit `452bc1778ca85310549beb43c2ad4670cc89d7ae`.
Their source paths are recorded in the adjacent `UPSTREAM.txt` files.
SoapUI's copyright and EUPL 1.1 license notice are reproduced in
[`soapui-EUPL-1.1-LICENSE.md`](soapui-EUPL-1.1-LICENSE.md). The pinned upstream
source is <https://github.com/SmartBear/soapui/blob/452bc1778ca85310549beb43c2ad4670cc89d7ae/LICENSE.md>.

The three files in `src/test/resources/wadl/` came from the same SoapUI
commit, but each carries its own Common Development and Distribution License
notice. Those file notices remain intact. The CDDL 1.0 text is included in
[`CDDL-1.0-LICENSE.txt`](CDDL-1.0-LICENSE.txt). Their source path is in
`src/test/resources/wadl/UPSTREAM.txt`.

These fixtures are test resources. Their inclusion does not change the
license of the project's independently written source files.

## Proxy Vole runtime JAR

`SoapUI Jar/com/liferay/com.btr.proxy.vole/20131209/com.btr.proxy.vole-20131209.jar`
is the original Proxy Vole 20131209 binary, mirrored by Liferay, SHA-256
`00633dd826be1eb99da02ac0697cbe71b3dd4b68b3ca15347172ca08407bcb17`.
Its download URL is recorded in the adjacent `UPSTREAM.txt` file.

The JAR contains only a manifest under `META-INF/`; it does not bundle a
license or notice file. The [original project archive](https://code.google.com/archive/p/proxy-vole)
labels Proxy Vole as "New BSD License". The original author's copyright and
BSD notice, preserved by an [upstream fork at a pinned commit](https://github.com/brsanthu/proxy-vole/blob/725a8c7f906e23676a574fcc334f60f7fa3433e1/LICENSE.txt),
are included in [`proxy-vole-BSD-LICENSE.txt`](proxy-vole-BSD-LICENSE.txt)
alongside the vendored binary. This attribution is for the original 2013
artifact; the later fork's Apache-licensed changes are not asserted to be
part of this JAR.
