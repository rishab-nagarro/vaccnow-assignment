package com.vaccnow.application.service;


import com.vaccnow.application.requestmodel.EmailDetailModel;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmailService {
    private final JavaMailSender mailSender;

    public void SendCustomEmail(EmailDetailModel emailDetailModel) {

        mailSender.send(mimeMessage -> {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
            messageHelper.setTo(emailDetailModel.getPersonEmailId());
            messageHelper.setSubject(emailDetailModel.getSubject());
            messageHelper.setText(emailDetailModel.getMessage(), true);
        });
    }
}
