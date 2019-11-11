package tagovi;


import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class TagHandler2 extends SimpleTagSupport {

    private String color;

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void doTag() throws JspException {
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd. MM. yyyy.");
        JspWriter out = getJspContext().getOut();
        
        // what ever code you put here is what will tag put out on screen
        try {
            out.println("<div style='color: " + color + ";'>");
            out.println("Calendar...: " + Calendar.getInstance().getTime());
            out.println("<br>LocalDateTime: " + LocalDateTime.now());
            out.println("<br>Date + sdf: "+(sdf.format(new Date())));
            out.print("</div>");

            JspFragment f = getJspBody();
            if (f != null) {
                f.invoke(out);
            }

        } catch (java.io.IOException ex) {
            throw new JspException("Error in TagHandler2 tag", ex);
        }
    }
}
