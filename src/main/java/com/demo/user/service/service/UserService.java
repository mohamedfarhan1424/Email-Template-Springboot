package com.demo.user.service.service;


import com.demo.user.service.VO.Department;
import com.demo.user.service.VO.ResponseTemplate;
import com.demo.user.service.entity.User;
import com.demo.user.service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;
    public User saveUser(User user) throws MessagingException {
        User saved = userRepository.save(user);
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.ssl.protocols", "TLSv1.2");
        props.put("mail.smtp.starttls.enable", "true");
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication("mohamedfarhan1424@gmail.com","iuvm oyxc qtpz sslk");
            }
        });
        Message message = new MimeMessage(session);
        message.addRecipients(Message.RecipientType.TO, InternetAddress.parse(saved.getEmail()));
        message.setSubject("Welcome to Awesome App");
        message.setContent("<!DOCTYPE html PUBLIC '-//W3C//DTD XHTML 1.0 Transitional//EN' 'http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd'>\n" +
                "<html xmlns=\"http://www.w3.org/1999/xhtml\">\n" +
                "  <head>\n" +
                "    <meta content=\"text/html; charset=utf-8\" http-equiv=\"Content-Type\" />\n" +
                "    <meta content=\"width=device-width, initial-scale=1\" name=\"viewport\" />\n" +
                "    <title>PropTech Kenya Welcome Email</title>\n" +
                "    <!-- Designed by https://github.com/kaytcat -->\n" +
                "    <!-- Robot header image designed by Freepik.com -->\n" +
                "    <style type=\"text/css\">\n" +
                "      @import url(https://fonts.googleapis.com/css?family=Nunito);\n" +
                "\n" +
                "      /* Take care of image borders and formatting */\n" +
                "\n" +
                "      img {\n" +
                "        max-width: 600px;\n" +
                "        outline: none;\n" +
                "        text-decoration: none;\n" +
                "        -ms-interpolation-mode: bicubic;\n" +
                "      }\n" +
                "      html {\n" +
                "        margin: 0;\n" +
                "        padding: 0;\n" +
                "      }\n" +
                "\n" +
                "      a {\n" +
                "        text-decoration: none;\n" +
                "        border: 0;\n" +
                "        outline: none;\n" +
                "        color: #bbbbbb;\n" +
                "      }\n" +
                "\n" +
                "      a img {\n" +
                "        border: none;\n" +
                "      }\n" +
                "\n" +
                "      /* General styling */\n" +
                "\n" +
                "      td,\n" +
                "      h1,\n" +
                "      h2,\n" +
                "      h3 {\n" +
                "        font-family: Helvetica, Arial, sans-serif;\n" +
                "        font-weight: 400;\n" +
                "      }\n" +
                "\n" +
                "      td {\n" +
                "        text-align: center;\n" +
                "      }\n" +
                "\n" +
                "      body {\n" +
                "        -webkit-font-smoothing: antialiased;\n" +
                "        -webkit-text-size-adjust: none;\n" +
                "        width: 100%;\n" +
                "        height: 100%;\n" +
                "        color: #666;\n" +
                "        background: #fff;\n" +
                "        font-size: 16px;\n" +
                "        height: 100vh;\n" +
                "        width: 100%;\n" +
                "        padding: 0px;\n" +
                "        margin: 0px;\n" +
                "      }\n" +
                "\n" +
                "      table {\n" +
                "        border-collapse: collapse !important;\n" +
                "      }\n" +
                "\n" +
                "      .headline {\n" +
                "        color: #444;\n" +
                "        font-size: 36px;\n" +
                "      }\n" +
                "\n" +
                "      .force-full-width {\n" +
                "        width: 100% !important;\n" +
                "      }\n" +
                "    </style>\n" +
                "    <style media=\"screen\" type=\"text/css\">\n" +
                "      @media screen {\n" +
                "        td,\n" +
                "        h1,\n" +
                "        h2,\n" +
                "        h3 {\n" +
                "          font-family: \"Nunito\", \"Helvetica Neue\", \"Arial\", \"sans-serif\" !important;\n" +
                "        }\n" +
                "      }\n" +
                "    </style>\n" +
                "    <style media=\"only screen and (max-width: 480px)\" type=\"text/css\">\n" +
                "      /* Mobile styles */\n" +
                "      @media only screen and (max-width: 480px) {\n" +
                "        table[class=\"w320\"] {\n" +
                "          width: 320px !important;\n" +
                "        }\n" +
                "      }\n" +
                "    </style>\n" +
                "    <style type=\"text/css\"></style>\n" +
                "  </head>\n" +
                "  <body\n" +
                "    bgcolor=\"#fff\"\n" +
                "    class=\"body\"\n" +
                "    style=\"\n" +
                "      padding: 20px;\n" +
                "      margin: 0;\n" +
                "      display: block;\n" +
                "      background: #ffffff;\n" +
                "      -webkit-text-size-adjust: none;\n" +
                "    \"\n" +
                "  >\n" +
                "    <table\n" +
                "      align=\"center\"\n" +
                "      cellpadding=\"0\"\n" +
                "      cellspacing=\"0\"\n" +
                "      height=\"100%\"\n" +
                "      width=\"100%\"\n" +
                "    >\n" +
                "      <tbody>\n" +
                "        <tr>\n" +
                "          <td align=\"center\" bgcolor=\"#fff\" class=\"\" valign=\"top\" width=\"100%\">\n" +
                "            <center class=\"\">\n" +
                "              <table\n" +
                "                cellpadding=\"0\"\n" +
                "                cellspacing=\"0\"\n" +
                "                class=\"w320\"\n" +
                "                style=\"margin: 0 auto\"\n" +
                "                width=\"600\"\n" +
                "              >\n" +
                "                <tbody>\n" +
                "                  <tr>\n" +
                "                    <td align=\"center\" class=\"\" valign=\"top\">\n" +
                "                      <table\n" +
                "                        cellpadding=\"0\"\n" +
                "                        cellspacing=\"0\"\n" +
                "                        style=\"margin: 0 auto\"\n" +
                "                        width=\"100%\"\n" +
                "                      ></table>\n" +
                "                      <table\n" +
                "                        bgcolor=\"#fff\"\n" +
                "                        cellpadding=\"0\"\n" +
                "                        cellspacing=\"0\"\n" +
                "                        class=\"\"\n" +
                "                        style=\"margin: 0 auto; width: 100%; margin-top: 100px\"\n" +
                "                      >\n" +
                "                        <tbody style=\"margin-top: 15px\">\n" +
                "                          <tr class=\"\">\n" +
                "                            <td class=\"\">\n" +
                "                              <img\n" +
                "                                alt=\"robot picture\"\n" +
                "                                class=\"\"\n" +
                "                                height=\"155\"\n" +
                "                                src=\"https://proptech-kenya.firebaseapp.com/assets/images/logo.png\"\n" +
                "                                width=\"155\"\n" +
                "                              />\n" +
                "                            </td>\n" +
                "                          </tr>\n" +
                "                          <tr class=\"\">\n" +
                "                            <td class=\"headline\">Welcome to Awesome App!</td>\n" +
                "                          </tr>\n" +
                "                          <tr>\n" +
                "                            <td>\n" +
                "                              <center class=\"\">\n" +
                "                                <table\n" +
                "                                  cellpadding=\"0\"\n" +
                "                                  cellspacing=\"0\"\n" +
                "                                  class=\"\"\n" +
                "                                  style=\"margin: 0 auto\"\n" +
                "                                  width=\"75%\"\n" +
                "                                >\n" +
                "                                  <tbody class=\"\">\n" +
                "                                    <tr class=\"\">\n" +
                "                                      <td\n" +
                "                                        class=\"\"\n" +
                "                                        style=\"color: #444; font-weight: 400\"\n" +
                "                                      >\n" +
                "                                        <br /><br />\n" +
                "                                        A property management application that\n" +
                "                                        helps you manage your real estate\n" +
                "                                        portfolio with ease and efficiency.\n" +
                "                                        <br /><br />\n" +
                "                                        You have successfully been registered to\n" +
                "                                        use PropTech as a <em>Landlord</em\n" +
                "                                        ><br />\n" +
                "                                        <br />\n" +
                "                                        Your login credentials are provided\n" +
                "                                        below:\n" +
                "                                        <br />\n" +
                "                                        <span style=\"font-weight: bold\"\n" +
                "                                          >Email: &nbsp;</span\n" +
                "                                        ><span\n" +
                "                                          style=\"font-weight: lighter\"\n" +
                "                                          class=\"\"\n" +
                "                                          >"+saved.getEmail()+"</span\n" +
                "                                        >\n" +
                "                                        <br />\n" +
                "                                        <span style=\"font-weight: bold\"\n" +
                "                                          >Password: &nbsp;</span\n" +
                "                                        ><span\n" +
                "                                          style=\"font-weight: lighter\"\n" +
                "                                          class=\"\"\n" +
                "                                          >HJ5f5s5F5G1D</span\n" +
                "                                        >\n" +
                "                                        <br /><br />\n" +
                "                                        <br />\n" +
                "                                      </td>\n" +
                "                                    </tr>\n" +
                "                                  </tbody>\n" +
                "                                </table>\n" +
                "                              </center>\n" +
                "                            </td>\n" +
                "                          </tr>\n" +
                "                          <tr>\n" +
                "                            <td class=\"\">\n" +
                "                              <div class=\"\">\n" +
                "                                <a\n" +
                "                                  style=\"\n" +
                "                                    background-color: #674299;\n" +
                "                                    border-radius: 4px;\n" +
                "                                    color: #fff;\n" +
                "                                    display: inline-block;\n" +
                "                                    font-family: Helvetica, Arial, sans-serif;\n" +
                "                                    font-size: 18px;\n" +
                "                                    font-weight: normal;\n" +
                "                                    line-height: 50px;\n" +
                "                                    text-align: center;\n" +
                "                                    text-decoration: none;\n" +
                "                                    width: 350px;\n" +
                "                                    -webkit-text-size-adjust: none;\n" +
                "                                  \"\n" +
                "                                  href=\"https://proptech-kenya.firebaseapp.com\"\n" +
                "                                  >Visit Account and Start Managing</a\n" +
                "                                >\n" +
                "                              </div>\n" +
                "                              <br />\n" +
                "                            </td>\n" +
                "                          </tr>\n" +
                "                        </tbody>\n" +
                "                      </table>\n" +
                "\n" +
                "                      <table\n" +
                "                        bgcolor=\"#fff\"\n" +
                "                        cellpadding=\"0\"\n" +
                "                        cellspacing=\"0\"\n" +
                "                        class=\"force-full-width\"\n" +
                "                        style=\"margin: 0 auto; margin-bottom: 5px:\"\n" +
                "                      >\n" +
                "                        <tbody>\n" +
                "                          <tr>\n" +
                "                            <td class=\"\" style=\"color: #444\">\n" +
                "                              <p>\n" +
                "                                The password was auto-generated, however feel\n" +
                "                                free to change it\n" +
                "\n" +
                "                                <a href=\"\" style=\"text-decoration: underline\">\n" +
                "                                  here</a\n" +
                "                                >\n" +
                "                              </p>\n" +
                "                            </td>\n" +
                "                          </tr>\n" +
                "                        </tbody>\n" +
                "                      </table>\n" +
                "                    </td>\n" +
                "                  </tr>\n" +
                "                </tbody>\n" +
                "              </table>\n" +
                "            </center>\n" +
                "          </td>\n" +
                "        </tr>\n" +
                "      </tbody>\n" +
                "    </table>\n" +
                "  </body>\n" +
                "</html>\n","text/html");
        message.setFrom(new InternetAddress("mohamedfarhan1424@gmail.com"));
        Transport.send(message);
        return saved;
    }

    public ResponseTemplate getUser(Long id) {
        ResponseTemplate template = new ResponseTemplate();
        User user = userRepository.findByUserId(id);
        Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/"
                +user.getDepartmentId(),Department.class);
        template.setUser(user);
        template.setDepartment(department);
        return template;

    }
}
