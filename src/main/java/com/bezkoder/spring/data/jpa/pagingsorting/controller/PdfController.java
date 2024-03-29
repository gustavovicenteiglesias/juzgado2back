package com.bezkoder.spring.data.jpa.pagingsorting.controller;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import java.sql.SQLException;

import java.text.NumberFormat;
import java.util.Currency;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RestController;

import com.bezkoder.spring.data.jpa.pagingsorting.model.Infraccione;
import com.bezkoder.spring.data.jpa.pagingsorting.repository.InfracionesRepository;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

@CrossOrigin(origins = "*")
@RestController



public class PdfController {
	@Autowired
	DataSource datasource;
	
	 @Autowired
	    protected DataSource localDataSource;
	 
	 @Autowired
		InfracionesRepository infracionesRepository;
	
	@GetMapping(value = "/api/portada/{id}")
	
	public void getDocument(HttpServletResponse response,@PathVariable("id") Long id) throws IOException, JRException, SQLException {
	
		Infraccione infraccion= infracionesRepository.findById(id).get();
		InputStream jasperStream = this.getClass().getResourceAsStream("/reports/PortadaJuzgado2.jrxml");
		Map <String,Object> para = new HashMap<>();
		para.put("causa", infraccion.getCausa());
		para.put("nombre", infraccion.getNombre());
		para.put("acta", infraccion.getActa());
		para.put("ley_ordenanza", infraccion.getLeyOrdenanza());
		para.put("articulo", infraccion.getArticulo());
		para.put("anio","2023");
		para.put("descripcion",infraccion.getDescripcion());
		para.put("acto_resolutorio",infraccion.getActoResolutorio());
		para.put("fecha", infraccion.getFecha());
		
		JasperReport jasperReport = JasperCompileManager.compileReport(jasperStream);
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, para,new JREmptyDataSource());
		
		response.setContentType("application/pdf");
		response.addHeader("Content-Disposition", "inline; filename=abono"+id+".pdf;");
		
		final OutputStream outStream = response.getOutputStream();
	    JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
	}
	 
@GetMapping(value = "/api/cedula/{id}")
	
	public void getDocumentcedula(HttpServletResponse response,@PathVariable("id") Long id) throws IOException, JRException, SQLException {
	
		Infraccione infraccion= infracionesRepository.findById(id).get();
		InputStream jasperStream = this.getClass().getResourceAsStream("/reports/Cedula.jrxml");
		Map <String,Object> para = new HashMap<>();
		para.put("causa", infraccion.getCausa());
		para.put("nombre", infraccion.getNombre());
		para.put("acta", infraccion.getActa());
		para.put("ley_ordenanza", infraccion.getLeyOrdenanza());
		para.put("articulo", infraccion.getArticulo());
		para.put("dominio",infraccion.getDominio());
		para.put("fecha", infraccion.getFecha());
		para.put("direccion", infraccion.getDireccion());
		para.put("localidad", infraccion.getLocalidad());
		para.put("provincia", infraccion.getProvincia());
		para.put("codigo_postal", infraccion.getCodigoPostal());
		
		JasperReport jasperReport = JasperCompileManager.compileReport(jasperStream);
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, para,new JREmptyDataSource());
		
		response.setContentType("application/pdf");
		response.addHeader("Content-Disposition", "inline; filename=cedula"+id+".pdf;");
		
		final OutputStream outStream = response.getOutputStream();
	    JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
	}


@GetMapping(value = "/api/cedulatitular/{id}")

public void getDocumentcedulaTitular(HttpServletResponse response,@PathVariable("id") Long id) throws IOException, JRException, SQLException {

	Infraccione infraccion= infracionesRepository.findById(id).get();
	InputStream jasperStream = this.getClass().getResourceAsStream("/reports/Cedula.jrxml");
	Map <String,Object> para = new HashMap<>();
	para.put("causa", infraccion.getCausa());
	para.put("nombre", infraccion.getNombreTitular());
	para.put("acta", infraccion.getActa());
	para.put("ley_ordenanza", infraccion.getLeyOrdenanza());
	para.put("articulo", infraccion.getArticulo());
	para.put("dominio",infraccion.getDominio());
	para.put("fecha", infraccion.getFecha());
	para.put("direccion", infraccion.getDireccionTitular());
	para.put("localidad", infraccion.getLocalidadTitular());
	para.put("provincia", infraccion.getProvinciaTitular());
	para.put("codigo_postal", infraccion.getCpTitular());
	
	JasperReport jasperReport = JasperCompileManager.compileReport(jasperStream);
	JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, para,new JREmptyDataSource());
	
	response.setContentType("application/pdf");
	response.addHeader("Content-Disposition", "inline; filename=cedulatitular"+id+".pdf;");
	
	final OutputStream outStream = response.getOutputStream();
    JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
}

