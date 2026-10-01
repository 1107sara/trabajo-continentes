package com.ces2.clase0.modelo;
import java.util.List;

public interface IContinente extends INombre, IClima, ICuriosidad {
    String getNombre();
    List<Region> getRegiones();
}