/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import java.net.URISyntaxException;

/**
 *
 * @author User
 */


public class SmsSender {

    // Find your Account Sid and Auth Token at twilio.com/console
    public static final String ACCOUNT_SID = "ACbbc5386a1bf0024f50f7816714271d6c";
    public static final String AUTH_TOKEN = "64aea1f8e7905e68e7ec1558f7020d6d";

    public static void send() throws URISyntaxException {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message message = Message
                .creator(new PhoneNumber("+21650065826"), // to
                        new PhoneNumber("+12027603018"), // from
                        " votre Sujet est ajouté")
                .create();
        System.out.println(message.getSid());
        System.out.println("notif");
    }
}
