package technology.touchmars.util;

import technology.touchmars.model.*;
import technology.touchmars.repository.CurrencyRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;
import static technology.touchmars.util.StringUtil.*;

@Stateless
public class PayoutRequestConverter {

    private static Logger log = Logger.getLogger(PayoutRequestConverter.class.getSimpleName());

    @Inject
    private CurrencyRepository currencyRepository;

    // Web csv file does NOT have summary header
    public PayoutRequestWeb convertCsv2PayoutRequestWeb(File file){
        PayoutRequestWeb req = new PayoutRequestWeb();
        try(Stream<String> lines = Files.lines(file.toPath())){
            lines.forEach(
                    line -> {
                        PayoutRequestItem item = convertLine2PayoutRequestItem(line);
                        if (item==null) {
                            // raise an exception to tell caller the file validation fails
                            // or accumulate these errors and tell caller in one time
                        }
                        item.setPayoutRequest(req);
                        req.getItems().add(item);
                    }
            );

        }catch (IOException e) {
            e.printStackTrace();
            log.log(Level.SEVERE, e.getMessage());
        }
        return null;
    }

    public PayoutRequestItem convertLine2PayoutRequestItem(String line){
        List<String> tokens = CsvReader.readLine(line);
        if (tokens.isEmpty() || tokens.size()<6) {
            return null;
        }
        PayoutRequestItem item = new PayoutRequestItem();
        //TODO: convert tokens 2 PayoutRequestItem
        // read 6 tokens one by one
        String t0 = tokens.get(0);
        if (notEmpty(t0)) {
            RecipientId rid = new RecipientId();
            if (isValidPhone(t0)) {
                Mobile m = new Mobile();
                m.setPhoneNo(t0);
                //TODO: find a way to find the country code of the phone no.
                rid.setMobile(m);
            } else if (isValidEmail(t0)) {
                rid.setEmail(t0);
            } else {
                rid.setPaypalId(t0);
            }
            item.setRecipientId(rid);
        }

        String t1 = tokens.get(1);
        if (notEmpty(t1)) {
            BigDecimal bd = new BigDecimal(t1.replaceAll(",", ""));
            item.setAmount(bd);
        }

        String t2 = tokens.get(2);
        if (notEmpty(t2)) {
            Currency c = currencyRepository.findByCode(t2);
            item.setCurrency(c);
            //TODO: what if this currency is disabled for now?
        }

        String t3 = tokens.get(3);
        if (notEmpty(t3)) {
            item.setCustomerId(t3);
        }

        String t4 = tokens.get(4);
        if (notEmpty(t4)) {
            item.setNote(t4);
        }

        String t5 = tokens.get(5);
        if (notEmpty(t5)){
            item.setWalletType(convertString2WalletType(t5));
        }

        return item;
    }


    // large batch csv file has a summary header !!!
    // TODO: similiar coding as above
    public PayoutRequestBatch convertCsv2PayoutRequestBatch(File file) {
        return null;
    }

}
