package com.scalastic.monitor.mail

/**
  * Created by Ghazi Naceur on 05/04/2019
  * Email: ghazi.ennacer@gmail.com
  */

import java.util.Properties

import javax.mail.internet.{InternetAddress, MimeMessage}
import javax.mail.{Message, Session}

object Mailer {
  val host = "smtp.gmail.com"
  val port = "587"

  def sendMail(address: String, password: String, subject: String, text: String) = {
    val properties = new Properties()
    properties.put("mail.smtp.port", port)
    properties.put("mail.smtp.auth", "true")
    properties.put("mail.smtp.starttls.enable", "true")

    val session = Session.getDefaultInstance(properties, null)
    val message = new MimeMessage(session)
    message.addRecipient(Message.RecipientType.TO, new InternetAddress(address));
    message.setSubject(subject)
    message.setContent(text, "text/html")

    val transport = session.getTransport("smtp")
    transport.connect(host, address, password)
    transport.sendMessage(message, message.getAllRecipients)
  }

  //   https://www.google.com/settings/security/lesssecureapps
  //   Activate the 2 steps authentication
  //   https://accounts.google.com/signin/v2/sl/pwd?service=accountsettings&passive=1209600&osid=1&continue=https%3A%2F%2Fmyaccount.google.com%2Fapppasswords%3Futm_source%3Dgoogle-account%26utm_medium%3Dweb&followup=https%3A%2F%2Fmyaccount.google.com%2Fapppasswords%3Futm_source%3Dgoogle-account%26utm_medium%3Dweb&rart=ANgoxcfyrKqR4Mxfw3jIvbf7EImvTg8AzG9NCGxzcprJ6u3UMk9o0mfQox_JENtkRb9RxFYoWQsdn7BSvt1CnkmbhEAA7p9F5w&csig=AF-SEnbMoXP2uKcDtvrb%3A1554496844&flowName=GlifWebSignIn&flowEntry=ServiceLogin

}
