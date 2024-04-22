package service.reportcard;

import base.service.BaseServiceImpl;
import jakarta.persistence.NoResultException;
import model.ReportCard;
import org.hibernate.SessionFactory;
import repository.reportCard.ReportCardRepository;
import java.util.List;

public class ReportCardServiceImpl extends BaseServiceImpl<ReportCard, Long, ReportCardRepository> implements ReportCardService {
    public ReportCardServiceImpl(ReportCardRepository repository, SessionFactory sessionFactory) {
        super(repository, sessionFactory);
    }

    @Override
    public List<ReportCard> reportCards(Long id) throws NoResultException {
        return repository.reportCards(id);
    }

    @Override
    public List<ReportCard> reportCardsStudent(Long id) throws NoResultException {
        return repository.reportCardsStudent(id);
    }
}
