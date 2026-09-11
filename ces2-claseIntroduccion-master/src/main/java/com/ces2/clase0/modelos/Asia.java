package com.ces2.clase0.modelos;

public class Asia implements IContinente {
    private Region region;
    public Asia(Region region) { this.region = region; }
    
    @Override public Region getRegion() { return region; }
    @Override public String obtenerNombre(Region r) { return "Asia - " + r.getNombre(); }
    @Override public String describirClima(Region r) { return "Clima: " + r.getClima(); }
    @Override public String mencionarCuriosidad(Region r) { return "Dato: " + r.getDetalle(); }
}