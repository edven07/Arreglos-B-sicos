#!/bin/bash
# Script para calcular interés simple

echo "Ingrese el capital (P):"
read P

echo "Ingrese la tasa de interés (R):"
read R

echo "Ingrese el tiempo en años (T):"
read T

SI=$(echo "$P * $R * $T / 100" | bc -l)

echo "El interés simple es: $SI"
