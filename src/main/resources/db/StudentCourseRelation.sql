-- 创建表
CREATE TABLE StudentCourseRelation (
                                       id INT AUTO_INCREMENT PRIMARY KEY,
                                       student_id VARCHAR(32) NOT NULL,
                                       courseId VARCHAR(32)  NOT NULL,
                                       create_by VARCHAR(255),
                                       create_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                       update_by VARCHAR(255),
                                       update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                                       INDEX idx_studentId (studentId),
                                       INDEX idx_courseId (courseId)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;