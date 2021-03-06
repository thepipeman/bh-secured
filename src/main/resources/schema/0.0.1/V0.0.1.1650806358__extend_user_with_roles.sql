DO
$$
  BEGIN
    CREATE TYPE mng.USER_ROLE AS ENUM (
      'ADMIN',
      'CUSTOMER'
      );
  EXCEPTION
    WHEN duplicate_object THEN NULL;
  END
$$;

ALTER TABLE mng.user
  ADD COLUMN role mng.USER_ROLE NOT NULL DEFAULT 'CUSTOMER' :: mng.USER_ROLE;

ALTER TABLE mng.user
  ALTER COLUMN role DROP DEFAULT;

CREATE CAST (CHARACTER VARYING as mng.USER_ROLE) WITH INOUT AS IMPLICIT;
