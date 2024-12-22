CREATE TABLE url_details (
    id BIGINT PRIMARY KEY,
    title TEXT,
    short_url VARCHAR(10),
    long_url TEXT,
    click_count INT,
    unique_clients INT
);