CREATE DATABASE IF NOT EXISTS `robert_huaman_api`;
CREATE DATABASE IF NOT EXISTS `robert_huaman_api_acceptance_tests`;

CREATE USER 'root'@'localhost' IDENTIFIED BY 'r0b3r7';
GRANT ALL ON *.* TO 'root'@'%';
