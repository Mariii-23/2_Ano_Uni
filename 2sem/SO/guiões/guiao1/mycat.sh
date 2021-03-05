#!/usr/bin/env bash
# set -euo pipefail

for i in {1..1000}; do
    ./pessoas -i Pessoa${i} $i
done

./pessoas -p Mariana 23
