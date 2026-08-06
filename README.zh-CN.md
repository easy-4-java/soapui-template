# soapui-template

![Java](https://img.shields.io/badge/Java-17-orange) ![License](https://img.shields.io/badge/License-Apache%202.0-blue)

[English](./README.md) | [简体中文](./README.zh-CN.md)

[1. Project Overview](#1-project-overview) | [2. Features & Status](#2-features--status) | [3. Requirements & Compatibility](#3-requirements--compatibility) | [4. Architecture & Modules](#4-architecture--modules) | [5. Installation](#5-installation) | [6. Quick Start](#6-quick-start) | [7. Configuration](#7-configuration) | [8. Core Usage / API](#8-core-usage--api) | [9. Testing & Build](#9-testing--build) | [10. Versioning & Branches](#10-versioning--branches) | [11. Contributing & License](#11-contributing--license)

## 1. Project Overview

`soapui-template`（"Opt For SoapUI"）是基于 SoapUI 引擎的轻量级编程封装层。Java 应用无需启动 SoapUI 图形界面，即可加载 WSDL、浏览其操作并调用 SOAP Web 服务操作，同时保留 SoapUI 熟悉的概念（项目、WSDL 接口、操作、设置、HTTP/S 与 WS-Security 选项）。

它是面向开发者的代码级驱动 SoapUI 的库（测试、自动化、服务 Mock 等场景）——不是 SoapUI 桌面工具的替代品，也不是独立的 HTTP 客户端框架。

典型场景：

| 场景 | 本模块提供的组件 |
|:---|:---|
| 无图形界面浏览 WSDL | `SoapuiWsdlTemplate`（操作、接口、WSDL 信息） |
| 按名称或索引调用 SOAP 操作 | `SoapuiWsdlRequestTemplate#invokeAt` / `invokeByName` |
| 获取响应状态与错误详情 | `SoapuiResponse`（request、status、error、response） |
| 复用 SoapUI 设置（HTTP、代理、SSL、WS-Addressing、WSI） | `SoapuiSettings` 体系 + `SoapuiProperties` |

## 2. Features & Status

项目状态：`1.0.x.*` 预发布开发线（快照版本）；在首个正式 Release 标签之前，公开 API 仍在稳定过程中。

| 能力 | 状态 | 说明 |
|:---|:---|:---|
| WSDL 加载与检查 | 稳定 | `SoapuiWsdlTemplate` 将 WSDL URL 加载为 `WsdlProject` 并暴露操作与接口 |
| 操作查询 | 稳定 | `getOperationAt(url, index)`、`getOperationByName(url, name)`、`getOperationList(url)`、`getOperations(url)` |
| 请求调用 | 稳定 | `SoapuiWsdlRequestTemplate` 支持按索引（`invokeAt`）或名称（`invokeByName`）调用，参数支持 `Map` 或 `String[]`，支持同步与异步 |
| 结果模型 | 稳定 | `SoapuiResponse<WsdlRequest>` 暴露 request、status、error 与原始响应 |
| SoapUI 设置模型 | 稳定 | `SoapuiSettingsImpl` 覆盖 HTTP、代理、SSL、WSDL、WS-Addressing（WSA）、WSI 与项目设置 |
| 设置文件加载 | 稳定 | `SoapuiSettingsFileLoader` 读写 SoapUI 设置 XML 文件（默认 `soapui-settings.xml`） |
| 响应处理器 | 稳定 | `SoapResponseHandler` SPI，提供纯文本、XML 与流式实现 |
| 请求参数处理器 | 稳定 | 数组与 Map 参数处理（`SoapRequestArrayParamHandler`、`SoapRequestMapParamHandler`） |
| WSDL 元数据模型 | 稳定 | `WsdlInfo`、`WsdlInterfaceInfo`、`WsdlOperationInfo` |

## 3. Requirements & Compatibility

| 要求 | 版本 |
|:---|:---|
| JDK | 17+ |
| Maven | 3.6+ |
| SoapUI 引擎 | SoapUI（SmartBear），需安装到本地 Maven 仓库（见 [5. Installation](#5-installation)） |
| XMLBeans | 2.6.0（xmlbeans、xmlbeans-xpath、xmlbeans-xmlpublic） |
| 其他运行依赖 | commons-lang3、commons-io、commons-codec、httpclient/httpmime/httpcore、wss4j、guava、groovy 等（已在 POM 声明） |

版本线：

| 分支 | JDK | 版本模式 | 说明 |
|:---|:---|:---|:---|
| `feature/1.0.x` | 8 | `1.0.x.*` | 当前开发线 |
| `feature/2.0.x` | 17 | `2.0.x.*` | 下一条版本线 |
| `feature/3.0.x` | 21 | `3.0.x.*` | 未来版本线 |

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

本工程为单 jar 模块，关键包位于 `com.smartbear.soapui.template`：

| 包 | 职责 |
|:---|:---|
| 根包 | `SoapuiWsdlTemplate`、`SoapuiWsdlRequestTemplate`、`SoapuiResponse`、`SoapuiProperties` |
| `handler` | `SoapRequestHandler`、`SoapResponseHandler`、`AbstractResponseHandler` 及默认实现（`def`） |
| `setting` | `SoapuiSettings` / `SoapuiSettingsImpl` 及 HTTP、代理、SSL、WSDL、WSA、WSI、项目设置模型 |
| `property` | `EnvironmentProperty` |
| `utils` | `SoapuiRequestUtils`、`SoapuiXmlUtils`、`SoapuiResponseUtils` |
| `wsdl` | `WsdlInfo`、`WsdlInterfaceInfo`、`WsdlOperationInfo` |

## 5. Installation

制品发布到 easy4j 私有仓库与 GitHub Releases，暂未发布 Maven Central。

Maven：

```xml
<dependency>
    <groupId>io.github.easy4j</groupId>
    <artifactId>soapui-template</artifactId>
    <version>2.0.x.x.20260630-SNAPSHOT</version>
</dependency>
```

Gradle：

```groovy
implementation 'io.github.easy4j:soapui-template:2.0.x.x.20260630-SNAPSHOT'
```

**前置条件 —— SoapUI 必须存在于你的 Maven 仓库。** POM 依赖 SoapUI 引擎（`com.eviware:soapui`），该引擎不会以预期形式发布到公共仓库，需先本地安装：

```bash
# 1. 克隆 SoapUI 源码
git clone https://github.com/SmartBear/soapui.git

# 2. 在 soapui/soapui/pom.xml 中将 XMLBeans 固定为 2.6.0：
#    org.apache.xmlbeans:xmlbeans / xmlbeans-xpath / xmlbeans-xmlpublic  ->  2.6.0

# 3. 构建并安装到本地 Maven 仓库
mvn clean install
```

如需团队共享，可将制品部署到 Nexus 仓库：

```bash
mvn deploy:deploy-file -DgroupId=com.eviware -DartifactId=soapui -Dversion=5.4.0 \
  -Dpackaging=jar -Dfile=/path/to/soapui-5.4.0.jar -Durl=${repositoryUrl} -DrepositoryId=${repositoryId}
mvn deploy:deploy-file -DgroupId=com.eviware -DartifactId=soapui -Dversion=5.4.0 \
  -Dpackaging=jar -Dfile=/path/to/soapui-5.4.0-sources.jar -Dclassifier=sources \
  -Durl=${repositoryUrl} -DrepositoryId=${repositoryId}
```

## 6. Quick Start

加载 WSDL、查询操作并调用：

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

预期结果：请求针对 WSDL 端点的 `sayHello` 操作执行；返回的 `SoapuiResponse` 携带请求、HTTP 状态、原始响应体（调用失败时则为抛出的异常）。

## 7. Configuration

`SoapuiProperties` 驱动模板与设置模型。测试配置使用 `soapui.*` 前缀（**假设**：绑定约定由消费方应用自行定义，本库为纯库，非 Spring Boot Starter）：

| 属性（JavaBean） | 默认值 | 说明 |
|:---|:---|:---|
| `settingsFile` | `soapui-settings.xml` | `SoapuiSettingsFileLoader` 使用的 SoapUI 设置文件名 |
| `createRequests` | `true` | 是否为 WSDL 操作创建请求 |
| `timeout` | `30000`（毫秒） | 请求超时 |
| `maximumCacheSize` | `100` | WSDL 缓存大小 |
| `cacheDuration` | `60` | WSDL 缓存时长 |
| `env` | `EnvironmentProperty` | 环境信息（名称/设置） |

`setting` 包提供可预配置并传给模板的专用模型：`SoapuiHttpSettings`、`SoapuiProxySettings`、`SoapuiSSLSettings`、`SoapuiWsdlSettings`、`SoapuiWsaSettings`、`SoapuiWSISettings`、`SoapuiProjectSettings`、`SoapuiHttpVersion`、`SoapuiHttpRequestCompression`。

## 8. Core Usage / API

调用前先浏览 WSDL：

```java
import com.smartbear.soapui.template.SoapuiWsdlTemplate;
import com.smartbear.soapui.template.wsdl.WsdlInfo;

SoapuiWsdlTemplate wsdlTemplate = new SoapuiWsdlTemplate();

WsdlInfo wsdlInfo = wsdlTemplate.getWsdlInfo("https://example.com/service?wsdl");
// wsdlInfo -> 该 WSDL 的接口与操作
```

按操作索引 + 数组参数调用（另有异步变体）：

```java
SoapuiResponse<WsdlRequest> result =
        requestTemplate.invokeAt("https://example.com/service?wsdl", 0, new String[] { "world" });
```

## 9. Testing & Build

构建与测试：

```bash
./mvnw clean verify
```

- 测试套件覆盖 WSDL 加载（`SoapuiWsdl_Test`、`SoapuiWsdlTemplate_Test`、`AbstractWsdlTemplate_Test`）、请求模板（`SoapuiRequestTemplate_Test`）、请求/响应工具（`SoapuiRequestUtils_Test`、`SoapuiResponseUtils_Test`）、消息解析（`SoapuiMessageParse_Test`）与 REST 调用（`SoapUI_Rest_Test`）；
- 构建配置了 JaCoCo Maven 插件：覆盖率报告生成于 `target/site/jacoco/index.html`，并配置了 BUNDLE 行覆盖率 90% 的校验规则（`haltOnFailure=false`，即只报告不阻断构建）；
- `central` Maven Profile（`./mvnw -Pcentral deploy`）附加 GPG 签名、源码包与 Javadoc 包用于发布。

## 10. Versioning & Branches

维护三条并行版本线：

| 分支 | JDK | 版本模式 |
|:---|:---|:---|
| `feature/1.0.x` | 8 | `1.0.x.*` |
| `feature/2.0.x` | 17 | `2.0.x.*` |
| `feature/3.0.x` | 21 | `3.0.x.*` |

维护策略：`1.0.x` 为当前活跃开发线（当前快照 `2.0.x.x.20260630-SNAPSHOT`）；`2.0.x` 与 `3.0.x` 为面向更新 JDK 的前向移植线。快照按需构建，正式 Release 通过 GitHub Releases 分发。

## 11. Contributing & License

- Fork 仓库并提交 Pull Request；`1.0.x` 版本线保持 JDK 8 兼容；
- Bug 反馈与功能建议通过 GitHub Issues 跟踪；
- 基于 [Apache License, Version 2.0](https://www.apache.org/licenses/LICENSE-2.0) 开源。
