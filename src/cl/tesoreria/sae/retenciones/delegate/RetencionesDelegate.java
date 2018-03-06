package cl.tesoreria.sae.retenciones.delegate;

import cl.tesoreria.sae.retenciones.egcrpckretenciones.EgcrConsAllRetenResult;
import cl.tesoreria.sae.retenciones.egcrpckretenciones.EgcrConsHistoricaResult;
import cl.tesoreria.sae.retenciones.egcrpckretenciones.EgcrConsPersonaResult;
import cl.tesoreria.sae.retenciones.egcrpckretenciones.EgcrConsconvjudicialResult;
import cl.tesoreria.sae.retenciones.egcrpckretenciones.EgcrConscredunivResult;
import cl.tesoreria.sae.retenciones.egcrpckretenciones.EgcrConsegrecuestionadosResult;
import cl.tesoreria.sae.retenciones.egcrpckretenciones.EgcrConsotrasretenResult;
import cl.tesoreria.sae.retenciones.egcrpckretenciones.EgcrConspensionalimenResult;
import cl.tesoreria.sae.retenciones.egcrpckretenciones.EgcrConsretenjudicialResult;
import cl.tesoreria.sae.retenciones.egcrpckretenciones.EgcrConsretenmandatosResult;
import cl.tesoreria.sae.retenciones.egcrpckretenciones.EgcrConsretenquiebraResult;
import cl.tesoreria.sae.retenciones.egcrpckretenciones.EgcrPckRetencionesException;
import cl.tesoreria.sae.retenciones.egcrpckretenciones.EgcrPckRetencionesRemote;
import cl.tesoreria.sae.retenciones.locator.ServiceLocator;
import cl.tesoreria.sae.retenciones.vo.ConvenioJudicialVO;
import cl.tesoreria.sae.retenciones.vo.CreditoUniverVO;
import cl.tesoreria.sae.retenciones.vo.EgresosCuestionadosVO;
import cl.tesoreria.sae.retenciones.vo.OtrasRetencionesVO;
import cl.tesoreria.sae.retenciones.vo.PensionAlimenticiaVO;
import cl.tesoreria.sae.retenciones.vo.PersonaVO;
import cl.tesoreria.sae.retenciones.vo.RetencionJudicialVO;
import cl.tesoreria.sae.retenciones.vo.RetencionMandatosVO;
import cl.tesoreria.sae.retenciones.vo.RetencionQuiebraVO;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;

import javax.sql.RowSet;

import org.apache.log4j.Logger;

public class RetencionesDelegate {
	
	private static final Logger logger = Logger.getLogger("cl.tesoreria.egresos.consultaretenciones.retencionesdelegate");

	private ServiceLocator locator;
	

	

	public ArrayList getConsultaRetenciones(String rutRete, boolean export) throws Exception {
		
		ArrayList<String[]> listaConsulta = new ArrayList<String[]>();
		RowSet rs = null;
		try {

			

			if (locator == null) {
				locator = new ServiceLocator();
				
			}
	
			EgcrPckRetencionesRemote retencionesRemote = locator.getEgcrPckRetencionesRemote();
			EgcrConsAllRetenResult resp = retencionesRemote.egcrConsAllReten(new BigDecimal(rutRete));
			
			

			if (resp.getRowSetCount() > 0) {
				rs = resp.getRowSet(0);
				rs.beforeFirst();
			}
			
			String[] array = null;
			String saldo =null;
			while (rs.next()) {
			
				if (null != rs.getString("MONTO_A_RETENER") && rs.getString("MONTO_A_RETENER").lastIndexOf("%") < 0) {
					saldo = rs.getString("SALDO");
					
				} else {
					saldo = null;
					
				}

				if (!export) {
					array = new String[] { rs.getString("FOLIO") + "," + rs.getString("ID_TIPO_RETENCION"),
							rs.getString("DESC_TIPO_RETENCION"), rs.getString("FOLIO"),
							rs.getString("DESC_ESTADO_RETENCION"), rs.getString("DESC_TIPO_DEVOLUCION"),
							rs.getString("ANNO"), rs.getString("CAUSAL"), rs.getString("MONTO_A_RETENER"),
							rs.getString("DESCCRIPCION_MONEDA"), rs.getString("MONTO_RETENIDO"), saldo };
					
				} else {
					array = new String[] { rs.getString("DESC_TIPO_RETENCION"), rs.getString("FOLIO"),
							rs.getString("DESC_ESTADO_RETENCION"), rs.getString("DESC_TIPO_DEVOLUCION"),
							rs.getString("ANNO"), rs.getString("CAUSAL"), rs.getString("MONTO_A_RETENER"),
							rs.getString("DESCCRIPCION_MONEDA"), rs.getString("MONTO_RETENIDO"),
							rs.getString("SALDO") };
					
				}
				listaConsulta.add(array);
				
			}

		} catch (EgcrPckRetencionesException e) {
			logger.error(e);
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			logger.error(e);
			throw new Exception(e);
		}

		return listaConsulta;
	}

