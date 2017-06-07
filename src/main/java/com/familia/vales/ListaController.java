package com.familia.vales;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.familia.vales.jpa.entities.DetalleVale;
import com.familia.vales.jpa.entities.EstadoVale;
import com.familia.vales.jpa.entities.OperacionVale;
import com.familia.vales.jpa.entities.Vale;
import com.familia.vales.jpa.repository.DetalleValeRepository;
import com.familia.vales.jpa.repository.EstadoValeRepository;
import com.familia.vales.jpa.repository.OperacionValeRepository;
import com.familia.vales.jpa.repository.ValeRepository;
import extranet_sgto_ordenes_compra.familia.*;

/**
 * @author juan.arboleda
 */
@Controller
public class ListaController {
		
	@Autowired
	private  ValeRepository valeRepository;
	
	@Autowired
	private  EstadoValeRepository estREp;
	
	@Autowired
	private  OperacionValeRepository opRep;
	
	@Autowired
	private DetalleValeRepository detValRep;
	
	@RequestMapping(value = "/lista", method = RequestMethod.GET)
	public ModelAndView lista(Locale locale, Model model,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("EEE, MMM d, yyyy");		
		String formattedDate = dateFormat.format(date);
		
		Collection<Vale> vales = valeRepository.findAll();
		EstadoVale estatus = estREp.findOne(1);
		String status = estatus.getEstado();

		Map<String, Object> miModelo = new HashMap<String, Object>();
		miModelo.put("estado", status);
		miModelo.put("fecha", formattedDate);
		miModelo.put("vales", vales);
		ModelAndView miMAV = new ModelAndView();
        miMAV.setViewName("lista");
        miMAV.addObject("model",miModelo);

        return miMAV;
	}
	

	@RequestMapping(value = "/excel", method = RequestMethod.GET)
	   public ModelAndView excel(HttpServletRequest request, HttpServletResponse response,Locale locale, Model model) throws IOException, ParseException {
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("EEE, MMM d, yyyy");		
		String formattedDate = dateFormat.format(date);
		
		Collection<Vale> vales = valeRepository.findAll();
		EstadoVale estatus = estREp.findOne(1);
		String status = estatus.getEstado();

		Map<String, Object> miModelo = new HashMap<String, Object>();
		miModelo.put("estado", status);
		miModelo.put("fecha", formattedDate);
		miModelo.put("vales", vales);
		ModelAndView miMAV = new ModelAndView();
        miMAV.setViewName("excel");
        miMAV.addObject("model",miModelo);

        return miMAV;//return new ModelAndView("redirect:/result");
	   }
	

