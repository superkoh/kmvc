package me.superkoh.framework.api.handler;

import me.superkoh.framework.api.annotation.KController;
import me.superkoh.framework.api.config.RequestHeaderProperties;
import me.superkoh.framework.api.response.BizRes;
import me.superkoh.framework.api.response.ErrorRes;
import me.superkoh.framework.api.response.SuccessRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@ControllerAdvice(annotations = {KController.class})
final public class DefaultResponseBodyHandler implements ResponseBodyAdvice<BizRes> {
    @Autowired
    private RequestHeaderProperties requestHeaderProperties;

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public BizRes beforeBodyWrite(BizRes body, MethodParameter returnType, MediaType selectedContentType,
                                  Class<? extends HttpMessageConverter<?>> selectedConverterType,
                                  ServerHttpRequest request, ServerHttpResponse response) {
        String deviceToken = response.getHeaders().getFirst(requestHeaderProperties.getDeviceToken());
        if (body instanceof ErrorRes) {
            ((ErrorRes) body).setVd(deviceToken);
            return body;
        }
        if (body instanceof SuccessRes) {
            ((SuccessRes) body).setVd(deviceToken);
            return body;
        }
        SuccessRes res = new SuccessRes(body);
        res.setVd(deviceToken);
        return res;
    }
}
