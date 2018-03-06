package cl.tesoreria.sae.retenciones.locator;

import javax.naming.Context;
import javax.naming.InitialContext;
import cl.tesoreria.sae.retenciones.egcrpckretenciones.EgcrPckRetencionesRemote;

public class ServiceLocator {

	private EgcrPckRetencionesRemote egcrPckRetencionesRemote;

	public EgcrPckRetencionesRemote getEgcrPckRetencionesRemote() throws Exception {
		if (egcrPckRetencionesRemote == null) {
			Context con = new InitialContext();
			egcrPckRetencionesRemote = (EgcrPckRetencionesRemote) con.lookup(
					"cl.tesoreria.sae.retenciones.egcrpckretenciones.EgcrPckRetenciones#cl.tesoreria.sae.retenciones.egcrpckretenciones.EgcrPckRetencionesRemote");
		}
		return egcrPckRetencionesRemote;
	}

}
