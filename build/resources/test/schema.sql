drop table if exists PRICES_RULES;

CREATE TABLE "PRICES_RULES"
(	"BRAND_ID" int,
    "START_DATE" timestamp default current_timestamp,
    "END_DATE" timestamp default current_timestamp,
    "PRICE_LIST" VARCHAR(100),
    "PRODUCT_ID" VARCHAR(100),
    "PRIORITY" int,
    "PRICE" decimal,
    "CURR" VARCHAR(100),
    PRIMARY KEY (BRAND_ID, PRODUCT_ID, PRICE_LIST)
);