	public PersonaVO getPersona(String rut) throws Exception {
		
		RowSet rs = null;
		PersonaVO persona = new PersonaVO();
		try {

			if (locator == null) {
				locator = new ServiceLocator();
			}
			EgcrPckRetencionesRemote retencionesRemote = locator.getEgcrPckRetencionesRemote();
			EgcrConsPersonaResult resp = retencionesRemote.egcrConsPersona(new BigDecimal(rut));

			
			if (resp.getRowSetCount() > 0) {
				rs = resp.getRowSet(0);
				
			}

			while (rs.next()) {
				persona.setNombre(rs.getString("NOMBRES"));
				persona.setAppPat(rs.getString("APELLIDO_PATERNO"));
				persona.setAppMat(rs.getString("APELLIDO_MATERNO"));
				break;
			}

		} catch (EgcrPckRetencionesException e) {
			logger.error(e);
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			logger.error(e);
			throw new Exception(e);
		}
		return persona;
	}

	public PensionAlimenticiaVO getConsPensionALimenticia(String folio) throws Exception {

		PensionAlimenticiaVO pensAlimentVO = new PensionAlimenticiaVO();
		RowSet rs = null;
		try {
			if (locator == null) {
				locator = new ServiceLocator();
			}
			EgcrPckRetencionesRemote retencionesRemote = locator.getEgcrPckRetencionesRemote();
			EgcrConspensionalimenResult resp = retencionesRemote.egcrConspensionalimen(new BigDecimal(folio));

			if (resp.getRowSetCount() > 0) {
				rs = resp.getRowSet(0);
			}

			while (rs.next()) {
				pensAlimentVO.setRetenYear(rs.getString("YEAR_RETEN"));
				pensAlimentVO.setRetFamiliaId(rs.getString("ID_RETFAMILIA"));
				pensAlimentVO.setFolio(rs.getString("FOLIO"));
				pensAlimentVO.setIdPersonaRet(rs.getString("ID_PER_RET"));
				pensAlimentVO.setRut(rs.getString("RUT_RET"));
				pensAlimentVO.setDv(rs.getString("DV_RET"));
				pensAlimentVO.setAppPat(rs.getString("APP_PAT_RET"));
				pensAlimentVO.setAppPat(rs.getString("APP_MAP_RET"));
				pensAlimentVO.setNombre(rs.getString("NOM_RET"));
				pensAlimentVO.setRit(rs.getString("RIT"));
				pensAlimentVO.setRuc(rs.getString("RUC"));
				pensAlimentVO.setMontoReten(rs.getString("MONTO_RETEN"));
				pensAlimentVO.setJuzgado(rs.getString("JUZGADO"));
				pensAlimentVO.setEstado(rs.getString("ESTADO_RETEN"));
				pensAlimentVO.setFechaIngre(rs.getString("FECH_INGRE"));
				pensAlimentVO.setIdPersonaBene(rs.getString("ID_PER_BENE"));
				pensAlimentVO.setRutBene(rs.getString("RUT_BENE"));
				pensAlimentVO.setDvBene(rs.getString("DV_BENE"));
				pensAlimentVO.setAppPatBene(rs.getString("APP_PAT_BENE"));
				pensAlimentVO.setAppMatBene(rs.getString("APP_MAT_BENE"));
				pensAlimentVO.setNombreBene(rs.getString("NOM_BENE"));
				pensAlimentVO.setNumCta(rs.getString("NUM_CTA"));
				pensAlimentVO.setBanco(rs.getString("BANCO"));
				pensAlimentVO.setObservacion(rs.getString("OBSERV"));
				break;
			}

		} catch (EgcrPckRetencionesException e) {
			logger.error(e);
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			logger.error(e);
			throw new Exception(e);
		}

		return pensAlimentVO;
	}

