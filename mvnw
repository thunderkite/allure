#!/bin/sh
set -e

MAVEN_VERSION=3.9.9
MAVEN_ROOT="${HOME}/.m2/wrapper/apache-maven-${MAVEN_VERSION}"
MAVEN_BIN="${MAVEN_ROOT}/bin/mvn"

if [ ! -x "${MAVEN_BIN}" ]; then
  archive="$(mktemp)"
  mkdir -p "${HOME}/.m2/wrapper"
  curl --fail --silent --show-error --location \
    "https://archive.apache.org/dist/maven/maven-3/${MAVEN_VERSION}/binaries/apache-maven-${MAVEN_VERSION}-bin.tar.gz" \
    --output "${archive}"
  tar -xzf "${archive}" -C "${HOME}/.m2/wrapper"
  rm -f "${archive}"
fi

exec "${MAVEN_BIN}" "$@"