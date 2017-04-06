package com.familia.vales;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.Vector;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import javax.servlet.ServletContext;
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
import com.familia.vales.servicios.CorreoServicio;
import com.familia.vales.servicios.CorreoServicioImpl;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 * @author juan.arboleda
 */
@Controller
public class EditarController {
	private static final String PLANTILLA_PORTERIA = "com/familia/vales/correo/plantillaCorreoPortero.vm";
	
	private static final String PLANTILLA_SOLICITANTE = "com/familia/vales/correo/plantillaCorreoSolicitante.vm";

	private static final String PLANTILLA_ALMACEN = "com/familia/vales/correo/plantillaAlmacen.vm";
	
	private CorreoServicio contactenosServicio;
	
	@Autowired
	private DetalleValeRepository detValRep;
	
	@Autowired
	private  EstadoValeRepository estadoValeRepository;
	
	
	@Autowired
	private  ValeRepository valeRepository;
	
	@Autowired
	private  OperacionValeRepository operacionRep;

		
	@RequestMapping("/valeEditar")
  	public void valeEditar(HttpServletRequest request, HttpServletResponse response,Locale locale, Model model) throws IOException, ParseException {
		String fecFinal =  request.getParameter("fecFin");
		String fecProrroga =  request.getParameter("fecPro");	
		String numVale =  request.getParameter("idVal");
		String idDetVales = request.getParameter("idFila");
		String aprobado= request.getParameter("valApro");
		String correo2= request.getParameter("Correo");
		String aporbadoPort= request.getParameter("Port");
		
		this.contactenosServicio = new CorreoServicioImpl(); 
	  	Vale vale = valeRepository.findOne(Integer.parseInt(numVale));
	  	OperacionVale opVal = operacionRep.findOne(Integer.parseInt(numVale));
	  	String correo = opVal.getUsuario().getEmail();
	  	Collection<DetalleVale> valle = detValRep.findAll();
	  	Vector<DetalleVale> vall = new Vector<DetalleVale>();
	  	for (Iterator<DetalleVale> iterator = valle.iterator(); iterator.hasNext();) {
	  		DetalleVale detallVale = (DetalleVale) iterator.next();
	  		if(detallVale.getVale().getIdVale()==vale.getIdVale()){
	  			vall.add(detallVale);
	  		}
	  	}
	  	int tam = vall.size();
	  	int cont = 0;
	  	for (Iterator<DetalleVale> iterator = vall.iterator(); iterator.hasNext();) {
	  		DetalleVale detallVale = (DetalleVale) iterator.next();

			if(detallVale.getFila()==Integer.parseInt(idDetVales)){
				try {
		  			if(fecProrroga.equals("")){
			  			detallVale.setFechaProrroga(null);
			  		}else{
			  			DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
				  		Date datew = formatter.parse(fecProrroga);
				  		detallVale.setFechaProrroga(datew);
			  		}								
				} catch (Exception e) {
					System.out.println("Error : " + e);
				}
				
				try {
		  			if(fecFinal.equals("")){
			  			detallVale.setFechaFinal(null);
			  			detallVale.setRecibido("No");
			  			detallVale.setPort(aporbadoPort);
			  		}else{
			  			detallVale.setRecibido("Si");
			  			DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				  		Date datew = formatter.parse(fecFinal);
				  		DateFormat formatter1 = new SimpleDateFormat("dd-MM-yyyy");
				  		String datew1 = formatter1.format(datew);
				  		Date datew2 = formatter1.parse(datew1);
				  		detallVale.setFechaFinal(datew2);	
				  		detallVale.setPort(aporbadoPort);
				  		 try {
				  			 	contactenosServicio.enviarCorreo(correo,correo2,numVale, PLANTILLA_SOLICITANTE, response);
							} catch (Exception e) {
								System.out.println("error al enviar: "+ e);
							}
			  		}
					} catch (Exception e) {
						System.out.println("Error : " + e);
					}
					if(aprobado!="" && aprobado!=null){					
						detallVale.setAprobado(aprobado);
					}
					
					
		  			detValRep.save(detallVale);
			 }
			try {
				String comp = detallVale.getAprobado();
				if(comp.equals("Si")){
			  		cont+=1;			  
				}
			} catch (Exception e) {
				System.out.println("Error aprobado: "+e);
			}
			
	  	}

	  	if(cont == tam){
	  		EstadoVale est = estadoValeRepository.findOne(2);
			vale.setEstadoVale(est);
			valeRepository.save(vale);

	  	}
   }
	
