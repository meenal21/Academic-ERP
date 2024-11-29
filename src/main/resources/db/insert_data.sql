INSERT INTO students (student_id,
                      roll_number,
                      first_name,
                      last_name,
                      email,
                      cgpa,
                      total_credits,
                      graduation_year,
                      domain,
                      specialisation,
                      placement_id
)
VALUES
    (1,'MT2024144', 'Mrunmayi', 'Shirke', 'mrun@example.com',9.6, 16, '2026', 1,1,1),
    (2,'MT2024150', 'Shubhi', 'Kesarwani', 'shubhi.kesarwani@example.com', 9.0, 16, '2026',2,2,2),
    (3,'MT2024088', 'Meenal', 'Jain', 'meenal.jain@iiitb.ac.in',9.6, 16, '2026',1,1,1),
    (4,'MT2024072', 'Jyoti', 'Singh', 'jyoti.singh@iiitb.ac.in',9.6, 16, '2026',2,2,2);


INSERT INTO domain (domain_id, program, batch, capacity, qualification)
VALUES
    (1,'Computer Science','MTech', 150,'BTech'),
    (2,'Electronics and Communication','MTech', 30, 'BTech');

INSERT INTO specialisation(specialisation.specialisation_id,name, code, description, credits_required)
VALUES
    (1,'AI & ML','AIML', 'Artificial Intelligence and Machine Learning', 16),
    (2,'Core CS','CSE', 'Core Computer Science', 16);


INSERT INTO placement (id,organisation, profile, description, intake, minimum_grade)
VALUES
    (1,'Google','Research','Researcher Role in Machine Learning', 5, 3.6),
    (2,'OpenAI','Research','LLM Research', 3, 3.8);
