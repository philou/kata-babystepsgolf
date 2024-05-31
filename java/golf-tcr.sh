#!/usr/bin/env sh

./tcr-scripts/build-it.sh && \
(./tcr-scripts/test.sh && ./tcr-scripts/commit.sh "$@" || ./tcr-scripts/revert.sh)
