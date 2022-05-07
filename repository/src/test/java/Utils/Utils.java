package Utils;

import Constants.*;
import Entity.*;

public class Utils {


    public static Company createCompany() {
        return Company.builder()
                .name(ConstantsCompany.NAME_COMPANY)
                .companySize(ConstantsCompany.SIZE_COMPANY)
                .typeCompany(ConstantsCompany.TYPE_COMPANY)
                .build();
    }

    public static Course createCourse() {
        return Course.builder()
                .description(ConstantsCourse.COURSE_DESCRIPTION)
                .dateStart(ConstantsCourse.DATE_START_COURSE)
                .dateFinish(ConstantsCourse.DATE_FINISH_COURSE)
                .build();
    }

    public static Location creatLocation() {
        return Location.builder()
                .country(ConstantsLocation.LOCATION_COUNTRY)
                .city(ConstantsLocation.LOCATION_CITY)
                .build();
    }

    public static Specialization createSpecialization() {
        return Specialization.builder()
                .profession(ConstantsSpecialization.SPECIALIZATION_PROFESSION)
                .experience(ConstantsSpecialization.SPECIALIZATION_EXPERIENCE)
                .salary(ConstantsSpecialization.SPECIALIZATION_SALARY)
                .professionLevel(ConstantsSpecialization.PROFESSION_LEVEL)
                .languageLevel(ConstantsSpecialization.LANGUAGE_LEVEL)
                .build();
    }

    public static Vacancy createVacancy() {
        return Vacancy.builder()
                .description(ConstantsVacancy.VACANCY_DESCRIPTION)
                .workingTime(ConstantsVacancy.WORKING_TIME)
                .build();

    }

    public static Technology createTechnology() {
        return Technology.builder()
                .technology(ConstantsTechnology.NAME_TECHNOLOGY)
                .build();
    }
}