@GetMapping(value = "/api/oficio/{id}")

public void getDocumentOficio(HttpServletResponse response,@PathVariable("id") Long id) throws IOException, JRException, SQLException {

	Infraccione infraccion= infracionesRepository.findById(id).get();
	InputStream jasperStream = this.getClass().getResourceAsStream("/reports/oficio.jrxml");
	Map <String,Object> para = new HashMap<>();
	para.put("causa", infraccion.getCausa());
	para.put("nombre",infraccion.getNombreTitular());
	para.put("acta", infraccion.getActa());
	para.put("ley_ordenanza", infraccion.getLeyOrdenanza());
	para.put("articulo", infraccion.getArticulo());
	para.put("dominio",infraccion.getDominio());
	para.put("fecha", infraccion.getFecha());
	para.put("dni", infraccion.getDniTitular());
	para.put("vehiculo", infraccion.getVehiculo());
	para.put("motor", infraccion.getMotor());
	para.put("chasis", infraccion.getChasis());
	para.put("agente", infraccion.getAgente());
	
	JasperReport jasperReport = JasperCompileManager.compileReport(jasperStream);
	JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, para,new JREmptyDataSource());
	
	response.setContentType("application/pdf");
	response.addHeader("Content-Disposition", "inline; filename=cedulatitular"+id+".pdf;");
	
	final OutputStream outStream = response.getOutputStream();
    JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
}

@GetMapping(value = "/api/recibo/{id}")

public void getDocumentrecibo(HttpServletResponse response,@PathVariable("id") Long id) throws IOException, JRException, SQLException {
	Locale arg = new Locale("es", "AR");
	Currency pesos = Currency.getInstance(arg);
	NumberFormat pesoFormat = NumberFormat.getCurrencyInstance(arg);
	Infraccione infraccion= infracionesRepository.findById(id).get();
	double valores= Float.parseFloat(infraccion.getValor());
	InputStream jasperStream = this.getClass().getResourceAsStream("/reports/recibo.jrxml");
	Map <String,Object> para = new HashMap<>();
	para.put("causa", infraccion.getCausa());
	para.put("nombre", infraccion.getNombre());
	para.put("acta", infraccion.getActa());
	para.put("ley_ordenanza", infraccion.getLeyOrdenanza());
	para.put("articulo", infraccion.getArticulo());
	para.put("inciso", infraccion.getInciso());
	para.put("dni",infraccion.getDni());
	para.put("fecha", infraccion.getFecha());
	para.put("direccion", infraccion.getDireccion());
	para.put("localidad", infraccion.getLocalidad());
	para.put("provincia", infraccion.getProvincia());
	para.put("valor", pesoFormat.format(valores));
	
	
	JasperReport jasperReport = JasperCompileManager.compileReport(jasperStream);
	JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, para,new JREmptyDataSource());
	
	response.setContentType("application/pdf");
	response.addHeader("Content-Disposition", "inline; filename=cedulatitular"+id+".pdf;");
	
	final OutputStream outStream = response.getOutputStream();
    JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
}

@GetMapping(value = "/api/recibocuotas/{id}")

