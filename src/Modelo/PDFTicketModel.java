package Modelo;

import java.util.Random;
import DTOs.BoletoDto;
import java.sql.ResultSet;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Font;
import com.itextpdf.text.Rectangle;
import java.io.FileOutputStream;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.EnumMap;
import java.util.Map;
import javax.imageio.ImageIO;

import java.awt.Desktop;
import java.io.File;

public class PDFTicketModel {

    private SimpleORM orm;

    public static final String logo_tickets = "src/imagenes/logofinalnegro.png";

    public PDFTicketModel() throws Exception {
        orm = SimpleORM.getInstance();
    }

    public static String generarStringRandom(int length) {
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder randomString = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(caracteres.length());
            randomString.append(caracteres.charAt(randomIndex));
        }
        return randomString.toString();
    }

    public static BufferedImage generateQRCode(String text, int width, int height) throws WriterException, IOException {
        Map<EncodeHintType, Object> hints = new EnumMap<>(EncodeHintType.class);
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);

        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height, hints);

        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        bufferedImage.createGraphics();

        //colores de qr
        Graphics2D graphics = (Graphics2D) bufferedImage.getGraphics();
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, width, height);
        graphics.setColor(Color.BLACK);

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (bitMatrix.get(i, j)) {
                    graphics.fillRect(i, j, 1, 1);
                }
            }
        }

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ImageIO.write(bufferedImage, "png", byteArrayOutputStream);

        //convertir byteArrayOutputStream a bufferedImage
        byte[] image = byteArrayOutputStream.toByteArray();

        ByteArrayInputStream bis = new ByteArrayInputStream(image);

        BufferedImage imagen = ImageIO.read(bis);

        return imagen;
    }

    public void generar_ticket_pdf(BoletoDto boleto) {
        Document documento = new Document();
        //parametros de documento
        Rectangle doc_size = new Rectangle(350, 450);
        documento.setPageSize(doc_size);
        documento.setMargins(25, 25, 25, 25);

        //intentar escribir documento
        try {
            //crear ruta de guardado para el ticket
            String filename = "ticket_" + String.valueOf(boleto.getId());
            String random_string = generarStringRandom(12);

            String project_dir = System.getProperty("user.dir");
            System.out.println("Directorio: " + project_dir);

            String downloadsPath = System.getProperty("user.home") + File.separator + "Downloads";
            File downloadsDir = new File(downloadsPath);

            if (!downloadsDir.exists()) {
                downloadsDir.mkdirs();
            }

            String filepath = downloadsPath + File.separator + filename + "_" + random_string + ".pdf";

            PdfWriter.getInstance(documento, new FileOutputStream(filepath));

            //imagen de portada
            Image header = Image.getInstance(logo_tickets);
            header.scaleToFit(128, 50);
            header.setAlignment(Chunk.ALIGN_LEFT);

            //codigo qr
            Image codigo_qr = Image.getInstance(generateQRCode("google.com", 160, 160), null);
            codigo_qr.setAlignment(Chunk.ALIGN_CENTER);

            //parrafo de titulo
            Paragraph parrafo_titulo = new Paragraph();
            parrafo_titulo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo_titulo.setFont(FontFactory.getFont("Tahoma", 14, Font.NORMAL, BaseColor.GRAY));
            parrafo_titulo.add("Informacion de Ticket \n\n");

            //parrafo de informacion
            Paragraph parrafo_info = new Paragraph();
            parrafo_info.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo_info.setFont(FontFactory.getFont("Tahoma", 18, Font.BOLD, BaseColor.BLACK));
            parrafo_info.add(String.valueOf(boleto.getAdultos()) + " x ADULTO" + "\n\n");
            parrafo_info.add(String.valueOf(boleto.getNinos()) + " x NIÑO" + "\n\n");

            parrafo_info.add(String.valueOf("Funcion: " + boleto.getFuncion_id()) + "\n");

            //conseguir el nombre de la pelicula basado en el boleto
            ResultSet rs2 = orm.simpleQuery("select peliculas.nombre from peliculas join funciones on funciones.pelicula_id = peliculas.id join boletos on boletos.funcion_id = funciones.id  where boletos.id =" + String.valueOf(boleto.getId()));
            rs2.next();
            parrafo_info.add("Pelicula: " + rs2.getString("nombre") + "\n");

            rs2 = orm.simpleQuery("select * from funciones where funciones.id=" + String.valueOf(boleto.getFuncion_id()));
            rs2.next();
            parrafo_info.add("Fecha: " + rs2.getString("activadesde") + "\n");

            parrafo_info.add(String.valueOf("Asiento(s): " + boleto.getAsientos()) + "\n");

            //bordes        
            Rectangle bordes_rec = new Rectangle(documento.left(), documento.bottom(), documento.right(), documento.top());
            bordes_rec.setBorder(Rectangle.BOX);
            bordes_rec.setBorderColor(new BaseColor(229, 66, 44));
            bordes_rec.setBorderWidth(10);

            documento.open();
            documento.add(bordes_rec);
            documento.add(header);
            documento.add(parrafo_titulo);
            documento.add(parrafo_info);
            documento.add(codigo_qr);
            documento.close();

            File pdfFile = new File(filepath);
            if (pdfFile.exists()) {
                if (Desktop.isDesktopSupported()) {
                    Desktop.getDesktop().open(pdfFile);
                } else {
                }
            } else {
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
