import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MyFrame extends JFrame {


    
    SimpleDateFormat timeFormat,dayFormat,dateFormat;
    JLabel daylable,datelable,timelable;
    String time,date,day;

    MyFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Digital Clock");
        this.setLayout(new FlowLayout());
        this.setSize(400,207);
        this.setResizable(false);



        timeFormat = new SimpleDateFormat("hh:mm:ss a");
        dayFormat = new SimpleDateFormat("EEEE");
        dateFormat = new SimpleDateFormat("dd MMMM yyyy");

        timelable = new JLabel();
        timelable.setFont(new Font("Verdana", Font.PLAIN,57));
        timelable.setForeground(new Color(0x999999));
        timelable.setBackground(new Color(0x3d4c41));
        timelable.setOpaque(true);

        daylable = new JLabel();
        daylable.setFont(new Font("Ink Free", Font.PLAIN,37));

        datelable = new JLabel();
        datelable.setFont(new Font("Ink Free", Font.PLAIN, 27));

        time = timeFormat.format(Calendar.getInstance().getTime());
        timelable.setText(time);

        this.add(timelable);
        this.add(daylable);
        this.add(datelable);
        this.setVisible(true);

        setTime();

    }

    public void setTime(){
        while (true){
            time= timeFormat.format(Calendar.getInstance().getTime());
            timelable.setText(time);

            day = dayFormat.format(Calendar.getInstance().getTime());
            daylable.setText(day);

            date = dateFormat.format(Calendar.getInstance().getTime());
            datelable.setText(date);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
