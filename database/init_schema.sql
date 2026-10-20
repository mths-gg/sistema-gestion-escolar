-- ==============================================================================
-- Proyecto: Sistema de Gestión Escolar (SGE) - SENA
-- Autor: David Mauricio Toro Cuéllar (Grupo 07)
-- Descripción: Script DDL en 3FN para la creación del esquema y datos de prueba.
-- ==============================================================================

CREATE DATABASE IF NOT EXISTS school_management;
USE school_management;

-- 1. Entidad: students (Estudiantes)
CREATE TABLE students (
    student_id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    date_of_birth DATE NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- 2. Entidad: teachers (Profesores)
CREATE TABLE teachers (
    teacher_id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    specialty VARCHAR(100) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- 3. Entidad: courses (Cursos/Materias)
-- 3FN: El curso depende de su ID. Tiene un profesor asignado.
CREATE TABLE courses (
    course_id INT AUTO_INCREMENT PRIMARY KEY,
    course_name VARCHAR(100) NOT NULL,
    description TEXT,
    credits INT NOT NULL CHECK (credits > 0),
    teacher_id INT,
    FOREIGN KEY (teacher_id) REFERENCES teachers(teacher_id) ON DELETE SET NULL
);

-- 4. Entidad: enrollments (Matrículas)
-- Rompe la relación Muchos a Muchos entre students y courses.
CREATE TABLE enrollments (
    enrollment_id INT AUTO_INCREMENT PRIMARY KEY,
    student_id INT NOT NULL,
    course_id INT NOT NULL,
    enrollment_date DATE NOT NULL,
    status VARCHAR(20) DEFAULT 'ACTIVE',
    FOREIGN KEY (student_id) REFERENCES students(student_id) ON DELETE CASCADE,
    FOREIGN KEY (course_id) REFERENCES courses(course_id) ON DELETE CASCADE,
    UNIQUE (student_id, course_id) -- Regla de negocio: Un estudiante no puede matricularse 2 veces en el mismo curso
);

-- 5. Entidad: grades (Calificaciones)
-- 3FN: La nota depende exclusivamente de la matrícula (student + course).
CREATE TABLE grades (
    grade_id INT AUTO_INCREMENT PRIMARY KEY,
    enrollment_id INT NOT NULL,
    grade_value DECIMAL(3, 2) NOT NULL CHECK (grade_value >= 0.00 AND grade_value <= 5.00),
    observation VARCHAR(255),
    graded_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (enrollment_id) REFERENCES enrollments(enrollment_id) ON DELETE CASCADE
);

-- ==============================================================================
-- INSERCIÓN DE DATOS DE PRUEBA (DUMMY DATA) PARA LA AUDITORÍA
-- ==============================================================================

INSERT INTO students (first_name, last_name, email, date_of_birth) VALUES
('Ana', 'Martinez', 'ana.martinez@email.com', '2005-04-15'),
('Luis', 'Ramirez', 'luis.ramirez@email.com', '2004-11-22');

INSERT INTO teachers (first_name, last_name, email, specialty) VALUES
('Carlos', 'Cadena', 'ccadena@sena.edu.co', 'Ingeniería de Software'),
('Martha', 'Gomez', 'mgomez@sena.edu.co', 'Bases de Datos');

INSERT INTO courses (course_name, description, credits, teacher_id) VALUES
('Programación POO', 'Fundamentos de Java', 4, 1),
('Diseño Relacional', 'Normalización y SQL', 3, 2);

INSERT INTO enrollments (student_id, course_id, enrollment_date) VALUES
(1, 1, '2026-10-19'),
(2, 2, '2026-10-19');

INSERT INTO grades (enrollment_id, grade_value, observation) VALUES
(1, 4.50, 'Excelente lógica'),
(2, 4.80, 'Modelo 3FN impecable');
