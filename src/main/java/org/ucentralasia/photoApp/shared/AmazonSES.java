package org.ucentralasia.photoApp.shared;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClientBuilder;
import com.amazonaws.services.simpleemail.model.*;
import org.ucentralasia.photoApp.shared.dto.UserDto;

public class AmazonSES {
    final String FROM = "alisher.isaev_2026@ucentalasia.org";
    final String SUBJECT = "One last step to complete your registration";

    final String HTMLBODY = "<h1>Please verify your email address</h1>"
            + "<p>Thank you for registering with our app. Complete your registration process and be able to log in</p>"
            + "clink on the following link: "
            + "<a href='http://localhost:8080/verification-service/email-verification.html?token=@tokenValue'>"
            + "Final step to complete your registration" + "</a><br/><br/>"
            + " Thank you! And we are waiting for you inside!";

    final String TEXTBODY = "Please verify your email address. "
            + "Thank you for registering with our app. Complete your registration process and be able to "
            + "open the following URL in your browser window: "
            + "http://localhost:8080/verification-service/email-verification.html?token=@tokenValue"
            + " Thank you! And we are waiting for you inside!";


    public void verifyEmail(UserDto userDto) {
        AmazonSimpleEmailService client = AmazonSimpleEmailServiceClientBuilder.standard()
                .withRegion(Regions.EU_NORTH_1).build();
        String htmlBodyWithToken = HTMLBODY.replaceAll("@tokenValue", userDto.getEmailVerificationToken());
        String textBodyWithToken = TEXTBODY.replaceAll("@tokenValue", userDto.getEmailVerificationToken());

        SendEmailRequest request = new SendEmailRequest()
                .withDestination(new Destination().withToAddresses(userDto.getEmail()))
                .withMessage(new Message().withBody(new Body()
                                .withHtml(new Content().withCharset("UTF-8").withData(htmlBodyWithToken))
                                .withText(new Content().withCharset("UTF-8").withData(textBodyWithToken)))
                        .withSubject(new Content().withCharset("UTF-8").withData(SUBJECT)))
                .withSource(FROM);

        client.sendEmail(request);

        System.out.println("Email sent!");
    }
}
