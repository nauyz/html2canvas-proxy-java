	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = null, callback = null;
		url = request.getParameter("url");
		callback = request.getParameter("callback");
		
		URL imageURL = new URL(url);
		RenderedImage img = ImageIO.read(imageURL);
	    	String imageString = null;
	    	ByteArrayOutputStream bos = new ByteArrayOutputStream(); 
		ImageIO.write(img, "png", bos);
		
		byte[] imageBytes = bos.toByteArray();
		BASE64Encoder encoder = new BASE64Encoder();  
        	imageString = encoder.encode(imageBytes); 
        	imageString = imageString.replaceAll("\r\n", "");
        	imageString = imageString.replaceAll("\r", "");
        	imageString = imageString.replaceAll("\n", "");
		
		byte[] callbackBytes = (callback + "(\"data:image/png;base64," + imageString + "\")").getBytes();
		
		OutputStream ostream = response.getOutputStream(); // 返回给浏览器端的流
		response.setContentType("application/octet-stream; charset=utf-8");
		response.addHeader("Content-Disposition", "inline;filename=\"image.png\"");
		ostream.write(callbackBytes);
		ostream.flush();
		ostream.close();
	}
	
