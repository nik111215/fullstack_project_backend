DROP TABLE IF EXISTS PERSON;
CREATE TABLE PERSON (
                        id IDENTITY NOT NULL PRIMARY KEY,
                        username VARCHAR(100) NOT NULL,
                        fullname VARCHAR(100) NOT NULL,
                        email VARCHAR(100) NOT NULL,
                        password VARCHAR(100) NOT NULL
);

DROP TABLE  IF EXISTS PERSON_DATA;
CREATE TABLE PERSON_DATA(
                            id IDENTITY NOT NULL PRIMARY KEY,
                            clientId integer not null REFERENCES PERSON(id),
                            lastprice INTEGER NOT NULL,
                            generalprice INTEGER NOT NULL,
                            favouritedish VARCHAR(100) NOT NULL
);