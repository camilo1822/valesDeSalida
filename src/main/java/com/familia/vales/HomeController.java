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
import javax.naming.AuthenticationException;
import javax.naming.AuthenticationNotSupportedException;
import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.familia.vales.jpa.entities.DetalleVale;
import com.familia.vales.jpa.entities.EstadoVale;
import com.familia.vales.jpa.entities.MotivoVale;
import com.familia.vales.jpa.entities.OperacionVale;
import com.familia.vales.jpa.entities.UnidadMedidaVale;
import com.familia.vales.jpa.entities.Usuario;
import com.familia.vales.jpa.entities.Vale;
import com.familia.vales.jpa.repository.DetalleValeRepository;
import com.familia.vales.jpa.repository.EstadoValeRepository;
import com.familia.vales.jpa.repository.MotivoValeRepository;
import com.familia.vales.jpa.repository.OperacionValeRepository;
import com.familia.vales.jpa.repository.UnidadMedidaValeRepository;
import com.familia.vales.jpa.repository.UsuarioRepository;
import com.familia.vales.jpa.repository.ValeRepository;
import com.familia.vales.servicios.CorreoServicio;
import com.familia.vales.servicios.CorreoServicioImpl;

import extranet_devoluciones_oc.familia.DT_FCMM;
import extranet_devoluciones_oc.familia.SI_CONSULTA_MATERIALES_OUT_SProxy;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;


/**
 * @author juan.arboleda
 */
@Controller
public class HomeController{
	
	private static final String PLANTILLA_CONTACTENOS = "com/familia/vales/correo/plantillaCorreo.vm";
	private static final String PLANTILLA_PORTERIA = "com/familia/vales/correo/plantillaCorreoPortero.vm";
	private CorreoServicio contactenosServicio;		
	private String actualizado;
	
	/*private String Logeado="deslogeado";
	private String CorreoLogeado="";*/
	
	@Autowired
	private DetalleValeRepository detValRep;	
	
	@Autowired
	private  UnidadMedidaValeRepository umRepository;
	
	@Autowired
	private  UsuarioRepository userRep;
	
	@Autowired
	private  EstadoValeRepository estREp;
	
	@Autowired
	private  OperacionValeRepository opRep;
	
	@Autowired
	private  MotivoValeRepository motRep;
	
	@Autowired
	private  ValeRepository valeRepository;
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home(Locale locale, Model model,HttpServletRequest request, HttpServletResponse response) throws Exception{
		actualizado="";
		String esSolicitante="";

		this.contactenosServicio = new CorreoServicioImpl();	
		Collection<UnidadMedidaVale> umVale = umRepository.findAll();
		String unidades[] = new String[umVale.size()];
		Collection<MotivoVale> mtVale = motRep.findAll();
		String motivos[] = new String[mtVale.size()];

		int i = 0;
		for (Iterator<UnidadMedidaVale> iterator = umVale.iterator(); iterator.hasNext();) {
			UnidadMedidaVale umVAl = (UnidadMedidaVale) iterator.next();
			unidades[i]=umVAl.getUnidadMedida();
			i+=1;
		}

		int j = 0;
		for (Iterator<MotivoVale> iterator = mtVale.iterator(); iterator.hasNext();) {
			MotivoVale mtVAl = (MotivoVale) iterator.next();
			motivos[j]=mtVAl.getMotivo();
			j+=1;
		}
		
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("EEE, MMM d, yyyy");
		Date fecHoy = new Date();
		DateFormat formatterHoy = new SimpleDateFormat("yyyy-MM-dd");
		String datewHoy = formatterHoy.format(fecHoy);

		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
				
		Collection<Vale> val = valeRepository.findAll();
		int numero=0;
		int tam = val.size();
		if(tam==0){
			numero=1;
		}else{
			for(int l = 1; l<=val.size();l++){
				Vale valPru = valeRepository.findOne(l);
				if(valPru==null){
					numero = l;
					break;
				}
				numero=l+1;
			}
		}		
				
		EstadoVale estatus = estREp.findOne(1);
		String status = estatus.getEstado();
		
		Map<String, Object> miModelo = new HashMap<String, Object>();
		
		/*miModelo.put("credencial",Logeado);
		miModelo.put("credencialCorreo",CorreoLogeado);*/
		miModelo.put("fecha", formattedDate);
		miModelo.put("fechaHoy", datewHoy);
		miModelo.put("esSolicitante", esSolicitante);
		miModelo.put("numVale", numero);
		miModelo.put("estado", status);
		miModelo.put("unidades", unidades);
		miModelo.put("motivos",motivos);
		ModelAndView miMAV = new ModelAndView();
        miMAV.setViewName("home");
        miMAV.addObject("model",miModelo);

        return miMAV;
	}
	
