package com.ces2.clase0.controladores;

import com.ces2.clase0.modelos.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ContinenteController {

    @GetMapping("/continentes")
    public String mostrarContinentes(Model model) {
        List<IContinente> listaContinentes = new ArrayList<>();

        // Objetos América
        listaContinentes.add(new America(new Region("Norteamérica", "Templado", "Tiene el Gran Cañón")));
        listaContinentes.add(new America(new Region("Centroamérica", "Tropical", "Canal de Panamá")));
        listaContinentes.add(new America(new Region("Sudamérica", "Variado", "Selva Amazónica")));

        // Objetos Europa
        listaContinentes.add(new Europa(new Region("Occidental", "Oceánico", "Revolución Industrial")));
        listaContinentes.add(new Europa(new Region("Del Este", "Continental", "Castillos medievales")));
        listaContinentes.add(new Europa(new Region("Nórdica", "Subártico", "Auroras boreales")));

        // Objetos Asia
        listaContinentes.add(new Asia(new Region("Oriental", "Subtropical", "Gran Muralla")));
        listaContinentes.add(new Asia(new Region("Sudeste", "Tropical", "Miles de islas")));
        listaContinentes.add(new Asia(new Region("Medio Oriente", "Árido", "Punto de encuentro")));

        model.addAttribute("continentes", listaContinentes);
        return "vistaContinentes"; 
    }
}