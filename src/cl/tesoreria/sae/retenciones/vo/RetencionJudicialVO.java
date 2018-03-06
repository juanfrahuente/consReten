package cl.tesoreria.sae.retenciones.vo; 

public class RetencionJudicialVO { 
    
  private String juducialId;
  private String estado;
  private String causal;
  private String rol;
  private String numOficio;
  private String oficioYear;
  private String grupoEgreso;
  private String retenYear;
  private String monto;
  private String moneda;
  private String porcentaje;
  private String juzgado;
  private String tipoPago;
  private String observacion;
  private String folio;
 
  public String getFolio() {
    return folio;
  }

  public String getGrupoEgreso() {
    return grupoEgreso;
  }

  public String getEstado() {
    return estado;
  }

  public String getRetenYear() {
    return retenYear;
  }

  public String getMoneda() {
    return moneda;
  }

  public String getNumOficio() {
    return numOficio;
  }

  public String getOficioYear() {
    return oficioYear;
  }

  public String getTipoPago() {
    return tipoPago;
  }

  public String getObservacion() {
    return observacion;
  }

  public String getMonto() {
    return monto;
  }

  public String getPorcentaje() {
    return porcentaje;
  }

  public String getJuducialId() {
    return juducialId;
  }

  public String getCausal() {
    return causal;
  }

  public String getRol() {
    return rol;
  }

  public String getJuzgado() {
    return juzgado;
  }

  public void setFolio(String folio) {
    this.folio = folio;
  }

  public void setGrupoEgreso(String grupoEgreso) {
    this.grupoEgreso = grupoEgreso;
  }

  public void setEstado(String estado) {
    this.estado = estado;
  }

  public void setRetenYear(String retenYear) {
    this.retenYear = retenYear;
  }

  public void setMoneda(String moneda) {
    this.moneda = moneda;
  }

  public void setNumOficio(String numOficio) {
    this.numOficio = numOficio;
  }

  public void setOficioYear(String oficioYear) {
    this.oficioYear = oficioYear;
  }

  public void setTipoPago(String tipoPago) {
    this.tipoPago = tipoPago;
  }

  public void setObservacion(String observacion) {
    this.observacion = observacion;
  }

  public void setMonto(String monto) {
    this.monto = monto;
  }

  public void setPorcentaje(String porcentaje) {
    this.porcentaje = porcentaje;
  }

  public void setJuducialId(String juducialId) {
    this.juducialId = juducialId;
  }

  public void setCausal(String causal) {
    this.causal = causal;
  }

  public void setRol(String rol) {
    this.rol = rol;
  }

  public void setJuzgado(String juzgado) {
    this.juzgado = juzgado;
  }    
} 
