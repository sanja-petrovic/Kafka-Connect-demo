#!/bin/sh
# wait-for-postgres.sh

set -e

host="$1"
shift

apt-get update
apt-get install -y postgresql-client

until PGPASSWORD=$DATABASE_PW psql -h "$host" -U $DATABASE_USER -c '\q'; do
  >&2 echo "Postgres is unavailable - sleeping"
  sleep 1
done

>&2 echo "Postgres is up - executing command"
exec "$@"