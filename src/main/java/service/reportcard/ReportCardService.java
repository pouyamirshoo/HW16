package service.reportcard;

import base.service.BaseService;
import jakarta.persistence.NoResultException;
import model.ReportCard;
import java.util.List;

public interface ReportCardService extends BaseService<ReportCard,Long> {
    List<ReportCard> reportCards(Long id) throws NoResultException;
    List<ReportCard> reportCardsStudent(Long id) throws NoResultException;
}
