package consulta;
import cl.tesoreria.sae.retenciones.delegate.RetencionesDelegate;
import cl.tesoreria.sae.retenciones.vo.PersonaVO;
import cl.tesoreria.utiles.vo.DatosFormatosTablaVO;
import org.apache.beehive.netui.pageflow.FormData;
import org.apache.beehive.netui.pageflow.Forward;
import org.apache.beehive.netui.pageflow.PageFlowController;
import java.util.ArrayList;
import org.apache.beehive.netui.pageflow.annotations.Jpf;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;


/**
 * @jpf:controller
 * @jpf:message-resources resources="messages.Validation"
 *  */
@SuppressWarnings("deprecation")
@Jpf.Controller(messageBundles = { 
    @Jpf.MessageBundle(bundlePath = "messages.Validation")
})
public class ConsultaController extends PageFlowController
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger("cl.tesoreria.egresos.consultaretenciones.consultacontroller");
	/*
	 * inicializamos nuestro begin */
    public BeginForm beginForm = new BeginForm();    
    
	/*
	 * metodo get del begin*/
    public BeginForm getBeginForm() {
    	return this.beginForm;
    }
	/*
	 * metodo set del begin*/
    public void setBeginForm(BeginForm beginForm){
    	this.beginForm = beginForm;
    }
   
    
 
    /**
     * This method represents the point of entry into the pageflow
     * @jpf:action form="beginForm"
     * @jpf:forward name="success" path="RespConsReten.jsp"
     * @jpf:validation-error-forward name="error" path="RespConsReten.jsp"
     */	
    @Jpf.Action(useFormBean = "beginForm", forwards = {
			@Jpf.Forward(name = "success", path = "RespConsReten.jsp") },
			validationErrorForward = @Jpf.Forward(name = "error", path = "RespConsReten.jsp"))
    
    protected Forward begin(BeginForm form){
    	ActionErrors errs = new ActionErrors() ;
    	boolean export = false;
    try
        {
    		if (!(this.getRequest().getRemoteUser().equalsIgnoreCase(this.getRequest().getParameter("RUT")))) {
			logger.info("El Rut: " + this.getRequest().getRemoteUser()
					+ " realizo una busqueda con un RUT diferente el cual es: "
					+ this.getRequest().getParameter("RUT"));
			return new Forward("error", form);

			
    		}
    	
            
            if (this.getRequest().getParameter("detalle") == null)
            {
            	
            	form.setRut(this.getRequest().getParameter("RUT"));
            	form.setDv(this.getRequest().getParameter("DV"));
               
            }
            RetencionesDelegate retDelegate = new RetencionesDelegate();
            
            PersonaVO persona = retDelegate.getPersona(form.getRut());
            this.getRequest().setAttribute("persona",persona);
             ArrayList result = retDelegate.getConsultaRetenciones(form.getRut(), export);
            
            if (result.size() == 0)
            {
                errs.add("error", new ActionError("1037", new String("1")));
                this.saveErrors(this.getRequest(),errs);
                this.getRequest().setAttribute("Error", "true");
                return new Forward("error", form);                    
            }
                                    
            String formatoTD = "  nowrap align=\"center\" class=\"TR_bgColor_1\" " +
                               ", nowrap align=\"center\" class=\"TR_bgColor_1\" " +
                               ", align=\"center\" class=\"TR_bgColor_1\" " +
                               ", align=\"center\" class=\"TR_bgColor_1\" " +
                               ", align=\"center\" class=\"TR_bgColor_1\" " +
                               ", nowrap align=\"center\" class=\"TR_bgColor_1\" " +
                               ", align=\"center\" class=\"TR_bgColor_1\" " +
                               ", align=\"center\" class=\"TR_bgColor_1\" " +
                               ", align=\"center\" class=\"TR_bgColor_1\" " +
                               ", align=\"center\" class=\"TR_bgColor_1\" " +
                               ", align=\"center\" class=\"TR_bgColor_1\" " +
                               ", align=\"center\" class=\"TR_bgColor_1\" ";
                     
            String titulos =  "<div>&nbsp;<br>&nbsp;</div>" +
                              ",<div>&nbsp;TIPO RETENCIÓN&nbsp;</div>" +
                              ",<div>&nbsp;N° FOLIO&nbsp;</div>" +
                              ",<div>&nbsp;ESTADO&nbsp;</div>" +
                              ",<div>&nbsp;TIPO DEVOLUCIÓN&nbsp;</div>" +
                              ",<div>&nbsp;AÑO&nbsp;</div>" +
                              ",<div>&nbsp;CAUSA ROL&nbsp;</div>" +
                              ",<div>&nbsp;MONTO A RETENER&nbsp;</div>" +
                              ",<div>&nbsp;MONEDA&nbsp;</div>" +
                              ",<div>&nbsp;MONTO RETENIDO&nbsp;</div>" +
                              ",<div>&nbsp;SALDO&nbsp;</div>";
            

            DatosFormatosTablaVO datosFormatosTablaVO = new DatosFormatosTablaVO();
            datosFormatosTablaVO.setDatos(result);
            datosFormatosTablaVO.setDescTabla(" border=\"1\" cellpadding=\"1\" cellspacing=\"1\" class=\"fondoTituloColumna\" ");
            datosFormatosTablaVO.setDescTD(formatoTD);
            datosFormatosTablaVO.setFormatoLink("align=\"center\"");
            datosFormatosTablaVO.setId("{pageFlow.beginForm.idRet}");
            datosFormatosTablaVO.setTablaLink(" border=\"0\"  cellpadding=\"0\" cellspacing=\"2\" class=\"bajada\"");
            datosFormatosTablaVO.setTitulos(titulos);                    
            this.getRequest().getSession().removeAttribute("consulta");
            this.getRequest().getSession().setAttribute("consulta",datosFormatosTablaVO);   
            this.getRequest().setAttribute("Error", "false"); 
            
        }
        catch (Exception e)
        {
            logger.error(e);
            errs.add("error", new ActionError("1035", new String("2")));
            this.saveErrors(this.getRequest(),errs);
            return new Forward("error", form);            
        }                    
        
        
        return new Forward("success", form);
    }

    /**
     * @jpf:action form="beginForm"
     * @jpf:forward name="success" path="RespConsDetalle.jsp"
     * @jpf:validation-error-forward name="error" path="RespConsDetalle.jsp"
     */
    @Jpf.Action(useFormBean = "beginForm", 
                forwards = { 
                    @Jpf.Forward(name = "success",
                                 path = "RespConsDetalle.jsp")
                }, 
                validationErrorForward = @Jpf.Forward(name = "error",
                                                      path = "RespConsDetalle.jsp"))
    protected Forward ConsDetalle(BeginForm form)    
    {   
  
    		
    	ActionErrors errs;
        String flag = "true";
        Integer tipoReten=0;
        try
        {
        	            tipoReten = new Integer(form.getIdRet().substring(form.getIdRet().lastIndexOf(",") + 1,form.getIdRet().length()));
            String folio = form.getIdRet().substring(0,form.getIdRet().indexOf(","));
            
            logger.info(" tipo reten  ->"+tipoReten+" Folio-->"+ folio);
            logger.info("folio ->"+ folio);
            RetencionesDelegate retDelegate = new RetencionesDelegate();

            switch (tipoReten.intValue())
            {
                case 1:
                {//RETENCION JUDICIAL
                	
                    this.getRequest().setAttribute("retJudicial",retDelegate.getConsRetenJudicial(folio));
                    break;
                }
                
                case 2:
                {//RETENCION POR MANDATO
                    this.getRequest().setAttribute("retPorManda",retDelegate.getConsRetenMandatos(folio));
                    break;
                }
                
                case 3:
                {//OTRAS RETENCIONES
                    this.getRequest().setAttribute("otrasReten",retDelegate.getConsOtrasReten(folio));
                    break;
                }
                
                case 4:
                {//RETENCIONES EGRESOS CUESTIONADOS
                    this.getRequest().setAttribute("egresoCuestion",retDelegate.getConsEgresosCuestio(folio));
                    break;
                }
                
                case 5:
                {//RETENCIONES QUIEBRA
                    this.getRequest().setAttribute("retenQuiebra",retDelegate.getConsRetenQuiebra(folio));
                    break;
                }
                
                case 6:
                {//CONVENIO JUDICIAL
                    this.getRequest().setAttribute("convJudi",retDelegate.getConsConvJudicial(folio));
                    break;
                }
                
                case 7:
                {//CREDITO UNIVERSITARIO
                    this.getRequest().setAttribute("creditUniv",retDelegate.getConsCreditoUniv(folio));
                    break;
                }
                
                case 10:
                {//PENSION ALIMENTICIA
                    this.getRequest().setAttribute("pensionAlimen",retDelegate.getConsPensionALimenticia(folio));
                    break;
                }
                
                default:
                {
                    flag = "false";
                }
            }
            if (flag.equalsIgnoreCase("true"))
            {
                this.getRequest().setAttribute("historial",retDelegate.getConsHistorica(folio));
            }
            else
            {
                logger.error("ConsRetencionesController.jpf.ConsDetalle:==>PROBLEMA DE TIPO DE DATO O PROBLEMA EN EL SWITCH..");
                errs = new ActionErrors();
                errs.add("error", new ActionError("1037", new String("2")));
                this.saveErrors(this.getRequest(),errs);
                this.getRequest().setAttribute("error","true");
                return new Forward("error", form);            
            }    
            
        }
        catch (Exception e)
        {
        	logger.error(e);
            errs = new ActionErrors();
            errs.add("error", new ActionError("1035", new String("2")));
            this.saveErrors(this.getRequest(),errs);
            this.getRequest().setAttribute("error","true");
            return new Forward("error", form);            
        }
        //this.getRequest().setAttribute("persona",persona);
        this.getRequest().setAttribute("error","false");
        this.getRequest().setAttribute("tipoReten",tipoReten.toString());
        return new Forward("success",form);
    }

    /**
     * @jpf:action form="beginForm"
     * @jpf:forward name="success" path="/archivoExcel.jsp"
     */
	@Jpf.Action(
		useFormBean = "beginForm", 
		forwards = { 
			@Jpf.Forward(name = "success", path = "/archivoExcel.jsp")
		}
	)
    protected Forward ExportaExel(BeginForm form)
    {
        try {
            boolean export = true;
            RetencionesDelegate retDelegate = new RetencionesDelegate();
            ArrayList result = retDelegate.getConsultaRetenciones(form.getRut(), export);
            
            String[] titulos = new String[]{"TIPO RETENCIÓN","N° FOLIO","ESTADO",
                    "TIPO DEVOLUCIÓN","AÑO","CAUSA ROL","MONTO A RETENER","MONEDA","MONTO RETENIDO","SALDO"};
                    
            this.getRequest().setAttribute("titulos",titulos);
            this.getRequest().setAttribute("arrayResult", result);
                
        } catch (Exception e) {
            logger.error(e);
        }    
        return new Forward("success");
    }

    /**
     * FormData get and set methods may be overwritten by the Form Bean editor.
     */
    public static class BeginForm extends FormData
    {
        /**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private String appMat;
        private String appPat;
        private String nombre;
        private String idRet;
        private String dv;
        private String rut;
        
        public void setRut(String rut)
        {
            this.rut = rut;
        }

        public String getRut()
        {
            return this.rut;
        }

        public void setDv(String dv)
        {
            this.dv = dv;
        }

        public String getDv()
        {
            return this.dv;
        }

        public void setIdRet(String idRet)
        {
            this.idRet = idRet;
        }

        public String getIdRet()
        {
            return this.idRet;
        }

        public void setNombre(String nombre)
        {
            this.nombre = nombre;
        }

        public String getNombre()
        {
            return this.nombre;
        }

        public void setAppPat(String appPat)
        {
            this.appPat = appPat;
        }

        public String getAppPat()
        {
            return this.appPat;
        }

        public void setAppMat(String appMat)
        {
            this.appMat = appMat;
        }

        public String getAppMat()
        {
            return this.appMat;
        }
    }
}
