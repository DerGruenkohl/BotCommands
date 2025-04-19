---------------------------------------- Baseline migration script for the JDUI integration of BotCommands ---------------------------------------
------------ This script is the first version of the database, you can apply this one manually as well as the ones after this version ------------
------------------------------------- The filename scheme should also be compatible with Flyway and Liquibase ------------------------------------

-------------------------------------------------- If you choose to create the database manually --------------------------------------------------
-------------------------------------------------- you will need to create a 'jdui' schema first --------------------------------------------------

------------ Base framework

set schema 'jdui';

-- TODO should this also have a jdui_version table?

CREATE TABLE views
(
    id   BIGINT NOT NULL,
    data bytea  NOT NULL,

    PRIMARY KEY (id)
)