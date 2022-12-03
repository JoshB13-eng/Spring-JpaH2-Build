
CREATE TABLE FRUIT(
    
    numberOfFruit INT NOT NULL UNIQUE AUTO_INCREMENT,
    
    fileByt Image,
    
    PRIMARY KEY(numberOfFruit)
);

CREATE TABLE APPLE(

    numberOfApple INT NOT NULL UNIQUE AUTO_INCREMENT,
    
    amount INT NOT NULL,
    
    PRIMARY KEY(numberOfApple),
    
    FOREIGN KEY (numberOfApple) REFERENCES FRUIT(numberOfFruit)
);

CREATE TABLE ORANGE(

    numberOfOrange INT NOT NULL UNIQUE AUTO_INCREMENT,
    
    amount INT NOT NULL,
    
    PRIMARY KEY(numberOfOrange),
    
    FOREIGN KEY (numberOfOrange) REFERENCES FRUIT(numberOfFruit)
);

CREATE TABLE LEMON(

    numberOfLemon INT NOT NULL UNIQUE AUTO_INCREMENT,
    
    amount INT NOT NULL,
    
    PRIMARY KEY(numberOfLemon),
    
    FOREIGN KEY (numberOfLemon) REFERENCES FRUIT(numberOfFruit)
);
