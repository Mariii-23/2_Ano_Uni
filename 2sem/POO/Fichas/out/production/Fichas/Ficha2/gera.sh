#!/usr/bin/env bash
set -euo pipefail
PATH="notas.txt"


for i in {1..100}; do
    # for j in {1..10}; do
    echo "$i $i $i $i $i $i $i $i" >> $PATH
done