	/**
	 * Simply selects the home view to render by returning its name.
	 * @throws IOException 
	 * @throws ParseException 
	 */
	  @RequestMapping(value = "/vale", method = RequestMethod.POST)
	   public ModelAndView vale(HttpServletRequest request, HttpServletResponse response,Locale locale, Model model,final RedirectAttributes redirectAttributes) throws IOException, ParseException {		
		  if(actualizado.equals("")){
		  				String ciuDest = request.getParameter("ciudadContacto");
		  				String numVale =  request.getParameter("idFiltrado");
			  			String piciz =  request.getParameter("contratadoEnPiciz");
			  			String senores =  request.getParameter("senhores");
			  			String diligenciado =  request.getParameter("autorizadoPor");
			  			String motivo =  request.getParameter("selectMotivo");
			  			String cual =  request.getParameter("cual");
			  			String justificacion =  request.getParameter("justificacion");
			  			String proveedor =  request.getParameter("proveedorId");
			  			String nit =  request.getParameter("nit");
			  			String empresa =  request.getParameter("empresa");
			  			String direccion =  request.getParameter("direccion");
			  			String nombre =  request.getParameter("nombreContacto");
			  			String telefono =  request.getParameter("telefonoContacto");
			  			String nombreRetira =  request.getParameter("nombreRetira");
			  			String cc =  request.getParameter("ccRetira");
			  			String empresaTrans =  request.getParameter("empresaTransporte");
			  			String placa =  request.getParameter("placaVehiculo");
			  						  			
			  			String observaciones =  request.getParameter("observaciones");
			  			String solicitante =  request.getParameter("solicitante");	
			  			
			  			String correo = request.getParameter("correoUsuario");
			  			String usuarioAlmacen = request.getParameter("correoAlmacen");
			  			String correoAlmacen = obtenerCorreo(usuarioAlmacen);
			  			System.out.println("correoAlmacen "+correoAlmacen);
			  			String planta =  request.getParameter("plantaUsuario");
			  			
			  			DetalleVale detVal = new DetalleVale();
			  			EstadoVale estVal = new EstadoVale();
			  			OperacionVale oprVal = new OperacionVale();			  			
			  			Usuario user = new Usuario();
			  			Vale vale = new Vale();
			  			
			  			Date date = new Date();
			  				  			
			  			/*vale*/
			  			EstadoVale es = estREp.findOne(1);
			  			
			  			vale.setDestinoCiudad(ciuDest);
			  			vale.setDestinoDireccion(direccion);
			  			vale.setDestinoEmpresa(empresa);
			  			vale.setDestinoNit(nit);
			  			vale.setDestinoNombre(nombre);
			  			vale.setDestinoTel(telefono);
			  			vale.setEstadoVale(es);
			  			vale.setFechaCreacion(date);
			  			vale.setIdVale(Integer.parseInt(numVale));
			  			vale.setJustificacion(justificacion);
			  			vale.setDestinoProveedor(proveedor);
			  			vale.setSenores(senores);
			  			vale.setMaterialPiciz(piciz);

			  			if(motivo.equals("Reparación")){
			  				vale.setMotivo("Reparación / Fabricación");
			  			}else if(motivo.equals("Procesamiento")){
			  				vale.setMotivo("Procesamiento Parcial");
			  			}else if(motivo.equals("Devolución")){
			  				vale.setMotivo("Devolución");
			  			}else if(motivo.equals("Venta")){
			  				vale.setMotivo("Venta Desperdicio");
			  			}else if(motivo.equals("Donación")){
			  				vale.setMotivo("Donación");
			  			}else if(motivo.equals("Préstamos")){
			  				vale.setMotivo("Préstamos");
			  			}else{
			  				vale.setMotivo(cual);
			  			}
			  			
			  			vale.setNombreDiligencio(diligenciado);
			  			vale.setPlanta(planta);
			  			vale.setRetiraEmpresa(empresaTrans);
			  			vale.setRetiraIdentificacion(cc);
			  			vale.setRetiraNombre(nombreRetira);
			  			vale.setRetiraPlaca(placa);
			  			vale.setObservaciones(observaciones);
			  			vale.setSolicitante(solicitante);
			  			valeRepository.save(vale);
			  			/*vale*/
			  				
			  			/*user*/
			  			user.setEmail(correo);
			  			user.setIdUsuario(Integer.parseInt(numVale));
			  			user.setNombres(solicitante);
			  			userRep.save(user);
			  			/*finUser*/
			  			
			  			
			  			/*Operacion*/
			  			estVal=estREp.findOne(1);
			  			oprVal.setDescripcion("General");
			  			oprVal.setEstadoValeFinal(estVal);
			  			oprVal.setEstadoValeInicial(estVal);
			  			oprVal.setFecha(null);
			  			oprVal.setIdOperacionVale(Integer.parseInt(numVale));
			  			oprVal.setUsuario(user);
			  			oprVal.setVale(vale);
			  			opRep.save(oprVal);
			  			/*fin operacion*/
			  			

			  			int pare = Integer.parseInt(request.getParameter("filaTotal"));
			  			System.out.println(pare);
			  			for(int i = 1;i<pare;i++){
				  			String idDet = numVale+i;
				  			int tamm = Integer.parseInt(idDet);
			  				String fila =  request.getParameter("fila"+i);
			  				if(fila!=null){
			  					String codigo =  request.getParameter("codigo"+i);
			  					String centro = request.getParameter("centro"+i);
					  			String descripcion =  request.getParameter("descri"+i);
					  			String um =  request.getParameter("um"+i);
					  			detVal.setUnidad(um);
					  			UnidadMedidaVale b;
					  			b = umRepository.findOne(1);
					  			detVal.setUnidadMedidaVale(b);
					  			String cantidad =  request.getParameter("cantidad"+i);
					  			String valorUni =  request.getParameter("vlrUnitario"+i);
					  				
					  			String valor =  request.getParameter("valor"+i);
					  			String peso =  request.getParameter("peso"+i);
					  			String regresa =  request.getParameter("regresa"+i);
					  			String pertenece =  request.getParameter("repuesto"+i);
					  			String oc =  request.getParameter("noOc"+i);
					  			String oca =  request.getParameter("noOca"+i);
					  			String fechaEspp =  request.getParameter("fecha"+i);
					  			try {
					  				if(fechaEspp.equals("")){
					  					detVal.setFechaEsperada(null);
						  			}else{
						  				DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
							  			Date datew = formatter.parse(fechaEspp);
							  			detVal.setFechaEsperada(datew);					  			
						  			}								
								} catch (Exception e) {
									System.out.println("Error : " + e);
								}
					  			detVal.setCantidad(Integer.parseInt(cantidad));
					  			detVal.setValorUni(Double.parseDouble(valorUni));
					  			detVal.setCodigo(codigo);
					  			detVal.setCentro(centro);
					  			detVal.setDescripcion(descripcion);				  			
					  			detVal.setFechaProrroga(null);
					  			detVal.setFila(Integer.parseInt(fila));
					  			detVal.setIdDetalleVale(tamm);
					  			if(oc.equals("N/A")){
					  				detVal.setNoOc(0);
					  			}else{
					  				detVal.setNoOc(Integer.parseInt(oc));
					  			}
					  			if(oca.equals("N/A")){
					  				detVal.setOcAd(0);
					  			}else{
					  				detVal.setOcAd(Integer.parseInt(oca));
					  			}
					  			detVal.setPerteneceMaquina(pertenece);
					  			detVal.setPeso(Double.parseDouble(peso));
					  			detVal.setVale(vale);
					  			detVal.setValor(Double.parseDouble(valor));
					  			detVal.setRegresa(regresa);
					  			if(regresa.equals("Si")){
					  				detVal.setRecibido("No");
					  				detVal.setAprobado("No");
					  				detVal.setFechaFinal(null);
					  			}else{
					  				detVal.setRecibido("Si");
					  				detVal.setAprobado("Si");
				  					Date fecFin = new Date();
				  					DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				  					String datew1 = formatter.format(fecFin);
						  			Date datew = formatter.parse(datew1);
				  					detVal.setFechaFinal(datew);
					  			}
					  			detValRep.save(detVal);
			  				}			  		
			  			}
			  			/*Fin detalle*/
			  			
			  			String redirect = request.getParameter("direccionFiltrada");

			  			if(redirect.equals("vales")){
			  				String numero = numVale;
			  				Vale val1 = valeRepository.findOne(Integer.parseInt(numero));
			  				Vector<DetalleVale> vecDetalle = new Vector<DetalleVale>();
			  				Collection<DetalleVale> detVal1 = detValRep.findAll();
			  				int numFila = 0;
			  				
			  				for (Iterator<DetalleVale> iterator = detVal1.iterator(); iterator.hasNext();) {
			  					DetalleVale DetVale = (DetalleVale) iterator.next();
			  					if(DetVale.getVale().getIdVale()==Integer.parseInt(numero)){
			  						vecDetalle.add(DetVale);
			  						numFila+=1;
			  					}
			  				}
			  				
			  				Date date1 = new Date();	
			  				DateFormat dateFormat = new SimpleDateFormat("EEE, MMM d, yyyy");		  			
			  				String fecha = dateFormat.format(date1);
			  				
			  				Map<String, Object> miModelo = new HashMap<String, Object>();
			  				miModelo.put("fecha", fecha);
			  				miModelo.put("numFila", numFila);
			  				miModelo.put("vale", val1);
			  				miModelo.put("detVales", vecDetalle);
			  				miModelo.put("prueba", numero);
			  				ModelAndView miMAV = new ModelAndView();
			  		        miMAV.setViewName("valeShow");
			  		        miMAV.addObject("model",miModelo);

			  		      try {
			  		        	contactenosServicio.enviarCorreo(correoAlmacen,correo,numVale, PLANTILLA_CONTACTENOS, response);
							} catch (Exception e) {
								System.out.println("error "+ e);
							}
				  		    actualizado="lista";
			  		        return miMAV;
			  			}
			  			
			  			ModelAndView miMAV = new ModelAndView();
		  		        miMAV.setViewName(redirect);
		  		        try {
		  		        	contactenosServicio.enviarCorreo(correoAlmacen,correo,numVale, PLANTILLA_CONTACTENOS, response);
						} catch (Exception e) {
							System.out.println("error "+ e);
						}
			  			return miMAV;	
		  			}else{
		  				actualizado="";
		  				return new ModelAndView("redirect:/lista");
		  			}
		  			
	   }
	  