	public CreditoUniverVO getConsCreditoUniv(String folio) throws Exception {

		CreditoUniverVO creditUniVO = new CreditoUniverVO();
		RowSet rs = null;
		try {
			if (locator == null) {
				locator = new ServiceLocator();
			}
			EgcrPckRetencionesRemote retencionesLocal = locator.getEgcrPckRetencionesRemote();
			EgcrConscredunivResult resp = retencionesLocal.egcrConscreduniv(new BigDecimal(folio));

			if (resp.getRowSetCount() > 0) {
				rs = resp.getRowSet(0);
			}

			while (rs.next()) {
				creditUniVO.setCredUnivId(rs.getString("ID_CREDITOU"));
				creditUniVO.setFolio(rs.getString("FOLIO"));
				creditUniVO.setObservacion(rs.getString("OBSERV"));
				creditUniVO.setFechaIngre(rs.getString("FECH_INGRE"));
				creditUniVO.setIdPersonaRet(rs.getString("ID_PERSONA"));
				creditUniVO.setRut(rs.getString("RUT"));
				creditUniVO.setDv(rs.getString("DV"));
				creditUniVO.setAppPat(rs.getString("APP_PAT"));
				creditUniVO.setAppPat(rs.getString("APP_MAP"));
				creditUniVO.setNombre(rs.getString("NOMBRE"));
				creditUniVO.setRetenYear(rs.getString("YEAR_RETEN"));
				creditUniVO.setMontoReten(rs.getString("MONTO"));
				creditUniVO.setNumCta(rs.getString("NUM_CTA"));
				creditUniVO.setGrupoEgreso(rs.getString("GRUPO_EGRESO"));
				creditUniVO.setTipoPago(rs.getString("TIPO_PAGO"));
				creditUniVO.setMoneda(rs.getString("MONEDA"));
				creditUniVO.setFechaLiqui(rs.getString("FECH_LIQUI"));
				creditUniVO.setEstado(rs.getString("ESTADO_RETEN"));
				creditUniVO.setUniversidad(rs.getString("UNIVERSIDAD"));
				break;
			}

		} catch (EgcrPckRetencionesException e) {
			logger.error(e);
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			logger.error(e);
			throw new Exception(e);
		}

		return creditUniVO;
	}

	public ConvenioJudicialVO getConsConvJudicial(String folio) throws Exception {

		ConvenioJudicialVO convJudiVO = new ConvenioJudicialVO();
		RowSet rs = null;
		try {
			if (locator == null) {
				locator = new ServiceLocator();
			}
			EgcrPckRetencionesRemote retencionesLocal = locator.getEgcrPckRetencionesRemote();
			EgcrConsconvjudicialResult resp = retencionesLocal.egcrConsconvjudicial(new BigDecimal(folio));

			if (resp.getRowSetCount() > 0) {
				rs = resp.getRowSet(0);
			}

			while (rs.next()) {
				convJudiVO.setConvJuducialId(rs.getString("ID_CONV_JUD"));
				convJudiVO.setJuzgado(rs.getString("JUZGADO"));
				convJudiVO.setSindico(rs.getString("SINDICO"));
				convJudiVO.setFechaIngre(rs.getString("FECH_INGRE"));
				convJudiVO.setRut(rs.getString("RUT"));
				convJudiVO.setDv(rs.getString("DV"));
				convJudiVO.setAppPat(rs.getString("APP_PAT"));
				convJudiVO.setAppPat(rs.getString("APP_MAP"));
				convJudiVO.setNombre(rs.getString("NOMBRE"));
				convJudiVO.setFechAprovConv(rs.getString("FECH_APROV_CONV"));
				convJudiVO.setNumExpe(rs.getString("NUM_EXP"));
				convJudiVO.setExpeYear(rs.getString("YEAR_EXP"));
				convJudiVO.setFolio(rs.getString("FOLIO"));
				convJudiVO.setObservacion(rs.getString("OBSERV"));
				convJudiVO.setEstado(rs.getString("ESTADO"));
				break;
			}

		} catch (EgcrPckRetencionesException e) {
			logger.error(e);
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			logger.error(e);
			throw new Exception(e);
		}

		return convJudiVO;
	}

