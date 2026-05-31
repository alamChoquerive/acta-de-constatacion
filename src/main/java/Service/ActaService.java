package Service;

import Model.ActaDeConstatacion;

import java.util.List;
import java.util.Optional;

public interface ActaService {
    List<ActaDeConstatacion> findAllActas();
    Optional<ActaDeConstatacion> findActaById(int id);
    ActaDeConstatacion saveActa(ActaDeConstatacion acta);
}