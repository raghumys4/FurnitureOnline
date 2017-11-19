package DaoImpl;


import Dao.RegisterDao;
import Entity.register;
//import com.FurnitureOnline.bo.RegisterBo;
//import com.FurnitureOnline.dao.RegisterDao;
//import net.sf.ehcache.hibernate.HibernateUtil;
//import com.FurnitureOnline.utility.HibernateUtil;
import com.Furnitue.Utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.annotations.NamedQuery;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RegisterDaoImpl implements RegisterDao{
    @Override
    public void saveRegisterationDetails(register registrationdetailsEntity) {
        HibernateUtils hibernateUtils=HibernateUtils.getInstance();
        SessionFactory sessionFactory=hibernateUtils.getSessionFactory();
        Session session=sessionFactory.openSession();
        Transaction tx=session.beginTransaction();
        session.save(registrationdetailsEntity);
        tx.commit();
        session.close();

    }

}
