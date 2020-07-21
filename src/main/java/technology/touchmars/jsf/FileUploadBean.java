package technology.touchmars.jsf;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Model;
import javax.faces.annotation.ManagedProperty;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

@Named("fileUploadBean")
@RequestScoped
public class FileUploadBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject Logger log;
//    private static final Logger log = Logger.getLogger(FileUploadBean.class.getSimpleName());

    private Part file;

    public void upload(){
        log.info("call upload...");
        log.log(Level.INFO, "content-type:{0}", file.getContentType());
        log.log(Level.INFO, "filename:{0}", file.getName());
        log.log(Level.INFO, "submitted filename:{0}", file.getSubmittedFileName());
        log.log(Level.INFO, "size:{0}", file.getSize());
        try {
            byte[] results=new byte[(int)file.getSize()];
            InputStream in=file.getInputStream();
            in.read(results);
        } catch (IOException ex) {
            log.log(Level.SEVERE, " ex @{0}", ex);
        }

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(String.format("File %s Uploaded!", file.getSubmittedFileName())));
    }

    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
        log.info("call setFile");
        log.log(Level.INFO, "content-type:{0}", file.getContentType());
        log.log(Level.INFO, "filename:{0}", file.getName());
        log.log(Level.INFO, "submitted filename:{0}", file.getSubmittedFileName());
        log.log(Level.INFO, "size:{0}", file.getSize());
    }

}
