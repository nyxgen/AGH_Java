
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class ClockFX {

    int centerX = 400;
    int centerY = 400;
    int clockFaceRadius = 150;
    int hourHandRadius = clockFaceRadius /2;
    int minuteHandRadius = clockFaceRadius *4/5;
    int secondHandRadius = clockFaceRadius;

    double hours = 0;
    double minutes = 0;
    double seconds = 0;

    ClockFX()
    {
    }
    public void updateHands(GraphicsContext graphicsContext ) {
        graphicsContext.setFill(Color.BLUE);
        graphicsContext.fillOval(centerX- clockFaceRadius, centerY- clockFaceRadius, 2* clockFaceRadius, 2* clockFaceRadius);
        graphicsContext.setFill(Color.BLACK);
        graphicsContext.setLineWidth(5);
        graphicsContext.strokeOval(centerX- clockFaceRadius, centerY- clockFaceRadius, 2* clockFaceRadius, 2* clockFaceRadius);
        graphicsContext.setLineWidth(1);
        for(int i = 1; i <= 60; ++i)
        {
            graphicsContext.strokeLine(
                    centerX + 0.9* clockFaceRadius * Math.cos((90 + (-1.0 * i / 60  ) * 360) * Math.PI / 180),
                    centerY - 0.9* clockFaceRadius * Math.sin((90 + (-1.0 * i / 60  ) * 360) * Math.PI / 180),
                    centerX + clockFaceRadius * Math.cos((90 + (-1.0 * i / 60  ) * 360) * Math.PI / 180),
                    centerY - clockFaceRadius * Math.sin((90 + (-1.0 * i / 60  ) * 360) * Math.PI / 180)
            );
        }
        for(int i = 1; i <= 12; ++i)
        {
            graphicsContext.strokeText( "" +i,
                    centerX - 5 + 0.9* clockFaceRadius * Math.cos((90 + (-1.0 * i/ 12) * 360) * Math.PI / 180),
                    centerY -  0.9 * clockFaceRadius * Math.sin((90 + (-1.0 * i / 12) * 360) * Math.PI / 180));
        }

        graphicsContext.setLineWidth(8);
        graphicsContext.strokeLine(
                centerX,
                centerY,
                centerX + hourHandRadius * Math.cos((90 + (-1.0 * (hours+minutes/60) / 12  ) * 360) * Math.PI / 180),
                centerY - hourHandRadius * Math.sin((90 + (-1.0 * (hours+minutes/60) / 12  ) * 360) * Math.PI / 180)
        );

        graphicsContext.setLineWidth(4);
         graphicsContext.strokeLine(
                 centerX,
                 centerY,
                 centerX + minuteHandRadius *Math.cos((90+(-1.0*(minutes+seconds/60)/60) * 360) * Math.PI/180),
                 centerY - minuteHandRadius *Math.sin((90+(-1.0*(minutes+seconds/60)/60) * 360) * Math.PI/180)
         );
        graphicsContext.setLineWidth(2);
        graphicsContext.strokeLine(
                centerX,
                centerY,
                centerX + secondHandRadius *Math.cos((90+(-1.0*seconds/60) * 360) * Math.PI/180),
                centerY - secondHandRadius *Math.sin((90+(-1.0*seconds/60) * 360) * Math.PI/180)
        );

    }
    public void updateTime()
    {
        Date date;
        Calendar calendar;

        date = new Date();
        calendar = GregorianCalendar.getInstance();

        calendar.setTime(date);   // assigns calendar to given date
        calendar.get(Calendar.HOUR_OF_DAY); // gets hour in 24h format
        calendar.get(Calendar.HOUR);        // gets hour in 12h format
        calendar.get(Calendar.MONTH);

        hours= calendar.get(Calendar.HOUR_OF_DAY);
        minutes = calendar.get(Calendar.MINUTE);
        seconds = calendar.get(Calendar.SECOND);

    }
}
