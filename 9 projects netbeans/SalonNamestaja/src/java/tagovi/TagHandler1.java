package tagovi;


import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class TagHandler1 extends SimpleTagSupport {

    @Override
    public void doTag() throws JspException {
        
        JspWriter out = getJspContext().getOut();
        
        // what ever code you put here is what will tag put out on screen
        try {
//            StringBuilder sb = new StringBuilder();
//            sb.append("<a href='http://www.google.com'>Google</a> | ");
//            sb.append("<a href='http://www.yahoo.com'>Yahoo</a> | ");
//            sb.append("<a href='http://www.bing.com'>Bing</a>");
//            out.println(sb.toString()); 
            out.print("<a href='http://www.google.com'>Google</a> | ");
            out.print("<a href='http://www.yahoo.com'>Yahoo</a> | ");
            out.print("<a href='http://www.bing.com'>Bing</a>");
            
            JspFragment f = getJspBody();
            if (f != null) {
                f.invoke(out);
            }

        } catch (java.io.IOException ex) {
            throw new JspException("Error in TagHandler1 tag", ex);
        }
    }
}
