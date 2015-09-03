--
-- JBoss, Home of Professional Open Source
-- Copyright 2013, Red Hat, Inc. and/or its affiliates, and individual
-- contributors by the @authors tag. See the copyright.txt in the
-- distribution for a full listing of individual contributors.
--
-- Licensed under the Apache License, Version 2.0 (the "License");
-- you may not use this file except in compliance with the License.
-- You may obtain a copy of the License at
-- http://www.apache.org/licenses/LICENSE-2.0
-- Unless required by applicable law or agreed to in writing, software
-- distributed under the License is distributed on an "AS IS" BASIS,
-- WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
-- See the License for the specific language governing permissions and
-- limitations under the License.
--

-- You can use this file to load seed data into the database using SQL statements
insert into Registrant(id, name, email, phone_number) values (0, 'John Smith', 'john.smith@mailinator.com', '2125551212')

insert into OpportunityStatus(id, name) values (0, 'Open')
insert into OpportunityStatus(id, name) values (1, 'Full')
insert into OpportunityStatus(id, name) values (2, 'Waitlist')
insert into OpportunityStatus(id, name) values (3, 'Confirmed')
insert into OpportunityStatus(id, name) values (4, 'Canceled')

insert into ActivityType(id, title) values (0, 'Hike')
insert into ActivityType(id, title) values (1, 'Sport Climb')
insert into ActivityType(id, title) values (2, 'Alpine Climb')
insert into ActivityType(id, title) values (3, 'Ski')
insert into ActivityType(id, title) values (4, 'Ski-Tour')
insert into ActivityType(id, title) values (5, 'Family')

insert into Activity(id, title, description, TYPE_ID, min, max) values (0, 'Some Title', 'Some Description', 5, -1, -1)
insert into Activity(id, title, description, TYPE_ID, min, max) values (1, 'Another Title', 'Another Description', 0, -1, -1)