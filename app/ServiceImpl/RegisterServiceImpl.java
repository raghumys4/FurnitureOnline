package ServiceImpl;

import DaoImpl.RegisterDaoImpl;
import Entity.register;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Service.RegisterService;

import javax.inject.Inject;


@Service
public class RegisterServiceImpl implements RegisterService {

    @com.google.inject.Inject
    private RegisterDaoImpl registerDao;

    @Override
    public void saveRegistrationDetails(register registrationdetailsEntity) {
        registerDao.saveRegisterationDetails(registrationdetailsEntity);
//        return null;
    }
}
