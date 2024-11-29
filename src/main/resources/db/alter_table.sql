ALTER TABLE students
    ADD COLUMN domain BIGINT;


ALTER TABLE students
    ADD CONSTRAINT FK_studentDomain
        FOREIGN KEY (domain) REFERENCES domain(domain_id)
            ON DELETE RESTRICT;

ALTER TABLE students
    ADD COLUMN placement_id INT;

ALTER TABLE students
    ADD CONSTRAINT FK_studentPlacement
        FOREIGN KEY (placement_id) REFERENCES placement(id)
            ON DELETE RESTRICT ;


ALTER TABLE students
    ADD COLUMN specialisation BIGINT;

ALTER TABLE students
    ADD CONSTRAINT FK_studentSpecialisation
        FOREIGN KEY (specialisation) REFERENCES specialisation(specialisation_id)
            ON DELETE RESTRICT ;

ALTER TABLE education
    ADD CONSTRAINT FK_education_student
        FOREIGN KEY (student_id) REFERENCES students(student_id)
            ON DELETE CASCADE;

INSERT INTO education (id,
    student_id,
    education_type,
    percentage,
    year,
    school_name
)
VALUES (1,
           1,              -- student_id from the students table
           '10th Grade',   -- education_type (must be unique per student)
           '85%',          -- percentage
           '2015',         -- year
           'ABC High School' -- school_name
       );

INSERT INTO education (id,
                       student_id,
                       education_type,
                       percentage,
                       year,
                       school_name
)
VALUES (2,
        1,              -- student_id from the students table
        '12th Grade',   -- education_type (must be unique per student)
        '95%',          -- percentage
        '2017',         -- year
        'DEF Clg' -- school_name
       );

INSERT INTO education (id,
                       student_id,
                       education_type,
                       percentage,
                       year,
                       school_name
)
VALUES (3,
        2,              -- student_id from the students table
        '10th Grade',   -- education_type (must be unique per student)
        '75%',          -- percentage
        '2016',         -- year
        'DEF Clg' -- school_name
       );

