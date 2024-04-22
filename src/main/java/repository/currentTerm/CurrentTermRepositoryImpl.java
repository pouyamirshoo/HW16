package repository.currentTerm;

import base.repository.BaseRepositoryImpl;
import model.Current;
import org.hibernate.SessionFactory;

public class CurrentTermRepositoryImpl extends BaseRepositoryImpl<Current, Long>
        implements CurrentTermRepository {
    public CurrentTermRepositoryImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Class<Current> getEntityClass() {
        return Current.class;
    }

}
