package web.bean;

import javax.faces.context.FacesContext;
import java.io.IOException;

public abstract class BaseBean {
    protected void redirect(String path) {
        try {
            FacesContext.getCurrentInstance()
                    .getExternalContext()
                    .redirect("/views" + path + ".jsf");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
