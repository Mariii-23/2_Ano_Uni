#!/usr/bin/env bash
# set -euo pipefail

./pessoas -i Mariana 100

for i in {1..1000}; do
    ./pessoas -i Pessoa${i} $i
done

./pessoas -i Lucas 100

./pessoas -p Mariana 23
./pessoas -p Lucas 23

echo
./pessoas -v
