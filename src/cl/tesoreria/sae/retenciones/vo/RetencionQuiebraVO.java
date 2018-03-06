package cl.tesoreria.sae.retenciones.vo; 

public class RetencionQuiebraVO { 
    
  private String quiebraId;
  private String folio;
  private String observacion;
  private String fechaIngre;
  private String personaId;
  private String numExpe;
  private String expeYear;
  private String juzgado;
  private String fechaDeclQuie;
  private String fechaDeclaDiarioOfi;
  private String sindicoSuplente;
  private String sindicoTitular;
  private String estado;
  
  public String getEstado() {
    return estado;
  }

  public void setEstado(String estado) {
    this.estado = estado;
  }
  public String getFolio() {
    return folio;
  }

  public String getFechaIngre() {
    return fechaIngre;
  }

  public String getObservacion() {
    return observacion;
  }

  public String getJuzgado() {
    return juzgado;
  }

  public String getNumExpe() {
    return numExpe;
  }

  public String getExpeYear() {
    return expeYear;
  }

  public String getQuiebraId() {
    return quiebraId;
  }

  public String getPersonaId() {
    return personaId;
  }

  public String getFechaDeclQuie() {
    return fechaDeclQuie;
  }

  public String getFechaDeclaDiarioOfi() {
    return fechaDeclaDiarioOfi;
  }

  public String getSindicoSuplente() {
    return sindicoSuplente;
  }

  public String getSindicoTitular() {
    return sindicoTitular;
  }

  public void setFolio(String folio) {
    this.folio = folio;
  }

  public void setFechaIngre(String fechaIngre) {
    this.fechaIngre = fechaIngre;
  }

  public void setObservacion(String observacion) {
    this.observacion = observacion;
  }

  public void setJuzgado(String juzgado) {
    this.juzgado = juzgado;
  }

  public void setNumExpe(String numExpe) {
    this.numExpe = numExpe;
  }

  public void setExpeYear(String expeYear) {
    this.expeYear = expeYear;
  }

  public void setQuiebraId(String quiebraId) {
    this.quiebraId = quiebraId;
  }

  public void setPersonaId(String personaId) {
    this.personaId = personaId;
  }

  public void setFechaDeclQuie(String fechaDeclQuie) {
    this.fechaDeclQuie = fechaDeclQuie;
  }

  public void setFechaDeclaDiarioOfi(String fechaDeclaDiarioOfi) {
    this.fechaDeclaDiarioOfi = fechaDeclaDiarioOfi;
  }

  public void setSindicoSuplente(String sindicoSuplente) {
    this.sindicoSuplente = sindicoSuplente;
  }

  public void setSindicoTitular(String sindicoTitular) {
    this.sindicoTitular = sindicoTitular;
  }    
} 