	@RequestMapping("/valeEditar2")
  	public void valeEditar2(HttpServletRequest request, HttpServletResponse response,Locale locale, Model model) throws IOException, ParseException {
		String fecFinal =  request.getParameter("fecFin");
		String fecProrroga =  request.getParameter("fecPro");	
		String numVale =  request.getParameter("idVal");
		String idDetVales = request.getParameter("idFila");
		String aprobado= request.getParameter("valApro");
		String correo2= request.getParameter("Correo");
		String aporbadoPort= request.getParameter("Port");
	  	Vale vale = valeRepository.findOne(Integer.parseInt(numVale));
	  	OperacionVale opVal = operacionRep.findOne(Integer.parseInt(numVale));
	  	String correo = opVal.getUsuario().getEmail();
	  	Collection<DetalleVale> valle = detValRep.findAll();
	  	Vector<DetalleVale> vall = new Vector<DetalleVale>();
	  	for (Iterator<DetalleVale> iterator = valle.iterator(); iterator.hasNext();) {
	  		DetalleVale detallVale = (DetalleVale) iterator.next();
	  		if(detallVale.getVale().getIdVale()==vale.getIdVale()){
	  			vall.add(detallVale);
	  		}
	  	}
	  	int tam = vall.size();
	  	int cont = 0;
	  	for (Iterator<DetalleVale> iterator = vall.iterator(); iterator.hasNext();) {
	  		DetalleVale detallVale = (DetalleVale) iterator.next();
			if(detallVale.getFila()==Integer.parseInt(idDetVales)){
				try {
					System.out.println(fecProrroga);
		  			if(fecProrroga.equals("")){
			  			detallVale.setFechaProrroga(null);
			  		}else{
			  			DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
				  		Date datew = formatter.parse(fecProrroga);
				  		detallVale.setFechaProrroga(datew);
			  		}								
				} catch (Exception e) {
					System.out.println("Error : " + e);
				}
				
				try {
		  			if(fecFinal.equals("")){
			  			detallVale.setFechaFinal(null);
			  			detallVale.setRecibido("No");
			  			detallVale.setPort(aporbadoPort);
			  			System.out.println(aporbadoPort);
			  			if(aporbadoPort.equals("Si")){
			  				String[] almacenes = retornaAlmacenes(numVale);
			  				String[] correos = obtenerCorreos(almacenes);
			  				enviarCorreos(response,numVale,correos,correo2);
			  			}
			  		}else{
			  			detallVale.setRecibido("Si");
			  			DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				  		Date datew = formatter.parse(fecFinal);
				  		DateFormat formatter1 = new SimpleDateFormat("dd-MM-yyyy");
				  		String datew1 = formatter1.format(datew);
				  		Date datew2 = formatter1.parse(datew1);
				  		detallVale.setFechaFinal(datew2);
				  		detallVale.setPort(aporbadoPort);
				  		System.out.println(aporbadoPort);
				  		if(aporbadoPort.equals("Si")){
			  				String[] almacenes = retornaAlmacenes(numVale);
			  				String[] correos = obtenerCorreos(almacenes);
			  				enviarCorreos(response,numVale,correos,correo2);
			  			}
			  		}
					} catch (Exception e) {
						System.out.println("Error : " + e);
					}
					if(aprobado!="" && aprobado!=null){					
						detallVale.setAprobado(aprobado);
					}
					
					
		  			detValRep.save(detallVale);
			 }
			try {
				String comp = detallVale.getAprobado();
				if(comp.equals("Si")){
			  		cont+=1;			  
				}
			} catch (Exception e) {
				System.out.println("Error aprobado: "+e);
			}
			
	  	}

	  	if(cont == tam){
	  		EstadoVale est = estadoValeRepository.findOne(2);
			vale.setEstadoVale(est);
			valeRepository.save(vale);

	  	}
   }
	