	@RequestMapping(value = "/filtro", method = RequestMethod.POST)
	   public ModelAndView filtro(HttpServletRequest request, HttpServletResponse response,Locale locale, Model model) throws IOException, ParseException {
			String radicado = request.getParameter("radicadoFiltro");
			
			String ORIGINAL = "0123456789";
			int cont = 0;
			char[] array = radicado.toCharArray();
			for(int i = 0; i < radicado.length(); i++){
				int pos = ORIGINAL.indexOf(array[i]);
				if(pos == -1){
					cont+=1;
				}
			}
			
			String estadoFiltro = request.getParameter("estadoFiltro");
			String filtrado = estadoFiltro; 
			if(filtrado.equals("TODOS")){
				return new ModelAndView("redirect:/lista");
			}else
			if(radicado != ""){
				if(cont==0){
					Collection<Vale> valess = valeRepository.findAll();
					Vector<Vale> vales = new Vector<Vale>();

					for (Iterator<Vale> iterator = valess.iterator(); iterator.hasNext();) {
						Vale valeFiltr = (Vale) iterator.next();
						if(valeFiltr.getIdVale()==Integer.parseInt(radicado) && valeFiltr.getEstadoVale().getEstado().equals(filtrado)){
							vales.add(valeFiltr);
						} 
					}		
					Map<String, Object> miModelo = new HashMap<String, Object>();
					miModelo.put("vales", vales);
					ModelAndView miMAV = new ModelAndView();
			        miMAV.setViewName("lista");
			        miMAV.addObject("model",miModelo);
			        return miMAV;
				}else{
					return new ModelAndView("redirect:/lista");
				}	

			}else{
				System.out.println("radicado igual");
				Collection<Vale> valess = valeRepository.findAll();
				Vector<Vale> vales = new Vector<Vale>();

				for (Iterator<Vale> iterator = valess.iterator(); iterator.hasNext();) {
					Vale valeFiltr = (Vale) iterator.next();
					if(valeFiltr.getEstadoVale().getEstado().equals(filtrado)){
						vales.add(valeFiltr);
					} 
				}		

				Map<String, Object> miModelo = new HashMap<String, Object>();
				miModelo.put("vales", vales);
				ModelAndView miMAV = new ModelAndView();
		        miMAV.setViewName("lista");
		        miMAV.addObject("model",miModelo);

		         return miMAV;
			}

	   }
	
	
	@RequestMapping(value="/FiltroFecha", method = RequestMethod.POST)
	   public ModelAndView FiltroFecha(HttpServletRequest request, HttpServletResponse response,Locale locale, Model model) throws IOException, ParseException {
			String fecha = request.getParameter("fecFiltro");			
			if(fecha != ""){
				
				DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	  			Date datew = formatter.parse(fecha);
				DateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd");
				String datew1 = formatter1.format(datew);
				
				Collection<Vale> valess = valeRepository.findAll();
				Vector<Vale> vales = new Vector<Vale>();

				for (Iterator<Vale> iterator = valess.iterator(); iterator.hasNext();) {
					Vale valeFiltr = (Vale) iterator.next();
					int iden=valeFiltr.getIdVale();
					Collection<DetalleVale> detFil = detValRep.findAll();
					for(Iterator<DetalleVale> iterator1 = detFil.iterator(); iterator1.hasNext();){
						DetalleVale DetValeFiltr = (DetalleVale) iterator1.next();
						int identi = DetValeFiltr.getVale().getIdVale();
						if(iden==identi){
							Date fechaEspp=DetValeFiltr.getFechaEsperada();
							if(fechaEspp==null){
								break;
							}
							String fecc=fechaEspp.toString();
							if(fecc.equals(datew1)){
								vales.add(valeFiltr);
								break;
							}
						} 
							
					}				 
				}		
				Map<String, Object> miModelo = new HashMap<String, Object>();
				miModelo.put("vales", vales);
				ModelAndView miMAV = new ModelAndView();
		        miMAV.setViewName("lista");
		        miMAV.addObject("model",miModelo);
		        return miMAV;

			}else{
				System.out.println("no tiene fecha");
				return new ModelAndView("redirect:/lista");
			}
	   }
	
	@RequestMapping(value="/FiltroCentro", method = RequestMethod.POST)
	   public ModelAndView FiltroCentro(HttpServletRequest request, HttpServletResponse response,Locale locale, Model model) throws IOException, ParseException {
			String centro = request.getParameter("centFiltro");			
			centro = centro.toUpperCase();
			if(centro != ""){				
				Collection<Vale> valess = valeRepository.findAll();
				Vector<Vale> vales = new Vector<Vale>();

				for (Iterator<Vale> iterator = valess.iterator(); iterator.hasNext();) {
					Vale valeFiltr = (Vale) iterator.next();
					int iden=valeFiltr.getIdVale();
					Collection<DetalleVale> detFil = detValRep.findAll();
					for(Iterator<DetalleVale> iterator1 = detFil.iterator(); iterator1.hasNext();){
						DetalleVale DetValeFiltr = (DetalleVale) iterator1.next();
						int identi = DetValeFiltr.getVale().getIdVale();
						if(iden==identi){
							String centr=DetValeFiltr.getCentro();
							if(centr==null){
								break;
							}
							
							if(centr.equals(centro)){
								vales.add(valeFiltr);
								break;
							}
						} 
							
					}				 
				}		
				Map<String, Object> miModelo = new HashMap<String, Object>();
				miModelo.put("vales", vales);
				ModelAndView miMAV = new ModelAndView();
		        miMAV.setViewName("lista");
		        miMAV.addObject("model",miModelo);
		        return miMAV;

			}else{
				System.out.println("no tiene fecha");
				return new ModelAndView("redirect:/lista");
			}
	   }
	
