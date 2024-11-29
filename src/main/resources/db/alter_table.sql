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