	  @RequestMapping(value = "/valeSaliente", method = RequestMethod.GET)
	   public ModelAndView valeSaliente(HttpServletRequest request, HttpServletResponse response,Locale locale, Model model) throws IOException, ParseException {
		String prueba = request.getParameter("valorFiltrado");
		Vale val = valeRepository.findOne(Integer.parseInt(prueba));
		Vector<DetalleVale> vecDetalle = new Vector<DetalleVale>();
		Collection<DetalleVale> detVal = detValRep.findAll();
		int numFila = 0;
		Date fecHoy = new Date();
		DateFormat formatterHoy = new SimpleDateFormat("yyyy-MM-dd");
		String datewHoy = formatterHoy.format(fecHoy);
		
		for (Iterator<DetalleVale> iterator = detVal.iterator(); iterator.hasNext();) {
			DetalleVale DetVale = (DetalleVale) iterator.next();
			if(DetVale.getVale().getIdVale()==Integer.parseInt(prueba)){
				vecDetalle.add(DetVale);
				numFila+=1;
			}
		}	
		
		Date date = new Date();	
		DateFormat dateFormat = new SimpleDateFormat("EEE, MMM d, yyyy");		  			
		String fecha = dateFormat.format(date);
		
		Map<String, Object> miModelo = new HashMap<String, Object>();
		miModelo.put("fechaHoy", datewHoy);
		miModelo.put("fecha", fecha);
		miModelo.put("numFila", numFila);
		miModelo.put("vale", val);
		miModelo.put("detVales", vecDetalle);
		miModelo.put("prueba", prueba);
		ModelAndView miMAV = new ModelAndView();
    miMAV.setViewName("valeSaliente");
    miMAV.addObject("model",miModelo);

     return miMAV;
			
	   }
	  
