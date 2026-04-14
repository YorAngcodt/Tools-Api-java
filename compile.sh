#!/bin/bash

# compile.sh - Script untuk compile Java files

echo "🔨 Compiling Java files..."

# Buat folder out jika belum ada
mkdir -p out

# Download Gson jika belum ada
if [ ! -f "lib/gson-2.10.1.jar" ]; then
    echo "📥 Downloading Gson library..."
    wget -P lib/ https://repo1.maven.org/maven2/com/google/code/gson/gson/2.10.1/gson-2.10.1.jar
fi

# Compile semua file Java
find src -name "*.java" > sources.txt
javac -cp "lib/gson-2.10.1.jar" -d out @sources.txt

if [ $? -eq 0 ]; then
    echo "✅ Compile successful!"
    rm sources.txt
else
    echo "❌ Compile failed!"
    rm sources.txt
    exit 1
fi
