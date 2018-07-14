package com.mdevi.examshell.service;


import com.mdevi.examshell.model.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;

import java.util.Locale;
import java.util.Optional;
import java.util.Scanner;

/**
 * This class represents service for student enrollment before attend test exam.
 *
 * @author Sergei Belonosov
 * @since 14.07.2018
 */
public class StudentEnrollmentImpl implements StudentEnrollment {
    private final Logger LOGGER = LoggerFactory.getLogger(StudentEnrollmentImpl.class);
    private Student student;
    private MessageSource messageSource;
    private Optional<String> localeString;

    public StudentEnrollmentImpl(Optional<String> localeString, MessageSource messageSource) {
        this.student = new Student();
        this.localeString = localeString;
        this.messageSource = messageSource;
    }


    public Student enrollStudent() {
        Locale locale;
        if (localeString.isPresent()) {
            locale = Locale.forLanguageTag(localeString.get());
        } else {
            locale = Locale.getDefault();
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("-------------------------------");
        System.out.println(messageSource.getMessage("app.student.enrollment.welcome", new String[]{}, locale));
        System.out.println(messageSource.getMessage("app.student.enrollment.enter.firstName", new String[]{}, locale));
        String firstName = sc.nextLine();
        System.out.println(messageSource.getMessage("app.student.enrollment.enter.lastName", new String[]{}, locale));
        String lastName = sc.nextLine();
        if (!("".equals(firstName)) && !("".equals(lastName))) {
            student.setFirstName(firstName);
            student.setLastName(lastName);
            // LOGGER.info("The new student is enrolled: " + student.toString());
            return student;
        } else {
            LOGGER.error("Wrong data has been entered.");
            return null;
        }
    }
}

