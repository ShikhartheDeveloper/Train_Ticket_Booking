package com.ShikharTheDeveloper.Train_Ticket_Booking.Service;

import com.ShikharTheDeveloper.Train_Ticket_Booking.Entities.Booking;
import com.ShikharTheDeveloper.Train_Ticket_Booking.Helper.QrCodeGenerator;
import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

@Service
public class PDFService {
    public ByteArrayInputStream generateTicketPdf(Booking booking) {
        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {
            PdfWriter.getInstance(document, out);
            document.open();

            // Title
            Font titleFont = new Font(Font.HELVETICA, 20, Font.BOLD);
            Paragraph title = new Paragraph("Train Ticket", titleFont);
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);
            document.add(new Paragraph(" ")); // blank line

            // Ab yaha Relations se data print karenge
            document.add(new Paragraph("PNR Number: " + booking.getPnrNumber()));
            document.add(new Paragraph("Passenger: " + booking.getCustomer().getName()));
            document.add(new Paragraph("Departure: " + booking.getTrainRoute().getDepartureStation()));
            document.add(new Paragraph("Arrival: " + booking.getTrainRoute().getArrivalStation()));
            document.add(new Paragraph("Coach: " + booking.getCoachType().getCoachName()));
            document.add(new Paragraph("Travel Date: " + booking.getTravelDate()));
            document.add(new Paragraph("Travel Time: " + booking.getTravelTime()));
            document.add(new Paragraph("Total Fare: ₹ " + booking.getTotalFare()));
            String qrText = "PNR: " + booking.getPnrNumber() +
                    "\nCustomer: " + booking.getCustomer().getName() +
                    "\nFrom: " + booking.getTrainRoute().getDepartureStation() +
                    "\nTo: " + booking.getTrainRoute().getArrivalStation() +
                    "\nDate: " + booking.getTravelDate() +
                    "\nTime: " + booking.getTravelTime() +
                    "\nFare: ₹" + booking.getTotalFare();

            byte[] qrBytes = QrCodeGenerator.generateQrCode(qrText, 200, 200);
            Image qrImage = Image.getInstance(qrBytes);
            qrImage.setAlignment(Image.ALIGN_CENTER);
            document.add(qrImage);

            document.close();

        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return new ByteArrayInputStream(out.toByteArray());
    }
}