	  @RequestMapping("/firmaPorteria")
	   public void firmaPorteria(HttpServletRequest request, HttpServletResponse response,Locale locale, Model model) throws IOException, ParseException {
				String valeId=request.getParameter("idValePdf");
				Vale val = valeRepository.findOne(Integer.parseInt(valeId));
				String porteria=request.getParameter("firmaPorteria");
				if(porteria != null){
					val.setPorteria(porteria);
					valeRepository.save(val);
				}
	   }
	  
	  @RequestMapping("/firmaAlmacen")
	  public void firmaAlmacen(HttpServletRequest request, HttpServletResponse response){
		  String numVale =  request.getParameter("idValePdf");		
		  String correoRemitente = request.getParameter("correoRem");		
		  	String correoPort = request.getParameter("correoPort");
		  	String firma = request.getParameter("firmaAlmcen");	
			
		  	String correo = obtenerCorreo(correoPort);
			Vale val = valeRepository.findOne(Integer.parseInt(numVale));
			val.setAlmacen(firma);
			valeRepository.save(val);	
			this.contactenosServicio = new CorreoServicioImpl(); 
			try {
		        	contactenosServicio.enviarCorreo(correo,correoRemitente,numVale, PLANTILLA_PORTERIA, response);
				} catch (Exception e) {
					System.out.println("error "+ e);
				}
	  }
	  