public void getDocumentreciboCuotas(HttpServletResponse response,@PathVariable("id") Long id) throws IOException, JRException, SQLException {
	Locale arg = new Locale("es", "AR");
	Currency pesos = Currency.getInstance(arg);
	NumberFormat pesoFormat = NumberFormat.getCurrencyInstance(arg);
	Infraccione infraccion= infracionesRepository.findById(id).get();
	InputStream jasperStream = this.getClass().getResourceAsStream("/reports/recibo.jrxml");
	Map <String,Object> para = new HashMap<>();
	para.put("causa", infraccion.getCausa());
	para.put("nombre", infraccion.getNombre());
	para.put("acta", infraccion.getActa());
	para.put("ley_ordenanza", infraccion.getLeyOrdenanza());
	para.put("articulo", infraccion.getArticulo());
	para.put("inciso", infraccion.getInciso());
	para.put("dni",infraccion.getDni());
	para.put("fecha", infraccion.getFecha());
	para.put("direccion", infraccion.getDireccion());
	para.put("localidad", infraccion.getLocalidad());
	para.put("provincia", infraccion.getProvincia());
	para.put("valor", pesoFormat.format(infraccion.getConvenio().getValor_cuota()));
	
	
	
	
	JasperReport jasperReport = JasperCompileManager.compileReport(jasperStream);
	JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, para,new JREmptyDataSource());
	
	response.setContentType("application/pdf");
	response.addHeader("Content-Disposition", "inline; filename=cedulatitular"+id+".pdf;");
	
	final OutputStream outStream = response.getOutputStream();
    JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
}

@GetMapping(value = "/api/reciboanticipo/{id}")

public void getDocumentreciboAnticipo(HttpServletResponse response,@PathVariable("id") Long id) throws IOException, JRException, SQLException {
	Locale arg = new Locale("es", "AR");
	Currency pesos = Currency.getInstance(arg);
	NumberFormat pesoFormat = NumberFormat.getCurrencyInstance(arg);
	Infraccione infraccion= infracionesRepository.findById(id).get();
	InputStream jasperStream = this.getClass().getResourceAsStream("/reports/recibo.jrxml");
	Map <String,Object> para = new HashMap<>();
	para.put("causa", infraccion.getCausa());
	para.put("nombre", infraccion.getNombre());
	para.put("acta", infraccion.getActa());
	para.put("ley_ordenanza", infraccion.getLeyOrdenanza());
	para.put("articulo", infraccion.getArticulo());
	para.put("inciso", infraccion.getInciso());
	para.put("dni",infraccion.getDni());
	para.put("fecha", infraccion.getFecha());
	para.put("direccion", infraccion.getDireccion());
	para.put("localidad", infraccion.getLocalidad());
	para.put("provincia", infraccion.getProvincia());
	para.put("valor",pesoFormat.format(infraccion.getConvenio().getAnticipo()));
	
	
	
	
	JasperReport jasperReport = JasperCompileManager.compileReport(jasperStream);
	JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, para,new JREmptyDataSource());
	
	response.setContentType("application/pdf");
	response.addHeader("Content-Disposition", "inline; filename=cedulatitular"+id+".pdf;");
	
	final OutputStream outStream = response.getOutputStream();
    JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
}
@GetMapping(value = "/api/convenio/{id}")

public void getDocumentconvenio(HttpServletResponse response,@PathVariable("id") Long id) throws IOException, JRException, SQLException {

	Infraccione infraccion= infracionesRepository.findById(id).get();
	InputStream jasperStream = getClass().getResourceAsStream("/reports/Convenio.jrxml");
	Map <String,Object> para = new HashMap<>();
	para.put("nro_causa", infraccion.getCausa());
	para.put("nombre", infraccion.getNombre());
	para.put("id_convenio", infraccion.getConvenio().getId());
	para.put("valor_cuota", infraccion.getConvenio().getValor_cuota());
	para.put("cant_cuotas", infraccion.getConvenio().getCant_cuotas());
	para.put("anticipo", infraccion.getConvenio().getAnticipo());
	para.put("dni",infraccion.getDni());
	para.put("fecha", infraccion.getFecha());
	para.put("domicilio", infraccion.getDireccion());
	para.put("localidad", infraccion.getLocalidad());
	para.put("provincia", infraccion.getProvincia());
	para.put("valor", infraccion.getValor());
	System.out.println(infraccion.getConvenio().getId());
	
	JasperReport jasperReport =JasperCompileManager.compileReport(jasperStream);// (JasperReport) JRLoader.loadObject(getClass().getResource("/reports/Convenio.jasper")); 
	JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, para,datasource.getConnection());
	
	response.setContentType("application/pdf");
	response.addHeader("Content-Disposition", "inline; filename=cedulatitular"+id+".pdf;");
	
	final OutputStream outStream = response.getOutputStream();
    JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
}
	
}
