CREATE TABLE dp_user (
    user_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    role VARCHAR(20) DEFAULT 'USER',
    email VARCHAR(100) NOT NULL,
    password VARCHAR(100) NOT NULL,
    gender VARCHAR(10) NOT NULL,
    created_at DATETIME DEFAULT NOW() NOT NULL,
    updated_at DATETIME,
    UNIQUE (email)
);

CREATE TABLE dp_content (
    content_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    store_name VARCHAR(255),
    contents TEXT,
    eat_Menu VARCHAR(255),
    has_receipt INT,
    star_rating INT,
    like_button INT,
    view_count INT DEFAULT 0,
    created_at DATETIME DEFAULT NOW(),
    author_id INT,
    FOREIGN KEY (author_id) REFERENCES dp_user(user_id)
);

CREATE TABLE dp_gather (
    post_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    post_name VARCHAR(255) NOT NULL,
    store_name VARCHAR(255),
    content TEXT,
    desired_attendees INT NOT NULL,
    current_attendees INT DEFAULT 0,
    appointment_time DATETIME,
    created_at DATETIME DEFAULT NOW() NOT NULL,
    updated_at DATETIME,
    author_id INT,
    FOREIGN KEY (author_id) REFERENCES dp_user(user_id)
);

CREATE TABLE dp_gather_comment (
    comment_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    post_id INT NOT NULL,
    user_id INT NOT NULL,
    content TEXT,
    created_at DATETIME DEFAULT NOW() NOT NULL,
    updated_at DATETIME,
    FOREIGN KEY (post_id) REFERENCES dp_gather(post_id),
    FOREIGN KEY (user_id) REFERENCES dp_user(user_id)
);




