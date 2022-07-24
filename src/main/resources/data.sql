-- Clients
insert into client(first_name, last_name, date_of_birth, email_address, address_line1, postcode)
values ('John', 'Doe', '2000-01-01', 'john.doe@test.com', 'Empire Way, Wembley', 'HA9 0WS');

insert into client(first_name, last_name, date_of_birth, email_address, address_line1, postcode)
values ('Jane', 'Doe', '2005-02-03', 'jane.doe@test.com', 'Church Road, Wimbledon', 'SW19 5AG');


-- Loans
insert into loan(loan_number, loan_suffix, loan_status, client_id)
values ('5008665378', '05', 'ACTIVE', (select id from client where email_address = 'john.doe@test.com'));

insert into loan(loan_number, loan_suffix, loan_status, client_id)
values ('5008665378', '06', 'CANCELLED', (select id from client where email_address = 'john.doe@test.com'));