	@RequestMapping("/retornaProveedor")
	public void retornaProveedor(HttpServletRequest request, HttpServletResponse response) throws IOException{
		extranet_sgto_ordenes_compra.familia.DT_CON_PROV extranet_sgto_ordenes_compra1familia1DT_CON_PROV_2id=new DT_CON_PROV();  
		extranet_sgto_ordenes_compra.familia.DT_REQUEST_PROVEDOR extranet_sgto_ordenes_compra1familia1DT_REQUEST_PROVEDOR_1id=new DT_REQUEST_PROVEDOR();
		extranet_sgto_ordenes_compra.familia.SI_CON_PROVEEDOR_OC_UID_OUT_SProxy sampleSI_CON_PROVEEDOR_OC_UID_OUT_SProxyid = new SI_CON_PROVEEDOR_OC_UID_OUT_SProxy();

       String cOD_PROV_4id=  request.getParameter("CodProveedor");
       System.out.println(cOD_PROV_4id);
           java.lang.String cOD_PROV_4idTemp = null;
       if(!cOD_PROV_4id.equals("")){
        cOD_PROV_4idTemp  = cOD_PROV_4id;
       }

       extranet_sgto_ordenes_compra1familia1DT_CON_PROV_2id.setCOD_PROV(cOD_PROV_4idTemp);

       extranet_sgto_ordenes_compra1familia1DT_REQUEST_PROVEDOR_1id.setPROVEEDOR(extranet_sgto_ordenes_compra1familia1DT_CON_PROV_2id);
       extranet_sgto_ordenes_compra.familia.DT_RESPONSE_PROVEEDOR SI_CON_PROVEEDOR_OC_UID_OUT_S13mtemp = sampleSI_CON_PROVEEDOR_OC_UID_OUT_SProxyid.SI_CON_PROVEEDOR_OC_UID_OUT_S(extranet_sgto_ordenes_compra1familia1DT_REQUEST_PROVEDOR_1id);
       System.out.println("sii "+SI_CON_PROVEEDOR_OC_UID_OUT_S13mtemp);
  
       DT_PROVEEDOR[] proveedor = SI_CON_PROVEEDOR_OC_UID_OUT_S13mtemp.getPROVEEDOR();
       DT_CONTACTO[] contacto = proveedor[0].getCONTACTO();
       
       ArrayList<String> repuesta=new ArrayList<>();
       repuesta.add("?"+proveedor[0].getCOD_PROV()+"?");
	   repuesta.add("?"+proveedor[0].getNIT()+"?");
	   repuesta.add("?"+proveedor[0].getNOMBRE()+"?");
	   repuesta.add("?"+proveedor[0].getDIRECCION()+"?");
	   if(contacto == null){
		   repuesta.add("?"+" "+"?");
		   repuesta.add("?"+" "+"?");
	   }else{
		   repuesta.add("?"+contacto[0].getTELEFONO()+"?");
		   repuesta.add("?"+contacto[0].getNOMBRES()+"?");		   
	   }
	   String ciudad = quitarTilde(proveedor[0].getCIUDAD());
	   System.out.println(ciudad);
	   repuesta.add("?"+ciudad+"?");
       response.getWriter().println(repuesta);
	}
	
