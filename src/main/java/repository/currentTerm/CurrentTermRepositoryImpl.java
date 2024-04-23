package repository.currentTerm;

import base.repository.BaseRepositoryImpl;
import conncetion.SessionFactorySingleton;
import model.Current;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class CurrentTermRepositoryImpl extends BaseRepositoryImpl<Current, Long>
        implements CurrentTermRepository {
    public CurrentTermRepositoryImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Class<Current> getEntityClass() {
        return Current.class;
    }

    @Override
    public List<Current> findAllCurrentTerms() {
        String hql = "FROM Current ";
        Session session = SessionFactorySingleton.getInstance().openSession();
        Query<Current> query = session.createQuery(hql);
        List<Current> currents = query.list();
        session.close();
        return currents;
    }
}
