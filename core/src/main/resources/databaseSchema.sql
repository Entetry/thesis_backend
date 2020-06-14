
CREATE TABLE "vp_trial_plot" (
	"id" serial NOT NULL,
	"leshoz" integer NOT NULL,
	"lesnichestvo" integer NOT NULL,
	"kvartal" varchar(255) NOT NULL,
	"videl" varchar(255) NOT NULL,
	"oblast" integer NOT NULL,
	"rayon" integer NOT NULL,
	"ploshad_probi" DECIMAL NOT NULL,
	"pokrov" integer NOT NULL,
	"position_relief" varchar(255) NOT NULL,
	"osobenosti_drev" varchar(255) NOT NULL,
	"forest_type" integer NOT NULL,
	"tym" integer NOT NULL,
	"pochva" integer NOT NULL,
	"ispolnitel" varchar(255) NOT NULL,
	"plho" integer NOT NULL,
	"poroda" integer NOT NULL,
	CONSTRAINT "vp_trial_plot_pk" PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);

CREATE TABLE "vp_areas" (
	"id" BIGINT GENERATED ALWAYS AS IDENTITY NOT NULL,
	"geom" GEOMETRY ,
	"relascopefactor" DOUBLE PRECISION ,
	"ishalfplotsize" boolean ,
	"num_lch" BIGINT ,
	"photo" TEXT,
	"_db_porod" VARCHAR ,
	"coords" VARCHAR ,
	"vp_trial_plot_id" BIGINT,
	"display_name" VARCHAR,
	CONSTRAINT "vp_areas_pk" PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);


CREATE TABLE "vp_privjazka" (
	"id" serial NOT NULL,
	"id_plot" integer ,
	"number" integer NOT NULL,
	"x" DOUBLE PRECISION NOT NULL,
	"y" DOUBLE PRECISION NOT NULL,
	"az" DOUBLE PRECISION NOT NULL,
	"l" integer NOT NULL,
	"plot_navigation_id" integer,
	"horizontaldistance" DOUBLE PRECISION,
	"slopedistance" DOUBLE PRECISION,
	"bias" integer,
	"pr" integer,
	"ms" integer,
	"rumb" integer,
	"ug" DOUBLE PRECISION,
	"vug" DOUBLE PRECISION,
	CONSTRAINT "vp_privjazka_pk" PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);
ALTER TABLE "vp_privjazka" ADD CONSTRAINT "vp_privjazka_fk0" FOREIGN KEY ("plot_navigation_id") REFERENCES "vp_trial_plot"("id");

CREATE TABLE "vp_poroda" (
	"id" serial NOT NULL,
	"plot_id" integer NOT NULL,
	"poroda" integer NOT NULL,
	"yarus" DECIMAL NOT NULL,
	"pokolenie" varchar(255) NOT NULL,
	"average_age" DECIMAL NOT NULL,
	CONSTRAINT "vp_poroda_pk" PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "vp_perechet" (
	"id" serial NOT NULL,
	"poroda_id" integer NOT NULL,
	"stupen_tolshchiny" DECIMAL NOT NULL,
	"delovyh" DECIMAL NOT NULL,
	"drovyanyh" DECIMAL NOT NULL,
	"suhostoynyh" DECIMAL NOT NULL,
	CONSTRAINT "vp_perechet_pk" PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "vp_height_measure" (
	"id" serial NOT NULL,
	"poroda_id" integer NOT NULL,
	"diameter" DECIMAL NOT NULL,
	"height" DECIMAL NOT NULL,
	CONSTRAINT "vp_height_measure_pk" PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



ALTER TABLE "vp_geodata" ADD CONSTRAINT "vp_geodata_fk0" FOREIGN KEY ("plot_id") REFERENCES "vp_trial_plot"("id");


ALTER TABLE "vp_poroda" ADD CONSTRAINT "vp_poroda_fk0" FOREIGN KEY ("plot_id") REFERENCES "vp_trial_plot"("id");

ALTER TABLE "vp_perechet" ADD CONSTRAINT "vp_perechet_fk0" FOREIGN KEY ("poroda_id") REFERENCES "vp_poroda"("id");

ALTER TABLE "vp_height_measure" ADD CONSTRAINT "vp_height_measure_fk0" FOREIGN KEY ("poroda_id") REFERENCES "vp_poroda"("id");

