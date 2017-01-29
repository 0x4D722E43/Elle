package progettoelle.registrazionevoti.services;

import progettoelle.registrazionevoti.domain.Professor;
import progettoelle.registrazionevoti.repositories.DataLayerException;
import progettoelle.registrazionevoti.repositories.UserRepository;

public class UpdateProfessorInfoService {
    
    private final UserRepository userRepository;

    public UpdateProfessorInfoService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void updateProfessorInfo(Professor professor, String officeLocation, String officeHours, String websiteLink) throws DataLayerException {
        professor.setOfficeLocation(officeLocation);
        professor.setOfficeHours(officeHours);
        professor.setWebsiteLink(websiteLink);
        userRepository.updateUser(professor);
    }
    
}