		public static void enviarPdf(String pdf,String cuerpo,HttpServletResponse response, String para, String de) throws MessagingException{
				 Properties properties = new Properties();
					properties.put("mail.smtp.host", "correoapps.familia.com.co");
					properties.put("mail.smtp.localhost", "correoapps.familia.com.co");
					properties.put("hostname", "correoapps.familia.com.co");
					properties.put("mail.smtp.port", 25);

					Session session = Session.getDefaultInstance(properties, null);
					
					BodyPart texto = new MimeBodyPart();
		            texto.setText(cuerpo);
		            BodyPart adjunto = new MimeBodyPart();
		            adjunto.setDataHandler(
		                new DataHandler(new FileDataSource(pdf)));
		            adjunto.setFileName("vale.pdf");
		            MimeMultipart multiParte = new MimeMultipart();
		            multiParte.addBodyPart(texto);
		            multiParte.addBodyPart(adjunto);
		            
					session.setDebug(true);

					MimeMessage msg = new MimeMessage(session);

					msg.setFrom(new InternetAddress(para));
					Address toAddress = new InternetAddress(de);
					msg.setRecipient(Message.RecipientType.TO, toAddress);

					msg.setSubject("Vale rechazado", "ISO-8859-1");
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
		
		public void borrarRechazado(String id, HttpServletResponse response) throws IOException, ParseException {
			String valeId=id;
			Collection<DetalleVale> valle = detValRep.findAll();	  	          
  			for (Iterator<DetalleVale> iterator = valle.iterator(); iterator.hasNext();) {
  				DetalleVale detallVale = (DetalleVale) iterator.next();
  				if(detallVale.getVale().getIdVale()==Integer.parseInt(valeId)){
  					detValRep.delete(detallVale);
  				}
  			}
  			Collection<OperacionVale> Opvale = opRep.findAll();  	          
  			for (Iterator<OperacionVale> iterator = Opvale.iterator(); iterator.hasNext();) {
  				OperacionVale opeVale = (OperacionVale) iterator.next();
  				if(opeVale.getVale().getIdVale()==Integer.parseInt(valeId)){
  					opRep.delete(opeVale);
  				}
  			}
			Vale eliminado = valeRepository.findOne(Integer.parseInt(valeId));
			valeRepository.delete(eliminado);
   }
		
	  
	  @RequestMapping("/rechazarVale")
	  public void rechazarVale(HttpServletRequest request, HttpServletResponse response) throws IOException, MessagingException, ParseException{
		  String valeId=request.getParameter("idValePdf");
		  String cuerpo = request.getParameter("cuerpoMsj");
		  String remitente = request.getParameter("Remitente");
			Vale val = valeRepository.findOne(Integer.parseInt(valeId));
	    	try{ 
				
				Date fecha1 = new Date();		  			
				DateFormat dateFormat1 = new SimpleDateFormat("EEE, MMM d, yyyy");		  				
				String fechaActu = dateFormat1.format(fecha1);
	            
	            ServletContext servletContext = request.getSession().getServletContext();
	            String relativeWebPath = "resources/hellojasper.jrxml";
	            String absoluteDiskPath = servletContext.getRealPath(relativeWebPath);
	            String relativeWebPath2 = "resources/rechazado.pdf";
	            String generado = servletContext.getRealPath(relativeWebPath2);
	            System.out.println("generado   "+generado);
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
			JasperExportManager.exportReportToPdfFile(
                      jasperPrint, generado); 
			Usuario user = userRep.findOne(Integer.parseInt(valeId));
			String correo = user.getEmail();
			enviarPdf(generado,cuerpo,response,correo,remitente);
			borrarRechazado(valeId,response);
	        }
	        catch (JRException e){
	            e.printStackTrace();
	        }
	  }
	  
	  /*@RequestMapping("/firmaAlmacen")
	   public void firmaAlmacen(HttpServletRequest request, HttpServletResponse response,Locale locale, Model model) throws IOException, ParseException {
				String valeId=request.getParameter("idValePdf");
				Vale val = valeRepository.findOne(Integer.parseInt(valeId));
				String alamcen=request.getParameter("firmaAlmacen");
				val.setAlmacen(alamcen);
				valeRepository.save(val);		
	   }*/
	  
	  
	  
	  @RequestMapping("/obtenerMaterial")
	   public void obtenerMaterial(HttpServletRequest request, HttpServletResponse response,Locale locale, Model model) throws IOException, ParseException {
		 
		  extranet_devoluciones_oc.familia.DT_FCMM extranet_devoluciones_oc1familia1DT_FCMM_1id = new DT_FCMM();
		  extranet_devoluciones_oc.familia.SI_CONSULTA_MATERIALES_OUT_SProxy sampleSI_CONSULTA_MATERIALES_OUT_SProxyid = new SI_CONSULTA_MATERIALES_OUT_SProxy();
		  		 
	      String cENTRO_3id=  request.getParameter("centroMaterial");
	          java.lang.String cENTRO_3idTemp = null;
	      if(!cENTRO_3id.equals("")){
	       cENTRO_3idTemp  = cENTRO_3id;
	      }
	      String cODIGO_4id=  request.getParameter("codigoMaterial");
	          java.lang.String cODIGO_4idTemp = null;
	      if(!cODIGO_4id.equals("")){
	       cODIGO_4idTemp  = cODIGO_4id;
	      }
	
	      extranet_devoluciones_oc1familia1DT_FCMM_1id.setCENTRO(cENTRO_3idTemp);
	      extranet_devoluciones_oc1familia1DT_FCMM_1id.setCODIGO(cODIGO_4idTemp);
	      extranet_devoluciones_oc.familia.DT_MATERIAL[] SI_CONSULTA_MATERIALES_IN_S13mtemp = sampleSI_CONSULTA_MATERIALES_OUT_SProxyid.SI_CONSULTA_MATERIALES_IN_S(extranet_devoluciones_oc1familia1DT_FCMM_1id);					
	      
	      ArrayList<String> repuesta=new ArrayList<>();
	      repuesta.add("?"+SI_CONSULTA_MATERIALES_IN_S13mtemp[0].getCENTRO()+"?");
		  repuesta.add("?"+SI_CONSULTA_MATERIALES_IN_S13mtemp[0].getCODIGO()+"?");
		  repuesta.add("?"+SI_CONSULTA_MATERIALES_IN_S13mtemp[0].getDESCRIPCION()+"?");
		  repuesta.add("?"+SI_CONSULTA_MATERIALES_IN_S13mtemp[0].getVALOR()+"?");
		  repuesta.add("?"+SI_CONSULTA_MATERIALES_IN_S13mtemp[0].getUMB()+"?");
		  response.getWriter().println(repuesta);
	  }
	  
	  @RequestMapping("/existeMaterial")
	   public void existeMaterial(HttpServletRequest request, HttpServletResponse response,Locale locale, Model model) throws IOException, ParseException {
		 System.out.println("!acxascascas");
		  extranet_devoluciones_oc.familia.DT_FCMM extranet_devoluciones_oc1familia1DT_FCMM_1id = new DT_FCMM();
		  extranet_devoluciones_oc.familia.SI_CONSULTA_MATERIALES_OUT_SProxy sampleSI_CONSULTA_MATERIALES_OUT_SProxyid = new SI_CONSULTA_MATERIALES_OUT_SProxy();
		  		 
	      String cENTRO_3id=  request.getParameter("centroMaterial");
	          java.lang.String cENTRO_3idTemp = null;
	      if(!cENTRO_3id.equals("")){
	       cENTRO_3idTemp  = cENTRO_3id;
	      }
	      String cODIGO_4id=  request.getParameter("codigoMaterial");
	          java.lang.String cODIGO_4idTemp = null;
	      if(!cODIGO_4id.equals("")){
	       cODIGO_4idTemp  = cODIGO_4id;
	      }
	
	      extranet_devoluciones_oc1familia1DT_FCMM_1id.setCENTRO(cENTRO_3idTemp);
	      extranet_devoluciones_oc1familia1DT_FCMM_1id.setCODIGO(cODIGO_4idTemp);
	      extranet_devoluciones_oc.familia.DT_MATERIAL[] SI_CONSULTA_MATERIALES_IN_S13mtemp = sampleSI_CONSULTA_MATERIALES_OUT_SProxyid.SI_CONSULTA_MATERIALES_IN_S(extranet_devoluciones_oc1familia1DT_FCMM_1id);					
	      String bandera="";
	       if(SI_CONSULTA_MATERIALES_IN_S13mtemp.length==0){
	    	   bandera="true";
	       }else{
	    	   bandera="false";
	       }	   
	       response.getWriter().println(bandera);
	  }
	  
	  @RequestMapping("/aprobadoresLdap")
	  public void aprobadoresLdap(HttpServletRequest request, HttpServletResponse response,Locale locale, Model model) throws IOException, ParseException {
		  String lugar=  request.getParameter("lugarAlmacenista");
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
			            	alamcenistas.add("?"+usuario+"?");
			            	miembros=miembros.substring(fin+1);
		            	}
		            	
		            }
		        }
		        namingEnum.close();
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		  response.getWriter().println(alamcenistas);
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
	  
	  @RequestMapping("/solicitantesLdap")
	  public void solicitantesLdap(HttpServletRequest request, HttpServletResponse response) throws IOException{
		  String solicitante=request.getParameter("Solicitante"); 
		  String ruta="OU=Usuarios,OU=Familia,DC=familia,DC=com,DC=co";
		  String url = "ldap://familia.com.co:389";
		  String bandera = "no";
		  Hashtable<String, String> env = new Hashtable<String, String>();
		  env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
		  env.put(Context.PROVIDER_URL, url);
		  env.put(Context.SECURITY_AUTHENTICATION, "simple");
		  env.put(Context.SECURITY_PRINCIPAL, "CN=Salmat Alma,OU=Medellin,OU=Colombia,OU=Usuarios,OU=Familia,DC=familia,DC=com,DC=co");
		  env.put(Context.SECURITY_CREDENTIALS, "Inicio2016");
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
			            String user="CN="+solicitante;
			            NamingEnumeration<?> namingEnum2 = ctx.search(ruta2, user, new SearchControls());
			            while(namingEnum2.hasMore ()){
			            	SearchResult result2 = (SearchResult) namingEnum2.next ();    
				            Attributes attrs2 = result2.getAttributes ();
				            String member = attrs2.get("memberOf").toString();
				            if(member.indexOf("Solicitantes") > -1){
				            	bandera="si";				     
				            }
			            }
		            }
		        }
		      namingEnum.close();
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		  response.getWriter().println(bandera);
	  }
	  
	  @RequestMapping("/aprobadorLdap")
	  public void aprobadorLdap(HttpServletRequest request, HttpServletResponse response) throws IOException{
		  String solicitante=request.getParameter("Aprobador");
		  System.out.println("::::::::::::::.lol:::::::::::::"+solicitante);
		  String ruta="OU=Usuarios,OU=Familia,DC=familia,DC=com,DC=co";
		  String url = "ldap://familia.com.co:389";	
		  String bandera="no";
		  Hashtable<String, String> env = new Hashtable<String, String>();
		  env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
		  env.put(Context.PROVIDER_URL, url);
		  env.put(Context.SECURITY_AUTHENTICATION, "simple");
		  env.put(Context.SECURITY_PRINCIPAL, "CN=Salmat Alma,OU=Medellin,OU=Colombia,OU=Usuarios,OU=Familia,DC=familia,DC=com,DC=co");
		  env.put(Context.SECURITY_CREDENTIALS, "Inicio2016");
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
			            String user="CN="+solicitante;
			            NamingEnumeration<?> namingEnum2 = ctx.search(ruta2, user, new SearchControls());
			            while(namingEnum2.hasMore ()){
			            	SearchResult result2 = (SearchResult) namingEnum2.next ();    
				            Attributes attrs2 = result2.getAttributes ();
				            String member = attrs2.get("memberOf").toString();
				            if(member.indexOf("Aprobadores") != -1){
				            	bandera="si";
				            }
			            }
		            }
		        }
		      namingEnum.close();
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		  response.getWriter().println(bandera);
	  }
	  
	  @RequestMapping("/conectionLdap")
	  public void conectionLdap(HttpServletRequest request, HttpServletResponse response) throws IOException {
		  String usuario=request.getParameter("Usuario");
		  
		  String contrasena=request.getParameter("Password");
		  String correos="";
		  String estado="";
		  String nombre="";
		  String planta="";

			//String url = "ldap://pragma.com.co:389";
		  	String url = "ldap://familia.com.co:389";
			Hashtable<String, String> env = new Hashtable<String, String>();
			env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
			env.put(Context.PROVIDER_URL, url);
			env.put(Context.SECURITY_AUTHENTICATION, "simple");
			env.put(Context.SECURITY_PRINCIPAL, usuario);
			env.put(Context.SECURITY_CREDENTIALS, contrasena);
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
				            NamingEnumeration<?> namingEnum2 = ctx.search(ruta2, "CN=*", new SearchControls());
				            while(namingEnum2.hasMore ()){
				            	SearchResult result2 = (SearchResult) namingEnum2.next ();    
					            Attributes attrs2 = result2.getAttributes ();
					            String usuarios=attrs2.get("cn").toString();
					            usuarios=usuarios.substring(4);
					            if(attrs2.get("mail")!=null){
					            	correos=attrs2.get("mail").toString();
					            	correos=correos.substring(6);
					            	if(correos.equals(usuario)){
						            	nombre=usuarios;
						            	planta=ciudad;
						            }
					            } 
				            }
			            }
			        }
			     namingEnum.close();   
				String ORIGINAL = "áéíóú";
				String REPLACEMENT = "aeiou";
				char[] array = nombre.toCharArray();
				for(int i = 0; i < nombre.length(); i++){
					int pos = ORIGINAL.indexOf(array[i]);
					if(pos > -1){
						array[i] = REPLACEMENT.charAt(pos);
					}
				}
				nombre = String.valueOf(array);

					/*Logeado=nombre;
					CorreoLogeado=usuario;*/
					ArrayList<String> datosUsuario=new ArrayList<>();
					datosUsuario.add(usuario);
					datosUsuario.add(nombre);
					datosUsuario.add(planta);
					ctx.close();
					response.getWriter().println(datosUsuario);
				
				

			} catch (AuthenticationNotSupportedException ex) {
				estado="fallido";
				response.getWriter().println("fallido");
			} catch (AuthenticationException ex) {
				estado="fallido";
				response.getWriter().println("fallido");
			} catch (NamingException ex) {
				estado="fallido";
				response.getWriter().println("fallido");
			}
		 
	  }
	  
	  @RequestMapping(value = "/valeDetail", method = RequestMethod.GET)
	   public ModelAndView valeDetail(HttpServletRequest request, HttpServletResponse response,Locale locale, Model model) throws IOException, ParseException {
		String prueba = request.getParameter("valorFiltrado");
		Vale val = valeRepository.findOne(Integer.parseInt(prueba));
		OperacionVale opVal = opRep.findOne(Integer.parseInt(prueba));
		Vector<DetalleVale> vecDetalle = new Vector<DetalleVale>();
		Collection<DetalleVale> detVal = detValRep.findAll();
		int numFila = 0;
		Date fecHoy = new Date();
		DateFormat formatterHoy = new SimpleDateFormat("yyyy-MM-dd");
		String datewHoy = formatterHoy.format(fecHoy);
		
		for (Iterator<DetalleVale> iterator = detVal.iterator(); iterator.hasNext();) {
			DetalleVale DetVale = (DetalleVale) iterator.next();
			if(DetVale.getVale().getIdVale()==Integer.parseInt(prueba)){
				vecDetalle.add(DetVale);
				numFila+=1;
			}
		}
		
		Date date = new Date();	
		DateFormat dateFormat = new SimpleDateFormat("EEE, MMM d, yyyy");		  			
		String fecha = dateFormat.format(date);
		
		Map<String, Object> miModelo = new HashMap<String, Object>();
		/*miModelo.put("credencial",Logeado);
		miModelo.put("credencialCorreo",CorreoLogeado);*/
		miModelo.put("fechaHoy", datewHoy);
		miModelo.put("fecha", fecha);
		miModelo.put("numFila", numFila);
		miModelo.put("vale", val);
		miModelo.put("detVales", vecDetalle);
		miModelo.put("prueba", prueba);
		miModelo.put("operacion", opVal);
		ModelAndView miMAV = new ModelAndView();
       miMAV.setViewName("vale");
       miMAV.addObject("model",miModelo);

       return miMAV;
			
	   }
	  
	  /*@RequestMapping("/Logout")
	  public void Logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		  Logeado="deslogeado";
		  CorreoLogeado="";
	  }*/
	  
	  @RequestMapping(value = "/aprobar", method = RequestMethod.GET)
	   public ModelAndView aprobar(HttpServletRequest request, HttpServletResponse response,Locale locale, Model model) throws IOException, ParseException {
		String prueba = request.getParameter("valorFiltrado");
		Vale val = valeRepository.findOne(Integer.parseInt(prueba));
		Vector<DetalleVale> vecDetalle = new Vector<DetalleVale>();
		Collection<DetalleVale> detVal = detValRep.findAll();
		int numFila = 0;
		Date fecHoy = new Date();
		DateFormat formatterHoy = new SimpleDateFormat("yyyy-MM-dd");
		String datewHoy = formatterHoy.format(fecHoy);
		
		for (Iterator<DetalleVale> iterator = detVal.iterator(); iterator.hasNext();) {
			DetalleVale DetVale = (DetalleVale) iterator.next();
			if(DetVale.getVale().getIdVale()==Integer.parseInt(prueba)){
				vecDetalle.add(DetVale);
				numFila+=1;
			}
		}
		
		Date date = new Date();	
		DateFormat dateFormat = new SimpleDateFormat("EEE, MMM d, yyyy");		  			
		String fecha = dateFormat.format(date);
		
		Map<String, Object> miModelo = new HashMap<String, Object>();
		/*miModelo.put("credencial",Logeado);
		miModelo.put("credencialCorreo",CorreoLogeado);*/
		miModelo.put("fechaHoy", datewHoy);
		miModelo.put("fecha", fecha);
		miModelo.put("numFila", numFila);
		miModelo.put("vale", val);
		miModelo.put("detVales", vecDetalle);
		miModelo.put("prueba", prueba);
		ModelAndView miMAV = new ModelAndView();
    miMAV.setViewName("aprobar");
    miMAV.addObject("model",miModelo);

     return miMAV;
			
	   }
}



