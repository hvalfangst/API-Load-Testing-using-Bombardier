-- 01_create_prayers_table.sql

CREATE TABLE IF NOT EXISTS prayers (
                                       id SERIAL PRIMARY KEY,
                                       prayer_title TEXT,
                                       prayer_text TEXT,
                                       prayer_intent TEXT,
                                       author VARCHAR(12),
                                       timestamp DATE
);
