import DAO.Impl.*;
import Entity.*;
import Utils.EntityFactoryManager;

import java.util.List;
import java.util.Set;

public class App {


    public static void main(String[] args) {
        EntityDaoCompanyImpl daoCompany = new EntityDaoCompanyImpl();

        Company company = Company.builder()
                .name("Soft")
                .companySize("50")
                .typeCompany("Startup")
                .build();

        Company company1 = Company.builder()
                .name("iTech")
                .companySize("150")
                .typeCompany("Product")
                .build();

        daoCompany.save(company);
        daoCompany.save(company1);

        EntityDaoLocationImpl daoLocation = new EntityDaoLocationImpl();

        Location location = Location.builder()
                .country("Belarus")
                .city("Minsk")
                .build();
        Location location1 = Location.builder()
                .country("Georgia")
                .city("Batumi")
                .build();
        Location location2 = Location.builder()
                .country("Turkey")
                .city("Istanbul")
                .build();

        daoLocation.save(location);
        daoLocation.save(location1);
        daoLocation.save(location2);

        EntityDaoVacancyImpl daoVacancy = new EntityDaoVacancyImpl();

        Vacancy vacancy = Vacancy.builder()
                .description("Business Analyst")
                .workingTime("Full-time")
                .build();

        Vacancy vacancy1 = Vacancy.builder()
                .description("Test")
                .workingTime("Telework")
                .build();

        Vacancy vacancy2 = Vacancy.builder()
                .description("Developer")
                .workingTime("Part-time")
                .build();

        Vacancy vacancy3 = Vacancy.builder()
                .description("Developer")
                .workingTime("Telework")
                .build();

        daoVacancy.save(vacancy);
        daoVacancy.save(vacancy1);
        daoVacancy.save(vacancy2);
        daoVacancy.save(vacancy3);

        vacancy.setLocations(daoLocation.findId(1));
        vacancy1.setLocations(daoLocation.findId(1));
        vacancy2.setLocations(daoLocation.findId(2));
        vacancy3.setLocations(daoLocation.findId(3));

        daoVacancy.update(vacancy);
        daoVacancy.update(vacancy1);
        daoVacancy.update(vacancy2);
        daoVacancy.update(vacancy3);


        EntityDaoSpecializationImpl daoSpecialization = new EntityDaoSpecializationImpl();

        Specialization specialization = Specialization.builder()
                .profession("Java")
                .professionLevel("Middle")
                .languageLevel("B2")
                .experience("5 years develop")
                .salary("4000$")
                .build();

        Specialization specialization1 = Specialization.builder()
                .profession("QA")
                .professionLevel("Team Lead")
                .languageLevel("C1")
                .experience("10 years QA")
                .salary("5000$")
                .build();

        Specialization specialization2 = Specialization.builder()
                .profession("Business Analyst")
                .professionLevel("Junior")
                .languageLevel("B2")
                .experience("2 years")
                .salary("2000$")
                .build();

        Specialization specialization3 = Specialization.builder()
                .profession("Java")
                .professionLevel("Junior")
                .languageLevel("A2")
                .experience("1 years ")
                .salary("500$")
                .build();

        daoSpecialization.save(specialization);
        daoSpecialization.save(specialization1);
        daoSpecialization.save(specialization2);
        daoSpecialization.save(specialization3);


        EntityDaoCourseImpl daoCourse = new EntityDaoCourseImpl();

        Course course = Course.builder()
                .description("Java Core")
                .dateStart("22.04.2020")
                .dateFinish("22.07.2020")
                .build();

        daoCourse.save(course);
        course.setLocation(location2);
        daoCourse.update(course);


        EntityDaoTechnologyImpl daoTechnology = new EntityDaoTechnologyImpl();

        Technology technology = Technology.builder()
                .technology("Hibernate")
                .build();

        Technology technology1 = Technology.builder()
                .technology("Java Core")
                .build();

        Technology technology2 = Technology.builder()
                .technology("Spring Boot")
                .build();

        daoTechnology.save(technology);
        daoTechnology.save(technology1);
        daoTechnology.save(technology2);

        specialization.setTechnology(List.of(technology, technology1, technology2));
        specialization3.setTechnology(List.of(technology, technology1, technology2));

        specialization.setVacancy(daoVacancy.findId(1));


        specialization1.setVacancy(daoVacancy.findId(2));


        specialization2.setVacancy(daoVacancy.findId(3));


        specialization3.setVacancy(daoVacancy.findId(4));


        daoSpecialization.update(specialization);
        daoSpecialization.update(specialization1);
        daoSpecialization.update(specialization2);
        daoSpecialization.update(specialization3);


        company.setVacancySet(Set.of(daoVacancy.findId(1), daoVacancy.findId(2), daoVacancy.findId(3)));
        company1.setVacancySet(Set.of(daoVacancy.findId(4)));

        company.setCourseSet(Set.of(daoCourse.findId(1)));

        daoCompany.update(company1);
        daoCompany.update(company);

        System.out.println(daoCompany.findAll());
        System.out.println(daoLocation.findAll());
        System.out.println(daoSpecialization.findAll());
        System.out.println(daoVacancy.findAll());
        System.out.println(daoTechnology.findAll());

        EntityFactoryManager.close();
    }
}