	@RequestMapping("/retornaProveedorNom")
	public void retornaProveedorNom(HttpServletRequest request, HttpServletResponse response) throws IOException{
		extranet_sgto_ordenes_compra.familia.DT_CON_PROV extranet_sgto_ordenes_compra1familia1DT_CON_PROV_2id=new DT_CON_PROV();  
		
		extranet_sgto_ordenes_compra.familia.DT_REQUEST_PROVEDOR extranet_sgto_ordenes_compra1familia1DT_REQUEST_PROVEDOR_1id=new DT_REQUEST_PROVEDOR();
		extranet_sgto_ordenes_compra.familia.SI_CON_PROVEEDOR_OC_UID_OUT_SProxy sampleSI_CON_PROVEEDOR_OC_UID_OUT_SProxyid = new SI_CON_PROVEEDOR_OC_UID_OUT_SProxy();

       String nOMBRE_7id=  request.getParameter("nombreProv");
           java.lang.String nOMBRE_7idTemp = null;
       if(!nOMBRE_7id.equals("")){
        nOMBRE_7idTemp  = nOMBRE_7id;
       }
       //extranet_sgto_ordenes_compra1familia1DT_CON_PROV_2id.setCOD_PROV("");
       extranet_sgto_ordenes_compra1familia1DT_CON_PROV_2id.setNOMBRE(nOMBRE_7idTemp);

       extranet_sgto_ordenes_compra1familia1DT_REQUEST_PROVEDOR_1id.setPROVEEDOR(extranet_sgto_ordenes_compra1familia1DT_CON_PROV_2id);
       extranet_sgto_ordenes_compra.familia.DT_RESPONSE_PROVEEDOR SI_CON_PROVEEDOR_OC_UID_OUT_S13mtemp = sampleSI_CON_PROVEEDOR_OC_UID_OUT_SProxyid.SI_CON_PROVEEDOR_OC_UID_OUT_S(extranet_sgto_ordenes_compra1familia1DT_REQUEST_PROVEDOR_1id);
       System.out.println("sii "+SI_CON_PROVEEDOR_OC_UID_OUT_S13mtemp);
  
       DT_PROVEEDOR[] proveedor = SI_CON_PROVEEDOR_OC_UID_OUT_S13mtemp.getPROVEEDOR();
       DT_CONTACTO[] contacto = proveedor[0].getCONTACTO();
       ArrayList<String> repuesta=new ArrayList<>();
	   repuesta.add("?"+proveedor[0].getCOD_PROV()+"?");
	   repuesta.add("?"+proveedor[0].getNIT()+"?");
	   repuesta.add("?"+proveedor[0].getNOMBRE()+"?");
	   repuesta.add("?"+proveedor[0].getDIRECCION()+"?");
	   if(contacto == null){
		   repuesta.add("?"+" "+"?");
		   repuesta.add("?"+" "+"?");
	   }else{
		   repuesta.add("?"+contacto[0].getTELEFONO()+"?");
		   repuesta.add("?"+contacto[0].getNOMBRES()+"?");		   
	   }	  
	   String ciudad = quitarTilde(proveedor[0].getCIUDAD());
	   repuesta.add("?"+ciudad+"?");

       response.getWriter().println(repuesta);
	}
	
	
	@RequestMapping("/retornaProveedorLista")
	public void retornaProveedorLista(HttpServletRequest request, HttpServletResponse response) throws IOException{
		extranet_sgto_ordenes_compra.familia.DT_CON_PROV extranet_sgto_ordenes_compra1familia1DT_CON_PROV_2id=new DT_CON_PROV();  
		
		extranet_sgto_ordenes_compra.familia.DT_REQUEST_PROVEDOR extranet_sgto_ordenes_compra1familia1DT_REQUEST_PROVEDOR_1id=new DT_REQUEST_PROVEDOR();
		extranet_sgto_ordenes_compra.familia.SI_CON_PROVEEDOR_OC_UID_OUT_SProxy sampleSI_CON_PROVEEDOR_OC_UID_OUT_SProxyid = new SI_CON_PROVEEDOR_OC_UID_OUT_SProxy();

       String nOMBRE_7id=  request.getParameter("nombreProveedor");
           java.lang.String nOMBRE_7idTemp = null;
       if(!nOMBRE_7id.equals("")){
        nOMBRE_7idTemp  = nOMBRE_7id;
       }
       extranet_sgto_ordenes_compra1familia1DT_CON_PROV_2id.setCOD_PROV("");
       extranet_sgto_ordenes_compra1familia1DT_CON_PROV_2id.setNOMBRE(nOMBRE_7idTemp);

       extranet_sgto_ordenes_compra1familia1DT_REQUEST_PROVEDOR_1id.setPROVEEDOR(extranet_sgto_ordenes_compra1familia1DT_CON_PROV_2id);
       extranet_sgto_ordenes_compra.familia.DT_RESPONSE_PROVEEDOR SI_CON_PROVEEDOR_OC_UID_OUT_S13mtemp = sampleSI_CON_PROVEEDOR_OC_UID_OUT_SProxyid.SI_CON_PROVEEDOR_OC_UID_OUT_S(extranet_sgto_ordenes_compra1familia1DT_REQUEST_PROVEDOR_1id);
       System.out.println("sii "+SI_CON_PROVEEDOR_OC_UID_OUT_S13mtemp);
  
       DT_PROVEEDOR[] proveedor = SI_CON_PROVEEDOR_OC_UID_OUT_S13mtemp.getPROVEEDOR();
	   ArrayList<String> repuesta=new ArrayList<>();
	   
	   for(int i=0;i<proveedor.length;i++){
		   String unico="?"+proveedor[i].getNOMBRE()+"?"; 
		   repuesta.add(unico);
       }
	   
       response.getWriter().println(repuesta);
	}
	
