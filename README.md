# soapui-template

![Java](https://img.shields.io/badge/Java-17-orange) ![License](https://img.shields.io/badge/License-Apache%202.0-blue)

[1. Project Overview](#1-project-overview) | [2. Features & Status](#2-features--status) | [3. Requirements & Compatibility](#3-requirements--compatibility) | [4. Architecture & Modules](#4-architecture--modules) | [5. Installation](#5-installation) | [6. Quick Start](#6-quick-start) | [7. Configuration](#7-configuration) | [8. Core Usage / API](#8-core-usage--api) | [9. Testing & Build](#9-testing--build) | [10. Versioning & Branches](#10-versioning--branches) | [11. Contributing & License](#11-contributing--license)

## 1. Project Overview

`soapui-template` ("Opt For SoapUI") is a thin, programmatic layer on top of the SoapUI engine. It lets a Java application load a WSDL, browse its operations, and invoke SOAP web service operations without starting the SoapUI GUI, while keeping the familiar SoapUI concepts (projects, WSDL interfaces, operations, settings, HTTP/S and WS-Security options).

It is a library for developers who want to drive SoapUI from code (tests, automation, service mocking workflows) — not a replacement for the SoapUI desktop tool and not a standalone HTTP client framework.

Typical scenarios:

| Scenario | What this module contributes |
|:---|:---|
| Browse a WSDL without the GUI | `SoapuiWsdlTemplate` (operations, interfaces, WSDL info) |
| Invoke a SOAP operation by name or index | `SoapuiWsdlRequestTemplate#invokeAt` / `invokeByName` |
| Capture response status / error details | `SoapuiResponse` (request, status, error, response) |
| Reuse SoapUI settings (HTTP, proxy, SSL, WS-Addressing, WSI) | `SoapuiSettings` hierarchy + `SoapuiProperties` |

## 2. Features & Status

Project status: pre-release development line (`1.0.x.*` snapshots); public API is still stabilizing until the first tagged release.

| Capability | Status | Notes |
|:---|:---|:---|
| WSDL loading and inspection | Stable | `SoapuiWsdlTemplate` loads a WSDL URL into a `WsdlProject` and exposes operations and interfaces |
| Operation lookup | Stable | `getOperationAt(url, index)`, `getOperationByName(url, name)`, `getOperationList(url)`, `getOperations(url)` |
| Request invocation | Stable | `SoapuiWsdlRequestTemplate` invokes by index (`invokeAt`) or by name (`invokeByName`) with `Map` or `String[]` parameters, sync or async |
| Result model | Stable | `SoapuiResponse<WsdlRequest>` exposes request, status, error and raw response |
| SoapUI settings model | Stable | `SoapuiSettingsImpl` covering HTTP, proxy, SSL, WSDL, WS-Addressing (WSA), WSI and project settings |
| Settings file loading | Stable | `SoapuiSettingsFileLoader` reads/writes a SoapUI settings XML file (default `soapui-settings.xml`) |
| Response handlers | Stable | `SoapResponseHandler` SPI with plain-text, XML and stream implementations |
| Request parameter handlers | Stable | Array and Map parameter handling (`SoapRequestArrayParamHandler`, `SoapRequestMapParamHandler`) |
| WSDL metadata models | Stable | `WsdlInfo`, `WsdlInterfaceInfo`, `WsdlOperationInfo` |

## 3. Requirements & Compatibility

| Requirement | Version |
|:---|:---|
| JDK | 17+ |
| Maven | 3.6+ |
| SoapUI engine | SoapUI (SmartBear) installed in the local Maven repository (see [5. Installation](#5-installation)) |
| XMLBeans | 2.6.0 (xmlbeans, xmlbeans-xpath, xmlbeans-xmlpublic) |
| Other runtime deps | commons-lang3, commons-io, commons-codec, httpclient/httpmime/httpcore, wss4j, guava, groovy, etc. (declared in the POM) |

Version lines:

| Branch | JDK | Version pattern | Notes |
|:---|:---|:---|:---|
| `feature/1.0.x` | 8 | `1.0.x.*` | Current line |
| `feature/2.0.x` | 17 | `2.0.x.*` | Next line |
| `feature/3.0.x` | 21 | `3.0.x.*` | Future line |

## 4. Architecture & Modules

```
WSDL URL
   |
   v
+------------------------------------+
| SoapuiWsdlTemplate (WsdlProject)   |
|  load WsdlInterface / WsdlOperation|
+------------------------------------+
   |
   v
SoapuiWsdlRequestTemplate
  invokeAt / invokeByName (params, async)
   |
   v
+------------------------------------+
| SoapRequestHandler -> SoapUI engine|
| SoapResponseHandler -> parse result|
+------------------------------------+
   |
   v
SoapuiResponse<WsdlRequest> (status / response / error)
```

The project is a single jar module. Key packages under `com.smartbear.soapui.template`:

| Package | Responsibility |
|:---|:---|
| root | `SoapuiWsdlTemplate`, `SoapuiWsdlRequestTemplate`, `SoapuiResponse`, `SoapuiProperties` |
| `handler` | `SoapRequestHandler`, `SoapResponseHandler`, `AbstractResponseHandler` + default implementations (`def`) |
| `setting` | `SoapuiSettings` / `SoapuiSettingsImpl` and the HTTP, proxy, SSL, WSDL, WSA, WSI, project settings models |
| `property` | `EnvironmentProperty` |
| `utils` | `SoapuiRequestUtils`, `SoapuiXmlUtils`, `SoapuiResponseUtils` |
| `wsdl` | `WsdlInfo`, `WsdlInterfaceInfo`, `WsdlOperationInfo` |

## 5. Installation

Artifacts are published to the easy4j private repository and GitHub Releases; the project is not yet on Maven Central.

Maven:

```xml
<dependency>
    <groupId>io.github.easy4j</groupId>
    <artifactId>soapui-template</artifactId>
    <version>2.0.x.x.20260630-SNAPSHOT</version>
</dependency>
```

Gradle:

```groovy
implementation 'io.github.easy4j:soapui-template:2.0.x.x.20260630-SNAPSHOT'
```

**Prerequisite — SoapUI must be available in your Maven repository.** The POM depends on the SoapUI engine (`com.eviware:soapui`), which is not published to public repositories in the expected form. Install it locally first:

```bash
# 1. Clone the SoapUI source
git clone https://github.com/SmartBear/soapui.git

# 2. In soapui/soapui/pom.xml, pin XMLBeans to 2.6.0:
#    org.apache.xmlbeans:xmlbeans / xmlbeans-xpath / xmlbeans-xmlpublic  ->  2.6.0

# 3. Build and install the engine into the local Maven repository
mvn clean install
```

To share the artifacts with a team, deploy them to a Nexus repository instead:

```bash
mvn deploy:deploy-file -DgroupId=com.eviware -DartifactId=soapui -Dversion=5.4.0 \
  -Dpackaging=jar -Dfile=/path/to/soapui-5.4.0.jar -Durl=${repositoryUrl} -DrepositoryId=${repositoryId}
mvn deploy:deploy-file -DgroupId=com.eviware -DartifactId=soapui -Dversion=5.4.0 \
  -Dpackaging=jar -Dfile=/path/to/soapui-5.4.0-sources.jar -Dclassifier=sources \
  -Durl=${repositoryUrl} -DrepositoryId=${repositoryId}
```

## 6. Quick Start

Load a WSDL, look up an operation and invoke it:

```java
import com.smartbear.soapui.template.SoapuiResponse;
import com.smartbear.soapui.template.SoapuiWsdlRequestTemplate;
import com.smartbear.soapui.template.SoapuiWsdlTemplate;
import com.eviware.soapui.impl.wsdl.WsdlRequest;

import java.util.HashMap;
import java.util.Map;

SoapuiWsdlTemplate wsdlTemplate = new SoapuiWsdlTemplate();
SoapuiWsdlRequestTemplate requestTemplate = new SoapuiWsdlRequestTemplate(wsdlTemplate);

Map<String, Object> params = new HashMap<>();
params.put("name", "world");

SoapuiResponse<WsdlRequest> result =
        requestTemplate.invokeByName("https://example.com/service?wsdl", "sayHello", params);

System.out.println("status   : " + result.getStatus());
System.out.println("response : " + result.getResponse());
System.out.println("error    : " + result.getError());
```

Expected result: the request is executed against the `sayHello` operation of the WSDL endpoint; the returned `SoapuiResponse` carries the request, HTTP status, raw response body (or the thrown exception when the call failed).

## 7. Configuration

`SoapuiProperties` drives the templates and the settings model. The test configuration uses a `soapui.*` prefix (**Assumption**: binding conventions are defined by the consuming application, since this is a plain library, not a Spring Boot starter):

| Property (JavaBean) | Default | Description |
|:---|:---|:---|
| `settingsFile` | `soapui-settings.xml` | SoapUI settings file name used by `SoapuiSettingsFileLoader` |
| `createRequests` | `true` | Whether requests are created for WSDL operations |
| `timeout` | `30000` (ms) | Request timeout |
| `maximumCacheSize` | `100` | WSDL cache size |
| `cacheDuration` | `60` | WSDL cache duration |
| `env` | `EnvironmentProperty` | Environment information (name/settings) |

The `setting` package provides dedicated models that can be pre-configured and passed to the templates: `SoapuiHttpSettings`, `SoapuiProxySettings`, `SoapuiSSLSettings`, `SoapuiWsdlSettings`, `SoapuiWsaSettings`, `SoapuiWSISettings`, `SoapuiProjectSettings`, `SoapuiHttpVersion`, `SoapuiHttpRequestCompression`.

## 8. Core Usage / API

Browse a WSDL before invoking anything:

```java
import com.smartbear.soapui.template.SoapuiWsdlTemplate;
import com.smartbear.soapui.template.wsdl.WsdlInfo;

SoapuiWsdlTemplate wsdlTemplate = new SoapuiWsdlTemplate();

WsdlInfo wsdlInfo = wsdlTemplate.getWsdlInfo("https://example.com/service?wsdl");
// wsdlInfo -> interfaces and operations of the WSDL
```

Invoke with an operation index and array parameters (asynchronous variant available):

```java
SoapuiResponse<WsdlRequest> result =
        requestTemplate.invokeAt("https://example.com/service?wsdl", 0, new String[] { "world" });
```

## 9. Testing & Build

Build and run tests:

```bash
./mvnw clean verify
```

- The test suite covers WSDL loading (`SoapuiWsdl_Test`, `SoapuiWsdlTemplate_Test`, `AbstractWsdlTemplate_Test`), request templates (`SoapuiRequestTemplate_Test`), request/response utilities (`SoapuiRequestUtils_Test`, `SoapuiResponseUtils_Test`), message parsing (`SoapuiMessageParse_Test`) and REST invocations (`SoapUI_Rest_Test`).
- The build is configured with the JaCoCo Maven plugin: a coverage report is generated at `target/site/jacoco/index.html` and a rule checks the bundle line coverage against a 90% minimum (`haltOnFailure=false`, so the check reports but does not fail the build).
- The `central` Maven profile (`./mvnw -Pcentral deploy`) attaches GPG signatures, sources and Javadoc jars for publishing.

## 10. Versioning & Branches

Three parallel version lines are maintained:

| Branch | JDK | Version pattern |
|:---|:---|:---|
| `feature/1.0.x` | 8 | `1.0.x.*` |
| `feature/2.0.x` | 17 | `2.0.x.*` |
| `feature/3.0.x` | 21 | `3.0.x.*` |

Maintenance policy: the `1.0.x` line is the actively developed line (current snapshot `2.0.x.x.20260630-SNAPSHOT`); `2.0.x` and `3.0.x` are forward porting lines targeting newer JDKs. Snapshots are built on demand; tagged releases are distributed via GitHub Releases.

## 11. Contributing & License

- Fork the repository and open a pull request; keep the `1.0.x` line compatible with JDK 8.
- Bug reports and feature requests are tracked via GitHub Issues.
- Licensed under the [Apache License, Version 2.0](https://www.apache.org/licenses/LICENSE-2.0).
