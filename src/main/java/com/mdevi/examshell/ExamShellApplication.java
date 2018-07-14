package com.mdevi.examshell;

import com.mdevi.examshell.model.Question;
import com.mdevi.examshell.service.StudentEnrollment;
import com.mdevi.examshell.service.StudentEnrollmentImpl;
import com.mdevi.examshell.service.TestQuestionsLoader;
import com.mdevi.examshell.service.TestQuestionsLoaderImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ResourceBundleMessageSource;

import java.util.Optional;

@SpringBootApplication
public class ExamShellApplication {

    @Value("${app.questions.csv.file}")
    private String csvFileName;
    @Value("${app.locale.string}")
    private String localeString;

    @Bean
    public static PropertySourcesPlaceholderConfigurer placeHolderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public StudentEnrollment studentEnrollment() {
        StudentEnrollment studentEnrollment =
                new StudentEnrollmentImpl(Optional.ofNullable(localeString), messageSource());
        return studentEnrollment;
    }

    // This bean has being declared within proper class.
/*    @Bean
    public TestProcessor testProcessor() {
        TestProcessor testProcessor =
                new TestProcessorImpl(studentEnrollment(),testQuestionsLoader(),messageSource(),Optional.ofNullable(localeString));
        return testProcessor;
    }*/

    @Bean
    public TestQuestionsLoader testQuestionsLoader() {
        TestQuestionsLoaderImpl loader =
                new TestQuestionsLoaderImpl(Optional.ofNullable(localeString));
        loader.setFileName(csvFileName);
        loader.setType(Question.class);
        return loader;
    }

    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages");
        messageSource.setDefaultEncoding("UTF-8");
        messageSource.setFallbackToSystemLocale(false);
        return messageSource;
    }

    public static void main(String[] args) {
        SpringApplication.run(ExamShellApplication.class, args);
    }
}