	@RequestMapping("/retornaProveedorNit")
	public void retornaProveedorNit(HttpServletRequest request, HttpServletResponse response) throws IOException{
		extranet_sgto_ordenes_compra.familia.DT_CON_PROV extranet_sgto_ordenes_compra1familia1DT_CON_PROV_2id=new DT_CON_PROV();  
		
		extranet_sgto_ordenes_compra.familia.DT_REQUEST_PROVEDOR extranet_sgto_ordenes_compra1familia1DT_REQUEST_PROVEDOR_1id=new DT_REQUEST_PROVEDOR();
		extranet_sgto_ordenes_compra.familia.SI_CON_PROVEEDOR_OC_UID_OUT_SProxy sampleSI_CON_PROVEEDOR_OC_UID_OUT_SProxyid = new SI_CON_PROVEEDOR_OC_UID_OUT_SProxy();

		String nIT_6id=  request.getParameter("nitProv");
        java.lang.String nIT_6idTemp = null;
	    if(!nIT_6id.equals("")){
	     nIT_6idTemp  = nIT_6id;
	    }
	    String sOCIEDAD_3id=  request.getParameter("sociedadProv");
        java.lang.String sOCIEDAD_3idTemp = null;
	    if(!sOCIEDAD_3id.equals("")){
	     sOCIEDAD_3idTemp  = sOCIEDAD_3id;
	    }
	    extranet_sgto_ordenes_compra1familia1DT_CON_PROV_2id.setSOCIEDAD(sOCIEDAD_3idTemp);
        extranet_sgto_ordenes_compra1familia1DT_CON_PROV_2id.setNIT(nIT_6idTemp);

       extranet_sgto_ordenes_compra1familia1DT_REQUEST_PROVEDOR_1id.setPROVEEDOR(extranet_sgto_ordenes_compra1familia1DT_CON_PROV_2id);
       extranet_sgto_ordenes_compra.familia.DT_RESPONSE_PROVEEDOR SI_CON_PROVEEDOR_OC_UID_OUT_S13mtemp = sampleSI_CON_PROVEEDOR_OC_UID_OUT_SProxyid.SI_CON_PROVEEDOR_OC_UID_OUT_S(extranet_sgto_ordenes_compra1familia1DT_REQUEST_PROVEDOR_1id);
       System.out.println("sii "+SI_CON_PROVEEDOR_OC_UID_OUT_S13mtemp);
  
       DT_PROVEEDOR[] proveedor = SI_CON_PROVEEDOR_OC_UID_OUT_S13mtemp.getPROVEEDOR();
       DT_CONTACTO[] contacto = proveedor[0].getCONTACTO();
       ArrayList<String> repuesta=new ArrayList<>();
	   repuesta.add("?"+proveedor[0].getCOD_PROV()+"?");
	   repuesta.add("?"+proveedor[0].getNIT()+"?");
	   repuesta.add("?"+proveedor[0].getNOMBRE()+"?");
	   repuesta.add("?"+proveedor[0].getDIRECCION()+"?");
	   if(contacto == null){
		   repuesta.add("?"+" "+"?");
		   repuesta.add("?"+" "+"?");
	   }else{
		   repuesta.add("?"+contacto[0].getTELEFONO()+"?");
		   repuesta.add("?"+contacto[0].getNOMBRES()+"?");		   
	   }	  
	   String ciudad = quitarTilde(proveedor[0].getCIUDAD());
	   repuesta.add("?"+ciudad+"?");
       response.getWriter().println(repuesta);
	}
	