	public String[] retornaAlmacenes(String numVale) throws IOException, ParseException{
		Vale vale = valeRepository.findOne(Integer.parseInt(numVale));
		String ciudad = vale.getPlanta();
		String[] almacenes = null;
		System.out.println(ciudad);
		switch(ciudad){
			case " Medellin": 
				ArrayList<String> alamcenistas=new ArrayList<>();
				alamcenistas = almacenistasLdap("AprobadoresMedellin");
				almacenes=new String[alamcenistas.size()];
				for(int i=0;i<alamcenistas.size();i++){
					almacenes[i]=alamcenistas.get(i);
				}				
				break;
		}
		return almacenes;
	}
	
	public String[] obtenerCorreos(String[] cn){
		  String[] correo=new String[cn.length];
		  for(int i=0;i<correo.length;i++){
			  if(cn[i].equals("SalMat Alma")){
				  System.out.println("salmat alma");
			  }else{
				  String unico="";
				  String url = "ldap://familia.com.co:389";
					Hashtable<String, String> env = new Hashtable<String, String>();
					env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
					env.put(Context.PROVIDER_URL, url);
					env.put(Context.SECURITY_AUTHENTICATION, "simple");
					env.put(Context.SECURITY_PRINCIPAL, "CN=Salmat Alma,OU=Medellin,OU=Colombia,OU=Usuarios,OU=Familia,DC=familia,DC=com,DC=co");
					env.put(Context.SECURITY_CREDENTIALS, "Inicio2016");
					String ruta = "OU=Usuarios,OU=Familia,DC=familia,DC=com,DC=co";
					  try {
					        DirContext ctx = new InitialDirContext(env);
					        NamingEnumeration<?> namingEnum = ctx.search(ruta, "OU=*", new SearchControls());
					        while (namingEnum.hasMore ()) {	
					            SearchResult result = (SearchResult) namingEnum.next ();    
					            Attributes attrs = result.getAttributes ();
					            String pais = attrs.get("ou").toString();
					            pais=pais.substring(4);
					            String ruta1="OU="+pais+","+ruta;
					            NamingEnumeration<?> namingEnum1 = ctx.search(ruta1, "OU=*", new SearchControls());
					            while(namingEnum1.hasMore ()){
					            	SearchResult result1 = (SearchResult) namingEnum1.next ();
						            Attributes attrs1 = result1.getAttributes ();
						            String ciudad = attrs1.get("ou").toString();
						            ciudad=ciudad.substring(4);
						            String ruta2="OU="+ciudad+","+ruta1;
						            String user="CN="+cn[i];
						            System.out.println("usuario "+user);
						            NamingEnumeration<?> namingEnum2 = ctx.search(ruta2, user, new SearchControls());
						            while(namingEnum2.hasMore ()){
						
						            	SearchResult result2 = (SearchResult) namingEnum2.next ();   
							            Attributes attrs2 = result2.getAttributes ();
							            unico = attrs2.get("mail").toString();
							            System.out.println("los coreooooos son: "+correo);
						            }
					            }
					        }
					      namingEnum.close();
					    } catch (Exception e) {
					        e.printStackTrace();
					    }
					  unico = unico.substring(6);
					  correo[i]=unico;
			  }			  
		  }
		  
		  System.out.println(correo);
		  return correo;
	  }
	
