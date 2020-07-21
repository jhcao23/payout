package technology.touchmars.jsf;

import technology.touchmars.model.PayoutRequestWeb;
import technology.touchmars.service.PayoutRequestService;
import technology.touchmars.util.FileUtil;
import technology.touchmars.util.PayoutRequestConverter;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

@Named("fileUploadBean")
@RequestScoped
public class FileUploadBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private PayoutRequestConverter payoutRequestConverter;

    @Inject
    private PayoutRequestService payoutRequestService;

//    @Inject Logger log;
    private static final Logger log = Logger.getLogger(FileUploadBean.class.getSimpleName());

//    @Inject
    // username should be able to inject from Authentication module
    private String username = "dummyUser";

    private Part file;

    private Long reqId = 8L;

    public String upload(){
        log.info("call upload...");
        log.log(Level.INFO, "content-type:{0}", file.getContentType());
        log.log(Level.INFO, "filename:{0}", file.getName());
        log.log(Level.INFO, "submitted filename:{0}", file.getSubmittedFileName());
        log.log(Level.INFO, "size:{0}", file.getSize());
        try {
            byte[] results=new byte[(int)file.getSize()];
            InputStream in=file.getInputStream();
            File file1 = FileUtil.allocateFile4User(username, file.getSubmittedFileName());
            file1 = FileUtil.writeInputStream2File(in, file1);
            //TODO: handle validation errors
//            PayoutRequestWeb payoutRequestWeb = payoutRequestConverter.convertCsv2PayoutRequestWeb(file1);
//            payoutRequestWeb = payoutRequestService.persistPayoutRequestWeb(payoutRequestWeb);
//            reqId = payoutRequestWeb.getId();
            return "good";
        } catch (IOException ex) {
            log.log(Level.SEVERE, " ex @{0}", ex);
        }
        return null;


//        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(String.format("File %s Uploaded!", file.getSubmittedFileName())));
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

    public Long getReqId() {
        return reqId;
    }

    public void setReqId(Long reqId) {
        this.reqId = reqId;
    }
}
