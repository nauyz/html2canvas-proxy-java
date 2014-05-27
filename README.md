html2canvas-proxy-java
======================

this item is a html2canvas proxy java plugin. html2canvas solve CROS problem by proxy config, but proxy needs Server side privide Url response.

代理格式
---------
### proxy请求格式
    http(s)://yourdomain:port/path?url=XXXX&callback=YYYYYY
  ###格式说明
    yourdomain是发布服务的域名，port是发布服务的端口，path是解决CROS问题的端口，url是请求的图片资源地址，callback是jsonp的参数，用来标记请求。
  
html2canvas-proxy-java功能
--------------------------
###功能
    接受如上所述的格式的请求，获取url参数和callback参数，请求url参数的http(s)的图片，处理图片为base64编码格式的字节流，返回给客户端。
###返回格式
    {callback}("data:{type};base64,{imageStream}")
###返回格式描述
    {callback}为callback参数的值，{type}为请求图片的类型，如image/type, {imageStream}为url地址返回的image的base64的字节流。

