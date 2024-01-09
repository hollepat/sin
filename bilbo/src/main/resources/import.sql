-- Create ENUM type 'belief'
CREATE TYPE belief_t AS ENUM ('BAD', 'GOOD');

-- Create table 'groups'
CREATE TABLE groups (
        id SERIAL PRIMARY KEY NOT NULL,
        name VARCHAR(255),
        groupBelief belief_t
);

-- Create table 'heroes'
CREATE TABLE heroes (
        id SERIAL PRIMARY KEY NOT NULL,
        hero_name VARCHAR(255) UNIQUE,
        belief belief_t,
        strength INT,
        magic INT,
        will INT,
        group_id BIGINT,
        CONSTRAINT fk_hero_group FOREIGN KEY (group_id) REFERENCES groups(id)
);

-- Create table 'battles'
CREATE TABLE battles (
         id SERIAL PRIMARY KEY NOT NULL,
         groupA_id BIGINT NOT NULL,
         groupB_id BIGINT NOT NULL,
         groupAvalue INT,
         groupBvalue INT,
         CONSTRAINT fk_battle_groupA FOREIGN KEY (groupA_id) REFERENCES groups(id),
         CONSTRAINT fk_battle_groupB FOREIGN KEY (groupB_id) REFERENCES groups(id)
);
