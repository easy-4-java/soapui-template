#!/usr/bin/env bash
set -euo pipefail

repository_root="$(cd "$(dirname "${BASH_SOURCE[0]}")/../.." && pwd)"
work_dir="$(mktemp -d)"
trap 'rm -rf "$work_dir"' EXIT
cd "$work_dir"

install_jar() {
  mvn -B --no-transfer-progress org.apache.maven.plugins:maven-install-plugin:3.1.4:install-file \
    -Dfile="$repository_root/$1" -DgroupId="$2" -DartifactId="$3" \
    -Dversion="$4" -Dpackaging=jar -DgeneratePom=true
}

install_jar 'SoapUI Jar/com/eviware/soapui/5.4.0/soapui-5.4.0.jar' com.eviware soapui 5.4.0-easy4j
install_jar 'SoapUI Jar/com/liferay/com.btr.proxy.vole/20131209/com.btr.proxy.vole-20131209.jar' com.liferay com.btr.proxy.vole 20131209
install_jar 'SoapUI Jar/com/smartbear/utils/analytics/analytics-core/5.4.0/analytics-core-5.4.0.jar' com.smartbear.utils.analytics analytics-core 5.4.0
install_jar 'SoapUI Jar/com/smartbear/utils/analytics/out-app-analytics-provider/5.4.0/out-app-analytics-provider-5.4.0.jar' com.smartbear.utils.analytics out-app-analytics-provider 5.4.0
