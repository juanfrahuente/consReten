package cl.tesoreria.sae.retenciones.vo; 

public class EgresosCuestionadosVO { 
    
  private String egresoQuestId;
  private String folio;
  private String observacion;
  private String fechaIngre;
  private String personaId;
  private String rut;
  private String dv;
  private String nombre;
  private String appPat;
  private String appMat;
  private String tipoForm;
  private String tipoDevo;
  private String estado;
  
  public String getEstado() {
    return estado;
  }

  public void setEstado(String estado) {
    this.estado = estado;
  }  
  
  public String getRut() {
    return rut;
  }

  public String getDv() {
    return dv;
  }

  public String getNombre() {
    return nombre;
  }

  public String getAppPat() {
    return appPat;
  }

  public String getAppMat() {
    return appMat;
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

  public String getPersonaId() {
    return personaId;
  }

  public String getEgresoQuestId() {
    return egresoQuestId;
  }

  public String getTipoForm() {
    return tipoForm;
  }

  public String getTipoDevo() {
    return tipoDevo;
  }

  public void setRut(String rut) {
    this.rut = rut;
  }

  public void setDv(String dv) {
    this.dv = dv;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public void setAppPat(String appPat) {
    this.appPat = appPat;
  }

  public void setAppMat(String appMat) {
    this.appMat = appMat;
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

  public void setPersonaId(String personaId) {
    this.personaId = personaId;
  }

  public void setEgresoQuestId(String egresoQustId) {
    this.egresoQuestId = egresoQustId;
  }

  public void setTipoForm(String tipoForm) {
    this.tipoForm = tipoForm;
  }

  public void setTipoDevo(String tipoDevo) {
    this.tipoDevo = tipoDevo;
  }    
} 
