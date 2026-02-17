-- Create table Work
CREATE TABLE public."Work" (
    id varchar(255) PRIMARY KEY UNIQUE,
    title TEXT NOT NULL,
    description TEXT NOT NULL
);

CREATE INDEX work_title_index ON public."Work"(title);

-- Create table Author
CREATE TABLE public."Author" (
    id varchar(255) PRIMARY KEY UNIQUE,
    name TEXT
);

CREATE INDEX author_name_index ON public."Author"(name);

-- Create table Subject
CREATE TABLE public."Subject" (
    id varchar(255) PRIMARY KEY,
    value TEXT NOT NULL,
    category TEXT NOT NULL,
    CONSTRAINT value_category_unique_constraint UNIQUE(value, category)
);

CREATE INDEX subject_category_index ON public."Subject"(category);
CREATE INDEX subject_value_index ON public."Subject"(value);
CREATE INDEX subject_value_category_index ON public."Subject"(value, category);

-- Create join table WorkAuthor
-- Many-to-many relationship between works and authors
CREATE TABLE public."WorkAuthor" (
    "workId" varchar(255) NOT NULL,
    "authorId" varchar(255) NOT NULL,

    PRIMARY KEY ("workId", "authorId"),

    FOREIGN KEY ("workId") REFERENCES public."Work"(id) ON DELETE CASCADE,
    FOREIGN KEY ("authorId") REFERENCES public."Author"(id) ON DELETE CASCADE
);

-- Create join table WorkSubject
-- Many-to-many relationship between works and subjects
CREATE TABLE public."WorkSubject" (
    "workId" varchar(255) NOT NULL,
    "subjectId" varchar(255) NOT NULL,

    PRIMARY KEY ("workId", "subjectId"),

    FOREIGN KEY ("workId") REFERENCES public."Work"(id) ON DELETE CASCADE,
    FOREIGN KEY ("subjectId") REFERENCES public."Subject"(id) ON DELETE CASCADE
);