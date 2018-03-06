package cl.tesoreria.sae.retenciones.vo; 

public class PersonaVO { 
    
  private String nombre;
  private String appPat;
  private String appMat;

  public String getNombre() {
    return nombre;
  }

  public String getAppPat() {
    return appPat;
  }

  public String getAppMat() {
    return appMat;
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
} 