	public RetencionQuiebraVO getConsRetenQuiebra(String folio) throws Exception {

		RetencionQuiebraVO retQuiebraVO = new RetencionQuiebraVO();
		RowSet rs = null;
		try {
			if (locator == null) {
				locator = new ServiceLocator();
			}
			EgcrPckRetencionesRemote retencionesLocal = locator.getEgcrPckRetencionesRemote();
			EgcrConsretenquiebraResult resp = retencionesLocal.egcrConsretenquiebra(new BigDecimal(folio));

			if (resp.getRowSetCount() > 0) {
				rs = resp.getRowSet(0);
			}

			while (rs.next()) {
				retQuiebraVO.setQuiebraId(rs.getString("ID_QUIEBRA"));
				retQuiebraVO.setFolio(rs.getString("FOLIO"));
				retQuiebraVO.setObservacion(rs.getString("OBSERV"));
				retQuiebraVO.setFechaIngre(rs.getString("FECH_INGRE"));
				retQuiebraVO.setPersonaId(rs.getString("ID_PERSONA"));
				retQuiebraVO.setNumExpe(rs.getString("NUM_EXPE"));
				retQuiebraVO.setExpeYear(rs.getString("YEAR_EXPE"));
				retQuiebraVO.setJuzgado(rs.getString("JUZGADO"));
				retQuiebraVO.setFechaDeclQuie(rs.getString("FECH_DECL_QUIE"));
				retQuiebraVO.setFechaDeclaDiarioOfi(rs.getString("FECH_DECL_DOFF"));
				retQuiebraVO.setSindicoSuplente(rs.getString("SINDICO_SUPLE"));
				retQuiebraVO.setSindicoTitular(rs.getString("SINDICO_TITU"));
				retQuiebraVO.setEstado(rs.getString("ESTADO"));
				break;
			}

		} catch (EgcrPckRetencionesException e) {
			logger.error(e);
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			logger.error(e);
			throw new Exception(e);
		}

		return retQuiebraVO;
	}

	public EgresosCuestionadosVO getConsEgresosCuestio(String folio) throws Exception {

		EgresosCuestionadosVO egreCuestioVO = new EgresosCuestionadosVO();
		RowSet rs = null;
		try {
			if (locator == null) {
				locator = new ServiceLocator();
			}
			EgcrPckRetencionesRemote retencionesLocal = locator.getEgcrPckRetencionesRemote();
			EgcrConsegrecuestionadosResult resp = retencionesLocal.egcrConsegrecuestionados(new BigDecimal(folio));

			if (resp.getRowSetCount() > 0) {
				rs = resp.getRowSet(0);
			}

			while (rs.next()) {
				egreCuestioVO.setEgresoQuestId(rs.getString("ID_EGRE_CUEST"));
				egreCuestioVO.setFolio(rs.getString("FOLIO"));
				egreCuestioVO.setObservacion(rs.getString("OBSERV"));
				egreCuestioVO.setFechaIngre(rs.getString("FECH_INGRE"));
				egreCuestioVO.setPersonaId(rs.getString("ID_PERSONA"));
				egreCuestioVO.setRut(rs.getString("RUT"));
				egreCuestioVO.setDv(rs.getString("DV"));
				egreCuestioVO.setAppPat(rs.getString("APP_PAT"));
				egreCuestioVO.setAppPat(rs.getString("APP_MAP"));
				egreCuestioVO.setNombre(rs.getString("NOMBRE"));
				egreCuestioVO.setTipoForm(rs.getString("TIPO_FORM"));
				egreCuestioVO.setTipoDevo(rs.getString("TIPO_DEVO"));
				egreCuestioVO.setEstado(rs.getString("ESTADO"));
				break;
			}

		} catch (EgcrPckRetencionesException e) {
			logger.error(e);
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			logger.error(e);
			throw new Exception(e);
		}

		return egreCuestioVO;
	}

