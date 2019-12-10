#!/bin/sh

echo "Get all:"
curl -X GET http://localhost:9999/entity

echo "\nInsert:"
curl -d "value=Hello" -X POST http://localhost:9999/entity

echo "\nChange:"
curl -d "id=1&value=World)" -X PUT http://localhost:9999/entity

echo "\nGet all:"
curl -X GET http://localhost:9999/entity
