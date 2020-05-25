CREATE TABLE courses (
  id                  BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  course_id            CHAR(36)            NOT NULL,
  name               VARCHAR(255)          NOT NULL,
  video_id            CHAR(36)            NOT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY u_video_id (video_id),
  FOREIGN KEY (video_id) REFERENCES videos(video_id)
)
DEFAULT CHARSET = utf8mb4;