	public ArrayList<String> almacenistasLdap(String lugar) throws IOException, ParseException {
		  String ruta="CN="+lugar;
		  System.out.println("ruta "+ruta);
		  String url = "ldap://familia.com.co:389";
		  Hashtable<String, String> env = new Hashtable<String, String>();
		  env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
		  env.put(Context.PROVIDER_URL, url);
		  env.put(Context.SECURITY_AUTHENTICATION, "simple");
		  env.put(Context.SECURITY_PRINCIPAL, "CN=Salmat Alma,OU=Medellin,OU=Colombia,OU=Usuarios,OU=Familia,DC=familia,DC=com,DC=co");
		  env.put(Context.SECURITY_CREDENTIALS, "Inicio2016");
		  ArrayList<String> alamcenistas=new ArrayList<>();
		  try {
		        DirContext ctx = new InitialDirContext(env);		 
		        NamingEnumeration<?> namingEnum = ctx.search("OU=Salma,OU=Aplicaciones,OU=Grupos,OU=Familia,DC=familia,DC=com,DC=co", ruta, new SearchControls());
		        while (namingEnum.hasMore ()) {		        	
		            SearchResult result = (SearchResult) namingEnum.next ();    
		            Attributes attrs = result.getAttributes ();
		            String miembros=attrs.get("member").toString();
		            for(int i = 0;i < miembros.length(); i++){
		            	int inicio = miembros.indexOf("CN"); 
		            	int fin = miembros.indexOf(",",inicio);
		         
		            	if(inicio != -1){
		            		String usuario=miembros.substring(inicio+3, fin);
			            	alamcenistas.add(usuario);
			            	miembros=miembros.substring(fin+1);
		            	}
		            	
		            }
		        }
		        namingEnum.close();
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		  return alamcenistas;
	  }
	
	
	public static void enviarCorreos(HttpServletResponse response,String id, String[] para, String de) throws MessagingException{
		Properties properties = new Properties();
			properties.put("mail.smtp.host", "correoapps.familia.com.co");
			properties.put("mail.smtp.localhost", "correoapps.familia.com.co");
			properties.put("hostname", "correoapps.familia.com.co");
			properties.put("mail.smtp.port", 25);

			Session session = Session.getDefaultInstance(properties, null);
			
			BodyPart texto = new MimeBodyPart();
           texto.setText("Coordial Saludo, llegó un material del vale "+id+" .Gracias");          
           MimeMultipart multiParte = new MimeMultipart();
           multiParte.addBodyPart(texto);
           
			session.setDebug(true);

			MimeMessage msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress(de));
			 Address[] destinos = new Address[para.length];
	            for(int i=0;i<destinos.length;i++){
	                destinos[i]=new InternetAddress(para[i]);
	            }
	            msg.addRecipients(Message.RecipientType.TO,destinos);
			msg.setSubject("Vale entrante", "ISO-8859-1");
			msg.setSentDate(new Date());

			msg.setContent(multiParte);

			Transport transport = null;
			try {
				response.setContentType("text/html");
				transport = session.getTransport("smtp");
				transport.connect();
				transport.sendMessage(msg, msg.getAllRecipients());
			} catch (Exception e) {

			} finally {
				if (transport != null) {
					transport.close();
				}
			}
       
}
		

	@RequestMapping("/verPdf")
	public void verPdf(HttpServletRequest request, HttpServletResponse response,Locale locale, Model model) throws IOException, ParseException {
				String valeId=request.getParameter("idValePdf");
				Vale val = valeRepository.findOne(Integer.parseInt(valeId));

      
		    	try{ 
					
	  				Date fecha1 = new Date();		  			
	  				DateFormat dateFormat1 = new SimpleDateFormat("EEE, MMM d, yyyy");		  				
	  				String fechaActu = dateFormat1.format(fecha1);
	  	            ServletContext servletContext = request.getSession().getServletContext();
		            String relativeWebPath = "resources/hellojasper.jrxml";
		            String absoluteDiskPath = servletContext.getRealPath(relativeWebPath);
		            
		            JasperReport jasperReport = 
		            JasperCompileManager.compileReport(absoluteDiskPath);	
	  	            String titulo = "Reporte De Vale "+ valeId;
	  	            Map<String, Object> parameters = new HashMap<String, Object>();
	  	            parameters.put("ReportTitle", titulo);
	  	            parameters.put("vales", val);
	  	            parameters.put("FechaAct", fechaActu);  
	  	            Collection<DetalleVale> valle = detValRep.findAll();
	  	            ArrayList<DetalleVale> vall= new ArrayList<DetalleVale>();
	  				for (Iterator<DetalleVale> iterator = valle.iterator(); iterator.hasNext();) {
	  					DetalleVale detallVale = (DetalleVale) iterator.next();
	  					if(detallVale.getVale().getIdVale()==Integer.parseInt(valeId)){
	  						vall.add(detallVale);
	  					}
	  				}

	  				JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(vall);
	  				JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters,beanColDataSource);  	     
		  	        JasperViewer.viewReport(jasperPrint,false);
	  	        }
	  	        catch (JRException e){
	  	            e.printStackTrace();
	  	        }
		   
		    	
	   }
	
	@RequestMapping(value = "/aprobar", method = RequestMethod.POST)
  	public ModelAndView aprobar(HttpServletRequest request, HttpServletResponse response,Locale locale, Model model) throws IOException, ParseException {
		String numVale =  request.getParameter("idFiltrado");		
		String correo2= request.getParameter("correoUsuario");
		
	  	String correoPort = request.getParameter("correoPorteria");
	  	String correo = obtenerCorreo(correoPort);
		Vale val = valeRepository.findOne(Integer.parseInt(numVale));
		String alamcen=request.getParameter("almacen");
		val.setAlmacen(alamcen);
		valeRepository.save(val);
		this.contactenosServicio = new CorreoServicioImpl(); 
		try {
	        	contactenosServicio.enviarCorreo(correo,correo2,numVale, PLANTILLA_PORTERIA, response);
			} catch (Exception e) {
				System.out.println("error "+ e);
			}
	  		return new ModelAndView("redirect:/lista");
			
   }
	
	@RequestMapping("/borrarVale")
	public void borrarVale(HttpServletRequest request, HttpServletResponse response,Locale locale, Model model) throws IOException, ParseException {
				String valeId=request.getParameter("idVale");
				Collection<DetalleVale> valle = detValRep.findAll();	  	          
	  			for (Iterator<DetalleVale> iterator = valle.iterator(); iterator.hasNext();) {
	  				DetalleVale detallVale = (DetalleVale) iterator.next();
	  				if(detallVale.getVale().getIdVale()==Integer.parseInt(valeId)){
	  					detValRep.delete(detallVale);
	  				}
	  			}
	  			Collection<OperacionVale> Opvale = operacionRep.findAll();  	          
	  			for (Iterator<OperacionVale> iterator = Opvale.iterator(); iterator.hasNext();) {
	  				OperacionVale opeVale = (OperacionVale) iterator.next();
	  				if(opeVale.getVale().getIdVale()==Integer.parseInt(valeId)){
	  					operacionRep.delete(opeVale);
	  				}
	  			}
				Vale eliminado = valeRepository.findOne(Integer.parseInt(valeId));
				valeRepository.delete(eliminado);
	   }

