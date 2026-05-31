package Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/*
 * CAMBIO: La controladoraMenu de Swing configuraba listeners en botones JButton.
 * Ahora @Controller mapea URLs a métodos Java, y cada método devuelve el nombre
 * de un template HTML (Thymeleaf lo busca en src/main/resources/templates/).
 *
 * En Swing:  buttonCrear.addActionListener(e -> abrirCrearActa())  → abre un JFrame
 * En Spring: @GetMapping("/actas/nueva")                           → devuelve template HTML
 */
@Controller
public class MenuController {

    // Redirige la raíz al menú
    @GetMapping("/")
    public String home() {
        return "redirect:/menu";
    }

    @GetMapping("/menu")
    public String menu() {
        // Retorna el nombre del template: src/main/resources/templates/menu.html
        return "menu";
    }
}