	public OtrasRetencionesVO getConsOtrasReten(String folio) throws Exception {

		OtrasRetencionesVO otrasRetenVO = new OtrasRetencionesVO();
		RowSet rs = null;
		try {
			if (locator == null) {
				locator = new ServiceLocator();
			}
			EgcrPckRetencionesRemote retencionesLocal = locator.getEgcrPckRetencionesRemote();
			EgcrConsotrasretenResult resp = retencionesLocal.egcrConsotrasreten(new BigDecimal(folio));

			if (resp.getRowSetCount() > 0) {
				rs = resp.getRowSet(0);
			}

			while (rs.next()) {
				otrasRetenVO.setOtrasRetenId(rs.getString("ID_OTRAS_RETEN"));
				otrasRetenVO.setFolio(rs.getString("FOLIO"));
				otrasRetenVO.setObservacion(rs.getString("OBSERV"));
				otrasRetenVO.setFechaIngre(rs.getString("FECH_INGRE"));
				otrasRetenVO.setPersonaId(rs.getString("ID_PERSONA"));
				otrasRetenVO.setRut(rs.getString("RUT"));
				otrasRetenVO.setDv(rs.getString("DV"));
				otrasRetenVO.setAppPat(rs.getString("APP_PAT"));
				otrasRetenVO.setAppPat(rs.getString("APP_MAP"));
				otrasRetenVO.setNombre(rs.getString("NOMBRE"));
				otrasRetenVO.setRetenYear(rs.getString("YEAR_RETEN"));
				otrasRetenVO.setGrupoEgreso(rs.getString("GRUPO_EGRESO"));
				otrasRetenVO.setEstado(rs.getString("ESTADO_RETEN"));
				break;
			}

		} catch (EgcrPckRetencionesException e) {
			logger.error(e);
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			logger.error(e);
			throw new Exception(e);
		}

		return otrasRetenVO;
	}

	public RetencionMandatosVO getConsRetenMandatos(String folio) throws Exception {

		RetencionMandatosVO retMandatoVO = new RetencionMandatosVO();
		RowSet rs = null;
		try {
			if (locator == null) {
				locator = new ServiceLocator();
			}
			EgcrPckRetencionesRemote retencionesLocal = locator.getEgcrPckRetencionesRemote();
			EgcrConsretenmandatosResult resp = retencionesLocal.egcrConsretenmandatos(new BigDecimal(folio));

			if (resp.getRowSetCount() > 0) {
				rs = resp.getRowSet(0);
			}

			while (rs.next()) {
				retMandatoVO.setMandatoId(rs.getString("ID_MANDATO"));
				retMandatoVO.setFolio(rs.getString("FOLIO"));
				retMandatoVO.setObservacion(rs.getString("OBSERV"));
				retMandatoVO.setFechMandato(rs.getString("FECH_MANDATO"));
				retMandatoVO.setPersonaId(rs.getString("ID_PERSONA"));
				retMandatoVO.setRut(rs.getString("RUT"));
				retMandatoVO.setDv(rs.getString("DV"));
				retMandatoVO.setAppPat(rs.getString("APP_PAT"));
				retMandatoVO.setAppPat(rs.getString("APP_MAP"));
				retMandatoVO.setNombre(rs.getString("NOMBRE"));
				retMandatoVO.setNumOficio(rs.getString("NUM_OFICIO"));
				retMandatoVO.setOficioYear(rs.getString("YEAR_OFICIO"));
				retMandatoVO.setRetenYear(rs.getString("YEAR_RETEN"));
				retMandatoVO.setMonto(rs.getString("MONTO"));
				retMandatoVO.setPorcentaje(rs.getString("PORCENTAJE"));
				retMandatoVO.setRepLegal(rs.getString("REP_LEGAL"));
				retMandatoVO.setGrupoEgreso(rs.getString("GRUPO_EGRESO"));
				retMandatoVO.setTipoPago(rs.getString("TIPO_PAGO"));
				retMandatoVO.setSubTipoRet(rs.getString("TIPO_RET_MANDA"));
				retMandatoVO.setMoneda(rs.getString("MONEDA"));
				retMandatoVO.setEstado(rs.getString("ESTADO_RETEN"));
				retMandatoVO.setNumeroCta(rs.getString("NUMERO_CTA"));
				retMandatoVO.setTipoCta(rs.getString("TIPO_CUENTA"));
				retMandatoVO.setBanco(rs.getString("BANCO"));
				break;
			}

		} catch (EgcrPckRetencionesException e) {
			logger.error(e);
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			logger.error(e);
			throw new Exception(e);
		}

		return retMandatoVO;
	}

