package expt;

import java.io.*; 
import javax.net.ssl.*; 
import java.net.UnknownHostException; 
 
/*http://forum.codecall.net/topic/62143-how-to-read-your-emails-using-java/ */

public class EmailService { 
    String server = "pop.gmail.com"; 
    int port = 995; 
    String username = "prat8759@gmail.com", password = "stupid8759"; 
     
    SSLSocket socket; 
    BufferedReader input; 
    PrintWriter output; 
     
    public static void main(String[] args) { 
        new EmailService(); 
    } 
     
    public EmailService() { 
        try { 
            SSLSocketFactory sslsocketfactory = (SSLSocketFactory) SSLSocketFactory.getDefault(); 
            socket = (SSLSocket)sslsocketfactory.createSocket(server, port); 
            input = new BufferedReader(new InputStreamReader(socket.getInputStream())); 
             
            // After each println you MUST flush the buffer, or it won't work properly. 
            // The true argument makes an automatic flush after each println. 
            output = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true); 
            connect(); 
        } catch (UnknownHostException e) { 
            e.printStackTrace(); 
        } catch (IOException e) { 
            e.printStackTrace(); 
        } 
    } 
     
    public void connect() throws IOException { 
        System.out.print("Greeting message: "); 
        String response = readOneLine(); 
        System.out.println(response); 
         
        // Username 
        output.println("USER " + username); 
        response = readOneLine(); 
        System.out.println(response); 
         
        // Password 
        output.println("PASS " + password); 
        response = readOneLine(); 
        System.out.println(response); 
         
        output.println("RETR 1"); 
        while (!response.equals(".")) { 
            response = readOneLine(); 
            System.out.println(response); 
        } 
    } 
     
    public String readOneLine() throws IOException { 
        return input.readLine(); 
    } 
}

/*
Greeting message: +OK Gpop ready for requests from 59.181.98.165 k43pf13740128eeg.2
+OK send PASS
+OK Welcome.
+OK message follows
X-Gmail-Received: d8bdcf6e5382d3f4e986ca8bdcf949d565a317e0
Received: by 10.64.253.10; Mon, 3 Apr 2006 21:28:51 -0700 (PDT)
Message-ID: <39bd39090604032128of1b7f97t@mail.gmail.com>
Date: Mon, 3 Apr 2006 21:28:51 -0700
From: "Gmail Team" <mail-noreply@google.com>
To: "pratik pansare" <prat8759@gmail.com>
Subject: Gmail is different. Here's what you need to know.
MIME-Version: 1.0
Content-Type: multipart/alternative; 
	boundary="----=_Part_26667_10073828.1144124931834"

------=_Part_26667_10073828.1144124931834
Content-Type: text/plain; charset=ISO-8859-1
Content-Transfer-Encoding: quoted-printable
Content-Disposition: inline

Auto-save, keyboard shortcuts, customized addresses and more. Sound cool? W=
e
think so too. Welcome to Gmail.

We hope this email will help you learn about some of the features that make
Gmail unique. To get started, you may want to:

   - Check out the Gmail
Tour<http://mail.google.com/mail/help/tour/start.html>in our Getting
   Started section <http://mail.google.com/mail/help/start.html>.
   - Import your
contacts<http://mail.google.com/support/bin/answer.py?answer=3D8301>to
Gmail from Yahoo! Mail, Outlook, Hotmail and others.
   - Visit our Help Center <http://mail.google.com/support/> to learn
   about Gmail's features, like free POP access.

Gmail also works great with other Google products like
Desktop<http://desktop.google.com>for offline searching,
Picasa <http://picasa.google.com> for sending your pictures, and
Google Talk<http://www.google.com/talk/>for making free calls and
sending instant messages to your friends.

As you're using Gmail, you might notice that there aren't any large,
blinking, irrelevant ads. That's because we only show small text ads that
are matched by computers and designed to be relevant to the messages you're
viewing.

Users have often told us that the more they use Gmail, the more they
discover its added benefits. So go ahead and give Gmail a try. We'll keep
working on making Gmail the best email service around. Thanks for joining u=
s
for the ride. We hope you'll enjoy Google's approach to email.

Thanks,

The Gmail Team

P.S. You can sign in to your account any time by visiting
http://mail.google.com

------=_Part_26667_10073828.1144124931834
Content-Type: text/html; charset=ISO-8859-1
Content-Transfer-Encoding: quoted-printable
Content-Disposition: inline

<html>
<font face=3D"Arial, Helvetica, sans-serif">
<p>Auto-save, keyboard shortcuts, customized addresses and more.  Sound
cool?  We think so too.  Welcome to Gmail.</p>

<p>We hope this email will help you learn about some of the features
that make Gmail unique.  To get started, you may want to:</p>
<ul>
  <li>Check out the
    <a href=3D"http://mail.google.com/mail/help/tour/start.html">Gmail Tour=
</a>
    in our <a href=3D"http://mail.google.com/mail/help/start.html">
    Getting Started section</a>.
  </li>
  <li><a href=3D"http://mail.google.com/support/bin/answer.py?answer=3D8301=
">
    Import your contacts</a> to Gmail from Yahoo! Mail, Outlook, Hotmail an=
d
    others.
  </li>
  <li>Visit our <a href=3D"http://mail.google.com/support/">Help
    Center</a> to learn about Gmail's features, like free POP access.
  </li>
</ul>

<p>Gmail also works great with other Google products like <a
href=3D"http://desktop.google.com">Desktop</a> for offline searching, <a
href=3D"http://picasa.google.com">Picasa</a> for sending your pictures,
and <a href=3D"http://www.google.com/talk/">Google Talk</a> for making
free calls and sending instant messages to your friends.</p>

<p>As you're using Gmail, you might notice that there aren't any large,
blinking, irrelevant ads.  That's because we only show small text ads
that are matched by computers and designed to be relevant to the
messages you're viewing.</p>

<p>Users have often told us that the more they use Gmail, the more they
discover its added benefits.  So go ahead and give Gmail a try.  We'll
keep working on making Gmail the best email service around.  Thanks for
joining us for the ride.  We hope you'll enjoy Google's approach to
email.</p>

<p>Thanks,</p>

<p>The Gmail Team</p>

<p>P.S. You can sign in to your account any time by visiting
<a href=3D"http://mail.google.com">http://mail.google.com</a></p>
</font>
</html>

------=_Part_26667_10073828.1144124931834--
.
*/