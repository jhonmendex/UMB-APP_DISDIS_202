#!/bin/bash
set -e

psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" <<-EOSQL
    CREATE DATABASE dbshipping;
    GRANT ALL PRIVILEGES ON DATABASE dbshipping TO dbuser;
    CREATE TABLE "shipping" (
      "id" SERIAL PRIMARY KEY,
      "address" character varying(90) NOT NULL,
      "sent_at" timestamp NOT NULL,
      "received_at" timestamp NOT NULL,
      "id_order_history" int UNIQUE NOT NULL
    );
EOSQL
