package bsu.chatbot.utils;





/**
 * @author Mohamed Gawad
 *
 *         SBM-API
 */
public class Utils {

//	public static <T> String convertListToJsonString(List<T> msgs) throws JsonProcessingException {
//		ObjectMapper mapper = new ObjectMapper();
//		String jsonInString = mapper.writeValueAsString(msgs);
//		return jsonInString;
//	}
//
//	public static <T> String convertToJsonString(T object) throws JsonProcessingException {
//		ObjectMapper mapper = new ObjectMapper();
//		String jsonInString = mapper.writeValueAsString(object);
//		return jsonInString;
//	}
//
//	public static <T> T convertGenericObject(String jsonString, TypeReference<T> type) throws MessengerException {
//		ObjectMapper jsonMapper = new ObjectMapper();
//		T object = null;
//		try {
//			object = jsonMapper.readValue(jsonString, type);
//		} catch (JsonGenerationException e) {
//			e.printStackTrace();
//			Recipient recipient = new Recipient();
//			recipient.setId(null);
//			throw new MessengerException(recipient, "Under construction");
//		} catch (JsonMappingException e) {
//			e.printStackTrace();
//			Recipient recipient = new Recipient();
//			recipient.setId(null);
//			throw new MessengerException(recipient, "Under construction");
//		} catch (IOException e) {
//			e.printStackTrace();
//			Recipient recipient = new Recipient();
//			recipient.setId(null);
//			throw new MessengerException(recipient, "Under construction");
//		}
//		return object;
//	}
//
//	public static String GetArabicString(String arabicText) {
//		byte ptext[] = null;
//		try {
//			ptext = arabicText.getBytes("ISO-8859-1");
//		} catch (UnsupportedEncodingException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		} catch (DOMException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		String value = null;
//		try {
//			value = new String(ptext, "UTF-8");
//		} catch (UnsupportedEncodingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		return value;
//	}
//
//	public static boolean isNumeric(String text) {
//		boolean result = true;
//		try {
//			Integer.parseInt(text);
//		} catch (Exception e) {
//			result = false;
//		}
//		return result;
//	}
//
//	public static String saveImage(String imageUrl, String destRoot) throws IOException {
//		URL url = new URL(imageUrl);
//		// String fileName = url.getFile();
//		String destName = destRoot + "tmpimage.jpg";
//		System.out.println(destName);
//		InputStream is = url.openStream();
//		OutputStream os = new FileOutputStream(destName);
//		byte[] b = new byte[2048];
//		int length;
//
//		while ((length = is.read(b)) != -1) {
//			os.write(b, 0, length);
//		}
//		is.close();
//		os.close();
//		return destName;
//	}
//
//	public static void sendEmailWithAttachments(String toAddress, String subject, String message, String[] attachFiles) throws AddressException, MessagingException {
//		String host = "smtp.gmail.com";
//		String port = "587";
//		final String mailFrom = "sbmdemo56@gmail.com";
//		final String password = "Pass@123456";
//
//		// sets SMTP server properties
//		Properties properties = new Properties();
//		properties.put("mail.smtp.host", host);
//		properties.put("mail.smtp.port", port);
//		properties.put("mail.smtp.auth", "true");
//		properties.put("mail.smtp.starttls.enable", "true");
//		properties.put("mail.user", mailFrom);
//		properties.put("mail.password", password);
//
//		// creates a new session with an authenticator
//		Authenticator auth = new Authenticator() {
//			public PasswordAuthentication getPasswordAuthentication() {
//				return new PasswordAuthentication(mailFrom, password);
//			}
//		};
//		Session session = Session.getInstance(properties, auth);
//
//		// creates a new e-mail message
//		Message msg = new MimeMessage(session);
//
//		msg.setFrom(new InternetAddress(mailFrom));
//		InternetAddress[] toAddresses = { new InternetAddress(toAddress) };
//		msg.setRecipients(Message.RecipientType.TO, toAddresses);
//		msg.setSubject(subject);
//		msg.setSentDate(new Date());
//
//		// creates message part
//		MimeBodyPart messageBodyPart = new MimeBodyPart();
//		messageBodyPart.setContent(message, "text/html");
//
//		// creates multi-part
//		Multipart multipart = new MimeMultipart();
//		multipart.addBodyPart(messageBodyPart);
//
//		// adds attachments
//		if (attachFiles != null && attachFiles.length > 0) {
//			for (String filePath : attachFiles) {
//				MimeBodyPart attachPart = new MimeBodyPart();
//
//				try {
//					attachPart.attachFile(filePath);
//				} catch (IOException ex) {
//					ex.printStackTrace();
//				}
//
//				multipart.addBodyPart(attachPart);
//			}
//		}
//
//		// sets the multi-part as e-mail's content
//		msg.setContent(multipart);
//
//		// sends the e-mail
//		Transport.send(msg);
//
//	}
}
