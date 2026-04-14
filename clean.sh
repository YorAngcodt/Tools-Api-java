#!/bin/bash

# clean.sh - Script untuk membersihkan hasil compile

echo "🧹 Cleaning compiled files..."

rm -rf out
rm -rf logs/*.log
rm -rf data/*.json

echo "✅ Clean complete!"
