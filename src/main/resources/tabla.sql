create TABLE personas (
                          id BIGSERIAL PRIMARY KEY,
                          password TEXT NOT NULL,
                          company_email TEXT NOT NULL,
                          personal_email TEXT ,
                          city TEXT ,
                          active BOOLEAN,
                          created_Date DATE NOT NULL,
                          imagen_url TEXT,
                          termination_Date DATE,
                          unique (company_email)
)