@RequestMapping("/verPdfBrowser")
	public void verPdfBrowser(HttpServletRequest request, HttpServletResponse response,Locale locale, Model model) throws IOException, ParseException {
			String valeId=request.getParameter("idValePdf");
			Vale val = valeRepository.findOne(Integer.parseInt(valeId));
	    	try{ 
				
				Date fecha1 = new Date();		  			
				DateFormat dateFormat1 = new SimpleDateFormat("EEE, MMM d, yyyy");		  				
				String fechaActu = dateFormat1.format(fecha1);
	            
	            ServletContext servletContext = request.getSession().getServletContext();
	            String relativeWebPath = "resources/hellojasper.jrxml";
	            String absoluteDiskPath = servletContext.getRealPath(relativeWebPath);
	            JasperReport jasperReport = 
	            JasperCompileManager.compileReport(absoluteDiskPath);	
	            String titulo = "Reporte De Vale "+ valeId;
	            Map<String, Object> parameters = new HashMap<String, Object>();
	            parameters.put("ReportTitle", titulo);
	            parameters.put("vales", val);
	            parameters.put("FechaAct", fechaActu);  
	            Collection<DetalleVale> valle = detValRep.findAll();
	            ArrayList<DetalleVale> vall= new ArrayList<DetalleVale>();
				for (Iterator<DetalleVale> iterator = valle.iterator(); iterator.hasNext();) {
					DetalleVale detallVale = (DetalleVale) iterator.next();
					if(detallVale.getVale().getIdVale()==Integer.parseInt(valeId)){
						vall.add(detallVale);
					}
				}

	          JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(vall);

			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters,beanColDataSource);  	     
	  	        
	  	    File pdf = File.createTempFile("output.", ".pdf");
	  	    JasperExportManager.exportReportToPdfStream(jasperPrint, new FileOutputStream(pdf));
	  	    FileInputStream ficheroInput = new FileInputStream(pdf);
	  	  	int tamanoInput = ficheroInput.available();
		  	byte[] datosPDF = new byte[tamanoInput];
		  	ficheroInput.read( datosPDF, 0, tamanoInput);
		  	 
		  	response.setHeader("Content-disposition","inline; filename=vale.pdf" );
		  	response.setContentType("application/pdf");
		  	response.setContentLength(tamanoInput);
		  	response.getOutputStream().write(datosPDF);		  	 
		  	ficheroInput.close();

	        }
	        catch (JRException e){
	            e.printStackTrace();
	        }

	}

