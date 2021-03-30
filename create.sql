create table contact_us (id bigint not null, description varchar(255), email varchar(255), phone varchar(255), primary key (id)) engine=MyISAM
create table event (id bigint not null, date date, description varchar(255), event_link varchar(255), primary key (id)) engine=MyISAM
create table event_user (user_id bigint not null, event_id bigint not null, primary key (user_id, event_id)) engine=MyISAM
create table faq (id bigint not null, answer varchar(255), question varchar(255), primary key (id)) engine=MyISAM
create table hibernate_sequence (next_val bigint) engine=MyISAM
insert into hibernate_sequence values ( 1 )
create table post (id bigint not null, description varchar(255), stickied bit not null, threadid integer not null, timestamp_created datetime, timestamp_edited datetime, title varchar(255), primary key (id)) engine=MyISAM
create table post_upvotes (id bigint not null, user_id bigint not null, post_id bigint, primary key (id)) engine=MyISAM
create table thread (threadid bigint not null, accountid bigint not null, anonymous bit not null, description varchar(255), new_desc varchar(255), stickied bit not null, timestamp_created datetime, timestamp_edited datetime, title varchar(255), primary key (threadid)) engine=MyISAM
create table topic_forum (forumid integer not null, title varchar(255), primary key (forumid)) engine=MyISAM
create table user (id bigint not null, birthday datetime, email varchar(45), firstname varchar(255), lastname varchar(255), password varchar(255), phone_number varchar(255), username varchar(45), primary key (id)) engine=MyISAM
create table user_preference (id bigint not null, dark_mode bit not null, email_notifiation bit not null, primary key (id)) engine=MyISAM
alter table user add constraint UK_ob8kqyqqgmefl0aco34akdtpe unique (email)
alter table user add constraint UK_sb8bbouer5wak8vyiiy4pf2bx unique (username)
alter table event_user add constraint FK7al72l95h9milsvq8ll0jiunc foreign key (event_id) references user (id)
alter table event_user add constraint FKsylmpicyd5c9dh5spqmixnj6r foreign key (user_id) references event (id)
alter table post_upvotes add constraint FK8xo1aj29hiah9bw8kd66i52ex foreign key (post_id) references post (id)
create table contact_us (id bigint not null, description varchar(255), email varchar(255), phone varchar(255), primary key (id)) engine=MyISAM
create table event (id bigint not null, date date, description varchar(255), event_link varchar(255), primary key (id)) engine=MyISAM
create table event_user (user_id bigint not null, event_id bigint not null, primary key (user_id, event_id)) engine=MyISAM
create table faq (id bigint not null, answer varchar(255), question varchar(255), primary key (id)) engine=MyISAM
create table hibernate_sequence (next_val bigint) engine=MyISAM
insert into hibernate_sequence values ( 1 )
create table post (id bigint not null, description varchar(255), stickied bit not null, threadid integer not null, timestamp_created datetime, timestamp_edited datetime, title varchar(255), primary key (id)) engine=MyISAM
create table post_upvotes (id bigint not null, user_id bigint not null, post_id bigint, primary key (id)) engine=MyISAM
create table thread (threadid bigint not null, accountid bigint not null, anonymous bit not null, description varchar(255), new_desc varchar(255), stickied bit not null, timestamp_created datetime, timestamp_edited datetime, title varchar(255), primary key (threadid)) engine=MyISAM
create table topic_forum (forumid integer not null, title varchar(255), primary key (forumid)) engine=MyISAM
create table user (id bigint not null, birthday datetime, email varchar(45), firstname varchar(255), lastname varchar(255), password varchar(255), phone_number varchar(255), username varchar(45), primary key (id)) engine=MyISAM
create table user_preference (id bigint not null, dark_mode bit not null, email_notifiation bit not null, primary key (id)) engine=MyISAM
alter table user add constraint UK_ob8kqyqqgmefl0aco34akdtpe unique (email)
alter table user add constraint UK_sb8bbouer5wak8vyiiy4pf2bx unique (username)
alter table event_user add constraint FK7al72l95h9milsvq8ll0jiunc foreign key (event_id) references user (id)
alter table event_user add constraint FKsylmpicyd5c9dh5spqmixnj6r foreign key (user_id) references event (id)
alter table post_upvotes add constraint FK8xo1aj29hiah9bw8kd66i52ex foreign key (post_id) references post (id)
create table contact_us (id bigint not null, description varchar(255), email varchar(255), phone varchar(255), primary key (id)) engine=MyISAM
create table event (id bigint not null, date date, description varchar(255), event_link varchar(255), primary key (id)) engine=MyISAM
create table event_user (user_id bigint not null, event_id bigint not null, primary key (user_id, event_id)) engine=MyISAM
create table faq (id bigint not null, answer varchar(255), question varchar(255), primary key (id)) engine=MyISAM
create table hibernate_sequence (next_val bigint) engine=MyISAM
insert into hibernate_sequence values ( 1 )
create table post (id bigint not null, description varchar(255), stickied bit not null, threadid integer not null, timestamp_created datetime, timestamp_edited datetime, title varchar(255), primary key (id)) engine=MyISAM
create table post_upvotes (id bigint not null, user_id bigint not null, post_id bigint, primary key (id)) engine=MyISAM
create table thread (threadid bigint not null, accountid bigint not null, anonymous bit not null, description varchar(255), new_desc varchar(255), stickied bit not null, timestamp_created datetime, timestamp_edited datetime, title varchar(255), primary key (threadid)) engine=MyISAM
create table topic_forum (forumid integer not null, title varchar(255), primary key (forumid)) engine=MyISAM
create table user (id bigint not null, birthday datetime, email varchar(45), firstname varchar(255), lastname varchar(255), password varchar(255), phone_number varchar(255), username varchar(45), primary key (id)) engine=MyISAM
create table user_preference (id bigint not null, dark_mode bit not null, email_notifiation bit not null, primary key (id)) engine=MyISAM
alter table user add constraint UK_ob8kqyqqgmefl0aco34akdtpe unique (email)
alter table user add constraint UK_sb8bbouer5wak8vyiiy4pf2bx unique (username)
alter table event_user add constraint FK7al72l95h9milsvq8ll0jiunc foreign key (event_id) references user (id)
alter table event_user add constraint FKsylmpicyd5c9dh5spqmixnj6r foreign key (user_id) references event (id)
alter table post_upvotes add constraint FK8xo1aj29hiah9bw8kd66i52ex foreign key (post_id) references post (id)
create table contact_us (id bigint not null, description varchar(255), email varchar(255), phone varchar(255), primary key (id)) engine=MyISAM
create table event (id bigint not null, date date, description varchar(255), event_link varchar(255), primary key (id)) engine=MyISAM
create table event_user (user_id bigint not null, event_id bigint not null, primary key (user_id, event_id)) engine=MyISAM
create table faq (id bigint not null, answer varchar(255), question varchar(255), primary key (id)) engine=MyISAM
create table hibernate_sequence (next_val bigint) engine=MyISAM
insert into hibernate_sequence values ( 1 )
create table post (id bigint not null, description varchar(255), stickied bit not null, threadid integer not null, timestamp_created datetime, timestamp_edited datetime, title varchar(255), primary key (id)) engine=MyISAM
create table post_upvotes (id bigint not null, user_id bigint not null, post_id bigint, primary key (id)) engine=MyISAM
create table thread (threadid bigint not null, accountid bigint not null, anonymous bit not null, description varchar(255), new_desc varchar(255), stickied bit not null, timestamp_created datetime, timestamp_edited datetime, title varchar(255), primary key (threadid)) engine=MyISAM
create table topic_forum (forumid integer not null, title varchar(255), primary key (forumid)) engine=MyISAM
create table user (id bigint not null, birthday datetime, email varchar(45), firstname varchar(255), lastname varchar(255), password varchar(255), phone_number varchar(255), username varchar(45), primary key (id)) engine=MyISAM
create table user_preference (id bigint not null, dark_mode bit not null, email_notifiation bit not null, primary key (id)) engine=MyISAM
alter table user add constraint UK_ob8kqyqqgmefl0aco34akdtpe unique (email)
alter table user add constraint UK_sb8bbouer5wak8vyiiy4pf2bx unique (username)
alter table event_user add constraint FK7al72l95h9milsvq8ll0jiunc foreign key (event_id) references user (id)
alter table event_user add constraint FKsylmpicyd5c9dh5spqmixnj6r foreign key (user_id) references event (id)
alter table post_upvotes add constraint FK8xo1aj29hiah9bw8kd66i52ex foreign key (post_id) references post (id)
create table contact_us (id bigint not null, description varchar(255), email varchar(255), phone varchar(255), primary key (id)) engine=MyISAM
create table event (id bigint not null, date date, description varchar(255), event_link varchar(255), primary key (id)) engine=MyISAM
create table event_user (user_id bigint not null, event_id bigint not null, primary key (user_id, event_id)) engine=MyISAM
create table faq (id bigint not null, answer varchar(255), question varchar(255), primary key (id)) engine=MyISAM
create table hibernate_sequence (next_val bigint) engine=MyISAM
insert into hibernate_sequence values ( 1 )
create table post (id bigint not null, description varchar(255), stickied bit not null, threadid integer not null, timestamp_created datetime, timestamp_edited datetime, title varchar(255), primary key (id)) engine=MyISAM
create table post_upvotes (id bigint not null, user_id bigint not null, post_id bigint, primary key (id)) engine=MyISAM
create table thread (threadid bigint not null, accountid bigint not null, anonymous bit not null, description varchar(255), new_desc varchar(255), stickied bit not null, timestamp_created datetime, timestamp_edited datetime, title varchar(255), primary key (threadid)) engine=MyISAM
create table topic_forum (forumid integer not null, title varchar(255), primary key (forumid)) engine=MyISAM
create table user (id bigint not null, birthday datetime, email varchar(45), firstname varchar(255), lastname varchar(255), password varchar(255), phone_number varchar(255), username varchar(45), primary key (id)) engine=MyISAM
create table user_preference (id bigint not null, dark_mode bit not null, email_notifiation bit not null, primary key (id)) engine=MyISAM
alter table user add constraint UK_ob8kqyqqgmefl0aco34akdtpe unique (email)
alter table user add constraint UK_sb8bbouer5wak8vyiiy4pf2bx unique (username)
alter table event_user add constraint FK7al72l95h9milsvq8ll0jiunc foreign key (event_id) references user (id)
alter table event_user add constraint FKsylmpicyd5c9dh5spqmixnj6r foreign key (user_id) references event (id)
alter table post_upvotes add constraint FK8xo1aj29hiah9bw8kd66i52ex foreign key (post_id) references post (id)
create table contact_us (id bigint not null, description varchar(255), email varchar(255), phone varchar(255), primary key (id)) engine=MyISAM
create table event (id bigint not null, date date, description varchar(255), event_link varchar(255), primary key (id)) engine=MyISAM
create table event_user (user_id bigint not null, event_id bigint not null, primary key (user_id, event_id)) engine=MyISAM
create table faq (id bigint not null, answer varchar(255), question varchar(255), primary key (id)) engine=MyISAM
create table hibernate_sequence (next_val bigint) engine=MyISAM
insert into hibernate_sequence values ( 1 )
create table post (id bigint not null, description varchar(255), stickied bit not null, threadid integer not null, timestamp_created datetime, timestamp_edited datetime, title varchar(255), primary key (id)) engine=MyISAM
create table post_upvotes (id bigint not null, user_id bigint not null, post_id bigint, primary key (id)) engine=MyISAM
create table thread (threadid bigint not null, accountid bigint not null, anonymous bit not null, description varchar(255), new_desc varchar(255), stickied bit not null, timestamp_created datetime, timestamp_edited datetime, title varchar(255), primary key (threadid)) engine=MyISAM
create table topic_forum (forumid integer not null, title varchar(255), primary key (forumid)) engine=MyISAM
create table user (id bigint not null, birthday datetime, email varchar(45), firstname varchar(255), lastname varchar(255), password varchar(255), phone_number varchar(255), username varchar(45), primary key (id)) engine=MyISAM
create table user_preference (id bigint not null, dark_mode bit not null, email_notifiation bit not null, primary key (id)) engine=MyISAM
alter table user add constraint UK_ob8kqyqqgmefl0aco34akdtpe unique (email)
alter table user add constraint UK_sb8bbouer5wak8vyiiy4pf2bx unique (username)
alter table event_user add constraint FK7al72l95h9milsvq8ll0jiunc foreign key (event_id) references user (id)
alter table event_user add constraint FKsylmpicyd5c9dh5spqmixnj6r foreign key (user_id) references event (id)
alter table post_upvotes add constraint FK8xo1aj29hiah9bw8kd66i52ex foreign key (post_id) references post (id)
create table contact_us (id bigint not null, description varchar(255), email varchar(255), phone varchar(255), primary key (id)) engine=MyISAM
create table event (id bigint not null, date date, description varchar(255), event_link varchar(255), primary key (id)) engine=MyISAM
create table event_user (user_id bigint not null, event_id bigint not null, primary key (user_id, event_id)) engine=MyISAM
create table faq (id bigint not null, answer varchar(255), question varchar(255), primary key (id)) engine=MyISAM
create table hibernate_sequence (next_val bigint) engine=MyISAM
insert into hibernate_sequence values ( 1 )
create table post (id bigint not null, description varchar(255), stickied bit not null, threadid integer not null, timestamp_created datetime, timestamp_edited datetime, title varchar(255), primary key (id)) engine=MyISAM
create table post_upvotes (id bigint not null, user_id bigint not null, post_id bigint, primary key (id)) engine=MyISAM
create table thread (threadid bigint not null, accountid bigint not null, anonymous bit not null, description varchar(255), new_desc varchar(255), stickied bit not null, timestamp_created datetime, timestamp_edited datetime, title varchar(255), primary key (threadid)) engine=MyISAM
create table topic_forum (forumid integer not null, title varchar(255), primary key (forumid)) engine=MyISAM
create table user (id bigint not null, birthday datetime, email varchar(45), firstname varchar(255), lastname varchar(255), password varchar(255), phone_number varchar(255), username varchar(45), primary key (id)) engine=MyISAM
create table user_preference (id bigint not null, dark_mode bit not null, email_notifiation bit not null, primary key (id)) engine=MyISAM
alter table user add constraint UK_ob8kqyqqgmefl0aco34akdtpe unique (email)
alter table user add constraint UK_sb8bbouer5wak8vyiiy4pf2bx unique (username)
alter table event_user add constraint FK7al72l95h9milsvq8ll0jiunc foreign key (event_id) references user (id)
alter table event_user add constraint FKsylmpicyd5c9dh5spqmixnj6r foreign key (user_id) references event (id)
alter table post_upvotes add constraint FK8xo1aj29hiah9bw8kd66i52ex foreign key (post_id) references post (id)
create table contact_us (id bigint not null, description varchar(255), email varchar(255), phone varchar(255), primary key (id)) engine=MyISAM
create table event (id bigint not null, date date, description varchar(255), event_link varchar(255), primary key (id)) engine=MyISAM
create table event_user (user_id bigint not null, event_id bigint not null, primary key (user_id, event_id)) engine=MyISAM
create table faq (id bigint not null, answer varchar(255), question varchar(255), primary key (id)) engine=MyISAM
create table hibernate_sequence (next_val bigint) engine=MyISAM
insert into hibernate_sequence values ( 1 )
create table post (id bigint not null, description varchar(255), stickied bit not null, threadid integer not null, timestamp_created datetime, timestamp_edited datetime, title varchar(255), primary key (id)) engine=MyISAM
create table post_upvotes (id bigint not null, user_id bigint not null, post_id bigint, primary key (id)) engine=MyISAM
create table thread (threadid bigint not null, accountid bigint not null, anonymous bit not null, description varchar(255), new_desc varchar(255), stickied bit not null, timestamp_created datetime, timestamp_edited datetime, title varchar(255), primary key (threadid)) engine=MyISAM
create table topic_forum (forumid integer not null, title varchar(255), primary key (forumid)) engine=MyISAM
create table user (id bigint not null, birthday datetime, email varchar(45), firstname varchar(255), lastname varchar(255), password varchar(255), phone_number varchar(255), username varchar(45), primary key (id)) engine=MyISAM
create table user_preference (id bigint not null, dark_mode bit not null, email_notifiation bit not null, primary key (id)) engine=MyISAM
alter table user add constraint UK_ob8kqyqqgmefl0aco34akdtpe unique (email)
alter table user add constraint UK_sb8bbouer5wak8vyiiy4pf2bx unique (username)
alter table event_user add constraint FK7al72l95h9milsvq8ll0jiunc foreign key (event_id) references user (id)
alter table event_user add constraint FKsylmpicyd5c9dh5spqmixnj6r foreign key (user_id) references event (id)
alter table post_upvotes add constraint FK8xo1aj29hiah9bw8kd66i52ex foreign key (post_id) references post (id)
create table contact_us (id bigint not null, description varchar(255), email varchar(255), phone varchar(255), primary key (id)) engine=MyISAM
create table event (id bigint not null, date date, description varchar(255), event_link varchar(255), primary key (id)) engine=MyISAM
create table event_user (user_id bigint not null, event_id bigint not null, primary key (user_id, event_id)) engine=MyISAM
create table faq (id bigint not null, answer varchar(255), question varchar(255), primary key (id)) engine=MyISAM
create table hibernate_sequence (next_val bigint) engine=MyISAM
insert into hibernate_sequence values ( 1 )
create table post (id bigint not null, description varchar(255), stickied bit not null, threadid integer not null, timestamp_created datetime, timestamp_edited datetime, title varchar(255), primary key (id)) engine=MyISAM
create table post_upvotes (id bigint not null, user_id bigint not null, post_id bigint, primary key (id)) engine=MyISAM
create table thread (threadid bigint not null, accountid bigint not null, anonymous bit not null, description varchar(255), new_desc varchar(255), stickied bit not null, timestamp_created datetime, timestamp_edited datetime, title varchar(255), primary key (threadid)) engine=MyISAM
create table topic_forum (forumid integer not null, title varchar(255), primary key (forumid)) engine=MyISAM
create table user (id bigint not null, birthday datetime, email varchar(45), firstname varchar(255), lastname varchar(255), password varchar(255), phone_number varchar(255), username varchar(45), primary key (id)) engine=MyISAM
create table user_preference (id bigint not null, dark_mode bit not null, email_notifiation bit not null, primary key (id)) engine=MyISAM
alter table user add constraint UK_ob8kqyqqgmefl0aco34akdtpe unique (email)
alter table user add constraint UK_sb8bbouer5wak8vyiiy4pf2bx unique (username)
alter table event_user add constraint FK7al72l95h9milsvq8ll0jiunc foreign key (event_id) references user (id)
alter table event_user add constraint FKsylmpicyd5c9dh5spqmixnj6r foreign key (user_id) references event (id)
alter table post_upvotes add constraint FK8xo1aj29hiah9bw8kd66i52ex foreign key (post_id) references post (id)
create table contact_us (id bigint not null, description varchar(255), email varchar(255), phone varchar(255), primary key (id)) engine=MyISAM
create table event (id bigint not null, date date, description varchar(255), event_link varchar(255), primary key (id)) engine=MyISAM
create table event_user (user_id bigint not null, event_id bigint not null, primary key (user_id, event_id)) engine=MyISAM
create table faq (id bigint not null, answer varchar(255), question varchar(255), primary key (id)) engine=MyISAM
create table hibernate_sequence (next_val bigint) engine=MyISAM
insert into hibernate_sequence values ( 1 )
create table post (id bigint not null, description varchar(255), stickied bit not null, threadid integer not null, timestamp_created datetime, timestamp_edited datetime, title varchar(255), primary key (id)) engine=MyISAM
create table post_upvotes (id bigint not null, user_id bigint not null, post_id bigint, primary key (id)) engine=MyISAM
create table thread (threadid bigint not null, accountid bigint not null, anonymous bit not null, description varchar(255), new_desc varchar(255), stickied bit not null, timestamp_created datetime, timestamp_edited datetime, title varchar(255), primary key (threadid)) engine=MyISAM
create table topic_forum (forumid integer not null, title varchar(255), primary key (forumid)) engine=MyISAM
create table user (id bigint not null, birthday datetime, email varchar(45), firstname varchar(255), lastname varchar(255), password varchar(255), phone_number varchar(255), username varchar(45), primary key (id)) engine=MyISAM
create table user_preference (id bigint not null, dark_mode bit not null, email_notifiation bit not null, primary key (id)) engine=MyISAM
alter table user add constraint UK_ob8kqyqqgmefl0aco34akdtpe unique (email)
alter table user add constraint UK_sb8bbouer5wak8vyiiy4pf2bx unique (username)
alter table event_user add constraint FK7al72l95h9milsvq8ll0jiunc foreign key (event_id) references user (id)
alter table event_user add constraint FKsylmpicyd5c9dh5spqmixnj6r foreign key (user_id) references event (id)
alter table post_upvotes add constraint FK8xo1aj29hiah9bw8kd66i52ex foreign key (post_id) references post (id)
create table contact_us (id bigint not null, description varchar(255), email varchar(255), phone varchar(255), primary key (id)) engine=MyISAM
create table event (id bigint not null, date date, description varchar(255), event_link varchar(255), primary key (id)) engine=MyISAM
create table event_user (user_id bigint not null, event_id bigint not null, primary key (user_id, event_id)) engine=MyISAM
create table faq (id bigint not null, answer varchar(255), question varchar(255), primary key (id)) engine=MyISAM
create table hibernate_sequence (next_val bigint) engine=MyISAM
insert into hibernate_sequence values ( 1 )
create table post (id bigint not null, description varchar(255), stickied bit not null, threadid integer not null, timestamp_created datetime, timestamp_edited datetime, title varchar(255), primary key (id)) engine=MyISAM
create table post_upvotes (id bigint not null, user_id bigint not null, post_id bigint, primary key (id)) engine=MyISAM
create table thread (threadid bigint not null, accountid bigint not null, anonymous bit not null, description varchar(255), new_desc varchar(255), stickied bit not null, timestamp_created datetime, timestamp_edited datetime, title varchar(255), primary key (threadid)) engine=MyISAM
create table topic_forum (forumid integer not null, title varchar(255), primary key (forumid)) engine=MyISAM
create table user (id bigint not null, birthday datetime, email varchar(45), firstname varchar(255), lastname varchar(255), password varchar(255), phone_number varchar(255), username varchar(45), primary key (id)) engine=MyISAM
create table user_preference (id bigint not null, dark_mode bit not null, email_notifiation bit not null, primary key (id)) engine=MyISAM
alter table user add constraint UK_ob8kqyqqgmefl0aco34akdtpe unique (email)
alter table user add constraint UK_sb8bbouer5wak8vyiiy4pf2bx unique (username)
alter table event_user add constraint FK7al72l95h9milsvq8ll0jiunc foreign key (event_id) references user (id)
alter table event_user add constraint FKsylmpicyd5c9dh5spqmixnj6r foreign key (user_id) references event (id)
alter table post_upvotes add constraint FK8xo1aj29hiah9bw8kd66i52ex foreign key (post_id) references post (id)