	@RequestMapping("/retornaNitLista")
	public void retornaNitLista(HttpServletRequest request, HttpServletResponse response) throws IOException{
		extranet_sgto_ordenes_compra.familia.DT_CON_PROV extranet_sgto_ordenes_compra1familia1DT_CON_PROV_2id=new DT_CON_PROV();  
		
		extranet_sgto_ordenes_compra.familia.DT_REQUEST_PROVEDOR extranet_sgto_ordenes_compra1familia1DT_REQUEST_PROVEDOR_1id=new DT_REQUEST_PROVEDOR();
		extranet_sgto_ordenes_compra.familia.SI_CON_PROVEEDOR_OC_UID_OUT_SProxy sampleSI_CON_PROVEEDOR_OC_UID_OUT_SProxyid = new SI_CON_PROVEEDOR_OC_UID_OUT_SProxy();

		String nIT_6id=  request.getParameter("nitProveedor");
        java.lang.String nIT_6idTemp = null;
	    if(!nIT_6id.equals("")){
	     nIT_6idTemp  = nIT_6id;
	    }
       extranet_sgto_ordenes_compra1familia1DT_CON_PROV_2id.setCOD_PROV("");
       extranet_sgto_ordenes_compra1familia1DT_CON_PROV_2id.setNIT(nIT_6idTemp);
       extranet_sgto_ordenes_compra1familia1DT_REQUEST_PROVEDOR_1id.setPROVEEDOR(extranet_sgto_ordenes_compra1familia1DT_CON_PROV_2id);
       extranet_sgto_ordenes_compra.familia.DT_RESPONSE_PROVEEDOR SI_CON_PROVEEDOR_OC_UID_OUT_S13mtemp = sampleSI_CON_PROVEEDOR_OC_UID_OUT_SProxyid.SI_CON_PROVEEDOR_OC_UID_OUT_S(extranet_sgto_ordenes_compra1familia1DT_REQUEST_PROVEDOR_1id);
  
       DT_PROVEEDOR[] proveedor = SI_CON_PROVEEDOR_OC_UID_OUT_S13mtemp.getPROVEEDOR();
       System.out.println("proveedor "+proveedor);
       ArrayList<String> repuesta=new ArrayList<>();
	   
	   for(int i=0;i<proveedor.length;i++){
		   repuesta.add("?"+proveedor[i].getSOCIEDAD()+"?");
		   repuesta.add("?"+proveedor[i].getCOD_PROV()+"?");
       }
	   
       response.getWriter().println(repuesta);
	}
	
	@RequestMapping("/existeEmpresa")
	public void existeEmpresa(HttpServletRequest request, HttpServletResponse response) throws IOException{
		extranet_sgto_ordenes_compra.familia.DT_CON_PROV extranet_sgto_ordenes_compra1familia1DT_CON_PROV_2id=new DT_CON_PROV();  
		
		extranet_sgto_ordenes_compra.familia.DT_REQUEST_PROVEDOR extranet_sgto_ordenes_compra1familia1DT_REQUEST_PROVEDOR_1id=new DT_REQUEST_PROVEDOR();
		extranet_sgto_ordenes_compra.familia.SI_CON_PROVEEDOR_OC_UID_OUT_SProxy sampleSI_CON_PROVEEDOR_OC_UID_OUT_SProxyid = new SI_CON_PROVEEDOR_OC_UID_OUT_SProxy();

       String nOMBRE_7id=  request.getParameter("nombreProv");
           java.lang.String nOMBRE_7idTemp = null;
       if(!nOMBRE_7id.equals("")){
        nOMBRE_7idTemp  = nOMBRE_7id;
       }
       extranet_sgto_ordenes_compra1familia1DT_CON_PROV_2id.setCOD_PROV("");
       extranet_sgto_ordenes_compra1familia1DT_CON_PROV_2id.setNOMBRE(nOMBRE_7idTemp);

       extranet_sgto_ordenes_compra1familia1DT_REQUEST_PROVEDOR_1id.setPROVEEDOR(extranet_sgto_ordenes_compra1familia1DT_CON_PROV_2id);
       extranet_sgto_ordenes_compra.familia.DT_RESPONSE_PROVEEDOR SI_CON_PROVEEDOR_OC_UID_OUT_S13mtemp = sampleSI_CON_PROVEEDOR_OC_UID_OUT_SProxyid.SI_CON_PROVEEDOR_OC_UID_OUT_S(extranet_sgto_ordenes_compra1familia1DT_REQUEST_PROVEDOR_1id);
  
       DT_PROVEEDOR[] proveedor = SI_CON_PROVEEDOR_OC_UID_OUT_S13mtemp.getPROVEEDOR();
       String bandera="";
       if(proveedor==null){
    	   bandera="true";
       }else{
    	   bandera="false";
       }	   
       response.getWriter().println(bandera);
	}
	
