CREATE TABLE public.user_account
(
    user_id integer NOT NULL DEFAULT nextval('user_account_user_id_seq'::regclass),
    first_name character varying COLLATE pg_catalog."default",
    last_name character varying COLLATE pg_catalog."default",
    address character varying COLLATE pg_catalog."default",
    phone_number character varying COLLATE pg_catalog."default",
    CONSTRAINT user_account_pkey PRIMARY KEY (user_id)
)


CREATE TABLE public.user_credentials
(
    user_credentials_id integer NOT NULL DEFAULT nextval('user_credentials_user_credentials_id_seq'::regclass),
    user_id integer,
    username character varying COLLATE pg_catalog."default",
    password character varying COLLATE pg_catalog."default",
    CONSTRAINT user_credentials_pkey PRIMARY KEY (user_credentials_id),
    CONSTRAINT fk_user FOREIGN KEY (user_id)
        REFERENCES public.user_account (user_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)


CREATE TABLE public.cinema_hall
(
    hall_id integer NOT NULL DEFAULT nextval('cinema_hall_hall_id_seq'::regclass),
    hall_name character varying COLLATE pg_catalog."default" NOT NULL,
    total_seats integer NOT NULL,
    is_active integer DEFAULT 0,
    CONSTRAINT cinema_hall_pkey PRIMARY KEY (hall_id)
)


CREATE TABLE public.movie_data
(
    movie_id integer NOT NULL DEFAULT nextval('movie_data_movie_id_seq'::regclass),
    movie_name character varying COLLATE pg_catalog."default",
    movie_language character varying COLLATE pg_catalog."default",
    actor character varying COLLATE pg_catalog."default",
    actress character varying COLLATE pg_catalog."default",
    director character varying COLLATE pg_catalog."default",
    special_characters character varying COLLATE pg_catalog."default",
    is_active integer,
    CONSTRAINT movie_data_pkey PRIMARY KEY (movie_id)
)



CREATE TABLE public.movie_show_data
(
    movie_show_id integer NOT NULL DEFAULT nextval('movie_show_data_movie_show_id_seq'::regclass),
    movie_id integer,
    hall_id integer,
    show_date_time timestamp without time zone,
    is_active integer,
    CONSTRAINT movie_show_data_pkey PRIMARY KEY (movie_show_id),
    CONSTRAINT movie_show_data_hall_id_fkey FOREIGN KEY (hall_id)
        REFERENCES public.cinema_hall (hall_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT movie_show_data_movie_id_fkey FOREIGN KEY (movie_id)
        REFERENCES public.movie_data (movie_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)



CREATE TABLE public.movie_reservation
(
    movie_reservation_id integer NOT NULL DEFAULT nextval('movie_reservation_movie_reservation_id_seq'::regclass),
    movie_show_id integer,
    user_id integer,
    no_of_seats_reserving integer,
    is_active integer,
    is_booked integer,
    CONSTRAINT movie_reservation_pkey PRIMARY KEY (movie_reservation_id),
    CONSTRAINT movie_reservation_movie_show_id_fkey FOREIGN KEY (movie_show_id)
        REFERENCES public.movie_show_data (movie_show_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT movie_reservation_user_id_fkey FOREIGN KEY (user_id)
        REFERENCES public.user_account (user_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)



CREATE TABLE public.seat_reservation
(
    seat_reservation_id integer NOT NULL DEFAULT nextval('seat_reservation_seat_reservation_id_seq'::regclass),
    movie_reservation_id integer,
    seat_number integer,
    CONSTRAINT seat_reservation_pkey PRIMARY KEY (seat_reservation_id),
    CONSTRAINT seat_reservation_movie_reservation_id_fkey FOREIGN KEY (movie_reservation_id)
        REFERENCES public.movie_reservation (movie_reservation_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)


CREATE TABLE public.movie_booking_data
(
    movie_booking_id integer NOT NULL DEFAULT nextval('movie_booking_data_movie_booking_id_seq'::regclass),
    movie_reservation_id integer,
    payment_status boolean,
    CONSTRAINT movie_booking_data_pkey PRIMARY KEY (movie_booking_id),
    CONSTRAINT movie_booking_data_movie_reservation_id_fkey FOREIGN KEY (movie_reservation_id)
        REFERENCES public.movie_reservation (movie_reservation_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)