	public RetencionJudicialVO getConsRetenJudicial(String folio) throws Exception {
		
		RetencionJudicialVO retJudiVO = new RetencionJudicialVO();
		RowSet rs = null;
		try {
			if (locator == null) {
				locator = new ServiceLocator();
			}
			EgcrPckRetencionesRemote retencionesRemote = locator.getEgcrPckRetencionesRemote();
			EgcrConsretenjudicialResult resp = retencionesRemote.egcrConsretenjudicial(new BigDecimal(folio));
			if (resp.getRowSetCount() > 0) {
				rs = resp.getRowSet(0);
			}

			while (rs.next()) {
				retJudiVO.setJuducialId(rs.getString("ID_JUDICIAL"));
				retJudiVO.setEstado(rs.getString("ESTADO_RETEN"));
				retJudiVO.setCausal(rs.getString("CAUSAL"));
				retJudiVO.setRol(rs.getString("ROL"));
				retJudiVO.setNumOficio(rs.getString("NUM_OFICIO"));
				retJudiVO.setOficioYear(rs.getString("YEAR_OFICIO"));
				retJudiVO.setGrupoEgreso(rs.getString("GRUP_EGRE"));
				retJudiVO.setRetenYear(rs.getString("YEAR_RETEN"));
				retJudiVO.setMonto(rs.getString("MONTO"));
				retJudiVO.setMoneda(rs.getString("MONEDA"));
				retJudiVO.setPorcentaje(rs.getString("PORCENTAJE"));
				retJudiVO.setJuzgado(rs.getString("JUZGADO"));
				retJudiVO.setTipoPago(rs.getString("TIPO_PAGO"));
				retJudiVO.setFolio(rs.getString("FOLIO"));
				retJudiVO.setObservacion(rs.getString("OBSERV"));
				break;
			}

		} catch (EgcrPckRetencionesException e) {
			logger.error(e);
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			logger.error(e);
			throw new Exception(e);
		}
		
		return retJudiVO;
	}

	public ArrayList getConsHistorica(String folio) throws Exception {
		ArrayList<String[]> listaConsulta = new ArrayList();
		RowSet rs = null;
		try {
			if (locator == null) {
				locator = new ServiceLocator();
			}
			EgcrPckRetencionesRemote retencionesRemote = locator.getEgcrPckRetencionesRemote();
			EgcrConsHistoricaResult resp = retencionesRemote.egcrConsHistorica(new BigDecimal(folio));
			
			if (resp.getRowSetCount() > 0) {
				rs = resp.getRowSet(0);
			}

			String[] array = null;
			while (rs.next()) {
				array = new String[] { 
						rs.getString("FECHA"),
						rs.getString("RUT"),
						rs.getString("DV"),
						rs.getString("ID_TESO"),
						rs.getString("TESO_DES"), 
						rs.getString("MONTO"),
						rs.getString("GLOSA") 
						};
				
				listaConsulta.add(array);
				
			}

		} catch (EgcrPckRetencionesException e) {
			logger.error(e);
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			logger.error(e);
			throw new Exception(e);
		}
		return listaConsulta;
	}
}