	@RequestMapping("/existeProveedor")
	public void existeProveedor(HttpServletRequest request, HttpServletResponse response) throws IOException{
		extranet_sgto_ordenes_compra.familia.DT_CON_PROV extranet_sgto_ordenes_compra1familia1DT_CON_PROV_2id=new DT_CON_PROV();  
		extranet_sgto_ordenes_compra.familia.DT_REQUEST_PROVEDOR extranet_sgto_ordenes_compra1familia1DT_REQUEST_PROVEDOR_1id=new DT_REQUEST_PROVEDOR();
		extranet_sgto_ordenes_compra.familia.SI_CON_PROVEEDOR_OC_UID_OUT_SProxy sampleSI_CON_PROVEEDOR_OC_UID_OUT_SProxyid = new SI_CON_PROVEEDOR_OC_UID_OUT_SProxy();
		
       String cOD_PROV_4id=  request.getParameter("CodProveedor");
           java.lang.String cOD_PROV_4idTemp = null;
       if(!cOD_PROV_4id.equals("")){
        cOD_PROV_4idTemp  = cOD_PROV_4id;
       }
       extranet_sgto_ordenes_compra1familia1DT_CON_PROV_2id.setCOD_PROV(cOD_PROV_4idTemp);
       extranet_sgto_ordenes_compra1familia1DT_REQUEST_PROVEDOR_1id.setPROVEEDOR(extranet_sgto_ordenes_compra1familia1DT_CON_PROV_2id);
       extranet_sgto_ordenes_compra.familia.DT_RESPONSE_PROVEEDOR SI_CON_PROVEEDOR_OC_UID_OUT_S13mtemp = sampleSI_CON_PROVEEDOR_OC_UID_OUT_SProxyid.SI_CON_PROVEEDOR_OC_UID_OUT_S(extranet_sgto_ordenes_compra1familia1DT_REQUEST_PROVEDOR_1id);
       DT_PROVEEDOR[] proveedor = SI_CON_PROVEEDOR_OC_UID_OUT_S13mtemp.getPROVEEDOR();
       String bandera="";
       if(proveedor==null){
    	   bandera="true";
       }else{
    	   bandera="false";
       }	   
       response.getWriter().println(bandera);
	}
	
	@RequestMapping("/existeNit")
	public void existeNit(HttpServletRequest request, HttpServletResponse response) throws IOException{
		extranet_sgto_ordenes_compra.familia.DT_CON_PROV extranet_sgto_ordenes_compra1familia1DT_CON_PROV_2id=new DT_CON_PROV();  
		extranet_sgto_ordenes_compra.familia.DT_REQUEST_PROVEDOR extranet_sgto_ordenes_compra1familia1DT_REQUEST_PROVEDOR_1id=new DT_REQUEST_PROVEDOR();
		extranet_sgto_ordenes_compra.familia.SI_CON_PROVEEDOR_OC_UID_OUT_SProxy sampleSI_CON_PROVEEDOR_OC_UID_OUT_SProxyid = new SI_CON_PROVEEDOR_OC_UID_OUT_SProxy();
		
		String nIT_6id=  request.getParameter("nitProveedor");
        java.lang.String nIT_6idTemp = null;
	    if(!nIT_6id.equals("")){
	     nIT_6idTemp  = nIT_6id;
	    }
	    extranet_sgto_ordenes_compra1familia1DT_CON_PROV_2id.setNIT(nIT_6idTemp);
       extranet_sgto_ordenes_compra1familia1DT_REQUEST_PROVEDOR_1id.setPROVEEDOR(extranet_sgto_ordenes_compra1familia1DT_CON_PROV_2id);
       extranet_sgto_ordenes_compra.familia.DT_RESPONSE_PROVEEDOR SI_CON_PROVEEDOR_OC_UID_OUT_S13mtemp = sampleSI_CON_PROVEEDOR_OC_UID_OUT_SProxyid.SI_CON_PROVEEDOR_OC_UID_OUT_S(extranet_sgto_ordenes_compra1familia1DT_REQUEST_PROVEDOR_1id);
       DT_PROVEEDOR[] proveedor = SI_CON_PROVEEDOR_OC_UID_OUT_S13mtemp.getPROVEEDOR();
       String bandera="";
       if(proveedor==null){
    	   bandera="true";
       }else{
    	   bandera="false";
       }	   
       response.getWriter().println(bandera);
	}

	public String quitarTilde(String conTilde){
		String ORIGINAL = "áéíóúÁÉÍÓÚ";
		String REPLACEMENT = "aeiouAEIOU";
		char[] array = conTilde.toCharArray();
		for(int i = 0; i < conTilde.length(); i++){
			int pos = ORIGINAL.indexOf(array[i]);
			if(pos > -1){
				array[i] = REPLACEMENT.charAt(pos);
			}
		}
		String sinTilde = String.valueOf(array);
		return sinTilde;
	}
	
}