@RequestMapping("/porteriasLdap")
public void porteriasLdap(HttpServletRequest request, HttpServletResponse response,Locale locale, Model model) throws IOException, ParseException {
	  String lugar=  request.getParameter("lugarPorteria");
	  String ruta="CN="+lugar;
	  String url = "ldap://familia.com.co:389";
	  Hashtable<String, String> env = new Hashtable<String, String>();
	  env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
	  env.put(Context.PROVIDER_URL, url);
	  env.put(Context.SECURITY_AUTHENTICATION, "simple");
	  env.put(Context.SECURITY_PRINCIPAL, "CN=Salmat Alma,OU=Medellin,OU=Colombia,OU=Usuarios,OU=Familia,DC=familia,DC=com,DC=co");
	  env.put(Context.SECURITY_CREDENTIALS, "Inicio2016");
	  ArrayList<String> porterias=new ArrayList<>();
	  try {
	        DirContext ctx = new InitialDirContext(env);		 
	        NamingEnumeration<?> namingEnum = ctx.search("OU=Salma,OU=Aplicaciones,OU=Grupos,OU=Familia,DC=familia,DC=com,DC=co", ruta, new SearchControls());
	        while (namingEnum.hasMore ()) {		        	
	            SearchResult result = (SearchResult) namingEnum.next ();    
	            Attributes attrs = result.getAttributes ();
	            String miembros=attrs.get("member").toString();
	            for(int i = 0;i < miembros.length(); i++){
	            	int inicio = miembros.indexOf("CN"); 
	            	int fin = miembros.indexOf(",",inicio);
	         
	            	if(inicio != -1){
	            		String usuario=miembros.substring(inicio+3, fin);
	            		porterias.add("?"+usuario+"?");
		            	miembros=miembros.substring(fin+1);
	            	}
	            	
	            }
	        }
	        namingEnum.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	  response.getWriter().println(porterias);
}

public String obtenerCorreo(String cn){
	  String correo="";
	  String url = "ldap://familia.com.co:389";
		Hashtable<String, String> env = new Hashtable<String, String>();
		env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
		env.put(Context.PROVIDER_URL, url);
		env.put(Context.SECURITY_AUTHENTICATION, "simple");
		env.put(Context.SECURITY_PRINCIPAL, "CN=Salmat Alma,OU=Medellin,OU=Colombia,OU=Usuarios,OU=Familia,DC=familia,DC=com,DC=co");
		env.put(Context.SECURITY_CREDENTIALS, "Inicio2016");
		String ruta = "OU=Usuarios,OU=Familia,DC=familia,DC=com,DC=co";
		  try {
		        DirContext ctx = new InitialDirContext(env);
		        NamingEnumeration<?> namingEnum = ctx.search(ruta, "OU=*", new SearchControls());
		        while (namingEnum.hasMore ()) {	
		            SearchResult result = (SearchResult) namingEnum.next ();    
		            Attributes attrs = result.getAttributes ();
		            String pais = attrs.get("ou").toString();
		            pais=pais.substring(4);
		            String ruta1="OU="+pais+","+ruta;
		            NamingEnumeration<?> namingEnum1 = ctx.search(ruta1, "OU=*", new SearchControls());
		            while(namingEnum1.hasMore ()){
		            	SearchResult result1 = (SearchResult) namingEnum1.next ();
			            Attributes attrs1 = result1.getAttributes ();
			            String ciudad = attrs1.get("ou").toString();
			            ciudad=ciudad.substring(4);
			            String ruta2="OU="+ciudad+","+ruta1;
			            String user="CN="+cn;
			            NamingEnumeration<?> namingEnum2 = ctx.search(ruta2, user, new SearchControls());
			            while(namingEnum2.hasMore ()){
			            	SearchResult result2 = (SearchResult) namingEnum2.next ();    
				            Attributes attrs2 = result2.getAttributes ();
				            correo = attrs2.get("mail").toString();
				            System.out.println(correo);
			            }
		            }
		        }
		      namingEnum.close();
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		  correo = correo.substring(6);
	  return correo;
}


}
