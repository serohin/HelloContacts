--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.9
-- Dumped by pg_dump version 9.5.9

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: contacts; Type: TABLE; Schema: public; Owner: kamazz
--

CREATE TABLE contacts (
    id bigint NOT NULL,
    name character varying(50) NOT NULL
);


ALTER TABLE contacts OWNER TO kamazz;

--
-- Name: contacts_id_seq; Type: SEQUENCE; Schema: public; Owner: kamazz
--

CREATE SEQUENCE contacts_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE contacts_id_seq OWNER TO kamazz;

--
-- Name: contacts_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: kamazz
--

ALTER SEQUENCE contacts_id_seq OWNED BY contacts.id;


--
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: public; Owner: kamazz
--

CREATE SEQUENCE hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE hibernate_sequence OWNER TO kamazz;

--
-- Name: id; Type: DEFAULT; Schema: public; Owner: kamazz
--

ALTER TABLE ONLY contacts ALTER COLUMN id SET DEFAULT nextval('contacts_id_seq'::regclass);


--
-- Data for Name: contacts; Type: TABLE DATA; Schema: public; Owner: kamazz
--

COPY contacts (id, name) FROM stdin;
8	Aaron
9	Abbott
10	Abel
11	Abraham
12	Adam
13	Addison
14	Adler
15	Adrian
16	Aedan
17	Alan
18	Alastair
19	Albern
20	Albert
21	Albion
22	Alden
23	Aldis
24	Aldrich
25	Alexander
26	Alfie
27	Alfred
28	Barnaby
29	Barrett
30	Brandan
31	Caldwell
32	Cedric
33	Calvin
34	Dale
35	Darell
36	Dylan
37	Eaton
38	Emmanuel
39	Freeman
40	Fletcher
41	Albion
42	Barclay
43	Barry
44	Bruce
45	Carrick
46	Chester
47	Clive
48	Dalton
49	Dennis
50	Dixon
51	Elbert
52	Elvis
53	Frank
54	Ferris
55	Farrell
56	Baldwin
57	Benedict
58	Bevis
59	Carroll
60	Christian
61	Conan
62	Damon
63	Douglas
64	Delmar
65	Eldon
66	Edan
67	Frederick
68	Felix
69	Floyd
70	Baird
71	Bernard
72	Burton
73	Casper
74	Christopher
75	Curtis
76	Darian
77	Dwayne
78	Denley
79	Eliot
80	Fergus
81	Fabian
82	Foster
83	Francis
7	Michel
1	Nick
2	John
3	Ann
4	Marry
5	Marcus
6	Maria
\.


--
-- Name: contacts_id_seq; Type: SEQUENCE SET; Schema: public; Owner: kamazz
--

SELECT pg_catalog.setval('contacts_id_seq', 84, true);


--
-- Name: hibernate_sequence; Type: SEQUENCE SET; Schema: public; Owner: kamazz
--

SELECT pg_catalog.setval('hibernate_sequence', 1, false);


--
-- Name: contacts_pkey; Type: CONSTRAINT; Schema: public; Owner: kamazz
--

ALTER TABLE ONLY contacts
    ADD CONSTRAINT contacts_pkey PRIMARY KEY (id);


--
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- PostgreSQL database dump complete
--

