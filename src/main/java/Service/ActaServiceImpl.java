package Service;

import Model.ActaDeConstatacion;
import Repository.ActaDeConstatacionRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class ActaServiceImpl implements ActaService {
    private final ActaDeConstatacionRepository actaRepo;

    // Inyección por constructor (Sin @Autowired porque Spring lo hace solo si hay un único constructor)
    public ActaServiceImpl(ActaDeConstatacionRepository actaRepo) {
        this.actaRepo = actaRepo;
    }

    @Override
    public List<ActaDeConstatacion> findAllActas() {
        return actaRepo.findAll();
    }

    @Override
    public Optional<ActaDeConstatacion> findActaById(int id) {
        return actaRepo.findById(id);
    }

    @Override
    public ActaDeConstatacion saveActa(ActaDeConstatacion acta) {
        return actaRepo.save(acta);
    }
}
