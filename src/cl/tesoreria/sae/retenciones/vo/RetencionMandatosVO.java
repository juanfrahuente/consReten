package cl.tesoreria.sae.retenciones.vo; 

public class RetencionMandatosVO { 
    
  private String mandatoId;
  private String folio;
  private String observacion;
  private String fechMandato;
  private String personaId;
  private String rut;
  private String dv;
  private String nombre;
  private String appPat;
  private String appMat;
  private String numOficio;
  private String oficioYear;
  private String retenYear;
  private String monto;
  private String porcentaje;
  private String repLegal;
  private String grupoEgreso;
  private String tipoPago;
  private String subTipoRet;
  private String moneda;
  private String estado;
  private String numeroCta;
  private String tipoCta;
  private String banco;

  public String getNumeroCta() {
    return numeroCta;
  }

  public String getTipoCta() {
    return tipoCta;
  }

  public String getBanco() {
    return banco;
  }

  public void setNumeroCta(String numeroCta) {
    this.numeroCta = numeroCta;
  }

  public void setTipoCta(String tipoCta) {
    this.tipoCta = tipoCta;
  }

  public void setBanco(String banco) {
    this.banco = banco;
  }
  
  public String getMandatoId() {
    return mandatoId;
  }

  public String getRetenYear() {
    return retenYear;
  }

  public void setRetenYear(String arg) {
    this.retenYear = arg;
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

  public String getSubTipoRet() {
    return subTipoRet;
  }

  public String getFolio() {
    return folio;
  }

  public String getGrupoEgreso() {
    return grupoEgreso;
  }

  public String getEstado() {
    return estado;
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

  public String getFechMandato() {
    return fechMandato;
  }

  public String getPersonaId() {
    return personaId;
  }

  public String getMonto() {
    return monto;
  }

  public String getPorcentaje() {
    return porcentaje;
  }

  public String getRepLegal() {
    return repLegal;
  }

  public void setMandatoId(String mandatoId) {
    this.mandatoId = mandatoId;
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

  public void setSubTipoRet(String subTipoRet) {
    this.subTipoRet = subTipoRet;
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

  public void setFechMandato(String fechMandato) {
    this.fechMandato = fechMandato;
  }

  public void setPersonaId(String personaId) {
    this.personaId = personaId;
  }

  public void setMonto(String monto) {
    this.monto = monto;
  }

  public void setPorcentaje(String porcentaje) {
    this.porcentaje = porcentaje;
  }

  public void setRepLegal(String repLegal) {
    this.repLegal = repLegal;
  }    
} 
