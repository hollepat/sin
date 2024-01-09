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

INSERT INTO heroes (hero_name, belief, strength, magic, will, group_id) VALUES ('Gandalf', 'GOOD', 2, 5, 10, 1);
INSERT INTO heroes (hero_name, belief, strength, magic, will, group_id) VALUES ('Bilbo', 'GOOD', 3, 10, 1, 1);
INSERT INTO heroes (hero_name, belief, strength, magic, will, group_id) VALUES ('Thorin', 'GOOD', 10, 5, 0, 1);

INSERT INTO heroes (hero_name, belief, strength, magic, will, group_id) VALUES ('Bolg', 'EVIL', 10, 10, 0, 2);
INSERT INTO heroes (hero_name, belief, strength, magic, will, group_id) VALUES ('Golfimbul', 'EVIL', 6, 4, 0, 2);
INSERT INTO heroes (hero_name, belief, strength, magic, will, group_id) VALUES ('Necromancer', 'EVIL', 3, 3, 10, 2);

INSERT INTO groups (name, groupBelief) VALUES ('Group 1', 'BAD');
INSERT INTO groups (name, groupBelief) VALUES ('Group 2', 'GOOD');
